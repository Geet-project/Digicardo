package com.gstechworks.digicardo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gstechworks.digicardo.Models.ViewProductModels;
import com.gstechworks.digicardo.R;

import java.util.ArrayList;

public class ViewProductRecyclerAdapter extends RecyclerView.Adapter<ViewProductRecyclerAdapter.ViewHolder> {
    ArrayList<ViewProductModels> viewProductModels;
    Context context;

    public ViewProductRecyclerAdapter(ArrayList<ViewProductModels> viewProductModels, Context context) {
        this.viewProductModels = viewProductModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewProductRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_viewproduct, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewProductRecyclerAdapter.ViewHolder holder, int position) {
        holder.productname.setText(viewProductModels.get(position).getProductname());

    }

    @Override
    public int getItemCount() {
        return viewProductModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productname = itemView.findViewById(R.id.ProductName);
        }
    }
}
