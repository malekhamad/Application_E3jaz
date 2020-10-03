package com.islam.malek.E3jaz;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;



public class createActivity extends Activity {
int position;
    String title[];
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);



        position=(int)getIntent().getExtras().get("positioncreate");


        title=getResources().getStringArray(R.array.create);

        position=(int)getIntent().getExtras().get("positioncreate");

        getActionBar().setTitle(title[position]);
       // getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));

        webView=(WebView)findViewById(R.id.webcreate);
        webView.loadUrl("file:///android_asset/create/create"+position+".html");





    }
}
