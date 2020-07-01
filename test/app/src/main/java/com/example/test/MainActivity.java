package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.test.fragment.ContinerActivity;
import com.example.test.grideview.GrideViewActivity;
import com.example.test.recyclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {
    private Button edit1;
    private Button radioo1;
    private Button check1;
    private Button Image1;
    private Button gride1;
    private Button recycler1;
    private Button webview_1;
    private Button nToast1;
    private Button dialog1;
    private Button process1;
    private Button pop1;
    private Button hand1;
    private Button con1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit_1);
        radioo1 = findViewById(R.id.radio_1);
        check1 = findViewById(R.id.check_1);
        Image1 = findViewById(R.id.Image_1);
        gride1 = findViewById(R.id.gride_1);
        recycler1 = findViewById(R.id.recycler_1);
        webview_1 = findViewById(R.id.web_1);
        nToast1 = findViewById(R.id.toast_1);
        dialog1 = findViewById(R.id.dialog_1);
        process1 = findViewById(R.id.process_1);
        pop1 = findViewById(R.id.pop_1);
        con1 = findViewById(R.id.con_1);
        hand1=findViewById(R.id.hand_1);

        setListeners();
    }

    public void setListeners() {
        OnClick onClick = new OnClick();
        edit1.setOnClickListener(onClick);
        radioo1.setOnClickListener(onClick);
        check1.setOnClickListener(onClick);
        Image1.setOnClickListener(onClick);
        gride1.setOnClickListener(onClick);
        recycler1.setOnClickListener(onClick);
        webview_1.setOnClickListener(onClick);
        nToast1.setOnClickListener(onClick);
        dialog1.setOnClickListener(onClick);
        process1.setOnClickListener(onClick);
        pop1.setOnClickListener(onClick);
        con1.setOnClickListener(onClick);
        hand1.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.edit_1:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.radio_1:
                    intent = new Intent(MainActivity.this, Radio_1.class);
                    break;
                case R.id.check_1:
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.Image_1:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.gride_1:
                    intent = new Intent(MainActivity.this, GrideViewActivity.class);
                    break;
                case R.id.recycler_1:
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.web_1:
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                case R.id.toast_1:
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;
                case R.id.dialog_1:
                    intent = new Intent(MainActivity.this, DialagActivity.class);
                    break;
                case R.id.process_1:
                    intent = new Intent(MainActivity.this, ProcessActivity.class);
                    break;
                case R.id.pop_1:
                    intent = new Intent(MainActivity.this, PopActivity.class);
                    break;
                case R.id.con_1:
                    intent = new Intent(MainActivity.this, ContinerActivity.class);
                    break;
                case R.id.hand_1:
                    intent=new Intent(MainActivity.this,HandlerActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
