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

public class ContactDetailAdapter extends RecyclerView.Adapter<ContactDetailAdapter.Viewholder> {
    ArrayList<ContactModel>contactModels;
    Context context;

    public ContactDetailAdapter(ArrayList<ContactModel> contactModels, Context context) {
        this.contactModels = contactModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactDetailAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_contact, null);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactDetailAdapter.Viewholder holder, int position) {
        holder.textView.setText(contactModels.get(position).getContacttitle());

    }

    @Override
    public int getItemCount() {
        return contactModels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView textView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.AddressTitle);
        }
    }
}
