package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class PopActivity extends AppCompatActivity {
    private Button pop1;
    private Button pop2;
    private PopupWindow mPop;
    private  PopupWindow mpop_zidingyi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        pop1=findViewById(R.id.pop_start);
        pop2=findViewById(R.id.pop_zidingyi);
        pop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=getLayoutInflater().inflate(R.layout.layout_pop_1,null);
                TextView textView=view.findViewById(R.id.tv_1);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToasUril.showmwssage(PopActivity.this,"好滴，可以撤了");
                    }
                });
                mPop=new PopupWindow(view,pop1.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                mPop.setOutsideTouchable(true);
                mPop.setFocusable(true);
                mPop.showAsDropDown(pop1,-20,20);

            }
        });
        pop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view=getLayoutInflater().inflate(R.layout.layout_pop,null);
                mpop_zidingyi=new PopupWindow(view,430, ViewGroup.LayoutParams.WRAP_CONTENT);
                mpop_zidingyi.showAtLocation(v, Gravity.BOTTOM,0,100);
                //设置背景颜色为0.5f的透明度

            }
        });
    }
}
