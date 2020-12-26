package com.example.application;

import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("userCode")
    private String userCode;
    @SerializedName("success")
    private boolean success;
    @SerializedName("userId")
    private int userId;

    public String getUserCode() {
        return userCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
