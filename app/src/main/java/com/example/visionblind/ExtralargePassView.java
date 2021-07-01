package com.example.visionblind;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.zolad.zoominimageview.ZoomInImageView;

import androidx.appcompat.app.AppCompatActivity;

import android.view.WindowManager;
import android.widget.TextView;

public class ExtralargePassView extends AppCompatActivity {

    TextView extralargePassedHeadline, extralargePassedDate, extralargePassedTime, extralargePassedDescription;
    private ZoomInImageView extralargeZoomImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_extralarge_pass_view);

        extralargePassedHeadline = findViewById(R.id.extralarge_pass_headline);
        extralargePassedDate = findViewById(R.id.extralarge_pass_date);
        extralargePassedTime = findViewById(R.id.extralarge_pass_time);
        extralargePassedDescription = findViewById(R.id.extralarge_pass_description);
        extralargeZoomImage = findViewById(R.id.extralarge_zoom_pass_image);

        String headline = getIntent().getStringExtra("headline");
        String date = getIntent().getStringExtra("date");
        String time = getIntent().getStringExtra("time");
        String description = getIntent().getStringExtra("description");
        byte[] byteArray = getIntent().getByteArrayExtra("image");

        extralargePassedHeadline.setText(headline);
        extralargePassedDate.setText(date);
        extralargePassedTime.setText(time);
        extralargePassedDescription.setText(description);


        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        extralargeZoomImage.setImageBitmap(bmp);
    }
}
