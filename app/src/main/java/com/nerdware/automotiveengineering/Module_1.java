package com.nerdware.automotiveengineering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.MobileAds;
import com.nerdware.automotiveengineering.Module1.ModuleAdapter;
import com.nerdware.automotiveengineering.Module1.module_item;

import java.util.ArrayList;

public class Module_1 extends AppCompatActivity {
        private ModuleAdapter adapter;

    Activity activity;
    RecyclerView recyclerView;

    ArrayList<module_item> itemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1);

        MobileAds.initialize(this);
        AdView mAdView = findViewById(R.id.module1);
        com.google.android.gms.ads.AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
// TODO: Add adView to your view hierarchy.

        recyclerView = findViewById(R.id.module_recyclerview);
        ImageView imageView = findViewById(R.id.back_btn);

        imageView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (Admob.minterstitialAd != null) {
                    Admob.minterstitialAd.show(activity);
                    Admob.minterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            Admob.minterstitialAd = null;
                            Admob.loadads(activity);
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                            super.onAdFailedToShowFullScreenContent(adError);
                            Admob.minterstitialAd = null;
                            Admob.loadads(activity);
                        }
                    });
                }
                onBackPressed();
            }
        });

        itemArrayList = new ArrayList<>();

        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        itemArrayList.add(new module_item(R.drawable.math1,"Mathematics 1",""));
        itemArrayList.add(new module_item(R.drawable.as,"Applied Science"," "));
        itemArrayList.add(new module_item(R.drawable.a,"Technical Drawing 1"," "));
        itemArrayList.add(new module_item(R.drawable.i,"Electrical Principles"," "));
        itemArrayList.add(new module_item(R.drawable.b,"Entrepreneurship"," "));
        itemArrayList.add(new module_item(R.drawable.j,"Information Technology"," "));
        itemArrayList.add(new module_item(R.drawable.ve,"Vehicle Technology"," "));
        itemArrayList.add(new module_item(R.drawable.vb,"Vehicle Body Works",""));
        itemArrayList.add(new module_item(R.drawable.ws,"Workshop Technology",""));



        ModuleAdapter moduleAdapter = new ModuleAdapter(itemArrayList, Module_1.this, (position, o) -> {

        });
        recyclerView.setAdapter(moduleAdapter);


        Admob.loadads(Module_1.this);
    }
}