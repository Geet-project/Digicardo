package com.gstechworks.digicardo.Fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gstechworks.digicardo.Activities.HomeActivity;
import com.gstechworks.digicardo.Adapters.NotificationAdapter;
import com.gstechworks.digicardo.Models.NotiModel;
import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.databinding.FragmentAdminNotiBinding;

import java.util.ArrayList;

public class AdminNotiFragment extends Fragment {

    FragmentAdminNotiBinding binding;
    ArrayList<NotiModel>notiModels = new ArrayList<>();
    NotificationAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_admin_noti, container, false);

        TypedArray notiimages = getResources().obtainTypedArray(R.array.noti_images);
        String[] notinames = getResources().getStringArray(R.array.noti_name);
        String[] notidesc = getResources().getStringArray(R.array.notidesc);
        String[]notitime = getResources().getStringArray(R.array.notitime);
        for(int i = 0; i<notiimages.length(); i++){
            NotiModel notiModel = new NotiModel(notinames[i], notidesc[i], notitime[i],notiimages.getResourceId(i,0));
            notiModels.add(notiModel);
        }
        adapter = new NotificationAdapter(notiModels, getContext());
        binding.AdminNotiREcyclerView.setAdapter(adapter);
        return  binding.getRoot();
    }
}