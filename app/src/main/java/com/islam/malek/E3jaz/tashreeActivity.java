package com.islam.malek.E3jaz;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class tashreeActivity extends Activity {
int position;
    String  title[];
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tashree);


        position=(int)getIntent().getExtras().get("positiontashree");

       // getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));

        title=getResources().getStringArray(R.array.tashree);
        getActionBar().setTitle(title[position]);

        webView=(WebView)findViewById(R.id.webtashree);
        webView.loadUrl("file:///android_asset/tashree/tashree"+position+".html");




    }
}
