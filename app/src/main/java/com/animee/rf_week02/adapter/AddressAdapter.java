package com.animee.rf_week02.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.animee.rf_week02.R;
import com.animee.rf_week02.databinding.ItemAddressBinding;
import com.animee.rf_week02.db.AddressDao;
import com.animee.rf_week02.db.DBManager;
import com.animee.rf_week02.view.AlertDialogUtils;
import com.animee.rf_week02.view.SaveAddressDialog;
import com.animee.rf_week02.view.ToastUtils;

import java.util.List;

public class AddressAdapter extends BaseAdapter {

    Context context;
    List<AddressDao> mDatas;
    int defaultId;

    public int getDefaultId() {
        return defaultId;
    }

    public AddressAdapter(Context context, List<AddressDao> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        VHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_address, viewGroup, false);
            holder = new VHolder(view);
            view.setTag(holder);
        } else {
            holder = (VHolder) view.getTag();
        }
        AddressDao dao = mDatas.get(i);
        holder.binding.itemAdsTvName.setText(dao.getName());
        holder.binding.itemAdsTvTel.setText(dao.getTel());
        holder.binding.itemAdsTvCity.setText(dao.getCity());
        holder.binding.itemAdsTvStreet.setText(dao.getStreet());
        // 点击事件
        // 编写修改地址的点击事件
        updateAddressClick(holder.binding.itemAdsTvModify, dao);
        // 删除地址的点击事件
        deleteAddressClick(holder.binding.itemAdsTvDelete, dao);
        // 复制地址的点击事件
        copyAddressClick(holder.binding.itemAdsTvCopy, dao);
        // 置顶的点击事件
        setTopClick(holder.binding.itemAdsTvTop, dao);
        // 设置默认的点击事件
        holder.binding.itemAdsRbDefault.setChecked(dao.isDefault());
        if (dao.isDefault()) {
            defaultId = dao.getId();
        } else {
            setDefaultClick(holder.binding.itemAdsRbDefault, dao);
        }

        return view;
    }

    /**
     * 设置默认选中的点击事件
     * @param rb
     * @param dao
     */
    private void setDefaultClick(RadioButton rb, AddressDao dao) {
        rb.setOnClickListener(view -> {
                for (AddressDao mData : mDatas) {
                    mData.setDefault(false);
                }
                dao.setDefault(true);
                defaultId = dao.getId();
                notifyDataSetChanged();
        });
    }

    private void setTopClick(TextView view, AddressDao dao) {
        view.setOnClickListener(view1 -> {
            // 移除数据源当中这个数据, 放在第一个位置
            mDatas.remove(dao);
            mDatas.add(0, dao);
            notifyDataSetChanged();
        });
    }

    /**
     * 复制地址到复制版当中
     */
    private void copyAddressClick(TextView view, AddressDao dao) {
        view.setOnClickListener(view1 -> {
            ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);

            ClipData clipData = ClipData.newPlainText("Label", dao.toString());
            cm.setPrimaryClip(clipData);
            ToastUtils.showToast(context, "复制成功");
        });
    }

    private void deleteAddressClick(TextView view, AddressDao dao) {
        view.setOnClickListener(view1 -> AlertDialogUtils.showNormalDialog(
                context, "提示信息", "您确定要删除这条收货地址吗?",
                "取消", "确定", null, () -> {
                    // 删除数据库当中的这条信息
                    DBManager.deleteAddressById(dao.getId());
                    // 删除数据源记录, 通知适配器更新
                    mDatas.remove(dao);
                    notifyDataSetChanged();
                }));
    }

    /**
     * 修改地址功能
     */
    private void updateAddressClick(TextView view, AddressDao dao) {
        view.setOnClickListener(view1 -> {
            SaveAddressDialog dialog = new SaveAddressDialog(context);
            dialog.show();
            dialog.setTitle("修改收获地址");
            dialog.setAddressDao(dao);
            dialog.setOnUpdateAddressListener(dao1 -> {
                // 修改数据库地址
                DBManager.modifyAddressById(dao1);
                // 更新数据, 提示适配器更新
                dao.clone(dao1);
                notifyDataSetChanged();
            });
        });
    }

    class VHolder {
        ItemAddressBinding binding;

        public VHolder(View view) {
            binding = ItemAddressBinding.bind(view);
        }
    }
}
