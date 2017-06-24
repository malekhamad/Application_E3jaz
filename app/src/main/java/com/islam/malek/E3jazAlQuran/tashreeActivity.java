package com.islam.malek.E3jazAlQuran;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class tashreeActivity extends Activity {
int position;
    String  title[];
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tashree);
        // Add Banner Add In Bottom........
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        position=(int)getIntent().getExtras().get("positiontashree");

       // getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));

        title=getResources().getStringArray(R.array.tashree);
        getActionBar().setTitle(title[position]);

        webView=(WebView)findViewById(R.id.webtashree);
        webView.loadUrl("file:///android_asset/tashree/tashree"+position+".html");




    }
}
