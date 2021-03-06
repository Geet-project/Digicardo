package com.gstechworks.digicardo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gstechworks.digicardo.Models.ContactModel;
import com.gstechworks.digicardo.R;

import java.util.ArrayList;

public class RegBusinessAdapter extends RecyclerView.Adapter<RegBusinessAdapter.ViewHolder> {
    ArrayList<ContactModel>contactModels;
    Context context;

    public RegBusinessAdapter(ArrayList<ContactModel> contactModels, Context context) {
        this.contactModels = contactModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RegBusinessAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_regbusiness, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RegBusinessAdapter.ViewHolder holder, int position) {
        holder.textView.setText(contactModels.get(position).getContacttitle());

    }

    @Override
    public int getItemCount() {
        return contactModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.BusinessName);
        }
    }
}
