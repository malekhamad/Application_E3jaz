package com.islam.malek.E3jazAlQuran;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class skyActivity extends Activity {
    private InterstitialAd interstitial;

    WebView webView;
    String skytitle[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sky);
        int position=(int)getIntent().getExtras().get("positionsky");
        // Add Banner Add In Bottom........
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

       // getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));
        skytitle=getResources().getStringArray(R.array.sky);
        getActionBar().setTitle(skytitle[position]);
        webView=(WebView)findViewById(R.id.websky);
        webView.loadUrl("file:///android_asset/sky/sky"+position+".html");


    }
}
