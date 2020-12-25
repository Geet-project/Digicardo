package com.gstechworks.digicardo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.gstechworks.digicardo.Common.Common;
import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.Response.LoginResponse;
import com.gstechworks.digicardo.Response.ResponseDetail;
import com.gstechworks.digicardo.Retrofit.ApiInterface;
import com.gstechworks.digicardo.SharedPreferences.SessionConfig;
import com.gstechworks.digicardo.databinding.ActivityLoginBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    ApiInterface apiInterface = Common.getAPIService();
    SessionConfig sessionConfig;
    boolean isNumber = false;
    ProgressDialog progressDialog;
    String mobile;
    int otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        progressDialog = new ProgressDialog(this);
        sessionConfig = new SessionConfig(this);
        mobile = binding.etNumber.getText().toString();


        binding.BtnLogin.setOnClickListener(view -> {
            if(!isNumber){
                binding.Numbererror.setVisibility(View.VISIBLE);
                binding.Numbererror.setText("Please enter mobile number.");
                binding.etNumber.requestFocus();
            }else{
                LoginSignUp();
            }
        });


        binding.etNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String number = binding.etNumber.getText().toString();
                if(number.equals("")){
                    binding.Numbererror.setVisibility(View.VISIBLE);
                    binding.Numbererror.setText("Please enter mobile number.");
                    binding.etNumber.requestFocus();
                }else if(number.length()<10){
                    binding.Numbererror.setVisibility(View.VISIBLE);
                    binding.Numbererror.setText("Please enter valid mobile number.");
                    binding.etNumber.requestFocus();
                }else{
                    binding.Numbererror.setVisibility(View.GONE);
                    isNumber = true;
                }

            }
        });
    }

    public void LoginSignUp(){
        progressDialog.show();
        progressDialog.setMessage("Please wait..");

        apiInterface.LoginSignUp(mobile).enqueue(new Callback<ResponseDetail>() {
            @Override
            public void onResponse(Call<ResponseDetail> call, Response<ResponseDetail> response) {
                if(response.isSuccessful()){
                    List<LoginResponse>loginResponses = response.body().getLoginResponse();
                    sessionConfig.setusermobile(loginResponses.get(0).getMobile());
                    String role_id = loginResponses.get(0).getRole();
                    if(role_id.equals("3")){
                        sessionConfig.setReseller(true);
                    }else if(role_id.equals("2")) {
                        sessionConfig.setUser(true);
                    }

                    int status = loginResponses.get(0).getStatus();
                    if(status == 0){
                        sendOtp();
                        progressDialog.dismiss();
                    }else if(status == 1){
                        sendOtp();
                        Intent i = new Intent(LoginActivity.this, OTPActivity.class);
                        i.putExtra("getotp", otp);
                        startActivity(i);
                        progressDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDetail> call, Throwable t) {

            }
        });
    }

    public void sendOtp(){
        apiInterface.sendOtp(mobile).enqueue(new Callback<ResponseDetail>() {
            @Override
            public void onResponse(Call<ResponseDetail> call, Response<ResponseDetail> response) {
                if(response.isSuccessful()){
                    otp = response.body().getOTPVarification();
                }
            }

            @Override
            public void onFailure(Call<ResponseDetail> call, Throwable t) {

            }
        });
    }
}