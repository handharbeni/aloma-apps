package com.studio.illiyin.alomagoindonesia.MenuTab;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.studio.illiyin.alomagoindonesia.Adapter.KabarAdapter;
import com.studio.illiyin.alomagoindonesia.Generator.ServiceGenerator;
import com.studio.illiyin.alomagoindonesia.Models.AppInfo;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponse2;
import com.studio.illiyin.alomagoindonesia.Models.KabarModel;
import com.studio.illiyin.alomagoindonesia.R;
import com.studio.illiyin.alomagoindonesia.fragment.DetailKabar;
import com.studio.illiyin.alomagoindonesia.service.RrequestInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class Kabar extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private ArrayList<KabarModel> data;
    private KabarAdapter adapter;
    RrequestInterface request;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_berita_burung, container, false);
        initViews();

//        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
//        String idShared = sharedPreferences.getString(SignIn.KEY_ID, "");

        return  view;
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
                adapter = new KabarAdapter(data, getActivity().getApplicationContext());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<JSONResponse2<KabarModel>> call, Throwable t) {
                Log.d(TAG, "Error"+t.getMessage());
            }
        });
    }
}
