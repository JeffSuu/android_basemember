package com.example.test.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.LinearViewHolder> {
    @NonNull

    private Context mContext;
    private OnItemClickListener mlistener;

    public GridAdapter(Context context, OnItemClickListener listener){
        mContext=context;
        this.mlistener=listener;
    }
    @Override
    public GridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_gridrecycler_iterm,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("Hello World!");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mlistener.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 50;
    }
    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_title);
        }
    }
    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
