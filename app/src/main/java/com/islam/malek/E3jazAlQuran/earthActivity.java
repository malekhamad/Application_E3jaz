package com.islam.malek.E3jazAlQuran;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class earthActivity extends Activity {
WebView webView;
    int position;
    String a[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth);
        // Add Banner Add In Bottom.......

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        position= (int) getIntent().getExtras().get("position");
        a=getResources().getStringArray(R.array.earth);
    //    getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));



        getActionBar().setTitle(a[position]);
        webView=(WebView)findViewById(R.id.webearth);
        webView.loadUrl("file:///android_asset/earth/earth"+position+".html");




    }

}
