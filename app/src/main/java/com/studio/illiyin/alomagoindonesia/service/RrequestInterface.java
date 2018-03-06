package com.studio.illiyin.alomagoindonesia.service;

import com.studio.illiyin.alomagoindonesia.Models.DetailKabarModel;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponse;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponse2;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponseDetailKabar;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponseHistory;
import com.studio.illiyin.alomagoindonesia.Models.KabarModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

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

//    @GET("kabarburung")
//    Call<JSONResponseDetailKabar<DetailKabarModel>> getContentKabar(@Field("id") String id);

    @GET("kabarburung/")
    Call<JSONResponseDetailKabar<DetailKabarModel>> getContentKabar();



//    Call<JSONResponseDetailKabar<DetailKabarModel>> getContentKabar();

    @GET("transferpulsa")
    Call<JSONResponseHistory> getListDataHistory();

    @FormUrlEncoded
    @POST("user/daftar")
    Call<ResponseBody> registerRequest(@Field("username") String username,
                                       @Field("password") String password,
                                       @Field("email") String email);

    @FormUrlEncoded
    @POST("user/masuk")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);
}
