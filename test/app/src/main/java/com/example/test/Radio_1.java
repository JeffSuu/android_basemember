package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Radio_1 extends AppCompatActivity {
    private RadioGroup bn_rg1;
    private RadioGroup bn_rg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_1);
    bn_rg1=findViewById(R.id.rg_1);
    bn_rg2=findViewById(R.id.rg_2);
    bn_rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton radioButton=group.findViewById(checkedId);
            Toast.makeText(Radio_1.this,radioButton.getText(),Toast.LENGTH_SHORT).show();
        }
    });
    }
}
