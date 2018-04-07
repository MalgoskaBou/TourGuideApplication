package com.musicstructureapp.android.tourguideapplication.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.musicstructureapp.android.tourguideapplication.R;

public class ItemViewHolder extends RecyclerView.ViewHolder{

  TextView myTextDescription;
  TextView myTextTitle;
  ImageView myImage;

    public ItemViewHolder(View itemView) {
        super(itemView);
        myTextDescription= itemView.findViewById(R.id.textDescriptionNew);
        myTextTitle = itemView.findViewById(R.id.myTextTitle);
        myImage = itemView.findViewById(R.id.myImageTitle);
        }
}
