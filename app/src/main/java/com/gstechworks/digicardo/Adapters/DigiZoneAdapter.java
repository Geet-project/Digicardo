package com.gstechworks.digicardo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.gstechworks.digicardo.Activities.BusinessRegistrationActivity;
import com.gstechworks.digicardo.Activities.MyProfileActivity;
import com.gstechworks.digicardo.Activities.OffersActivity;
import com.gstechworks.digicardo.Activities.RegisteredBusinessActivity;
import com.gstechworks.digicardo.Models.DigiModels;
import com.gstechworks.digicardo.R;

import java.util.ArrayList;

public class DigiZoneAdapter extends RecyclerView.Adapter<DigiZoneAdapter.ViewHolder> {
    ArrayList<DigiModels>digiModels;
    Context context;

    public DigiZoneAdapter(ArrayList<DigiModels> digiModels, Context context) {
        this.digiModels = digiModels;
        this.context = context;
    }

    @NonNull
    @Override
    public DigiZoneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_digicardomyzone, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull DigiZoneAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(digiModels.get(position).getImg());
        holder.textView.setText(digiModels.get(position).getName());
        holder.cardView.setOnClickListener(view -> {
            if(position==1){
                Intent i = new Intent(context, BusinessRegistrationActivity.class);
                context.startActivity(i);
            }else if(position ==0){
                Intent i = new Intent(context, MyProfileActivity.class);
                context.startActivity(i);
            }
            else if(position==5){
                Intent i = new Intent(context, OffersActivity.class);
                context.startActivity(i);
            }else if(position ==3){
                Intent i = new Intent(context, RegisteredBusinessActivity.class);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return digiModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.DigiMyzoneImg);
            textView = itemView.findViewById(R.id.DigiMyzoneText);
            cardView = itemView.findViewById(R.id.DigiZoneCardView);
        }
    }
}
