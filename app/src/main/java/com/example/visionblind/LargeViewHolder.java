package com.example.visionblind;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class LargeViewHolder extends RecyclerView.ViewHolder {

    View largeView;

    public LargeViewHolder(@NonNull View itemView) {
        super(itemView);

        largeView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                largeClickListener.onItemClick(v,getAdapterPosition());

            }
        });
    }

    public void setDetails(Context ctx, String image, String headline, String date, String time, String description){

        TextView largeHeadline = largeView.findViewById(R.id.large_headline);
        TextView largeDate = largeView.findViewById(R.id.large_date);
        TextView largeTime = largeView.findViewById(R.id.large_time);
        ImageView largeImage = largeView.findViewById(R.id.large_card_image);
        TextView largeDescription = largeView.findViewById(R.id.large_description);

        largeHeadline.setText(headline);
        largeDate.setText(date);
        largeTime.setText(time);
        largeDescription.setText(description);
        Picasso.get().load(image).into(largeImage);

    }

    private LargeViewHolder.ClickListener largeClickListener;
    public interface ClickListener {
        void onItemClick(View view,int position);
    }

    public  void setOnClickListener(LargeViewHolder.ClickListener clickListener){
        largeClickListener = clickListener;
    }
}
