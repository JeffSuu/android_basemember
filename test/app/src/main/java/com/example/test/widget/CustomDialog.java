package com.example.test.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.test.R;

public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView mTvTitle, mTvMessage, mTvCancel, mTvConfirm;

    private String title, massage, cancel, confirm;
    private IOCancelListener cancelListener;
    private IOConfirmListener confirmListener;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeId) {
        super(context, themeId);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMassage(String massage) {
        this.massage = massage;
        return this;
    }

    public CustomDialog setCancel(String cancel,IOCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener=listener;
        return this;

    }

    public CustomDialog setConfirm(String confirm,IOConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener=listener;
        return this;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialag);
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p= getWindow().getAttributes();
        Point size =new Point();
        d.getSize(size);
        p.width=(int)(size.x*0.8);//设置dialog的宽度为当前手机屏幕*0.8
        mTvTitle = findViewById(R.id.tv_title);
        mTvMessage = findViewById(R.id.tv_meg);
        mTvCancel = findViewById(R.id.tv_cancle);
        mTvConfirm = findViewById(R.id.tv_confir);
        if (!TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(massage)) {
            mTvMessage.setText(massage);
        }
        if (!TextUtils.isEmpty(cancel)) {
            mTvCancel.setText(cancel);
        }
        if (!TextUtils.isEmpty(confirm)) {
            mTvConfirm.setText(confirm);
        }
        mTvConfirm.setOnClickListener(this);
        mTvCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_confir:
                if(confirmListener!=null){
                    confirmListener.onConfirm(this);
                }dismiss();
                break;
            case R.id.tv_cancle:
                if(cancelListener!=null){
                    cancelListener.onCancel(this);
                }dismiss();
                break;
        }
    }

    public interface IOCancelListener{
        void onCancel(CustomDialog dialog);
    }
    public interface IOConfirmListener{
        void onConfirm(CustomDialog dialog);
    }
}
