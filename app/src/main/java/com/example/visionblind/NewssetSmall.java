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

public class NewssetSmall extends AppCompatActivity {
    private CardView small_hot_card, small_political_card, small_social_card, small_sports_card, small_business_card, small_weather_card, small_foreign_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_newsset_small);
        Toolbar toolbar = findViewById(R.id.complete_actionbar);
        setSupportActionBar(toolbar);
        small_hot_card = (CardView) findViewById(R.id.small_hot_card);
        small_political_card = (CardView) findViewById(R.id.small_political_card);
        small_social_card = (CardView) findViewById(R.id.small_social_card);
        small_sports_card = (CardView) findViewById(R.id.small_sports_card);
        small_business_card = (CardView) findViewById(R.id.small_business_card);
        small_weather_card = (CardView) findViewById(R.id.small_weather_card);
        small_foreign_card = (CardView) findViewById(R.id.small_foreign_card);

        small_hot_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetSmall.this, SmallHot.class);
                startActivity(intent);
            }
        });

        small_political_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetSmall.this, SmallPolitical.class);
                startActivity(intent);
            }
        });

        small_social_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetSmall.this, SmallSocial.class);
                startActivity(intent);
            }
        });

        small_sports_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetSmall.this, SmallSports.class);
                startActivity(intent);
            }
        });

        small_business_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetSmall.this, SmallBusiness.class);
                startActivity(intent);
            }
        });

        small_weather_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetSmall.this, SmallWeather.class);
                startActivity(intent);
            }
        });

        small_foreign_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetSmall.this, SmallForeign.class);
                startActivity(intent);
            }
        });


    }
}
