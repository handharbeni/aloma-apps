package com.studio.illiyin.alomagoindonesia.Models;

/**
 * Created by fairuz on 2/3/2018.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONResponse {
    private boolean isOK;
    private AppInfo data;
    public AppInfo getData(){
        return data;
    }
    public boolean getIsOK(){
        return isOK;
    }
}


