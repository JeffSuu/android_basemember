package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.test.widget.CustomDialog;

public class DialagActivity extends AppCompatActivity {
    private Button nBtn1, nBtn2, nBtn3, nBtn4, nBtn5,nBtn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialag);
        nBtn1 = findViewById(R.id.dialog_1);
        nBtn2 = findViewById(R.id.dialog_2);
        nBtn3 = findViewById(R.id.dialog_3);
        nBtn4 = findViewById(R.id.dialog_4);
        nBtn5 = findViewById(R.id.dialog_5);
        nBtn6=findViewById(R.id.dialog_6);
        setListener();
    }

    public void setListener() {
        OnClick onClick = new OnClick();
        nBtn1.setOnClickListener(onClick);
        nBtn2.setOnClickListener(onClick);
        nBtn3.setOnClickListener(onClick);
        nBtn4.setOnClickListener(onClick);
        nBtn5.setOnClickListener(onClick);
        nBtn6.setOnClickListener(onClick);

    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.dialog_1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialagActivity.this);
                    builder.setTitle("请回答").setMessage("你觉得小苏怎么样？")
                            .setPositiveButton("好帅！", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToasUril.showmwssage(DialagActivity.this, "你很诚实...");
                                }
                            }).setNeutralButton("就那样吧...", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToasUril.showmwssage(getApplicationContext(), "你再仔细看看...");
                        }
                    }).setNegativeButton("一般般吧...", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToasUril.showmwssage(DialagActivity.this, "睁眼说瞎话...");
                        }
                    }).setIcon(R.drawable.international).show();
                    break;
                case R.id.dialog_2:
                    final String[] array2 = new String[]{"man", "woman"};
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(DialagActivity.this);
                    builder1.setTitle("Choose the sex:").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToasUril.showmwssage(DialagActivity.this, array2[which]);
                        }
                    }).show();
                    break;
                case R.id.dialog_3:
                    final String[] array3 = new String[]{"man", "woman"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialagActivity.this);
                    builder2.setTitle("Choose the sex:").setSingleChoiceItems(array3, 1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToasUril.showmwssage(DialagActivity.this, array3[which]);

                        }
                    }).show();
                    break;
                case R.id.dialog_4:
                    final String[] array4 = new String[]{"sing", "dance", "coding"};
                    boolean[] isSelected = new boolean[]{false, false, true};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialagActivity.this);
                    builder3.setTitle("what do I want to do?").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToasUril.showmwssage(DialagActivity.this, array4[which] + " is " + isChecked);
                        }
                    }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
                    break;
                case R.id.dialog_5:
                    AlertDialog.Builder builder4=new AlertDialog.Builder(DialagActivity.this);
                    View view= LayoutInflater.from(DialagActivity.this).inflate(R.layout.dialog,null);
                    EditText Et1=view.findViewById(R.id.et_usr);
                    EditText Et2=view.findViewById(R.id.et_pass);
                    Button nBt=view.findViewById(R.id.rt_bt);
                    nBt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                    builder4.setView(view).setTitle("请先登录").show();

                    break;
                case R.id.dialog_6:
                    CustomDialog customDialog=new CustomDialog(DialagActivity.this);
                    customDialog.setTitle("提示").setMassage("确认删除此项？")
                            .setConfirm("确认", new CustomDialog.IOConfirmListener() {
                                @Override
                                public void onConfirm(CustomDialog dialog) {

                                }
                            }).setCancel("取消", new CustomDialog.IOCancelListener() {
                        @Override
                        public void onCancel(CustomDialog dialog) {

                        }
                    }).show();
            }
        }
    }
}
