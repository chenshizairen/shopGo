package com.animee.rf_week02.view;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
