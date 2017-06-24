package com.islam.malek.E3jazAlQuran;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class sonnaActivity extends Activity {

    int position;
    WebView webView;
    String title[];
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonna);
// Add Banner Add In Bottom........
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        position=(int)getIntent().getExtras().get("positionsonna");


        title=getResources().getStringArray(R.array.sonna);

        getActionBar().setTitle(title[position]);

       // getActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));

        webView=(WebView)findViewById(R.id.websonna);

        webView.loadUrl("file:///android_asset/sonna/sonna"+position+".html");







    }
}
