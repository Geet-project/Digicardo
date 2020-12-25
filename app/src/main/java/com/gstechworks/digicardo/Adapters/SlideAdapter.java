package com.gstechworks.digicardo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gstechworks.digicardo.Models.SliderModel;
import com.gstechworks.digicardo.R;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SlideAdapter extends SliderViewAdapter<SlideAdapter.myholder> {
    ArrayList<SliderModel> imageModels;
    Context context;

    public SlideAdapter(ArrayList<SliderModel> imageModels, Context context) {
        this.imageModels = imageModels;
        this.context = context;
    }

    @Override
    public SlideAdapter.myholder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slide, null);
        return new myholder(inflate);
    }

    @Override
    public void onBindViewHolder(SlideAdapter.myholder viewHolder, int position) {
        Picasso.get().load(imageModels.get(position).getImgslider()).into(viewHolder.imageView);
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = imageModels.get(position).getPhone();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+91" + phone));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getCount() {
        return imageModels.size();
    }

    public class myholder extends SliderViewAdapter.ViewHolder {
        ImageView imageView;
        public myholder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imglogo);
        }
    }
}
