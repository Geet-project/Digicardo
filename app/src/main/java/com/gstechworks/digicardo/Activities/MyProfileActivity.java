package com.gstechworks.digicardo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.databinding.ActivityMyProfileBinding;

public class MyProfileActivity extends AppCompatActivity {

    ActivityMyProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_profile);

        binding.EditImage.setOnClickListener(view -> {
            Intent i = new Intent(MyProfileActivity.this, EditProfileActivity.class);
            startActivity(i);
        });
    }
}