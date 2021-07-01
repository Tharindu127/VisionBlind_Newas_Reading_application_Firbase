package com.example.visionblind;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class CompleteBlindViewHolder extends RecyclerView.ViewHolder {

    View completeView;

    public CompleteBlindViewHolder(@NonNull View itemView) {
        super(itemView);

        completeView = itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                completeClickListener.onItemClick(v,getAdapterPosition());
            }
        });
    }

    public void setDetails(Context ctx, String image, String headline, String date, String time, String picDescription, String description){

        TextView completeHeadline = completeView.findViewById(R.id.complete_headline);
        TextView completeDate = completeView.findViewById(R.id.complete_date);
        TextView completeTime = completeView.findViewById(R.id.complete_time);
        TextView completePictureDescription = completeView.findViewById(R.id.picture_description);
        TextView completeDscription = completeView.findViewById(R.id.complete_description);
        ImageView completeImage = completeView.findViewById(R.id.complete_card_image);

        completeHeadline.setText(headline);
        completePictureDescription.setText(picDescription);
        completeDscription.setText(description);
        completeDate.setText(date);
        completeTime.setText(time);
        Picasso.get().load(image).into(completeImage);
    }

    private CompleteBlindViewHolder.ClickListener completeClickListener;
    public interface  ClickListener {

        void onItemClick(View view,int position);

    }

    public void setOnClickListener(CompleteBlindViewHolder.ClickListener clickListener){

        completeClickListener = clickListener;
    }

}

