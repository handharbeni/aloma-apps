package com.studio.illiyin.alomagoindonesia.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.studio.illiyin.alomagoindonesia.Adapter.DetailKabarAdapter;
import com.studio.illiyin.alomagoindonesia.Adapter.KabarAdapter;
import com.studio.illiyin.alomagoindonesia.Generator.ServiceGenerator;
import com.studio.illiyin.alomagoindonesia.MenuTab.Kabar;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponse2;
import com.studio.illiyin.alomagoindonesia.Models.KabarModel;
import com.studio.illiyin.alomagoindonesia.R;
import com.studio.illiyin.alomagoindonesia.service.RrequestInterface;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fairuz on 2/8/2018.
 */

public class DetailKabar extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private ArrayList<KabarModel> data;
    private DetailKabarAdapter adapter;
    RrequestInterface request;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail_kabar_burung,container,false);
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
        Call<JSONResponse2<KabarModel>> call = request.getListKabarBurung();
        call.enqueue(new Callback<JSONResponse2<KabarModel>>() {
            @Override
            public void onResponse(Call<JSONResponse2<KabarModel>> call, Response<JSONResponse2<KabarModel>> response) {
                JSONResponse2<KabarModel> jsonResponse2 = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse2.getListKabar()));
                adapter = new DetailKabarAdapter(data, getActivity().getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponse2<KabarModel>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
