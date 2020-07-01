package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HandlerActivity extends AppCompatActivity {
    Button mBtn;
    Button mBtn2;
    Handler handler;
    EditText mEt;
    TextView mTv;
    Button mBtn3;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        mBtn = findViewById(R.id.start_handle);
        mBtn2=findViewById(R.id.shared_1);
        mBtn3=findViewById(R.id.show_share);
        mEt=findViewById(R.id.et_share);
        mTv=findViewById(R.id.tv_show);
        sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        editor=sharedPreferences.edit();
       mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(HandlerActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }, 3000);
            }
        });
//        new Thread() {
//            public void run() {
//                super.run();
//                Message message = new Message();
//                message.what = 1;
//                handler.sendMessage(message);
//            }
//        }.start();
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("name",mEt.getText().toString());
                editor.apply();
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mTv.setText(sharedPreferences.getString("name",""));
            }
        });
    }

}
//        handler=new Handler(){


//            @Override
//            public void handleMessage(@NonNull Message msg) {
//                super.handleMessage(msg);
//                switch (msg.what){
//                    case 1:
//                        ToasUril.showmwssage(getApplicationContext(),"现成通信完成！");

//                }
//            }
//        };