package com.studio.illiyin.alomagoindonesia.Models;

/**
 * Created by fairuz on 2/6/2018.
 */

public class JSONResponse2<K> {
    private boolean isOK;
    private KabarModel[] data;
    private TanggalTerakhirDiubah tanggalWaktu;
    private int judul;

    public KabarModel[] getListKabar(){
        return data;
    }
    public boolean getIsOK() {
        return isOK;
    }

    public TanggalTerakhirDiubah getTanggalWaktu() {
        return tanggalWaktu;
    }

    public int getJudul() {
        return judul;
    }

}
