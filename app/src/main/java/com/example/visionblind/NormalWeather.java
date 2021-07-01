package com.example.visionblind;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class NormalWeather extends AppCompatActivity {

    LinearLayoutManager normalLinerLayoutManager;
    RecyclerView normalRecyclerView;
    FirebaseDatabase normalFirebaseDatabase;
    DatabaseReference normalDatabaseReference;
    FirebaseRecyclerAdapter<Model, NormalViewHolder> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<Model> options;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_normal_weather);
        progressBar = (ProgressBar)findViewById(R.id.welcome_progress);
        ThreeBounce circle = new ThreeBounce();
        progressBar.setIndeterminateDrawable(circle);
        progressBar.setVisibility(View.VISIBLE);
        Toolbar toolbar = findViewById(R.id.complete_actionbar);
        setSupportActionBar(toolbar);

        normalLinerLayoutManager = new LinearLayoutManager(this);
        normalLinerLayoutManager.setReverseLayout(true);
        normalLinerLayoutManager.setStackFromEnd(true);

        normalRecyclerView = findViewById(R.id.normal_weather_recycler);
        normalFirebaseDatabase = FirebaseDatabase.getInstance();
        normalDatabaseReference = normalFirebaseDatabase.getReference("WeatherNews");

        showData();

    }

    private void showData() {
        options = new FirebaseRecyclerOptions.Builder<Model>().setQuery(normalDatabaseReference, Model.class).build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, NormalViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull NormalViewHolder holder, int position, @NonNull Model model) {

                holder.setDetails(getApplicationContext(), model.getImage(), model.getHeadline(), model.getDate(), model.getTime(), model.getDescription());
                progressBar.setVisibility(View.INVISIBLE);
            }

            @NonNull
            @Override
            public NormalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.normal_cardview,parent, false);

                NormalViewHolder viewHolder = new NormalViewHolder(itemView);
                viewHolder.setOnClickListener(new NormalViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        TextView mHeadline = view.findViewById(R.id.normal_headline);
                        TextView mDate = view.findViewById(R.id.normal_date);
                        TextView mTime = view.findViewById(R.id.normal_time);
                        TextView mDescription = view.findViewById(R.id.normal_description);
                        ImageView mImage = view.findViewById(R.id.normal_card_image);

                        String passHeadline = mHeadline.getText().toString();
                        String passDate = mDate.getText().toString();
                        String passTime = mTime.getText().toString();
                        String passDescription = mDescription.getText().toString();
                        Bitmap passBitmap = ((BitmapDrawable)mImage.getDrawable()).getBitmap();

                        Intent intent = new Intent(view.getContext(), NormalPassView.class);
                        intent.putExtra("headline", passHeadline);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        passBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        byte[] byteArray = stream.toByteArray();
                        intent.putExtra("image", byteArray);
                        intent.putExtra("date", passDate);
                        intent.putExtra("time", passTime);
                        intent.putExtra("description", passDescription);
                        startActivity(intent);

                    }
                });

                return viewHolder;
            }
        };
        normalRecyclerView.setLayoutManager(normalLinerLayoutManager);
        firebaseRecyclerAdapter.startListening();
        normalRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    protected  void onStart(){
        super.onStart();
        if (firebaseRecyclerAdapter != null){
            firebaseRecyclerAdapter.startListening();
        }
    }
}
