package com.gstechworks.digicardo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gstechworks.digicardo.Models.TrendingModel;
import com.gstechworks.digicardo.R;

import java.util.ArrayList;

public class TrendingCategoriesAdapter extends RecyclerView.Adapter<TrendingCategoriesAdapter.ViewHolder> {
    ArrayList<TrendingModel> trendingModels;
    Context context;

    public TrendingCategoriesAdapter(ArrayList<TrendingModel> trendingModels, Context context) {
        this.trendingModels = trendingModels;
        this.context = context;
    }

    @NonNull
    @Override
    public TrendingCategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_layout, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingCategoriesAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(trendingModels.get(position).getImage());
        holder.textView.setText(trendingModels.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return trendingModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.trendingimg);
            textView = itemView.findViewById(R.id.trendingname);
        }
    }
}
