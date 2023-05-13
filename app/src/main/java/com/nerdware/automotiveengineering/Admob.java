package com.nerdware.automotiveengineering;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Admob {
    public static InterstitialAd minterstitialAd;

    public static void loadads(Activity activity){
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(activity, "ca-app-pub-2829905592411826/9100098387", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                minterstitialAd = interstitialAd;

            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                minterstitialAd = null;
            }
        });
    }
}
