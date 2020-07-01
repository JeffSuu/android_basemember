package com.example.test.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test.R;

public class Afragment extends Fragment {
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_afragment,container,false);

        return view;
    }
    public  static Afragment newInstance(String title){
        Afragment afragment=new Afragment();
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        afragment.setArguments(bundle);
        return afragment;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView=view.findViewById(R.id.af_tv);
        Bundle bundle=getArguments();
        String title=bundle.getString("title");
        textView.setText(title);

    }
}
