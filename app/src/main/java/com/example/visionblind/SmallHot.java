package com.example.visionblind;

import android.content.Context;
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
import com.google.firebase.database.Query;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

import me.biubiubiu.justifytext.library.JustifyTextView;

public class SmallHot extends AppCompatActivity {


    LinearLayoutManager hotLinerLayoutManager;
    RecyclerView hotRecyclerView;
    FirebaseDatabase hotFirebaseDatabase;
    DatabaseReference hotDatabaseReference;
    FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<Model> options;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_small_hot);

        progressBar = (ProgressBar)findViewById(R.id.welcome_progress);
        ThreeBounce circle = new ThreeBounce();
        progressBar.setIndeterminateDrawable(circle);
        progressBar.setVisibility(View.VISIBLE);
        Toolbar toolbar = findViewById(R.id.complete_actionbar);
        setSupportActionBar(toolbar);

        hotLinerLayoutManager = new LinearLayoutManager(this);
        hotLinerLayoutManager.setReverseLayout(true);
        hotLinerLayoutManager.setStackFromEnd(true);

        hotRecyclerView = findViewById(R.id.small_hot_recycler);
        hotFirebaseDatabase = FirebaseDatabase.getInstance();
        hotDatabaseReference = hotFirebaseDatabase.getReference("HotNews");

        showData();

    }

    private void showData() {


        options = new FirebaseRecyclerOptions.Builder<Model>().setQuery(hotDatabaseReference, Model.class).build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Model model) {

                holder.setDetails(getApplicationContext(), model.getImage(), model.getHeadline(), model.getDate(), model.getTime(), model.getDescription());
                progressBar.setVisibility(View.INVISIBLE);
            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.small_hot_cardview, parent, false);
                ViewHolder viewHolder = new ViewHolder(itemView);
                viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        TextView mHeadline = view.findViewById(R.id.headline);
                        TextView mDate = view.findViewById(R.id.date);
                        TextView mTime = view.findViewById(R.id.time);
                        TextView mDescription = view.findViewById(R.id.description);
                        ImageView mImage = view.findViewById(R.id.card_image);

                        String passHeadline = mHeadline.getText().toString();
                        String passDate = mDate.getText().toString();
                        String passTime = mTime.getText().toString();
                        String passDescription = mDescription.getText().toString();
                        Bitmap passBitmap = ((BitmapDrawable)mImage.getDrawable()).getBitmap();

                        Intent intent = new Intent(view.getContext(), SmallPassView.class);
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
        hotRecyclerView.setLayoutManager(hotLinerLayoutManager);
        firebaseRecyclerAdapter.startListening();
        hotRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    protected  void onStart(){
        super.onStart();
        if (firebaseRecyclerAdapter != null){
            firebaseRecyclerAdapter.startListening();
        }
    }

}
