package com.example.visionblind;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.zolad.zoominimageview.ZoomInImageView;

import androidx.appcompat.app.AppCompatActivity;

import android.view.WindowManager;
import android.widget.TextView;

public class LargePassView extends AppCompatActivity {

    TextView largePassedHeadline, largePassedDate, largePassedTime, normalPassedDescription;
    private ZoomInImageView largezoomImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_large_pass_view);

        largePassedHeadline = findViewById(R.id.large_pass_headline);
        largePassedDate = findViewById(R.id.large_pass_date);
        largePassedTime = findViewById(R.id.large_pass_time);
        normalPassedDescription = findViewById(R.id.large_pass_description);
        largezoomImage = findViewById(R.id.large_zoom_pass_image);

        String headline = getIntent().getStringExtra("headline");
        String date = getIntent().getStringExtra("date");
        String time = getIntent().getStringExtra("time");
        String description = getIntent().getStringExtra("description");
        byte[] byteArray = getIntent().getByteArrayExtra("image");

        largePassedHeadline.setText(headline);
        largePassedDate.setText(date);
        largePassedTime.setText(time);
        normalPassedDescription.setText(description);


        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        largezoomImage.setImageBitmap(bmp);

    }
}
