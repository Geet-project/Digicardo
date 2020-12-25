package com.gstechworks.digicardo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.gstechworks.digicardo.Models.NotiModel;
import com.gstechworks.digicardo.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.myholder> {
    ArrayList<NotiModel> notiModels;
    Context context;

    public NotificationAdapter(ArrayList<NotiModel> notiModels, Context context) {
        this.notiModels = notiModels;
        this.context = context;
    }

    @NonNull
    @Override
    public NotificationAdapter.myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.noti_item, null);
        return new myholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.myholder holder, int position){
        holder.circleImageView.setImageResource(notiModels.get(position).getNoti_img());
        holder.noti_name.setText(notiModels.get(position).getNoti_name());
        holder.noti_desc.setText(notiModels.get(position).getNoti_desc());
        holder.noti_time.setText(notiModels.get(position).getNoti_time());

    }

    @Override
    public int getItemCount() {
        return notiModels.size();
    }

    public class myholder extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        TextView noti_name, noti_desc, noti_time;
        public myholder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.cirlcenotiimg);
            noti_name = itemView.findViewById(R.id.notiname);
            noti_desc = itemView.findViewById(R.id.notidesc);
            noti_time = itemView.findViewById(R.id.noti_time);
        }
    }
}
