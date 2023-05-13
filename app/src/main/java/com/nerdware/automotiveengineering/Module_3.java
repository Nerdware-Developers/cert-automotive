package com.nerdware.automotiveengineering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.tv.AdRequest;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class Module_3 extends AppCompatActivity {
    private module_3_Adapter module3Adapter;
    ArrayList<module_3_item> items;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module3);



// TODO: Add adView to your view hierarchy.
        RecyclerView recyclerView = findViewById(R.id.module_recyclerview);
        ImageView imageView = findViewById(R.id.back_btn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        items = new ArrayList<>();

        items.add(new module_3_item(R.drawable.g,"Mathematics", ""));
        items.add(new module_3_item(R.drawable.cms,"Communication Skills", ""));
        items.add(new module_3_item(R.drawable.ls,"Life Skills", ""));
        items.add(new module_3_item(R.drawable.a," Technical Drawing", ""));
        items.add(new module_3_item(R.drawable.vee,"Vehicle Electrical & Electric System", ""));
        items.add(new module_3_item(R.drawable.wom,"WorkshopOrganization & Management", ""));

        module_3_Adapter module3Adapter1 = new module_3_Adapter(items,Module_3.this);
        recyclerView.setAdapter(module3Adapter1);

        m3ads.loadads(Module_3.this);
    }
}
