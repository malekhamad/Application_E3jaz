package com.islam.malek.E3jaz;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class quranActvity extends Activity {
int position;
    String title[];
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran_actvity);

        position=(int)getIntent().getExtras().get("positionquran");


      //  getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));

        webView=(WebView)findViewById(R.id.webquran);
        title=getResources().getStringArray(R.array.quran);


        getActionBar().setTitle(title[position]);

        webView.loadUrl("file:///android_asset/quran/quran"+position+".html");







    }
}
