package com.shan.merchant.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.shan.merchant.R;


/**
 * Created by chenjunshan on 7/18/17.
 */

public abstract class HintDialog {
    private Context context;
    private AlertDialog dialog;
    private int content;

    public HintDialog(Context context, int content) {
        this.context = context;
        this.content = content;
    }

    public void show() {
        if (dialog != null) {
            dialog.show();
            return;
        }
        dialog = new AlertDialog.Builder(context).setTitle(context.getResources().getString(R.string.str_hint))//设置对话框标题

                .setMessage(context.getResources().getString(content))//设置显示的内容

                .setPositiveButton(context.getResources().getString(R.string.str_qd), new DialogInterface.OnClickListener() {//添加确定按钮
                    @Override

                    public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件
                        ok();
                    }

                }).setNegativeButton(context.getResources().getString(R.string.str_cancel), new DialogInterface.OnClickListener() {//添加返回按钮


                    @Override

                    public void onClick(DialogInterface dialog, int which) {//响应事件
                        dismiss();
                        cancel();
                    }

                }).show();//在按键响应事件中显示此对话框
    }

    public void dismiss() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public abstract void ok();

    public abstract void cancel();
}
