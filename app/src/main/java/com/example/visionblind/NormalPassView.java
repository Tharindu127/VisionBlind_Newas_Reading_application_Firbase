package com.example.visionblind;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.zolad.zoominimageview.ZoomInImageView;

import androidx.appcompat.app.AppCompatActivity;

import android.view.WindowManager;
import android.widget.TextView;

public class NormalPassView extends AppCompatActivity {

    TextView normalPassedHeadline, normalPassedDate, normalPassedTime, normalPassedDescription;
    private ZoomInImageView normalzoomImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_normal_pass_view);

        normalPassedHeadline = findViewById(R.id.normal_pass_headline);
        normalPassedDate = findViewById(R.id.normal_pass_date);
        normalPassedTime = findViewById(R.id.normal_pass_time);
        normalPassedDescription = findViewById(R.id.normal_pass_description);
        normalzoomImage = findViewById(R.id.normal_zoom_pass_image);

        String headline = getIntent().getStringExtra("headline");
        String date = getIntent().getStringExtra("date");
        String time = getIntent().getStringExtra("time");
        String description = getIntent().getStringExtra("description");
        byte[] byteArray = getIntent().getByteArrayExtra("image");

        normalPassedHeadline.setText(headline);
        normalPassedDate.setText(date);
        normalPassedTime.setText(time);
        normalPassedDescription.setText(description);


        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        normalzoomImage.setImageBitmap(bmp);


    }
}
