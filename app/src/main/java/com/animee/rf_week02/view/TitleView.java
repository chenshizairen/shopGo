package com.animee.rf_week02.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.animee.rf_week02.R;

/**
 * 接口回调:
 * 当这个类的某项事件由他触发, 但是功能不是由他决定, 就可以用接口回调解决
 * 1. 创建接口, 编写回调方法
 * 2. 在这个类中, 将接口设置为成员变量, 然后通过set方法对其进行赋值
 * 2. 在被触发的地方调用这个接口的方法
 */
public class TitleView extends RelativeLayout implements View.OnClickListener {
    private ImageView leftIv, rightIv;
    private TextView titleTv;
    private RelativeLayout layout;

    public interface OnclickImgListener {
        public void onClick(View view);
    }

    OnclickImgListener leftListener, rightListener;

    public void setOnClickLeftImgListener(OnclickImgListener leftListener) {
        this.leftListener = leftListener;
    }

    public void setOnClickRightImgListener(OnclickImgListener rightListener) {
        this.rightListener = rightListener;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_iv_left:
//                ((Activity)getContext()).finish();
                if (leftListener != null) {
                    leftListener.onClick(view);
                }
                break;
            case R.id.title_iv_right:
                if (rightListener != null) {
                    rightListener.onClick(view);
                }
                break;
        }
    }

    // 在代码当中创建view对象时, 会调用的构造方法
    public TitleView(Context context) {
        this(context, null);
    }

    // 在布局当中些view对象时, 会调用的构造方法
    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout, this);
        initView();
        setEvent();
    }

    private void setEvent() {
        leftIv.setOnClickListener(this);
        rightIv.setOnClickListener(this);
    }

    private void initView() {
        leftIv = findViewById(R.id.title_iv_left);
        rightIv = findViewById(R.id.title_iv_right);
        titleTv = findViewById(R.id.title_tv);
        layout = findViewById(R.id.title_view);
    }

    /**
     * 设置标题
     */
    public void setTitle(String title) {
        titleTv.setText(title);
    }

    public void setTitle(int titleId) {
        titleTv.setText(titleId);
    }

    /**
     * 设置标题颜色
     */
    public void setTitleColor(int color) {
        titleTv.setTextColor(color);
    }

    /**
     * 设置背景颜色
     */
    public void setBgResource(int color) {
        layout.setBackgroundResource(color);
    }

    public void setBdColor(int color) {
        layout.setBackgroundColor(color);
    }

    /**
     * 设置是否显示左右图片
     */
    public void setVisibleImg(int left, int right) {
        leftIv.setVisibility(left);
        rightIv.setVisibility(right);
    }

    /**
     * 修改左边显示图片
     */
    public void setLeftImgResource(int resId) {
        leftIv.setImageResource(resId);
    }

    public void setRightImgResource(int resId) {
        rightIv.setImageResource(resId);
    }

}
