package com.studio.illiyin.alomagoindonesia.service;

import com.studio.illiyin.alomagoindonesia.Models.JSONResponse;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponse2;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponseHistory;
import com.studio.illiyin.alomagoindonesia.Models.KabarModel;

import retrofit2.Call;
import retrofit2.http.GET;

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

    @GET("kabarburung")
    Call<JSONResponse2<KabarModel>> getListKabarBurung();

    @GET("transferpulsa")
    Call<JSONResponseHistory> getListDataHistory();
}
