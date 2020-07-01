package com.example.test.grideview;

import android.os.Bundle;
import android.text.NoCopySpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

public class GrideViewActivity extends AppCompatActivity {
    private GridView mGv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grideview);
        mGv=findViewById(R.id.gv);
        mGv.setAdapter(new MyGrideViewAdapter(GrideViewActivity.this));
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GrideViewActivity.this,"点击 pos"+position,Toast.LENGTH_SHORT).show();
            }
        });
        mGv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GrideViewActivity.this,"长按 pos"+position,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
