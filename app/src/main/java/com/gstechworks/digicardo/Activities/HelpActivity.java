package com.gstechworks.digicardo.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.gstechworks.digicardo.Adapters.HelpAdapter;
import com.gstechworks.digicardo.Models.HelpModel;
import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.databinding.ActivityHelpBinding;

import java.util.ArrayList;

public class HelpActivity extends AppCompatActivity {
    ArrayList<HelpModel>helpModels = new ArrayList<>();
    ActivityHelpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_help);

        binding.notiIcon.setOnClickListener(view -> {
            final AlertDialog.Builder mbuilder = new AlertDialog.Builder(this);
            View v = getLayoutInflater().inflate(R.layout.dialog_help, null);
            mbuilder.setView(v);
            final AlertDialog dialog = mbuilder.create();
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.show();
        });

        String[] helpheading = getResources().getStringArray(R.array.HelpHeading);
        for(int i =0; i<helpheading.length; i++){
            HelpModel helpModel = new HelpModel(helpheading[i]);
            helpModels.add(helpModel);
        }
        HelpAdapter adapter = new HelpAdapter(helpModels, this);
        binding.helprecyclerview.setAdapter(adapter);
        binding.helprecyclerview.setNestedScrollingEnabled(false);
    }
}