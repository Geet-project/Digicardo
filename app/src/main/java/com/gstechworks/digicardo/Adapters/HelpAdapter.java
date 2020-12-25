package com.gstechworks.digicardo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gstechworks.digicardo.Models.HelpModel;
import com.gstechworks.digicardo.R;

import java.util.ArrayList;

public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.ViewHolder> {
    ArrayList<HelpModel>helpModels;
    Context context;

    public HelpAdapter(ArrayList<HelpModel> helpModels, Context context) {
        this.helpModels = helpModels;
        this.context = context;
    }

    @NonNull
    @Override
    public HelpAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_help, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HelpAdapter.ViewHolder holder, int position) {
        holder.heading.setText(helpModels.get(position).getHelpheading());
        holder.arrowdown.setOnClickListener(view -> {
            holder.arrowdown.setVisibility(View.GONE);
            holder.arrowup.setVisibility(View.VISIBLE);
            holder.helpvalue.setVisibility(View.VISIBLE);
        });

        holder.arrowup.setOnClickListener(view -> {
            holder.arrowdown.setVisibility(View.VISIBLE);
            holder.arrowup.setVisibility(View.GONE);
            holder.helpvalue.setVisibility(View.GONE);
        });

    }

    @Override
    public int getItemCount() {
        return helpModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading, helpvalue;
        ImageView arrowup, arrowdown;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.lorem_heading);
            arrowup = itemView.findViewById(R.id.arrowup);
            arrowdown = itemView.findViewById(R.id.arrowdown);
            helpvalue = itemView.findViewById(R.id.loremvalue);

        }
    }
}
