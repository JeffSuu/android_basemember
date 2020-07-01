package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.widget.InteralStorageActivity;

public class StorageActivity extends AppCompatActivity {
    private Button mBt1, mBt2;
    private TextView mTv;
    private Mybroadcast mybroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        mBt1 = findViewById(R.id.shared_1);
        mBt2 = findViewById(R.id.interal_storage);
        mTv=findViewById(R.id.tv_cast);
        onClick onclick=new onClick();
        mBt1.setOnClickListener(onclick);
        mBt2.setOnClickListener(onclick);
        mybroadcast=new Mybroadcast();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.test");
        LocalBroadcastManager.getInstance(this).registerReceiver( mybroadcast,intentFilter);

    }
    class onClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.shared_1:
                    intent = new Intent(getApplicationContext(), HandlerActivity.class);
                    startActivity(intent);
                    break;
                case R.id.interal_storage:
                    intent = new Intent(getApplicationContext(), InteralStorageActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
    class Mybroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "com.example.test":
                    mTv.setText("收到广播！");
                    break;

            }
        }
    }
}

