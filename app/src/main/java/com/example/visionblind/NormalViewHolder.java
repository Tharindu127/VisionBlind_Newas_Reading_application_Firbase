package com.example.visionblind;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class NormalViewHolder extends RecyclerView.ViewHolder {

    View normalview;

    public NormalViewHolder(@NonNull View itemView) {
        super(itemView);

        normalview = itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                normalClickListener.onItemClick(v, getAdapterPosition());

            }
        });

    }

    public void setDetails(Context ctx, String image, String headline, String date, String time, String description){

        TextView normalHeadline = normalview.findViewById(R.id.normal_headline);
        ImageView normalImage = normalview.findViewById(R.id.normal_card_image);
        TextView normalDate = normalview.findViewById(R.id.normal_date);
        TextView normalTime = normalview.findViewById(R.id.normal_time);
        TextView normalDescription = normalview.findViewById(R.id.normal_description);

        normalHeadline.setText(headline);
        normalDate.setText(date);
        normalTime.setText(time);
        normalDescription.setText(description);
        Picasso.get().load(image).into(normalImage);
    }

    private NormalViewHolder.ClickListener normalClickListener;

    public interface ClickListener {

        void onItemClick(View view,int position);
    }

    public void setOnClickListener(NormalViewHolder.ClickListener clickListener){
        normalClickListener = clickListener;
    }
}
