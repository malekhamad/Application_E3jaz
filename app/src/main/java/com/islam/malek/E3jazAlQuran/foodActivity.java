package com.islam.malek.E3jazAlQuran;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class foodActivity extends Activity {
    int position ;
    String title[];
    WebView webView;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        // Add Banner Add In Bottom........
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        position=(int)getIntent().getExtras().get("positionfood");

        title=getResources().getStringArray(R.array.food);

        getActionBar().setTitle(title[position]);
     //   getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));

        webView=(WebView)findViewById(R.id.webfood);
        webView.loadUrl("file:///android_asset/food/food"+position+".html");






    }
}
