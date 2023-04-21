package com.animee.rf_week02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.animee.rf_week02.adapter.AddressAdapter;
import com.animee.rf_week02.databinding.ActivityAddressBinding;
import com.animee.rf_week02.db.AddressDao;
import com.animee.rf_week02.db.DBManager;
import com.animee.rf_week02.view.SaveAddressDialog;
import com.animee.rf_week02.view.TitleView;
import com.animee.rf_week02.view.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class AddressActivity extends AppCompatActivity {

    ActivityAddressBinding binding;
    List<AddressDao> mDatas;
    private AddressAdapter adapter;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddressBinding.inflate(getLayoutInflater());
        LinearLayout root = binding.getRoot();
        setContentView(root);
        setTitleView();
        preferences = getSharedPreferences("address_pref", MODE_PRIVATE);

        mDatas = new ArrayList<>();
        // 设置适配器
        adapter = new AddressAdapter(this, mDatas);
        binding.addressLv.setAdapter(adapter);
        // 加载数据库内容
        loadDBDatas();
        // 设置ListView的单项点击监听事件
        binding.addressLv.setOnItemClickListener((parent, view, position, id) -> {
            AddressDao dao = mDatas.get(position);
            Intent intent = new Intent();
            intent.putExtra("ads", dao);
            setResult(RESULT_OK, intent);
            finish();
        });
        // 添加底部布局
        addFooterView();
    }

    private void addFooterView() {
        View footerView = getLayoutInflater().inflate(R.layout.item_ads_footer, null);
        Button addBtn = footerView.findViewById(R.id.item_ads_btn_add);

        binding.addressLv.addFooterView(footerView);
        addBtn.setOnClickListener(view -> {
            // 弹出添加收货人地址对话框
            showAdsDialog();
        });
    }

    /** 显示保存地址对话框*/
    private void showAdsDialog() {
        SaveAddressDialog dialog = new SaveAddressDialog(this);
        dialog.show();
        dialog.setOnUpdateAddressListener(dao -> {
            boolean exist = DBManager.existAddressInDB(dao);
            if (exist) {
                ToastUtils.showToast(AddressActivity.this, "收货地址已存在");
            } else {
                long l = DBManager.insertAddressToDB(dao);
                if (l>0) {
                    ToastUtils.showToast(AddressActivity.this, "保存成功");
                    dao.setId((int) l);
                    mDatas.add(dao);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void setTitleView() {
        binding.addressTitle.setTitle(R.string.address);
        binding.addressTitle.setVisibleImg(View.VISIBLE, View.GONE);
        binding.addressTitle.setOnClickLeftImgListener(view -> finish());
    }

    /** 加载数据库数据, 通知适配器更新*/
    private void loadDBDatas() {
        mDatas.clear();
        List<AddressDao> list = DBManager.queryAllAddressFromDB();
        mDatas.addAll(list);
        // 读取共享参数的置顶信息
        int topId = preferences.getInt("top", -1);
        int defaultId = preferences.getInt("default", -1);

        if (topId != -1 || defaultId != -1) {
            for (int i = 0; i < mDatas.size(); i++) {
                AddressDao dao = mDatas.get(i);
                if (dao.getId() == topId) {
                    mDatas.remove(dao);
                    mDatas.add(0, dao);
                }
                if (dao.getId() == defaultId) {
                    dao.setDefault(true);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }

    /**
     * 当前页面被销毁时, 会调用的方法
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 获取需要置顶的数据
        int topId = mDatas.get(0).getId();
        // 获取默认的地址的id
        int defaultId = adapter.getDefaultId();
        // 写入到共享参数当中
        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt("top", topId);
        edit.putInt("default", defaultId);
        edit.apply();
    }
}