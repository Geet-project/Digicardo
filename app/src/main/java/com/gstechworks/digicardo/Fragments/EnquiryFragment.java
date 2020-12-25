package com.gstechworks.digicardo.Fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gstechworks.digicardo.Adapters.EnquiryAdapter;
import com.gstechworks.digicardo.Models.EnquiryModels;
import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.databinding.FragmentEnquiryBinding;

import java.util.ArrayList;

public class EnquiryFragment extends Fragment {
    FragmentEnquiryBinding binding;
    ArrayList<EnquiryModels>enquiryModels = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_enquiry, container, false);
        String names[] = getResources().getStringArray(R.array.Username);
        for(int i =0; i<names.length; i++) {
            EnquiryModels enquiryModels1 = new EnquiryModels(names[i]);
            enquiryModels.add(enquiryModels1);
        }
        EnquiryAdapter adapter= new EnquiryAdapter(enquiryModels, getContext());
        binding.EnquiryRecyclerView.setAdapter(adapter);
        binding.EnquiryRecyclerView.setNestedScrollingEnabled(false);

        return binding.getRoot();
    }
}