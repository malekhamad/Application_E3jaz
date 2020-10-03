package com.islam.malek.E3jaz;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class doctorActivity extends Activity {
String title[];
    int position;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

       position=(int)getIntent().getExtras().get("positiondoctor");


       // getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));
        title=getResources().getStringArray(R.array.doctor);
        getActionBar().setTitle(title[position]);

        webView=(WebView)findViewById(R.id.webdoctor);
        webView.loadUrl("file:///android_asset/doctor/doctor"+position+".html");




    }
}
