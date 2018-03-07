package com.studio.illiyin.alomagoindonesia.Models;

/**
 * Created by fairuz on 3/7/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignInModel {
    @SerializedName("is_ok")
    @Expose
    private Boolean isOk;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("terdaftar")
    @Expose
    private String terdaftar;
    @SerializedName("uniq_key")
    @Expose
    private String uniqKey;

    public Boolean getIsOk() {
        return isOk;
    }

    public void setIsOk(Boolean isOk) {
        this.isOk = isOk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTerdaftar() {
        return terdaftar;
    }

    public void setTerdaftar(String terdaftar) {
        this.terdaftar = terdaftar;
    }

    public String getUniqKey() {
        return uniqKey;
    }

    public void setUniqKey(String uniqKey) {
        this.uniqKey = uniqKey;
    }
}
