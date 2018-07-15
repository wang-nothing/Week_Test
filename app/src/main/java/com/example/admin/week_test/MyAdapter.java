package com.example.admin.week_test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<GoodBean.DataBean> data;

    public MyAdapter(Context context, List<GoodBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.mybase, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String adapter_title = data.get(i).getTitle();
        String bargainPrice = data.get(i).getBargainPrice();
        String path = data.get(i).getImages().split("\\|")[0];
        viewHolder.mybase_tv.setText(adapter_title);
        viewHolder.mybase_price.setText(bargainPrice);
        Glide.with(context).load(path).into(viewHolder.mybase_image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
