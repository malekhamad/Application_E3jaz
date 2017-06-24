package com.islam.malek.E3jazAlQuran;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class balaghiActivity extends Activity {

    int position;
    String title[];
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balaghi);
        // Add Banner Add In Bottom........
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        int position = (int) getIntent().getExtras().get("positionbalagh");



            title = getResources().getStringArray(R.array.balaghi);

            getActionBar().setTitle(title[position]);
         //   getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));
            webView = (WebView) findViewById(R.id.webbalaghi);
            webView.loadUrl("file:///android_asset/balaghi/balaghi" + position + ".html");




    }

}
