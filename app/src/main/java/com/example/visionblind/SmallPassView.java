package com.example.visionblind;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.codesgood.views.JustifiedTextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.zolad.zoominimageview.ZoomInImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import me.biubiubiu.justifytext.library.JustifyTextView;

public class SmallPassView extends AppCompatActivity {


    TextView smallPassedHeadline, smallPassedDate, smallPassedTime;
    JustifiedTextView smallPassedDescription;
    private ZoomInImageView zoomImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_small_pass_view);


        smallPassedHeadline = findViewById(R.id.small_pass_headline);
        smallPassedDate = findViewById(R.id.small_pass_date);
        smallPassedTime = findViewById(R.id.small_pass_time);
        smallPassedDescription = findViewById(R.id.small_pass_description);
        zoomImage = findViewById(R.id.small_zoom_pass_image);

        String headline = getIntent().getStringExtra("headline");
        String date = getIntent().getStringExtra("date");
        String time = getIntent().getStringExtra("time");
        String description = getIntent().getStringExtra("description");
        byte[] byteArray = getIntent().getByteArrayExtra("image");

        smallPassedHeadline.setText(headline);
        smallPassedDate.setText(date);
        smallPassedTime.setText(time);
        smallPassedDescription.setText(description);


        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        zoomImage.setImageBitmap(bmp);

    }


}
