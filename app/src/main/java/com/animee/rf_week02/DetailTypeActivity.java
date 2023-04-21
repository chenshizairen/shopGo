package com.animee.rf_week02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import com.animee.rf_week02.adapter.DetailGVAdapter;
import com.animee.rf_week02.adapter.DetailLVAdapter;
import com.animee.rf_week02.bean.ContentDatas;
import com.animee.rf_week02.bean.InfoBean;
import com.animee.rf_week02.view.TitleView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DetailTypeActivity extends AppCompatActivity implements View.OnClickListener {

    private String type;
    TitleView titleView;
    Button sortBtn, searchBtn;
    Spinner spinner;
    ListView goodsLv;
    GridView goodsGv;
    List<InfoBean> mDatas; // 列表和网格视图的数据源
    private DetailLVAdapter lvAdapter;
    private DetailGVAdapter gvAdapter;
    private ArrayAdapter<String> spAdapter;
    private boolean isAscPrice = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_type);
        // 接收数据
        type = getIntent().getStringExtra("type");
        // 初始化view
        initView();
        setTitleView();
        // 设置ListView的内容
        mDatas = new ArrayList<>();

        // 设置适配器ListView, GridView
        lvAdapter = new DetailLVAdapter(this, mDatas);
        goodsLv.setAdapter(lvAdapter);

        gvAdapter = new DetailGVAdapter(this, mDatas);
        goodsGv.setAdapter(gvAdapter);
        // 加载数据
        loadDatas();
        // 设置spinner的显示
        String[] arr = {"列表显示", "网格显示"};
        spAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        spinner.setAdapter(spAdapter);
        // 切换页面的样式
        changePageStyle();
        // 设定监听器  搜索, 排序
        setEvent();
    }

    private void setEvent() {
        searchBtn.setOnClickListener(this);
        sortBtn.setOnClickListener(this);
    }

    /** 通过设置spinner的选中监听器切换页面显示*/
    private void changePageStyle() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (pos) {
                    case 0:
                        goodsLv.setVisibility(View.VISIBLE);
                        goodsGv.setVisibility(View.GONE);
                        break;
                    case 1:
                        goodsLv.setVisibility(View.GONE);
                        goodsGv.setVisibility(View.VISIBLE);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    /** 第一次加载数据*/
    private void loadDatas() {
        for (InfoBean bean : ContentDatas.shopList) {
            if (bean.getKind().equals(type)) {
                mDatas.add(bean);
            }
        }
        // 数据源内容发生改变, 提示适配器更新
        lvAdapter.notifyDataSetChanged();
        gvAdapter.notifyDataSetChanged();
    }


    private void setTitleView() {
        titleView.setTitle(type);
        titleView.setTitleColor(Color.WHITE);
        titleView.setRightImgResource(R.mipmap.icon_gwc);
        titleView.setOnClickLeftImgListener(view -> finish());
        titleView.setOnClickRightImgListener(view -> {
            // 跳转到购物车页面
            startActivity(new Intent(DetailTypeActivity.this, CartActivity.class));
        });
    }

    private void initView() {
        titleView = findViewById(R.id.detail_titleview);
        sortBtn = findViewById(R.id.detail_btn_sort);
        searchBtn = findViewById(R.id.detail_btn_search);
        spinner = findViewById(R.id.detail_sp);
        goodsLv = findViewById(R.id.detail_lv);
        goodsGv = findViewById(R.id.detail_gv);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.detail_btn_search:
                break;
            case R.id.detail_btn_sort:
                // 对于数据源当中的价格进行排序 从低到高
                sortGoodsList();
                break;
        }
    }

    /* 对于商品列表进行排序的方法*/
    private void sortGoodsList() {
        if (isAscPrice) {
            mDatas.sort(Comparator.comparingDouble(InfoBean::getPrice));
        } else {
            mDatas.sort((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
        }
        isAscPrice = !isAscPrice;
        // 提示适配器更新
        lvAdapter.notifyDataSetChanged();
        gvAdapter.notifyDataSetChanged();
    }
}