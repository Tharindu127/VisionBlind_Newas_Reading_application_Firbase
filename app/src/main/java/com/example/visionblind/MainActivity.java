package com.example.visionblind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button buttonComplete;
    Button buttonPartial;
    private long backPressed;
    private Toast backToast;
    TextToSpeech textSpeech;
    Vibrator vibrator;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        textSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int lang = textSpeech.setLanguage(Locale.ENGLISH);


                }
            }
        });


        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        buttonComplete = (Button) findViewById(R.id.complete);
        buttonPartial = (Button) findViewById(R.id.partial);

        buttonComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 1){
                            Toast.makeText(MainActivity.this, "Complete Blindness (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "Complete Blindness, double tap to go to complete blindness";
                            int speech = textSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(100);

                        }
                        else if (i ==2){
                            Toast.makeText(MainActivity.this, "Going to Complete Blindness (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "Going to Complete Blindness";
                            int speech = textSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(300);
                            openComplete();
                        }
                       i = 0;
                    }

                    private void openComplete() {
                        Intent intent = new Intent(MainActivity.this, CompleteBlind.class);
                        startActivity(intent);
                    }
                }, 500);
            }
        });

        buttonPartial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 1){
                            Toast.makeText(MainActivity.this, "Partial Blindness (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "Partial Blindness, double tap to go partial blindness";
                            int speec = textSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(100);
                        }
                        else if (i ==2){
                            Toast.makeText(MainActivity.this, "Going to Partial Blindness (Speaking)", Toast.LENGTH_SHORT).show();
                            String s = "Going to Partial Blindness";
                            int speec = textSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(300);
                            openComplete();
                        }
                        i = 0;
                    }

                    private void openComplete() {
                        Intent intent = new Intent(MainActivity.this, FontSize.class);
                        startActivity(intent);
                    }
                }, 500);
            }
        });

    }

    @Override
    public void onBackPressed() {
        final MediaPlayer suspend_back = MediaPlayer.create(this,R.raw.back_suspended);

        if (backPressed + 10000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else {
            backToast = Toast.makeText(getBaseContext(), "Touch again to exit (speaking)", Toast.LENGTH_SHORT);
            String s = "touch again to exit";
            int speech = textSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            backToast.show();
        }

        backPressed = System.currentTimeMillis();
    }

}
