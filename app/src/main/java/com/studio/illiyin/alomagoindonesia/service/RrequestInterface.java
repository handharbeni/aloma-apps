package com.studio.illiyin.alomagoindonesia.service;

import com.studio.illiyin.alomagoindonesia.Models.JSONResponse;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponse2;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponseHistory;
import com.studio.illiyin.alomagoindonesia.Models.KabarModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    @GET("kabarburung")
    Call<JSONResponse2<KabarModel>> getListKabarBurung();

    @GET("kabarburung/")
    Call<JSONResponse2<KabarModel>> getContentKabar();

    @GET("transferpulsa")
    Call<JSONResponseHistory> getListDataHistory();

    @POST("user/daftarBody")
    Call<ResponseBody> registerRequest(@Query("username") String username,
                                       @Query("password") String password,
                                       @Query("email") String email);
    @POST("user/masukBody")
    Call<ResponseBody> loginRequest(@Query("username") String username,
                                    @Query("password") String password);
}
