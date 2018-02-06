package com.studio.illiyin.alomagoindonesia.fragment;


import android.app.DownloadManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.studio.illiyin.alomagoindonesia.Adapter.DisclaimerAdapter;
import com.studio.illiyin.alomagoindonesia.Generator.ServiceGenerator;
import com.studio.illiyin.alomagoindonesia.Models.AppInfo;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponse;
import com.studio.illiyin.alomagoindonesia.R;
import com.studio.illiyin.alomagoindonesia.service.RrequestInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mindha on 16/06/2017.
 */

public class Disclaimer extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private ArrayList<AppInfo> data;
    private DisclaimerAdapter adapter;
    RrequestInterface request;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//       super.onCreateView(inflater, container, savedInstanceState);
       view = inflater.inflate(R.layout.fragment_disclaimer, container, false);
       getActivity().setTitle("Disclaimer");
       initViews();
       return view;
    }

    private void initViews() {
        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        loadData();
    }

    private void loadData() {
        request = ServiceGenerator.createService(RrequestInterface.class);
        retrofit2.Call<JSONResponse> call = request.getDisclaimer();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(retrofit2.Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getData()));
                adapter = new DisclaimerAdapter(data, getActivity().getApplicationContext());
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(retrofit2.Call<JSONResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
