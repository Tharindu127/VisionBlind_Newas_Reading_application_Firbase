package com.example.visionblind;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mclickListener.onItemClick(v,getAdapterPosition());

            }
        });

    }


    private ViewHolder.ClickListener mclickListener;

    public void setDetails(Context applicationContext, String image, String headline, String date, String time, String description) {
        TextView mHeadline = mView.findViewById(R.id.headline);
        TextView mDate = mView.findViewById(R.id.date);
        TextView mTime = mView.findViewById(R.id.time);
        TextView mDescription = mView.findViewById(R.id.description);
        ImageView mImage = mView.findViewById(R.id.card_image);

        mHeadline.setText(headline);
        mDate.setText(date);
        mTime.setText(time);
        mDescription.setText(description);
        Picasso.get().load(image).into(mImage);
    }


    public interface ClickListener {

        void onItemClick(View view, int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mclickListener = clickListener;
    }
}
