package com.nerdware.automotiveengineering.dash;

import android.annotation.SuppressLint;
import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class dashinter {
    public static InterstitialAd minterstitialAd;

    public static void loadads(Activity activity){
        @SuppressLint("VisibleForTests") AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(activity, "ca-app-pub-2829905592411826/7978588405", adRequest, new InterstitialAdLoadCallback() {
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
