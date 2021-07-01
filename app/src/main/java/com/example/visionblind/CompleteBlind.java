package com.example.visionblind;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class CompleteBlind extends AppCompatActivity {

    Button hotnews, politicalnews, socialnews, sportsnews, businessnews, weathernews, foreignnews;
    int i;
    TextToSpeech textToSpeech;
    Vibrator vibrator;
    private long backPressed;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_complete_blind);
        Toolbar toolbar = findViewById(R.id.complete_actionbar);
        setSupportActionBar(toolbar);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                    String e = "Choose news category";
                    int speech = textToSpeech.speak(e, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        hotnews = (Button) findViewById(R.id.hotnews);
        politicalnews = (Button) findViewById(R.id.politicalnews);
        socialnews = (Button) findViewById(R.id.socialnews);
        sportsnews = (Button) findViewById(R.id.sportsnews);
        businessnews = (Button) findViewById(R.id.businessnews);
        weathernews = (Button) findViewById(R.id.weathernews);
        foreignnews = (Button) findViewById(R.id.foreignnews);



        hotnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 1){
                            Toast.makeText(CompleteBlind.this, "Hot News (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "Hot news, double tap to go hot news";
                            int speec = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(100);
                        }
                        else if (i ==2){
                            Toast.makeText(CompleteBlind.this, "Going to hot news (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "going to hot news";
                            int speec = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(300);
                            openComplete();
                        }

                        i = 0;
                    }

                    private void openComplete() {
                        Intent intent = new Intent(CompleteBlind.this, HotNews.class);
                        startActivity(intent);
                    }
                }, 500);
            }
        });

        politicalnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 1){
                            Toast.makeText(CompleteBlind.this, "Political News (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "political news, double tap to go political news";
                            int speec = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(100);
                        }
                        else if (i ==2){
                            Toast.makeText(CompleteBlind.this, "Going to political news (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "going to political news";
                            int speec = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(300);
                            openComplete();
                        }

                        i = 0;
                    }

                    private void openComplete() {
                        Intent intent = new Intent(CompleteBlind.this, PoliticalNews.class);
                        startActivity(intent);
                    }
                }, 500);
            }
        });

        socialnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 1){
                            Toast.makeText(CompleteBlind.this, "Social news (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "social news, double tap to go social news";
                            int speec = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(100);

                        }
                        else if (i ==2){
                            Toast.makeText(CompleteBlind.this, "Going to social news (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "going to social news";
                            int speec = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(300);
                            openComplete();
                        }

                        i = 0;
                    }

                    private void openComplete() {
                        Intent intent = new Intent(CompleteBlind.this, SocialNews.class);
                        startActivity(intent);
                    }
                }, 500);
            }
        });

        sportsnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 1){
                            Toast.makeText(CompleteBlind.this, "Sports news (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "sports news, double tap to go sports news";
                            int speec = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(100);

                        }
                        else if (i ==2){
                            Toast.makeText(CompleteBlind.this, "Going to sports news (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "going to sports news";
                            int speec = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(300);
                            openComplete();
                        }

                        i = 0;
                    }

                    private void openComplete() {
                        Intent intent = new Intent(CompleteBlind.this, SportsNews.class);
                        startActivity(intent);
                    }
                }, 500);
            }
        });

        businessnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 1){
                            Toast.makeText(CompleteBlind.this, "Business news (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "business news, double tap to go business news";
                            int speec = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(100);

                        }
                        else if (i ==2){
                            Toast.makeText(CompleteBlind.this, "Going to business news (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "going to business news";
                            int speec = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(300);
                            openComplete();
                        }

                        i = 0;
                    }

                    private void openComplete() {
                        Intent intent = new Intent(CompleteBlind.this, BusinessNews.class);
                        startActivity(intent);
                    }
                }, 500);
            }
        });

        weathernews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 1){
                            Toast.makeText(CompleteBlind.this, "Weather news (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "weather news, double tap to go weather news";
                            int speec = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(100);

                        }
                        else if (i ==2){
                            Toast.makeText(CompleteBlind.this, "Going to weather news (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "going to weather news";
                            int speec = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(300);
                            openComplete();
                        }

                        i = 0;
                    }

                    private void openComplete() {
                        Intent intent = new Intent(CompleteBlind.this, WeatherNews.class);
                        startActivity(intent);
                    }
                }, 500);
            }
        });

        foreignnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 1){
                            Toast.makeText(CompleteBlind.this, "Foreign news (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "foreign news, double tap to go foreign news";
                            int speec = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(100);

                        }
                        else if (i ==2){
                            Toast.makeText(CompleteBlind.this, "Going to foreign news (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "going to foreign news";
                            int speec = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(300);
                            openComplete();
                        }

                        i = 0;
                    }

                    private void openComplete() {
                        Intent intent = new Intent(CompleteBlind.this, ForeignNews.class);
                        startActivity(intent);
                    }
                }, 500);
            }
        });

    }
    @Override
    public void onBackPressed() {
        final MediaPlayer suspend_back = MediaPlayer.create(this,R.raw.back_suspended);

        if (backPressed + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else {
            backToast = Toast.makeText(getBaseContext(), "Touch again to back (speaking)", Toast.LENGTH_SHORT);
            String s = "touch again to back";
            int speech = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            backToast.show();
        }

        backPressed = System.currentTimeMillis();
    }

}
