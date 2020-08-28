package com.example.customlistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder> {

    private List<com.example.customlistviewdemo.Property> propertyList; //news list
    private Context context;
    private  OnNOtelistener onNOtelistener;

    public PropertyAdapter(List<com.example.customlistviewdemo.Property> propertyList, Context context, OnNOtelistener onNOtelistener) {

        this.propertyList = propertyList;
        this.context = context;
        this.onNOtelistener =onNOtelistener;

    } //


    public PropertyAdapter(List<com.example.customlistviewdemo.Property> propertyList, Context context) {

        this.propertyList = propertyList;
        this.context = context;

    } //

    public class PropertyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {   OnNOtelistener onNOtelistener;

        public ImageView propertyImageView;
        public TextView addressTextView;

        public PropertyViewHolder (View view ,OnNOtelistener onNOtelistener)
        {   super(view);
            propertyImageView = view.findViewById(R.id.propertyImageView);
            addressTextView = view.findViewById(R.id.addressTextView);
            this.onNOtelistener =onNOtelistener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNOtelistener.OnNoteClick(getAdapterPosition());

        }//implemnet the interface of Listener
    }

    public interface OnNOtelistener{
        void  OnNoteClick(int position);

    }// the interface to get position


    @NonNull
    @Override
    public PropertyAdapter.PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View itemView = LayoutInflater.from(context).inflate(R.layout.property_layout, parent, false);
        return new PropertyAdapter.PropertyViewHolder(itemView, onNOtelistener);

    }

    @Override  // Populating data into the item through holder
    public void onBindViewHolder (PropertyViewHolder holder, int position )
    {

        holder.propertyImageView.setImageResource(propertyList.get(position).getImage());
        holder.addressTextView.setText(propertyList.get(position).getAddress());

    }

    @Override
    public int getItemCount(){
        return propertyList.size();
    }
  }
