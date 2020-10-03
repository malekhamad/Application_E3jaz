package com.islam.malek.E3jaz;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;



public class earthActivity extends Activity {
WebView webView;
    int position;
    String a[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth);
        // Add Banner Add In Bottom.......



        position= (int) getIntent().getExtras().get("position");
        a=getResources().getStringArray(R.array.earth);
    //    getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));



        getActionBar().setTitle(a[position]);
        webView=(WebView)findViewById(R.id.webearth);
        webView.loadUrl("file:///android_asset/earth/earth"+position+".html");




    }

}
