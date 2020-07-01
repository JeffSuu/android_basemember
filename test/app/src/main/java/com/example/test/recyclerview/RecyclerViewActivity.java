package com.example.test.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test.R;

public class RecyclerViewActivity extends AppCompatActivity {
    private Button mBtn_1;
    private Button mBtn_2;
    private Button mBtn_3;
    private Button mBtn_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mBtn_1=findViewById(R.id.btn_linear);
        mBtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerViewActivity.this,LinearRecyclerViewActivity.class);
                startActivity(intent);

            }
        });
        mBtn_2=findViewById(R.id.btn_hor);
        mBtn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerViewActivity.this,HorRecyclerActivity.class);
                startActivity(intent);
            }
        });
        mBtn_3=findViewById(R.id.btn_grid);
        mBtn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerViewActivity.this,GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        mBtn_4=findViewById(R.id.btn_pu);
        mBtn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerViewActivity.this,PuRecyclerActivity.class);
                startActivity(intent);
            }
        });
    }
}
