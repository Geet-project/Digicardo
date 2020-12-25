package com.gstechworks.digicardo.Fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gstechworks.digicardo.Adapters.ContactDetailAdapter;
import com.gstechworks.digicardo.Adapters.SearchAdapter;
import com.gstechworks.digicardo.Models.ContactModel;
import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.databinding.FragmentSearchBinding;

import java.util.ArrayList;


public class SearchFragment extends Fragment {
    FragmentSearchBinding binding;
    ArrayList<ContactModel>contactModels = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search, container, false);
        String[] contactitle = getResources().getStringArray(R.array.ProductNames);
        for(int i =0; i<contactitle.length; i++){
            ContactModel contactModel = new ContactModel(contactitle[i]);
            contactModels.add(contactModel);
        }
        SearchAdapter adapter = new SearchAdapter(contactModels, getContext() );
        binding.SearchListingRecyclerView.setAdapter(adapter);
        return binding.getRoot();
    }
}