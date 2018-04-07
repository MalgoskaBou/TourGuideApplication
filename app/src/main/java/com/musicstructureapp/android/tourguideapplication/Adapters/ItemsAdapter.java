package com.musicstructureapp.android.tourguideapplication.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.transition.TransitionManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.musicstructureapp.android.tourguideapplication.Models.ItemModel;
import com.musicstructureapp.android.tourguideapplication.R;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private ArrayList<ItemModel> itemModels;
    private Context context;
    private int mExpandedPosition = -1;
    private RecyclerView rv;

    public ItemsAdapter(Context context, ArrayList<ItemModel> itemModels, RecyclerView rv) {
        this.context = context;
        this.itemModels = itemModels;
        this.rv = rv;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(context).inflate(R.layout.element_list, parent, false);
        return new ItemViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, int position) {

    holder.myTextTitle.setText(itemModels.get(position).getMyTitle());
    holder.myImage.setImageResource(itemModels.get(position).getMyImage());
    holder.myTextDescription.setText(itemModels.get(position).getMyDescription());

        final boolean isExpanded = position==mExpandedPosition;
        holder.myTextDescription.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:holder.getAdapterPosition();
                TransitionManager.beginDelayedTransition(rv);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }
}