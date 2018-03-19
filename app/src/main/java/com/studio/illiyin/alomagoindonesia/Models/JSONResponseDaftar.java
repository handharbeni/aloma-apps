package com.studio.illiyin.alomagoindonesia.Models;

/**
 * Created by fairuz on 3/19/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONResponseDaftar {
    @SerializedName("is_ok")
    @Expose
    private Boolean isOk;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getIsOk() {
        return isOk;
    }

    public void setIsOk(Boolean isOk) {
        this.isOk = isOk;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
