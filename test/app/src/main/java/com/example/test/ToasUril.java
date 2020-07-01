package com.example.test;

import android.content.Context;
import android.widget.Toast;

public class ToasUril {
    public static Toast Toastmesg;
    public static void  showmwssage(Context context,String msg){
        if(Toastmesg==null){
            Toastmesg=Toast.makeText(context,msg,Toast.LENGTH_SHORT);

        }else{
            Toastmesg.setText(msg);

        }
        Toastmesg.show();
    }

}
