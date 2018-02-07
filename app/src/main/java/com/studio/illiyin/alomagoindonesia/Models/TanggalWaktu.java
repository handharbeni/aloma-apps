package com.studio.illiyin.alomagoindonesia.Models;

/**
 * Created by fairuz on 2/6/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TanggalWaktu {
    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;
    @SerializedName("datetime")
    @Expose
    private String datetime;

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

}
