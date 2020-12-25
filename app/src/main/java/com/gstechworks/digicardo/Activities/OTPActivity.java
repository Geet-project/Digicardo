package com.gstechworks.digicardo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.databinding.ActivityOTPBinding;

public class OTPActivity extends AppCompatActivity {
    ActivityOTPBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_o_t_p);
        binding.BackArrow.setOnClickListener(view -> {
            onBackPressed();
            finish();
        });

        binding.ProceedBtn.setOnClickListener(view -> {
            Intent i = new Intent(OTPActivity.this, HomeActivity.class);
            startActivity(i);
        });
    }
}