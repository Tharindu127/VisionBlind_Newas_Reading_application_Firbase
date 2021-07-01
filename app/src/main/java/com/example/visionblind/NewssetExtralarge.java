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

public class NewssetExtralarge extends AppCompatActivity {
    private CardView extralarge_hot_card, extralarge_political_card, extralarge_social_card, extralarge_sports_card, extralarge_business_card, extralarge_weather_card, extralarge_foreign_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_newsset_extralarge);
        Toolbar toolbar = findViewById(R.id.complete_actionbar);
        setSupportActionBar(toolbar);

        extralarge_hot_card = (CardView) findViewById(R.id.extralarge_hot_card);
        extralarge_political_card = (CardView) findViewById(R.id.extralarge_political_card);
        extralarge_social_card = (CardView) findViewById(R.id.extralarge_social_card);
        extralarge_sports_card = (CardView) findViewById(R.id.extralarge_sports_card);
        extralarge_business_card = (CardView) findViewById(R.id.extralarge_business_card);
        extralarge_weather_card = (CardView) findViewById(R.id.extralarge_weather_card);
        extralarge_foreign_card = (CardView) findViewById(R.id.extralarge_foreign_card);

        extralarge_hot_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetExtralarge.this, ExtralargeHot.class);
                startActivity(intent);
            }
        });

        extralarge_political_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetExtralarge.this, ExtralargePolitical.class);
                startActivity(intent);
            }
        });

        extralarge_social_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetExtralarge.this, ExtralargeSocial.class);
                startActivity(intent);
            }
        });

        extralarge_sports_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetExtralarge.this, ExtralargeSports.class);
                startActivity(intent);
            }
        });

        extralarge_business_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetExtralarge.this, ExtralargeBusiness.class);
                startActivity(intent);
            }
        });

        extralarge_weather_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetExtralarge.this, ExtralargeWeather.class);
                startActivity(intent);
            }
        });

        extralarge_foreign_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetExtralarge.this, ExtralargeForeign.class);
                startActivity(intent);
            }
        });


    }
}
