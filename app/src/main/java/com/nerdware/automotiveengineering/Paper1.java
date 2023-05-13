package com.nerdware.automotiveengineering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nerdware.automotiveengineering.paper_i.PaperAdapter;

import java.util.ArrayList;

public class Paper1 extends AppCompatActivity {

    private AdView mAdView;
    RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper1);
        mAdView = findViewById(R.id.ads);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        recyclerView = findViewById(R.id.paper_recyclerview);
        MobileAds.initialize(this);
        ImageView imageView = findViewById(R.id.back_btn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ArrayList<paper_i_items> paper_i_itemsArrayList = new ArrayList<>();

        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        paper_i_itemsArrayList.add(new paper_i_items(R.drawable.e1,"Mathematics"));
        paper_i_itemsArrayList.add(new paper_i_items(R.drawable.e2,"Applied  Science & Electrical principles"));
        paper_i_itemsArrayList.add(new paper_i_items(R.drawable.e3,"Motor Vehicle Trade Practice 1"));
        paper_i_itemsArrayList.add(new paper_i_items(R.drawable.e4,"Technical Drawing"));
        paper_i_itemsArrayList.add(new paper_i_items(R.drawable.e6,"Vehicle Technology & Workshop Technology & Body Work"));
        paper_i_itemsArrayList.add(new paper_i_items(R.drawable.j,"ICT & Entrepreneurship"));

        PaperAdapter paperAdapter = new PaperAdapter(paper_i_itemsArrayList, this);
        recyclerView.setAdapter(paperAdapter);
        paperads.loadads(Paper1.this);
    }
}