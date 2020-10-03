package com.islam.malek.E3jaz;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;



public class balaghiActivity extends Activity {

    int position;
    String title[];
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balaghi);
        int position = (int) getIntent().getExtras().get("positionbalagh");



            title = getResources().getStringArray(R.array.balaghi);

            getActionBar().setTitle(title[position]);
         //   getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));
            webView = (WebView) findViewById(R.id.webbalaghi);
            webView.loadUrl("file:///android_asset/balaghi/balaghi" + position + ".html");




    }

}
