package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProcessActivity extends AppCompatActivity {
    private ProgressBar mpb3;
    private Button mbt1;
    private Button mbt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        mpb3=findViewById(R.id.pb2);
        mpb3.setProgress(30);
        mbt1=findViewById(R.id.pb_start);
        mbt2=findViewById(R.id.pb_1);
        mbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog=new ProgressDialog(getApplicationContext());
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载...");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToasUril.showmwssage(getApplicationContext(),"finish...");
                    }
                });
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "棒...", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToasUril.showmwssage(getApplicationContext(),"finish...");
                    }
                });
                progressDialog.show();
            }
        });
        mbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            handler.sendEmptyMessage(0);
            }
        });
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (mpb3.getProgress()<100){
             handler.postDelayed(runnable,500);
            }else {
                ToasUril.showmwssage(getApplicationContext(),"加载完成");
            }
        }
    };
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            mpb3.setProgress(mpb3.getProgress()+5);
            handler.sendEmptyMessage(0);
        }
    };
}
