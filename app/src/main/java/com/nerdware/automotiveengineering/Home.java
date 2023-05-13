package com.nerdware.automotiveengineering;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import com.nerdware.automotiveengineering.dash.Items;
import com.nerdware.automotiveengineering.dash.MyAdapter;
import java.util.ArrayList;

public class Home extends AppCompatActivity {

    Activity activity;
    int Counter = 0;

    RecyclerView recyclerView;


    ArrayList<Items> itemsList;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    @SuppressLint({"NonConstantResourceId", "VisibleForTests"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeReceiver, filter);
        // Check for internet connectivity
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        if (!isConnected) {
            // Disable or hide certain features of your app
            // Show a dialog box to inform the user that they need an internet connection
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You need an internet connection to use this feature.")
                    .setTitle("No Internet Connection")
                    .setPositiveButton("OK", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }


// TODO: Add adView to your view hierarchy.
        ImageSlider imageSlider = findViewById(R.id.image_slider);
        drawerLayout = findViewById(R.id.drawer_layer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav);
        recyclerView = findViewById(R.id.recyclerview);
        toolbar.setTitle("Home");
        toolbar.setTitleTextAppearance(this, R.style.ToolBarTitle);



        itemsList = new ArrayList<>();


        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        itemsList.add(new Items(R.drawable.e,"Module 1"));
        itemsList.add(new Items(R.drawable.exm1,"Paper 1"));
        itemsList.add(new Items(R.drawable.f, "Module 2"));
        itemsList.add(new Items(R.drawable.exm2, "Paper 2"));


        MyAdapter myAdapter = new MyAdapter(position -> {

            if (position == 0) {
                Intent intent = new Intent(Home.this, Module_1.class);
                startActivity(intent);
            } else if (position == 1) {
                Intent intent = new Intent(Home.this, Paper1.class);
                startActivity(intent);
            } else if (position == 2) {
                Intent intent = new Intent(Home.this, Module_3.class);
                startActivity(intent);
            } else if (position == 3) {
                Intent intent = new Intent(Home.this, Paper_2.class);
                startActivity(intent);
            }
        }, itemsList, this);


        recyclerView.setAdapter(myAdapter);
        com.nerdware.automotiveengineering.dash.dashinter.loadads(Home.this);


        ArrayList<SlideModel> imageList = new ArrayList<>();


        imageList.add(new SlideModel(R.drawable.e, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.d, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.c, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.b, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.a, ScaleTypes.FIT));
        imageSlider.setImageList(imageList,ScaleTypes.FIT);
        imageSlider.setItemClickListener(i -> {

            String fileName = "";

            int position = 0;
            switch (position) {
                case 0:
                    fileName = "mao.pdf";
                    break;
                case 1:
                    fileName = "td.pdf";
                    break;
                case 2:
                    fileName = "workshop.pdf";
                    break;
                case 3:
                    fileName = "ict.pdf";
                    break;
                case 4:
                    fileName = "ee.pdf";
                    break;

            }
            Intent intent = new Intent(Home.this, PDF.class);
            intent.putExtra("FILE_NAME", fileName);
            startActivity(intent);
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        navigationView.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.nav_home:
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(Home.this, "Home", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.nav_about:
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(Home.this, "About", Toast.LENGTH_SHORT).show();
                    about(this);

                    break;
                case R.id.nav_setting:
                    drawerLayout.closeDrawer(GravityCompat.START);

                    Toast.makeText(Home.this, "Setting", Toast.LENGTH_SHORT).show();
                    Intent set = new Intent(Home.this, Setting.class);
                    startActivity(set);

                    break;
                case R.id.nav_share:
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(Home.this, "Share", Toast.LENGTH_SHORT).show();
                    String sub = "Your Subject Here";
                    String msgbody = "https://play.google.com/store/apps/details?id=com.nerdware.mechanical";

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, sub);
                    intent.putExtra(Intent.EXTRA_TEXT, msgbody);
                    startActivity(Intent.createChooser(intent, "Share via"));
                    break;
                case R.id.nav_exit:
                    drawerLayout.closeDrawer(GravityCompat.START);

                    Toast.makeText(Home.this, "Exit", Toast.LENGTH_SHORT).show();
                    exitMenu(Home.this);


                    break;
            }
            return true;
        });
    }



    private void about(Home dashBoard) {
        AlertDialog.Builder builder = new AlertDialog.Builder(dashBoard);
        builder.setTitle("About");
        builder.setMessage("This Application was Developed by Nerdware Developers with an aim of making your study easier." +
                "For any complains or feedback about our products please do contact us through our email at nerweredevelopers@gmail.com");
        builder.setNegativeButton("back", (dialog, which) -> dialog.dismiss());
        builder.show();
    }


    private void exitMenu(Home dashBoard) {
        AlertDialog.Builder builder = new AlertDialog.Builder(dashBoard);
        builder.setTitle("WARNING!!");
        builder.setMessage("Are You Sure You Want To Exit ?");
        builder.setPositiveButton("Yes", (dialog, which) -> finish());
        builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

}


