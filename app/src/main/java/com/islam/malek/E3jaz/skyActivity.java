package com.islam.malek.E3jaz;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class skyActivity extends Activity {

    WebView webView;
    String skytitle[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sky);
        int position=(int)getIntent().getExtras().get("positionsky");

       // getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));
        skytitle=getResources().getStringArray(R.array.sky);
        getActionBar().setTitle(skytitle[position]);
        webView=(WebView)findViewById(R.id.websky);
        webView.loadUrl("file:///android_asset/sky/sky"+position+".html");


    }
}
