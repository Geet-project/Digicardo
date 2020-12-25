package com.gstechworks.digicardo.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gstechworks.digicardo.Adapters.ViewProductRecyclerAdapter;
import com.gstechworks.digicardo.Models.ViewProductModels;
import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.databinding.ActivityAddServicesBinding;

import java.util.ArrayList;

public class AddServicesActivity extends AppCompatActivity {
    ActivityAddServicesBinding binding;
    ArrayList<ViewProductModels> viewProductModels = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_services);
        binding.AddNewService.setOnClickListener(view -> {
            final AlertDialog.Builder mbuilder = new AlertDialog.Builder(this);
            View v = getLayoutInflater().inflate(R.layout.dialog_services, null);
            mbuilder.setView(v);
            final AlertDialog dialog = mbuilder.create();
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.show();
        });
        binding.nextbtn.setOnClickListener(view -> {
            Intent i = new Intent(AddServicesActivity.this, ContactDetailActivity.class);
            startActivity(i);
        });

        binding.previousbtn.setOnClickListener(view -> {
            onBackPressed();
            finish();
        });

        binding.SkipBtn.setOnClickListener(view -> {
            Intent i = new Intent(AddServicesActivity.this, ContactDetailActivity.class);
            startActivity(i);
        });
        String[] pro_names = getResources().getStringArray(R.array.ProductNames);
        for(int i =0; i<pro_names.length; i++){
            ViewProductModels viewProductModel = new ViewProductModels(pro_names[i]);
            viewProductModels.add(viewProductModel);
        }
        ViewProductRecyclerAdapter adapter = new ViewProductRecyclerAdapter(viewProductModels, this);
        binding.ViewServiceRecyclerView.setAdapter(adapter);
        binding.ViewServiceRecyclerView.setNestedScrollingEnabled(false);
    }
}