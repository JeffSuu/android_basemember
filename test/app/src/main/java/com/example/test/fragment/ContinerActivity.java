package com.example.test.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.test.R;

public class ContinerActivity extends AppCompatActivity {
    private Button trans;
    private Afragment afragment;
    private Bfragment bfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continer);
        trans=findViewById(R.id.con_bt);
        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bfragment==null){
                    bfragment=new Bfragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_1,bfragment).commitAllowingStateLoss();
            }
        });
        afragment=Afragment.newInstance("第一个Fragment要好好学习...");
        //尽量调用comitallow避免出现问题
             getSupportFragmentManager().beginTransaction().add(R.id.frame_1,afragment).commitAllowingStateLoss();
    }
}
