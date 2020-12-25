package com.gstechworks.digicardo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gstechworks.digicardo.Models.SocialModels;
import com.gstechworks.digicardo.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.Viewholder> {
    ArrayList<SocialModels>socialModels;
    Context context;

    public SocialAdapter(ArrayList<SocialModels> socialModels, Context context) {
        this.socialModels = socialModels;
        this.context = context;
    }

    @NonNull
    @Override
    public SocialAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_social, null);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SocialAdapter.Viewholder holder, int position) {
        holder.circleImageView.setImageResource(socialModels.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return socialModels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.SocialImg);
        }
    }
}
