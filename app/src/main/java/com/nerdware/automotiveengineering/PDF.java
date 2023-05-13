package com.nerdware.automotiveengineering;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class PDF extends AppCompatActivity {

    private String fileName;
    private PDFView pdfView;
    private AdView mAdView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        Toast.makeText(this, "this may take a while.Please be patient", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Ensure your have an internet connection", Toast.LENGTH_LONG).show();

        MobileAds.initialize(this);
        mAdView = findViewById(R.id.pdf);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
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

        pdfView = findViewById(R.id.view);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        fileName = getIntent().getStringExtra("FILE_NAME");
        final File localFile;
        try {
            localFile = File.createTempFile("robot", "pdf");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StorageReference reference = FirebaseStorage.getInstance().getReference().child("pdfs/" + fileName);
        Log.v("PDF", "Before getFile() method call");
        reference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                Log.d("PDF", "getFile() method success");
                displaypdf(localFile);
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void displaypdf(File localFile) {
        Uri uri = Uri.fromFile(localFile);
        if (pdfView != null) {
            pdfView.fromUri(uri)
                    .onLoad(new OnLoadCompleteListener() {
                        @Override
                        public void loadComplete(int nbPages) {

                        }
                    })
                    .onPageError(new OnPageErrorListener() {
                        @Override
                        public void onPageError(int page, Throwable t) {

                        }
                    })
                    .load();
        }
    }


}