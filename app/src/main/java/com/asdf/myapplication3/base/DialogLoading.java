package com.asdf.myapplication3.base;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * 加载对话框
 */
public class DialogLoading extends ProgressDialog {

    public DialogLoading(Context context) {
        super(context);
        this.setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    public void setDialogLabel(String label) {
        setMessage(label);
    }
}
