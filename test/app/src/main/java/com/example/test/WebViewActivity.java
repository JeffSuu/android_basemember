package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView wb_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        wb_1=findViewById(R.id.wb);
        //加载本地
       // wb_1.loadUrl("file:///android_asset/baidu.html");
        //加载网络
        wb_1.getSettings().setJavaScriptEnabled(true);
        wb_1.setWebViewClient(new MyWebViewClient());
        wb_1.setWebChromeClient(new MyWebChromeClient());
        wb_1.loadUrl("https://m.baidu.com");

    }
    class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
            //return super.shouldOverrideUrlLoading(view, request);

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView","onPageStarted...");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView","onPagefinished...");
            wb_1.loadUrl("javascript:alert('hello')");
        }
    }
    class MyWebChromeClient extends WebChromeClient{
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK&&wb_1.canGoBack()){
            wb_1.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
