package com.animee.rf_week02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.animee.rf_week02.bean.ContentDatas;
import com.animee.rf_week02.view.TitleView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView typleLv;
    TitleView titleView;
    List<String> mDatas;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        // 初始化数据源
        mDatas = new ArrayList<>();
        // 设置适配器
        adapter = new ArrayAdapter<>(this, R.layout.item_mainlv,
                R.id.item_main_tv, mDatas);
        typleLv.setAdapter(adapter);
        // 获取数据
        loadDatas();

        setEvent();
    }

    private void setEvent() {
        typleLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, DetailTypeActivity.class);
                intent.putExtra("type", mDatas.get(position));
                startActivity(intent);
            }
        });
    }

    /** 获取并解析网络数据, 将数据放入mDatas数据源当中*/
    private void loadDatas() {
        mDatas.addAll(ContentDatas.dailyKindList);
        // 数据源信息发生改变, 提示适配器再刷新一下
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        typleLv = findViewById(R.id.main_lv);
        titleView = findViewById(R.id.main_titleview);
        // 设置标题栏内容
        titleView.setBgResource(R.color.red);
        titleView.setTitle(R.string.main_title);
        titleView.setTitleColor(Color.WHITE);
        titleView.setVisibleImg(View.VISIBLE, View.INVISIBLE);
        titleView.setOnClickLeftImgListener(view -> finish());
    }
}