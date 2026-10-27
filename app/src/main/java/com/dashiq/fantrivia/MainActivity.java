package com.dashiq.fantrivia;
import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class MainActivity extends Activity {
    private WebView gameView;
    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        gameView=new WebView(this);
        gameView.setBackgroundColor(Color.rgb(11,16,32));
        gameView.setVerticalScrollBarEnabled(false);
        gameView.setHorizontalScrollBarEnabled(false);
        gameView.setWebViewClient(new WebViewClient());
        gameView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        WebSettings w=gameView.getSettings();
        w.setJavaScriptEnabled(true);
        w.setDomStorageEnabled(true);
        w.setAllowFileAccess(true);
        w.setAllowFileAccessFromFileURLs(false);
        w.setAllowUniversalAccessFromFileURLs(false);
        w.setBlockNetworkLoads(true);
        w.setAllowContentAccess(false);
        w.setJavaScriptCanOpenWindowsAutomatically(false);
        setContentView(gameView);
        gameView.loadUrl("file:///android_asset/index.html");
    }
    @Override public void onPause(){if(gameView!=null){gameView.onPause();gameView.pauseTimers();}super.onPause();}
    @Override public void onResume(){super.onResume();if(gameView!=null){gameView.onResume();gameView.resumeTimers();}}
    @Override public void onDestroy(){if(gameView!=null){gameView.destroy();gameView=null;}super.onDestroy();}
}
