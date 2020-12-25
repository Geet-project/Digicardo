package com.gstechworks.digicardo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.gstechworks.digicardo.Adapters.RegBusinessAdapter;
import com.gstechworks.digicardo.Adapters.SearchAdapter;
import com.gstechworks.digicardo.Models.ContactModel;
import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.databinding.ActivityRegisteredBusinessBinding;

import java.util.ArrayList;

public class RegisteredBusinessActivity extends AppCompatActivity {
    ActivityRegisteredBusinessBinding binding;
    ArrayList<ContactModel>contactModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registered_business);
        String[] contactitle = getResources().getStringArray(R.array.ProductNames);
        for(int i =0; i<contactitle.length; i++){
            ContactModel contactModel = new ContactModel(contactitle[i]);
            contactModels.add(contactModel);
        }
        RegBusinessAdapter adapter = new RegBusinessAdapter(contactModels, this );
        binding.RegBusinessRecyclerView.setAdapter(adapter);
    }
}