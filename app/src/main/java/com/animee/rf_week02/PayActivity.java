package com.animee.rf_week02;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.animee.rf_week02.databinding.ActivityPayBinding;
import com.animee.rf_week02.db.AddressDao;
import com.animee.rf_week02.db.DBManager;
import com.animee.rf_week02.view.ToastUtils;

public class PayActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityPayBinding binding;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPayBinding.inflate(getLayoutInflater());
        LinearLayout root = binding.getRoot();
        setContentView(root);

        setTitleView();

        double total = getIntent().getDoubleExtra("total", 0);
        binding.payEtTotal.setText(total + "");

        // 获取默认的收货地址的id
        preferences = getSharedPreferences("address_pref", MODE_PRIVATE);
        int defaultId = preferences.getInt("default", -1);
        AddressDao dao = DBManager.queryAddressById(defaultId);
        if (dao != null) {
            binding.payEtShr.setText(dao.getName());
            binding.payEtTel.setText(dao.getTel());
            binding.payEtAddress.setText(dao.getCity() + "|" + dao.getStreet());
        }
        // 设置取消订单
        binding.payBtnCancel.setOnClickListener(view -> finish());
    }

    private void setTitleView() {
        binding.payTitleview.setTitle("订单");
        binding.payTitleview.setVisibleImg(View.VISIBLE, View.GONE);
        binding.payTitleview.setOnClickLeftImgListener(view -> finish());

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.pay_iv_write) {
            Intent intent = new Intent(PayActivity.this, AddressActivity.class);
            startActivityIfNeeded(intent, 100);
        }
    }

    /**
     * 接收返回数据显示收货人信息
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            AddressDao dao = (AddressDao) data.getSerializableExtra("ads");
            binding.payEtShr.setText(dao.getName());
            binding.payEtTel.setText(dao.getTel());
            binding.payEtAddress.setText(dao.getCity() + " | " + dao.getStreet());
        }
    }
}