package com.animee.rf_week02.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.animee.rf_week02.R;
import com.animee.rf_week02.databinding.DialogAddressBinding;
import com.animee.rf_week02.db.AddressDao;

import java.util.regex.Pattern;

public class SaveAddressDialog extends Dialog implements View.OnClickListener {
    DialogAddressBinding binding;
    AddressDao addressDao; // 修改地址会传入地址内容

    public SaveAddressDialog(@NonNull Context context) {
        super(context);
    }

    public interface OnUpdateAddressListener {
        public void onUpdateAddress(AddressDao dao);
    }

    private OnUpdateAddressListener onUpdateAddressListener;

    public void setOnUpdateAddressListener(OnUpdateAddressListener onUpdateAddressListener) {
        this.onUpdateAddressListener = onUpdateAddressListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DialogAddressBinding.inflate(getLayoutInflater());
        RelativeLayout root = binding.getRoot();
        setContentView(root);
        setEvent();
    }

    private void setEvent() {
        binding.dgAdsBtn.setOnClickListener(this);
        binding.dgAdsIvCancel.setOnClickListener(this);
    }

    /**
     * 修改对话框标题方法
     */
    public void setTitle(String msg) {
        binding.dgAdsTvTitle.setText(msg);
    }

    /**
     * 设置对话框中输入框的显示
     */
    public void setAddressDao(AddressDao dao) {
        this.addressDao = dao;
        binding.dgAdsEtShr.setText(dao.getName());
        binding.dgAdsEtTel.setText(dao.getTel());
        binding.dgAdsEtCity.setText(dao.getCity());
        binding.dgAdsEtStreet.setText(dao.getStreet());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dg_ads_btn:
                AddressDao dao = judgeInputMsg();
                // 添加新地址逻辑: 如果这个地址没有一摸一样的就添加数据库, 如果有一样的就不添加, 提示用户
                if (dao != null) {
                    // 判断是否传入了原来的地址
                    if (this.addressDao == null) {
                        if (onUpdateAddressListener != null) { // 增加地址的判断
                            onUpdateAddressListener.onUpdateAddress(dao);
                        }
                    } else { // 修改地址的判断
                        // 1. 判断修改该内容和原来内容是否一致, 完全一致, 不修改, 提示用户
                        if (dao.equals(this.addressDao)) {
                            ToastUtils.showToast(getContext(), "未进行修改该, 于原内容一致! ");
                        } else {
                            // 2. 不一致, 将修改该后的数据回调回去, 在回调之前设置id, 在适配器更新地址
                            dao.setId(addressDao.getId());
                            if (onUpdateAddressListener != null) { // 增加地址的判断
                                onUpdateAddressListener.onUpdateAddress(dao);
                            }
                        }
                    }
                    cancel();
                }
                break;
            case R.id.dg_ads_iv_cancel:
                cancel();
                break;

        }
    }

    private AddressDao judgeInputMsg() {
        String name = binding.dgAdsEtShr.getText().toString().trim();
        String tel = binding.dgAdsEtTel.getText().toString().trim();
        String city = binding.dgAdsEtCity.getText().toString().trim();
        String street = binding.dgAdsEtStreet.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(tel) || TextUtils.isEmpty(city) || TextUtils.isEmpty(street)) {
            ToastUtils.showToast(getContext(), "输入信息不能为空");
            return null;
        }
        // 手机号的正则表达式
        if (!Pattern.matches("^1[3-9]\\d{9}$", tel)) {
            ToastUtils.showToast(getContext(), "输入手机号不符合规则");
            return null;
        }
        return new AddressDao(0, name, tel, city, street);
    }

}
