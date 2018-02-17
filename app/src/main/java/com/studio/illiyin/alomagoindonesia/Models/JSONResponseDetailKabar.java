package com.studio.illiyin.alomagoindonesia.Models;

/**
 * Created by fairuz on 2/17/2018.
 */

public class JSONResponseDetailKabar<K> {
    private boolean isOK;
    private DetailKabarModel[] data;

    public DetailKabarModel[] getData(){
        return data;
    }
    private boolean getIsOK(){
        return isOK;
    }
}
