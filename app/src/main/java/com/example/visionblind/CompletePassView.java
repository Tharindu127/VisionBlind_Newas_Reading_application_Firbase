package com.example.visionblind;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.codesgood.views.JustifiedTextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Handler;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class CompletePassView extends AppCompatActivity {

    TextView completePassedHeadline, completePassedDate, completePassedTime, completePassedPicDescription;
    JustifiedTextView completePassedDescription;
    ImageView completePassedImage;
    CardView headlineCard, pictureCard, descriptionCard;
    TextToSpeech passedSpeech;
    private long backPressed;
    private Toast backToast;
    Vibrator vibrator;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_complete_pass_view);

        passedSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    int lang = passedSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        completePassedHeadline = findViewById(R.id.complete_pass_headline);
        completePassedDate = findViewById(R.id.complete_pass_date);
        completePassedTime = findViewById(R.id.complete_pass_time);
        completePassedDescription = findViewById(R.id.complete_pass_description);
        completePassedImage = findViewById(R.id.complete_pass_image);

        headlineCard = findViewById(R.id.headline_card);
        pictureCard = findViewById(R.id.picture_description_card);
        descriptionCard = findViewById(R.id.description_card);

        final String headline = getIntent().getStringExtra("headline");
        final String date = getIntent().getStringExtra("date");
        final String time = getIntent().getStringExtra("time");
        final String description = getIntent().getStringExtra("description");
        final String picDescription = getIntent().getStringExtra("picDescription");
        byte[] byteArray = getIntent().getByteArrayExtra("image");

        completePassedHeadline.setText(headline);
        completePassedDate.setText(date);
        completePassedTime.setText(time);
        completePassedDescription.setText(description);


        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        completePassedImage.setImageBitmap(bmp);

        headlineCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 1){
                            Toast.makeText(CompletePassView.this, "Headline, Date and Time.", Toast.LENGTH_SHORT).show();
                            String s = "Headline.";
                            int speech = passedSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(100);

                        }
                        else if(i == 2){
                            Toast.makeText(CompletePassView.this, "Reading Headline, Date and Time.", Toast.LENGTH_SHORT).show();
                            String s = "Reading Headline :" + headline + "date :" + date + "time :" + time;
                            int speech = passedSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(200);
                        }
                        i = 0;
                    }
                },500);


            }
        });

        pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 1){
                            Toast.makeText(CompletePassView.this, "Picture Description..", Toast.LENGTH_SHORT).show();
                            String s = "picture description." ;
                            int speech = passedSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(100);

                        }
                        else if(i == 2){
                            Toast.makeText(CompletePassView.this, "Reading Picture Description..", Toast.LENGTH_SHORT).show();
                            String s = "Reading picture description :" + picDescription;
                            int speech = passedSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(200);
                        }
                        i = 0;
                    }
                },500);
            }
        });

        descriptionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 1){
                            Toast.makeText(CompletePassView.this, "News Description..", Toast.LENGTH_SHORT).show();
                            String s = "news description.";
                            int speech = passedSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(100);

                        }
                        else if(i == 2){
                            Toast.makeText(CompletePassView.this, "Reading News Description..", Toast.LENGTH_SHORT).show();
                            String s = "Reading news description :" + description;
                            int speech = passedSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                            vibrator.vibrate(200);
                        }
                        i = 0;
                    }
                },500);

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
            int speech = passedSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            backToast.show();
        }

        backPressed = System.currentTimeMillis();
    }
}
