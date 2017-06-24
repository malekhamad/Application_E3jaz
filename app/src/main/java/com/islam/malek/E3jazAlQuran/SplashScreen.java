package com.islam.malek.E3jazAlQuran;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        int SplashTimer=4000;

  new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
          Intent intent=new Intent(getApplicationContext(),MainActivity.class);
              startActivity(intent);
          finish();
      }
  },SplashTimer);
    }
}
