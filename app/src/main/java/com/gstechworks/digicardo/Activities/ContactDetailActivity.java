package com.gstechworks.digicardo.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import com.gstechworks.digicardo.Adapters.ContactDetailAdapter;
import com.gstechworks.digicardo.Adapters.SocialAdapter;
import com.gstechworks.digicardo.Models.ContactModel;
import com.gstechworks.digicardo.Models.SocialModels;
import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.databinding.ActivityContactDetailBinding;

import java.util.ArrayList;

public class ContactDetailActivity extends AppCompatActivity {
    ActivityContactDetailBinding binding;
    ArrayList<ContactModel> contactModels = new ArrayList<>();
    ArrayList<SocialModels>socialModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_contact_detail);

        binding.AddNewAddress.setOnClickListener(view -> {
            final AlertDialog.Builder mbuilder = new AlertDialog.Builder(this);
            View v = getLayoutInflater().inflate(R.layout.dialog_contact, null);
            mbuilder.setView(v);
            final AlertDialog dialog = mbuilder.create();
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.show();
        });

        binding.AddEmailAddress.setOnClickListener(view -> {
            final AlertDialog.Builder mbuilder = new AlertDialog.Builder(this);
            View v = getLayoutInflater().inflate(R.layout.dialog_email, null);
            mbuilder.setView(v);
            final AlertDialog dialog = mbuilder.create();
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.show();
        });

        binding.AddNumber.setOnClickListener(view -> {
            final AlertDialog.Builder mbuilder = new AlertDialog.Builder(this);
            View v = getLayoutInflater().inflate(R.layout.dialog_phone, null);
            mbuilder.setView(v);
            final AlertDialog dialog = mbuilder.create();
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.show();
        });

        binding.AddSocialNetwork.setOnClickListener(view -> {
            final AlertDialog.Builder mbuilder = new AlertDialog.Builder(this);
            View v = getLayoutInflater().inflate(R.layout.dialog_social, null);
            mbuilder.setView(v);
            final AlertDialog dialog = mbuilder.create();
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.show();
        });

        binding.previousbtn.setOnClickListener(view -> {
            onBackPressed();
            finish();
        });

        String[] contactitle = getResources().getStringArray(R.array.Addresstitle);
        for(int i =0; i<contactitle.length; i++){
            ContactModel contactModel = new ContactModel(contactitle[i]);
            contactModels.add(contactModel);
        }
        ContactDetailAdapter adapter = new ContactDetailAdapter(contactModels, this);
        binding.AddressRecyclerView.setAdapter(adapter);
        binding.AddressRecyclerView.setNestedScrollingEnabled(false);
        binding.EmailAddressRecyclerView.setAdapter(adapter);
        binding.EmailAddressRecyclerView.setNestedScrollingEnabled(false);
        binding.PhoneNumberRecyclerView.setAdapter(adapter);
        binding.PhoneNumberRecyclerView.setNestedScrollingEnabled(false);


        TypedArray socialimages = getResources().obtainTypedArray(R.array.SocialIcons);
        for(int i =0; i<socialimages.length(); i++){
            SocialModels socialModel = new SocialModels(socialimages.getResourceId(i,0));
            socialModels.add(socialModel);
        }
        SocialAdapter adapter1 = new SocialAdapter(socialModels, this);
        binding.SocialRecyclerView.setAdapter(adapter1);
    }
}