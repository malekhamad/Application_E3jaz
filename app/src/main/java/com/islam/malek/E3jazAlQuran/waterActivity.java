package com.islam.malek.E3jazAlQuran;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class waterActivity extends Activity {
    private InterstitialAd interstitial;
WebView webView;
    String title[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        int position=(int)getIntent().getExtras().get("positionwater");





        title=getResources().getStringArray(R.array.water);
//getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));
        getActionBar().setTitle(title[position]);
        webView=(WebView)findViewById(R.id.webwater);

        webView.loadUrl("file:///android_asset/water/water"+position+".html");

    }
}
