package com.studio.illiyin.alomagoindonesia.Models;

/**
 * Created by fairuz on 3/8/2018.
 */

public class JSONResponseHistories {
    private boolean isOK;
    private HistoriesModel[] message;
    public HistoriesModel[] getListHistory(){
        return message;
    }
    public boolean getIsOK(){
        return isOK;
    }
}
