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
import com.gstechworks.digicardo.databinding.ActivityAddProductBinding;

import java.util.ArrayList;

public class AddProductActivity extends AppCompatActivity {
    ActivityAddProductBinding binding;
    ArrayList<ViewProductModels> viewProductModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_product);

        binding.AddNewProduct.setOnClickListener(view -> {
            final AlertDialog.Builder mbuilder = new AlertDialog.Builder(this);
            View v = getLayoutInflater().inflate(R.layout.dialog_addproduct, null);
            mbuilder.setView(v);
            final AlertDialog dialog = mbuilder.create();
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.show();
        });

        binding.previousbtn.setOnClickListener(view -> {
           onBackPressed();
           finish();
        });

        binding.nextbtn.setOnClickListener(view -> {
            Intent i = new Intent(AddProductActivity.this, AddServicesActivity.class);
            startActivity(i);
            finish();
        });
        binding.SkipBtn.setOnClickListener(view -> {
            Intent i = new Intent(AddProductActivity.this, AddServicesActivity.class);
            startActivity(i);
            finish();
        });
        String[] pro_names = getResources().getStringArray(R.array.ProductNames);
        for(int i =0; i<pro_names.length; i++){
            ViewProductModels viewProductModel = new ViewProductModels(pro_names[i]);
            viewProductModels.add(viewProductModel);
        }
        ViewProductRecyclerAdapter adapter = new ViewProductRecyclerAdapter(viewProductModels, this);
        binding.ViewProductRecyclerView.setAdapter(adapter);
        binding.ViewProductRecyclerView.setNestedScrollingEnabled(false);

    }
}