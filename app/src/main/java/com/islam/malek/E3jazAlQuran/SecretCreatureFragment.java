package com.islam.malek.E3jazAlQuran;


import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecretCreatureFragment extends ListFragment {
    private InterstitialAd mInterstitialAd;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(
                inflater.getContext(),
                android.R.layout.simple_list_item_activated_1,
                getResources().getStringArray(R.array.create)
        );
        setListAdapter(arrayAdapter);

        //add inestrial app .....
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-6570381802681746/6102101712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(position==0||position==2||position==4||position==6||position==8
                ||position==10||position==12||position==14||position==16||position==18
                ||position==20||position==22||position==24){
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }}
            Intent intent=new Intent(getActivity(),createActivity.class);
        intent.putExtra("positioncreate",position);
        getActivity().startActivity(intent);
    }
}
