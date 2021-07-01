package com.example.visionblind;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ExtralargeViewHolder extends RecyclerView.ViewHolder {

    View extraLargeView;

    public ExtralargeViewHolder(@NonNull View itemView) {
        super(itemView);

        extraLargeView = itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                extralargeClickListener.onItemClick(v,getAdapterPosition());

            }
        });
    }

    public void setDetails(Context ctx, String image, String headline, String date, String time, String description){

        TextView extraLargeHeadline = extraLargeView.findViewById(R.id.extralarge_headline);
        TextView extraLargeDate = extraLargeView.findViewById(R.id.extralarge_date);
        TextView extraLargeTime = extraLargeView.findViewById(R.id.extralarge_time);
        ImageView extraLargeImage = extraLargeView.findViewById(R.id.extralarge_card_image);
        TextView extralargeDescription = extraLargeView.findViewById(R.id.extralarge_description);

        extraLargeHeadline.setText(headline);
        extraLargeDate.setText(date);
        extraLargeTime.setText(time);
        extralargeDescription.setText(description);
        Picasso.get().load(image).into(extraLargeImage);
    }

    private ExtralargeViewHolder.ClickListener extralargeClickListener;
    public interface ClickListener {
        void onItemClick(View view, int position);

    }

    public void setOnClickListener(ExtralargeViewHolder.ClickListener clickListener){
        extralargeClickListener = clickListener;
    }

}
