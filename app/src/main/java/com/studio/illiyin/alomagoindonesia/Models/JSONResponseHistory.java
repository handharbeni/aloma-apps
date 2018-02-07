package com.studio.illiyin.alomagoindonesia.Models;

/**
 * Created by fairuz on 2/7/2018.
 */

public class JSONResponseHistory {
    private boolean isOK;
    private HistoryModel[] data;
    public HistoryModel[] getListHistory(){
        return data;
    }
    public boolean getIsOK(){
        return isOK;
    }
}
