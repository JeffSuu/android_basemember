package com.example.test.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.test.R;

public class HorRecyclerActivity extends AppCompatActivity {
    private RecyclerView mRecycle1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycler);
        mRecycle1=findViewById(R.id.rv_hor);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(HorRecyclerActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mRecycle1.setLayoutManager(linearLayoutManager);
        mRecycle1.addItemDecoration(new MyDecoration() );
        mRecycle1.setAdapter(new HorAdapter(HorRecyclerActivity.this, new HorAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HorRecyclerActivity.this,"click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight),0);
        }
    }
}
