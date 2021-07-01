package com.example.visionblind;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
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

import android.os.Handler;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Locale;

public class PoliticalNews extends AppCompatActivity {

    LinearLayoutManager completeLinerLayoutManager;
    RecyclerView completeRecyclerView;
    FirebaseDatabase completeFirebaseDatabase;
    DatabaseReference completeDatabaseReference;
    FirebaseRecyclerAdapter<Model, CompleteBlindViewHolder> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<Model> options;
    TextToSpeech completehotspeech;
    private long backPressed;
    private Toast backToast;
    ProgressBar progressBar;
    Vibrator vibrator;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_political_news);
        progressBar = (ProgressBar)findViewById(R.id.welcome_progress);
        ThreeBounce circle = new ThreeBounce();
        progressBar.setIndeterminateDrawable(circle);
        progressBar.setVisibility(View.VISIBLE);
        Toolbar toolbar = findViewById(R.id.complete_actionbar);
        setSupportActionBar(toolbar);

        completeLinerLayoutManager = new LinearLayoutManager(this);
        completeLinerLayoutManager.setReverseLayout(true);
        completeLinerLayoutManager.setStackFromEnd(true);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        completeRecyclerView = findViewById(R.id.complete_political_recycler);
        completeFirebaseDatabase = FirebaseDatabase.getInstance();
        completeDatabaseReference = completeFirebaseDatabase.getReference("PoliticalNews");

        completehotspeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    int lang = completehotspeech.setLanguage(Locale.ENGLISH);
                    String e = "loading political news";
                    int speec = completehotspeech.speak(e, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        showData();

        showData();

    }

    private void showData() {

        options = new FirebaseRecyclerOptions.Builder<Model>().setQuery(completeDatabaseReference, Model.class).build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, CompleteBlindViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CompleteBlindViewHolder holder, int position, @NonNull Model model) {
                holder.setDetails(getApplicationContext(), model.getImage(), model.getHeadline(), model.getDate(), model.getTime(), model.getPicDescription(), model.getDescription());
                progressBar.setVisibility(View.INVISIBLE);
            }

            @NonNull
            @Override
            public CompleteBlindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.complete_cardview,parent,false);
                CompleteBlindViewHolder viewHolder = new CompleteBlindViewHolder(itemView);
                viewHolder.setOnClickListener(new CompleteBlindViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(final View view, int position) {

                        i++;

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if(i == 1){
                                    TextView mHeadline = view.findViewById(R.id.complete_headline);
                                    TextView mDate = view.findViewById(R.id.complete_date);
                                    TextView mTime = view.findViewById(R.id.complete_time);

                                    String passHeadline = mHeadline.getText().toString();
                                    String passDate = mDate.getText().toString();
                                    String passTime = mTime.getText().toString();
                                    Toast.makeText(PoliticalNews.this, "Reading Headline", Toast.LENGTH_LONG).show();
                                    String s = "Reading Headline :" + passHeadline + "date :" + passDate + "time :" + passTime + "double tap to do to the news";
                                    int speech = completehotspeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                                    vibrator.vibrate(100);
                                }
                                else if (i == 2){
                                    TextView mHeadline = view.findViewById(R.id.complete_headline);
                                    TextView mDate = view.findViewById(R.id.complete_date);
                                    TextView mTime = view.findViewById(R.id.complete_time);
                                    TextView mDescription = view.findViewById(R.id.complete_description);
                                    TextView mPicDescription = view.findViewById(R.id.picture_description);
                                    ImageView mImage = view.findViewById(R.id.complete_card_image);

                                    String passHeadline = mHeadline.getText().toString();
                                    String passPicDescription = mPicDescription.getText().toString();
                                    String passDate = mDate.getText().toString();
                                    String passTime = mTime.getText().toString();
                                    String passDescription = mDescription.getText().toString();
                                    Bitmap passBitmap = ((BitmapDrawable)mImage.getDrawable()).getBitmap();

                                    Intent intent = new Intent(view.getContext(), CompletePassView.class);
                                    intent.putExtra("headline", passHeadline);
                                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                    passBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                    byte[] byteArray = stream.toByteArray();
                                    intent.putExtra("image", byteArray);
                                    intent.putExtra("date", passDate);
                                    intent.putExtra("time", passTime);
                                    intent.putExtra("picDescription", passPicDescription);
                                    intent.putExtra("description", passDescription);
                                    startActivity(intent);
                                    Toast.makeText(PoliticalNews.this, "Going to news", Toast.LENGTH_LONG).show();
                                    String s = "Going to :" + passHeadline;
                                    int speech = completehotspeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                                    vibrator.vibrate(300);
                                }
                                i = 0;
                            }

                        }, 500);

                    }
                });
                return viewHolder;
            }
        };

        completeRecyclerView.setLayoutManager(completeLinerLayoutManager);
        firebaseRecyclerAdapter.startListening();
        completeRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    protected void onStart(){

        super.onStart();

        if (firebaseRecyclerAdapter!= null){

            firebaseRecyclerAdapter.startListening();
        }
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
            int speech = completehotspeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            backToast.show();
        }

        backPressed = System.currentTimeMillis();
    }

}
