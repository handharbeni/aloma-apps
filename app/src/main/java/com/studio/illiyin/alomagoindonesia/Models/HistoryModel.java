package com.studio.illiyin.alomagoindonesia.Models;

/**
 * Created by Mindha on 21/06/2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryModel {
//    int id;
//    String photo, number, day, time, price;
//
//    public HistoryModel(int id, String photo, String number, String day, String time, String price) {
//        this.id = id;
//        this.photo = photo;
//        this.number = number;
//        this.day = day;
//        this.time = time;
//        this.price = price;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(String photo) {
//        this.photo = photo;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public String getDay() {
//        return day;
//    }
//
//    public void setDay(String day) {
//        this.day = day;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user_token")
    @Expose
    private String userToken;
    @SerializedName("nomor_pengirim")
    @Expose
    private String nomorPengirim;
    @SerializedName("nomor_tujuan")
    @Expose
    private String nomorTujuan;
    @SerializedName("denominasi")
    @Expose
    private String denominasi;
    @SerializedName("total_pulsa_transfer")
    @Expose
    private String totalPulsaTransfer;
    @SerializedName("verifikasi")
    @Expose
    private String verifikasi;
    @SerializedName("sent")
    @Expose
    private String sent;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("deleted")
    @Expose
    private String deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getNomorPengirim() {
        return nomorPengirim;
    }

    public void setNomorPengirim(String nomorPengirim) {
        this.nomorPengirim = nomorPengirim;
    }

    public String getNomorTujuan() {
        return nomorTujuan;
    }

    public void setNomorTujuan(String nomorTujuan) {
        this.nomorTujuan = nomorTujuan;
    }

    public String getDenominasi() {
        return denominasi;
    }

    public void setDenominasi(String denominasi) {
        this.denominasi = denominasi;
    }

    public String getTotalPulsaTransfer() {
        return totalPulsaTransfer;
    }

    public void setTotalPulsaTransfer(String totalPulsaTransfer) {
        this.totalPulsaTransfer = totalPulsaTransfer;
    }

    public String getVerifikasi() {
        return verifikasi;
    }

    public void setVerifikasi(String verifikasi) {
        this.verifikasi = verifikasi;
    }

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}