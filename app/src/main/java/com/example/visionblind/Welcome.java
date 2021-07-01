package com.example.visionblind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.ChasingDots;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.FadingCircle;
import com.github.ybq.android.spinkit.style.Pulse;
import com.github.ybq.android.spinkit.style.RotatingCircle;
import com.github.ybq.android.spinkit.style.ThreeBounce;

import java.util.Locale;

public class Welcome extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 8000;
    TextToSpeech textToSpeech;
    ImageView icon;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        icon = findViewById(R.id.imageView2);
        progressBar = (ProgressBar)findViewById(R.id.welcome_progress);
        ThreeBounce circle = new ThreeBounce();
        progressBar.setIndeterminateDrawable(circle);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcome.this, MainActivity.class);
                startActivity(intent);
                finish();


            }
        },SPLASH_TIME_OUT);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int lang = textToSpeech.setLanguage(Locale.ENGLISH);

                    String s = "welcome to lets read news. This is a demo application for visually impaired people to see and read news.";
                    int speech = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
    }
}
