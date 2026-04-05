package com.ch10coder.codeserver;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Use a simple layout with just a WebView
        myWebView = new WebView(this);
        setContentView(myWebView);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        
        // This makes it look better on phones
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        myWebView.setWebViewClient(new WebViewClient());

        // Smart Keyboard Tweak: 
        // This makes sure VS Code's editor "shrinks" instead of getting hidden.
        myWebView.setVerticalScrollBarEnabled(false);
        myWebView.setHorizontalScrollBarEnabled(false);

        // LOAD YOUR CODE-SERVER HERE!
        // We'll use localhost because that's where code-server runs
        myWebView.loadUrl("http://localhost:8080");
    }

    // This handles the "Back" button so it doesn't just exit the app
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
