package com.animee.rf_week02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.animee.rf_week02.CartActivity;
import com.animee.rf_week02.R;
import com.animee.rf_week02.bean.ContentDatas;
import com.animee.rf_week02.bean.InfoBean;
import com.animee.rf_week02.view.AmountView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CartAdapter extends BaseAdapter {

    Context context;
    List<InfoBean> mDatas;

    public CartAdapter(Context context, List<InfoBean> mDatas) {
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
            view = LayoutInflater.from(context).inflate(R.layout.item_detaillv, viewGroup, false);
            holder = new VHolder(view);
            view.setTag(holder);
        } else {
            holder = (VHolder) view.getTag();
        }
        InfoBean bean = mDatas.get(i);


        holder.titleTv.setText(bean.getTitle());
        holder.priceTv.setText("￥ " + bean.getPrice());
        holder.typeTv.setText("日常用品 - " + bean.getKind());
        // 使用picasso加载网络图片加载到本地上
        Picasso.with(context).load(bean.getPic()).into(holder.iv);
        // 设置数量选择器
        holder.amountView.setStorage(bean.getCount());
        // =============================================================
        holder.amountView.setShowCount(bean.getBuycount());
        // 设置按钮的监听事件
        VHolder finalHolder = holder;

        // 设置数量调节器的监听事件
        holder.amountView.setOnAmountListener(num -> {
            bean.setBuycount(num);
            // 重新计算总价格
            ((CartActivity) context).calculateTotalToTv();
        });
        // 设定删除按钮点击事件
        holder.delIv.setOnClickListener(view1 -> {
            mDatas.remove(bean);
            notifyDataSetChanged();
            ((CartActivity) context).calculateTotalToTv();
        });
        return view;
    }
    class VHolder {
        ImageView iv, delIv;
        TextView titleTv, priceTv, typeTv;
        AmountView amountView;
        Button buyBtn;

        public VHolder(View v) {
            iv = v.findViewById(R.id.item_dl_iv);
            delIv = v.findViewById(R.id.item_dl_iv_del);
            titleTv = v.findViewById(R.id.item_dl_tv_title);
            priceTv = v.findViewById(R.id.item_dl_tv_price);
            typeTv = v.findViewById(R.id.item_dl_tv_type);
            amountView = v.findViewById(R.id.item_dl_av);
            buyBtn = v.findViewById(R.id.item_dl_btn_buy);
            buyBtn.setVisibility(View.GONE);
            delIv.setVisibility(View.VISIBLE);
        }
    }
}
