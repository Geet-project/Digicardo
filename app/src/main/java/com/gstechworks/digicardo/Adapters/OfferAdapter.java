package com.gstechworks.digicardo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gstechworks.digicardo.Models.OffersModel;
import com.gstechworks.digicardo.R;

import java.net.ContentHandler;
import java.util.ArrayList;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {
    ArrayList<OffersModel>offersModels;
    Context context;

    public OfferAdapter(ArrayList<OffersModel> offersModels, Context context) {
        this.offersModels = offersModels;
        this.context = context;
    }


    @NonNull
    @Override
    public OfferAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_layout, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(offersModels.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return offersModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.offerimage);
        }
    }
}
