package com.animee.rf_week02;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.animee.rf_week02.adapter.CartAdapter;
import com.animee.rf_week02.bean.ContentDatas;
import com.animee.rf_week02.bean.InfoBean;
import com.animee.rf_week02.view.TitleView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    TitleView titleView;
    ListView cartLv;
    Button payBtn;
    TextView totalTv;
    List<InfoBean> mDatas;
    private CartAdapter adapter;

    private double total; // 总金额

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        initView();
        setTitleView();
        loadDatas();

        // 设置适配器
        adapter = new CartAdapter(this, mDatas);
        cartLv.setAdapter(adapter);
        calculateTotalToTv();
    }

    // 计算购物车总价格, 显示在TextView上
    public void calculateTotalToTv() {
        total = 0;
        for (InfoBean bean : mDatas) {
            total += bean.getBuycount() * bean.getPrice();
        }
        totalTv.setText("￥ " + total);
    }

    private void loadDatas() {
        mDatas = new ArrayList<>();
        mDatas.addAll(ContentDatas.getBuyGoodsList());
    }

    /* 在此处针对页面标题进行设置*/
    private void setTitleView() {
        titleView.setTitle(R.string.cart);
        titleView.setVisibleImg(View.VISIBLE, View.GONE);
        titleView.setOnClickLeftImgListener(view -> finish());
    }

    private void initView() {
        titleView = findViewById(R.id.cart_titleview);
        cartLv = findViewById(R.id.cart_lv);
        payBtn = findViewById(R.id.cart_btn_buy);
        totalTv = findViewById(R.id.cart_tv_total);
        payBtn.setOnClickListener(view -> {
            Intent intent = new Intent(CartActivity.this, PayActivity.class);
            intent.putExtra("total", total);
            startActivity(intent);
        });
    }
}