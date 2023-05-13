package com.nerdware.automotiveengineering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class Paper_2 extends AppCompatActivity {
    ArrayList<paper_item> paper_items;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper2);


// TODO: Add adView to your view hierarchy.
        RecyclerView recyclerView = findViewById(R.id.recycler_pp2);

        ImageView imageView = findViewById(R.id.back_pp2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        paper_items = new ArrayList<>();

        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));


        paper_items.add(new paper_item(R.drawable.e2,"Mathematics 2"));
        paper_items.add(new paper_item(R.drawable.e6,"Technical Drawing"));
        paper_items.add(new paper_item(R.drawable.e1,"Workshop Organization Management"));
        paper_items.add(new paper_item(R.drawable.e3,"Communication Skills"));
        paper_items.add(new paper_item(R.drawable.e4,"Engines & AutoElectrics"));


        paper_2_Adapter pap_adapter = new paper_2_Adapter(paper_items,this);
        recyclerView.setAdapter(pap_adapter);
        paper2ads.loadads(Paper_2.this);
    }

}