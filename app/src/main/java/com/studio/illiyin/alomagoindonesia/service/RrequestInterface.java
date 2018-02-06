package com.studio.illiyin.alomagoindonesia.service;

import com.studio.illiyin.alomagoindonesia.Models.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by fairuz on 2/3/2018.
 */

public interface RrequestInterface {
    @GET("appinfo")
    Call<JSONResponse> getDataInfo();

    @GET("appinfo/disclaimer")
    Call<JSONResponse> getDisclaimer();

    @GET("appinfo/privacy")
    Call<JSONResponse> getInfoPrivacy();

    @GET("appinfo/about")
    Call<JSONResponse> getInfoAbout();


}
