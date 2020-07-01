package com.example.test.grideview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.test.R;

public class MyGrideViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public MyGrideViewAdapter(Context context) {
        this.mContext = context;
        mLayoutInflater= LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        public ImageView imageView;
        public TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView=mLayoutInflater.inflate(R.layout.layout_grid_item,null);
            holder=new ViewHolder();
            holder.textView=convertView.findViewById(R.id.gv_tv);
            holder.imageView=convertView.findViewById(R.id.gv_iv);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
    }//赋值
        holder.textView.setText("花");
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591717807442&di=cdc4e25961540b455a312fe13d9785ee&imgtype=0&src=http%3A%2F%2Fobs-f582.obs.cn-north-1.myhwclouds.com%2Fattachment%2Fuploads2010%2F11%2Fuserid269680time20101127050247.jpg").into(holder.imageView);
        return convertView;
}
}
