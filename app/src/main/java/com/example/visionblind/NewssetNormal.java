package com.example.visionblind;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.view.WindowManager;

public class NewssetNormal extends AppCompatActivity {
    private CardView normal_hot_card, normal_political_card, normal_social_card, normal_sports_card, normal_business_card, normal_weather_card, normal_foreign_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_newsset_normal);
        Toolbar toolbar = findViewById(R.id.complete_actionbar);
        setSupportActionBar(toolbar);
        normal_hot_card = (CardView) findViewById(R.id.normal_hot_card);
        normal_political_card = (CardView) findViewById(R.id.normal_political_card);
        normal_social_card = (CardView) findViewById(R.id.normal_social_card);
        normal_sports_card = (CardView) findViewById(R.id.normal_sports_card);
        normal_business_card = (CardView) findViewById(R.id.normal_business_card);
        normal_weather_card = (CardView) findViewById(R.id.normal_weather_card);
        normal_foreign_card = (CardView) findViewById(R.id.normal_foreign_card);

        normal_hot_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetNormal.this, NormalHot.class);
                startActivity(intent);
            }
        });

        normal_political_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetNormal.this, NormalPolitical.class);
                startActivity(intent);
            }
        });

        normal_social_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetNormal.this, NormalSocial.class);
                startActivity(intent);
            }
        });

        normal_sports_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetNormal.this, NormalSports.class);
                startActivity(intent);
            }
        });

        normal_business_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetNormal.this, NormalBusiness.class);
                startActivity(intent);
            }
        });

        normal_weather_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetNormal.this, NormalWeather.class);
                startActivity(intent);
            }
        });

        normal_foreign_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetNormal.this, NormalForeign.class);
                startActivity(intent);
            }
        });
    }
}
