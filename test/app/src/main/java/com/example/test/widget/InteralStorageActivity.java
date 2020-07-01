package com.example.test.widget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.test.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InteralStorageActivity extends AppCompatActivity {
    private Button mBtn2;
    private EditText mEt;
    private static String filename = "text.txt";
    TextView mTv;
    Button mBtn3;
    Button mBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interal_storage);
        mBtn2 = findViewById(R.id.shared_1);
        mBtn3 = findViewById(R.id.show_share);
        mEt = findViewById(R.id.et_share);
        mTv = findViewById(R.id.tv_show);
        mBtn4 = findViewById(R.id.broad_cast);
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEt.getText().toString());
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv.setText(read());
            }
        });
        mBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.test");
                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
            }
        });
    }

    private void save(String data) {
        OutputStream outputStream = null;
        try {
            outputStream = openFileOutput(filename, MODE_PRIVATE);
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String read() {
        InputStream inputStream = null;
        try {
            inputStream = openFileInput(filename);
            byte[] bf = new byte[1024];
            int len = 0;
            StringBuilder stringBuilder = new StringBuilder("");
            while ((len = inputStream.read(bf)) > 0) {
                stringBuilder.append(new String(bf, 0, len));
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
