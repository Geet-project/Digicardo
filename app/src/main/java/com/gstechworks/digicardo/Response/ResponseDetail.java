package com.gstechworks.digicardo.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDetail {
    @SerializedName("login_response ")
    @Expose
    private List<LoginResponse> loginResponse = null;

    public List<LoginResponse> getLoginResponse() {
        return loginResponse;
    }

    public void setLoginResponse(List<LoginResponse> loginResponse) {
        this.loginResponse = loginResponse;
    }


    //Otp Response

    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("OTP_Varification")
    @Expose
    private Integer oTPVarification;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getOTPVarification() {
        return oTPVarification;
    }

    public void setOTPVarification(Integer oTPVarification) {
        this.oTPVarification = oTPVarification;
    }
    
}
