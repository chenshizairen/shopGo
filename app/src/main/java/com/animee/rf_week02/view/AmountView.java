package com.animee.rf_week02.view;

import android.content.Context;
import android.os.TestLooperManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.animee.rf_week02.R;
import com.google.android.material.internal.TextWatcherAdapter;

public class AmountView extends LinearLayout implements View.OnClickListener {
    private Button subBtn, addBtn;
    private EditText numEt;
    private int storage = 100;
    private int showCount = 1;

    // 设置产品库存
    public void setStorage(int storage) {
        this.storage = storage;
    }

    // 设置显示数量
    public void setShowCount(int count) {
        this.showCount = count;
        numEt.setText("" + showCount);
    }

    // 将这个view当中的数量传递出去
    public interface OnAmountListener {
        public void onAmount(int num);
    }

    OnAmountListener onAmountListener;

    public void setOnAmountListener(OnAmountListener onAmountListener) {
        this.onAmountListener = onAmountListener;
    }

    public AmountView(Context context) {
        this(context, null);
    }

    public AmountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.amount_view, this);
        initView();
    }

    private void initView() {
        subBtn = findViewById(R.id.amount_btn_sub);
        addBtn = findViewById(R.id.amount_btn_plus);
        numEt = findViewById(R.id.amount_et);
        subBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
        // 设置输入框的监听器
        numEt.addTextChangedListener(watcher);
    }
    // 返回输入框当中的数据
    public int getAmountNum() {
        String after = numEt.getText().toString().trim();
        if (TextUtils.isEmpty(after)) {
            return 1;
        }
        return Integer.parseInt(after);
    }
    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            Log.d("beforeTextChanged :  ", charSequence.toString()
//                    + ", " + i + ", " + i1 + ", " + i2);
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            Log.d("onTextChanged :  ", charSequence.toString()
//                    + ", " + i + ", " + i1 + ", " + i2);
//            System.out.println();
        }

        @Override
        public void afterTextChanged(Editable editable) {
            String after = editable.toString().trim();
            if (TextUtils.isEmpty(after)) {
                showCount = 1;
                numEt.setText("1");
                return;
            }
            showCount = Integer.parseInt(after);
            if (showCount < 1) {
                showCount = 1;
                numEt.setText("1");
            } else if (showCount > storage) {
                showCount = storage;
                numEt.setText(showCount + "");
            }

            if (onAmountListener != null) {
                onAmountListener.onAmount(showCount);
            }
        }
    };

    @Override
    public void onClick(View view) {
        String numstr = numEt.getText().toString().trim();
        int num = Integer.parseInt(numstr);
        switch (view.getId()) {
            case R.id.amount_btn_sub:
                if (num > 1) {
                    num--;
                }
                break;
            case R.id.amount_btn_plus:
                if (num < storage) {
                    num++;
                }
                break;
        }
        numEt.clearFocus(); // 失去焦点
        numEt.setText(num + "");
        if (onAmountListener != null) {
            onAmountListener.onAmount(showCount);
        }
    }

}
