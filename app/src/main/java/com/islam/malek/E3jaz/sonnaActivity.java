package com.islam.malek.E3jaz;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class sonnaActivity extends Activity {

    int position;
    WebView webView;
    String title[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonna);


        position=(int)getIntent().getExtras().get("positionsonna");


        title=getResources().getStringArray(R.array.sonna);

        getActionBar().setTitle(title[position]);

       // getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));

        webView=(WebView)findViewById(R.id.websonna);

        webView.loadUrl("file:///android_asset/sonna/sonna"+position+".html");







    }
}
