package com.example.visionblind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class FontSize extends AppCompatActivity {

    Button small, normal, large, extralarge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_font_size);

        small = (Button) findViewById(R.id.smallbutton);
        normal = (Button) findViewById(R.id.normalbutton);
        large = (Button) findViewById(R.id.largebutton);
        extralarge = (Button) findViewById(R.id.extralargebutton);
        Toolbar toolbar = findViewById(R.id.complete_actionbar);
        setSupportActionBar(toolbar);

        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FontSize.this, NewssetSmall.class);
                startActivity(intent);
            }
        });

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FontSize.this, NewssetNormal.class);
                startActivity(intent);
            }
        });

        large.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FontSize.this, NewssetLarge.class);
                startActivity(intent);
            }
        });

        extralarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FontSize.this, NewssetExtralarge.class);
                startActivity(intent);
            }
        });
    }
}
