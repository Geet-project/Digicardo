package com.gstechworks.digicardo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gstechworks.digicardo.Models.EnquiryModels;
import com.gstechworks.digicardo.R;

import java.util.ArrayList;

public class EnquiryAdapter extends RecyclerView.Adapter<EnquiryAdapter.ViewHolder> {
    ArrayList<EnquiryModels>enquiryModels;
    Context context;

    public EnquiryAdapter(ArrayList<EnquiryModels> enquiryModels, Context context) {
        this.enquiryModels = enquiryModels;
        this.context = context;
    }

    @NonNull
    @Override
    public EnquiryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_enquiry, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull EnquiryAdapter.ViewHolder holder, int position) {
        holder.textView.setText(enquiryModels.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return enquiryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.UserName);
        }
    }
}
