package com.nerdware.automotiveengineering;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Setting extends AppCompatActivity {
    private AdView mAdView, banner, bans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        MobileAds.initialize(this);
        mAdView = findViewById(R.id.adView);
        banner = findViewById(R.id.mp);
        bans = findViewById(R.id.ad3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        banner.loadAd(adRequest);
        bans.loadAd(adRequest);
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.SMART_BANNER);
// TODO: Add adView to your view hierarchy.
        ImageView imageView = findViewById(R.id.back_btn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}