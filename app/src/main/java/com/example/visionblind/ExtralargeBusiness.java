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

public class ExtralargeBusiness extends AppCompatActivity {

    LinearLayoutManager extraLargeLinerLayoutManager;
    RecyclerView extraLargeRecyclerView;
    FirebaseDatabase extraLargeFirebaseDatabase;
    DatabaseReference extraLargeDatabaseReference;
    FirebaseRecyclerAdapter<Model, ExtralargeViewHolder> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<Model> options;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_extralarge_business);
        progressBar = (ProgressBar)findViewById(R.id.welcome_progress);
        ThreeBounce circle = new ThreeBounce();
        progressBar.setIndeterminateDrawable(circle);
        progressBar.setVisibility(View.VISIBLE);
        Toolbar toolbar = findViewById(R.id.complete_actionbar);
        setSupportActionBar(toolbar);

        extraLargeLinerLayoutManager = new LinearLayoutManager(this);
        extraLargeLinerLayoutManager.setReverseLayout(true);
        extraLargeLinerLayoutManager.setStackFromEnd(true);

        extraLargeRecyclerView = findViewById(R.id.extralarge_business_recycler);
        extraLargeFirebaseDatabase= FirebaseDatabase.getInstance();
        extraLargeDatabaseReference = extraLargeFirebaseDatabase.getReference("PoliticalNews");

        showData();

    }

    private void showData() {

        options= new FirebaseRecyclerOptions.Builder<Model>().setQuery(extraLargeDatabaseReference,Model.class).build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, ExtralargeViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ExtralargeViewHolder holder, int position, @NonNull Model model) {

                holder.setDetails(getApplicationContext(),model.getImage(), model.getHeadline(), model.getDate(), model.getTime(), model.getDescription());
                progressBar.setVisibility(View.INVISIBLE);
            }

            @NonNull
            @Override
            public ExtralargeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.extralarge_cardview,parent, false);
                ExtralargeViewHolder viewHolder = new ExtralargeViewHolder(itemView);
                viewHolder.setOnClickListener(new ExtralargeViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        TextView mHeadline = view.findViewById(R.id.extralarge_headline);
                        TextView mDate = view.findViewById(R.id.extralarge_date);
                        TextView mTime = view.findViewById(R.id.extralarge_time);
                        TextView mDescription = view.findViewById(R.id.extralarge_description);
                        ImageView mImage = view.findViewById(R.id.extralarge_card_image);

                        String passHeadline = mHeadline.getText().toString();
                        String passDate = mDate.getText().toString();
                        String passTime = mTime.getText().toString();
                        String passDescription = mDescription.getText().toString();
                        Bitmap passBitmap = ((BitmapDrawable)mImage.getDrawable()).getBitmap();

                        Intent intent = new Intent(view.getContext(), ExtralargePassView.class);
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

        extraLargeRecyclerView.setLayoutManager(extraLargeLinerLayoutManager);
        firebaseRecyclerAdapter.startListening();
        extraLargeRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    protected void onStart(){

        super.onStart();
        if(firebaseRecyclerAdapter != null){
            firebaseRecyclerAdapter.startListening();
        }
    }
}
