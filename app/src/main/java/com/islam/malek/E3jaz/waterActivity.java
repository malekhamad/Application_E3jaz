package com.islam.malek.E3jaz;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class waterActivity extends Activity {
WebView webView;
    String title[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);



        int position=(int)getIntent().getExtras().get("positionwater");





        title=getResources().getStringArray(R.array.water);
//getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));
        getActionBar().setTitle(title[position]);
        webView=(WebView)findViewById(R.id.webwater);

        webView.loadUrl("file:///android_asset/water/water"+position+".html");

    }
}
