package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {
    private Button btn_1,btn_2,btn_3,btn_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        btn_1=findViewById(R.id.toast_1);
        btn_2=findViewById(R.id.toast_2);
        btn_3=findViewById(R.id.toast_3);
        btn_4=findViewById(R.id.toast_4);
        Onclick onclick=new Onclick();
        btn_1.setOnClickListener(onclick);
        btn_2.setOnClickListener(onclick);
        btn_3.setOnClickListener(onclick);
        btn_4.setOnClickListener(onclick);
    }
    class Onclick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
        switch (v.getId()){
            case R.id.toast_1:
                Toast.makeText(ToastActivity.this,"Toast",Toast.LENGTH_SHORT).show();
                break;
            case R.id.toast_2:
                Toast toastCenrer= Toast.makeText(ToastActivity.this,"Toast",Toast.LENGTH_SHORT);
                toastCenrer.setGravity(Gravity.CENTER,0,0);
                toastCenrer.show();
                break;
            case R.id.toast_3:
                Toast customer=new Toast(getApplicationContext());
                LayoutInflater inflater=LayoutInflater.from(getApplicationContext());
                View view=     inflater.inflate(R.layout.layout_toast,null);
                TextView textView=view.findViewById(R.id.tv_title);
                ImageView imageView=view.findViewById(R.id.tv_toast);
                imageView.setImageResource(R.drawable.international);
                textView.setText("I love learning...");
                customer.setView(view);
                customer.show();
                break;
            case R.id.toast_4:
                ToasUril.showmwssage(getApplicationContext(),"封装好啦...");
                break;
        }
        }
    }

}
