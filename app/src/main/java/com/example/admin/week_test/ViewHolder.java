package com.example.admin.week_test;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView mybase_tv,mybase_price;
    public ImageView mybase_image;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mybase_tv = itemView.findViewById(R.id.mybase_tv);
        mybase_price = itemView.findViewById(R.id.mybase_price);
        mybase_image = itemView.findViewById(R.id.mybase_image);
    }
}
