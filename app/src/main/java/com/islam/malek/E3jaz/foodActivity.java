package com.islam.malek.E3jaz;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class foodActivity extends Activity {
    int position ;
    String title[];
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        position=(int)getIntent().getExtras().get("positionfood");

        title=getResources().getStringArray(R.array.food);

        getActionBar().setTitle(title[position]);
     //   getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));

        webView=(WebView)findViewById(R.id.webfood);
        webView.loadUrl("file:///android_asset/food/food"+position+".html");






    }
}
