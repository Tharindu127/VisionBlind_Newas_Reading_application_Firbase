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

public class NewssetLarge extends AppCompatActivity {
    private CardView large_hot_card, large_political_card, large_social_card, large_sports_card, large_business_card, large_weather_card, large_foreign_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_newsset_large);
        Toolbar toolbar = findViewById(R.id.complete_actionbar);
        setSupportActionBar(toolbar);
        large_hot_card = (CardView) findViewById(R.id.large_hot_card);
        large_political_card = (CardView) findViewById(R.id.large_political_large);
        large_social_card = (CardView) findViewById(R.id.large_social_card);
        large_sports_card = (CardView) findViewById(R.id.large_sports_card);
        large_business_card = (CardView) findViewById(R.id.large_business_card);
        large_weather_card = (CardView) findViewById(R.id.large_weather_card);
        large_foreign_card = (CardView) findViewById(R.id.large_foreign_card);

        large_hot_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetLarge.this, LargeHot.class);
                startActivity(intent);
            }
        });

        large_political_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetLarge.this, LargePolitical.class);
                startActivity(intent);
            }
        });

        large_social_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetLarge.this, LargeSocial.class);
                startActivity(intent);
            }
        });

        large_sports_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetLarge.this, LargeSports.class);
                startActivity(intent);
            }
        });

        large_business_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetLarge.this, LargeBusiness.class);
                startActivity(intent);
            }
        });

        large_weather_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetLarge.this, LargeWeather.class);
                startActivity(intent);
            }
        });

        large_foreign_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewssetLarge.this, LargeForeign.class);
                startActivity(intent);
            }
        });

    }
}
