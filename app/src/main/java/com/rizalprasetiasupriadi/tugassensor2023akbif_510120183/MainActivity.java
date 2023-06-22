package com.rizalprasetiasupriadi.tugassensor2023akbif_510120183;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//NIM     :   10120183
//NAMA    :   RIZAL PRASETIA SUPRIADI
//KELAS   :   IF-5


public class MainActivity extends AppCompatActivity {

//    selected menu(tab)
    private int selectedTab = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Layout
        final LinearLayout lokasiLayout = findViewById(R.id.lokasiLayout);
        final LinearLayout profilLayout = findViewById(R.id.profilLayout);
        final LinearLayout infoLayout = findViewById(R.id.infoLayout);
        final LinearLayout restoranLayout = findViewById(R.id.restoranLayout);

//        image
        final ImageView lokasiImage = findViewById(R.id.lokasiImage);
        final ImageView profilImage = findViewById(R.id.profilImage);
        final ImageView infoImage = findViewById(R.id.infoImage);
        final ImageView restoranImage = findViewById(R.id.restoranImage);

//        text
        final TextView lokasiTxt = findViewById(R.id.lokasiTxt);
        final TextView profilTxt = findViewById(R.id.profilTxt);
        final TextView infoTxt = findViewById(R.id.infoTxt);
        final TextView restoranTxt = findViewById(R.id.restoranTxt);




//        Awal Perpindahan Menu

        //set lokasi fragment
        getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                                .replace(R.id.fragmenContainer, LokasiFragment.class, null)
                                        .commit();

        lokasiLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTab != 1){

                    //set lokasi fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmenContainer, LokasiFragment.class, null)
                            .commit();

                    profilTxt.setVisibility(View.GONE);
                    infoTxt.setVisibility(View.GONE);
                    restoranTxt.setVisibility(View.GONE);

                    profilImage.setImageResource(R.drawable.icons_profil);
                    infoImage.setImageResource(R.drawable.icons_info);
                    restoranImage.setImageResource(R.drawable.icons_food);

                    profilLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    infoLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    restoranLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    lokasiTxt.setVisibility(View.VISIBLE);
                    lokasiImage.setImageResource(R.drawable.icons_maps);
                    lokasiLayout.setBackgroundResource(R.drawable.round_back_maps_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    lokasiLayout.startAnimation(scaleAnimation);

                    selectedTab = 1;
                }
            }
        });

        profilLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTab != 2){

                    //set profil fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmenContainer, ProfilFragment.class, null)
                            .commit();

                    lokasiTxt.setVisibility(View.GONE);
                    infoTxt.setVisibility(View.GONE);
                    restoranTxt.setVisibility(View.GONE);

                    lokasiImage.setImageResource(R.drawable.icons_maps);
                    infoImage.setImageResource(R.drawable.icons_info);
                    restoranImage.setImageResource(R.drawable.icons_food);

                    lokasiLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    infoLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    restoranLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    profilTxt.setVisibility(View.VISIBLE);
                    profilImage.setImageResource(R.drawable.icons_profil);
                    profilLayout.setBackgroundResource(R.drawable.round_back_profil_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    profilLayout.startAnimation(scaleAnimation);

                    selectedTab = 2;
                }
            }
        });

        infoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTab != 3){

                    //set info fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmenContainer, InfoFragment.class, null)
                            .commit();

                    lokasiTxt.setVisibility(View.GONE);
                    profilTxt.setVisibility(View.GONE);
                    restoranTxt.setVisibility(View.GONE);

                    lokasiImage.setImageResource(R.drawable.icons_maps);
                    profilImage.setImageResource(R.drawable.icons_profil);
                    restoranImage.setImageResource(R.drawable.icons_food);

                    lokasiLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profilLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    restoranLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    infoTxt.setVisibility(View.VISIBLE);
                    infoImage.setImageResource(R.drawable.icons_info);
                    infoLayout.setBackgroundResource(R.drawable.round_back_info_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    infoLayout.startAnimation(scaleAnimation);

                    selectedTab = 3;
                }
            }
        });

        restoranLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTab != 4){

                    //set info fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmenContainer, RestoranFragment.class, null)
                            .commit();

                    lokasiTxt.setVisibility(View.GONE);
                    profilTxt.setVisibility(View.GONE);
                    infoTxt.setVisibility(View.GONE);

                    lokasiImage.setImageResource(R.drawable.icons_maps);
                    profilImage.setImageResource(R.drawable.icons_profil);
                    infoImage.setImageResource(R.drawable.icons_info);

                    lokasiLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profilLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    infoLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    restoranTxt.setVisibility(View.VISIBLE);
                    restoranImage.setImageResource(R.drawable.icons_food);
                    restoranLayout.setBackgroundResource(R.drawable.round_back_info_100);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    restoranLayout.startAnimation(scaleAnimation);

                    selectedTab = 4;
                }
            }
        });
//        Akhir perpindahan Menu

    }
}