package com.example.test.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull

    private Context mContext;
    private OnItemClickListener mlistener;

    public LinearAdapter(Context context,OnItemClickListener listener){
        mContext=context;
        this.mlistener=listener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==0){
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_iterm,parent,false));

        }else{
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_iterm_2,parent,false));
        }

    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2==0){
            return 0;
        }else {
            return 1;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position)==0){
            ((LinearViewHolder)holder).textView.setText("Hello World!");
        }else{
            ((LinearViewHolder2)holder).textView.setText("小苏爱学习！");

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistener.onClick(position);
            }
        } );

    }

    @Override
    public int getItemCount() {
        return 30;
    }
    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_title);
        }
    }
    class LinearViewHolder2 extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;
        public LinearViewHolder2(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_title);
            imageView=itemView.findViewById(R.id.iv);
        }
    }
    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
