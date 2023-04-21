package com.animee.rf_week02.view;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertDialogUtils {
    public interface OnBtnClickListener {
        public void onBtnClick();
    }

    public static void showNormalDialog(Context context, String title, String msg,
                                        String lInfo, String rInfo,
                                        OnBtnClickListener lListener, OnBtnClickListener rListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(msg)
                .setPositiveButton(rInfo, (dialog, i) -> {
                    if (rListener != null) {
                        rListener.onBtnClick();
                    }
                    dialog.cancel();
                }).setNegativeButton(lInfo, (dialog, i) -> {
                    if (lListener != null) {
                        lListener.onBtnClick();
                    }
                    dialog.cancel();
                });
        builder.create().show();
    }
}
