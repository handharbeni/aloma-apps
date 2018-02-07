package com.studio.illiyin.alomagoindonesia.Models;

/**
 * Created by Mindha on 18/06/2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class KabarModel {
//    int id;
//    String photo, judul, date;
//
//    public KabarModel(int id, String photo, String judul, String date) {
//        this.id = id;
//        this.photo = photo;
//        this.judul = judul;
//        this.date = date;
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
//    public String getJudul() {
//        return judul;
//    }
//
//    public void setJudul(String judul) {
//        this.judul = judul;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("tanggal_waktu")
    @Expose
    private TanggalWaktu tanggalWaktu;
    @SerializedName("terakhir_diubah")
    @Expose
    private TanggalTerakhirDiubah terakhirDiubah;
    @SerializedName("images")
    @Expose
    private Object images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public TanggalWaktu getTanggalWaktu() {
        return tanggalWaktu;
    }

    public void setTanggalWaktu(TanggalWaktu tanggalWaktu) {
        this.tanggalWaktu = tanggalWaktu;
    }

    public TanggalTerakhirDiubah getTerakhirDiubah() {
        return terakhirDiubah;
    }

    public void setTerakhirDiubah(TanggalTerakhirDiubah terakhirDiubah) {
        this.terakhirDiubah = terakhirDiubah;
    }

    public Object getImages() {
        return images;
    }

    public void setImages(Object images) {
        this.images = images;
    }

}

