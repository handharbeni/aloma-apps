package com.studio.illiyin.alomagoindonesia.fragment;

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

import com.studio.illiyin.alomagoindonesia.Adapter.HistoryAdapter;
import com.studio.illiyin.alomagoindonesia.Generator.ServiceGenerator;
import com.studio.illiyin.alomagoindonesia.Models.HistoryModel;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponse;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponseHistory;
import com.studio.illiyin.alomagoindonesia.R;
import com.studio.illiyin.alomagoindonesia.service.RrequestInterface;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mindha on 16/06/2017.
 */

public class History extends Fragment{
//    View v;
//    private static HistoryAdapter adapter;
//    ArrayList<HistoryModel> dataModels;
//    ListView listViewMessage;
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        v = inflater.inflate(R.layout.fragment_history, container, false);
//        getActivity().setTitle("History");
//        listViewMessage = (ListView) v.findViewById(R.id.listHistory);
//        dummyHistory();
//        initAdapter();
//        return v;
//    }
//
//    public void dummyHistory(){
//        dataModels = new ArrayList<>();
//        for (int i=0;i<20;i++){
//            String uri = "@drawable/icon_bird_bak_bak.png";
//            dataModels.add(new HistoryModel(i, uri, "Number"+(i+1), "2017-02-02", "11:00","10.000"));
//        }
//    }
//
//
//    public void initAdapter(){
//        adapter = new HistoryAdapter(dataModels,getActivity().getApplicationContext());
//
//        listViewMessage.setAdapter(adapter);
//        listViewMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                HistoryModel dataModel= dataModels.get(position);
//            }
//        });
//
//    }

    View view;
    private RecyclerView recyclerView;
    private ArrayList<HistoryModel> data;
    private HistoryAdapter adapter;
    RrequestInterface request;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_history, container, false);
        getActivity().setTitle("History");
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
        Call<JSONResponseHistory> call = request.getListDataHistory();
        call.enqueue(new Callback<JSONResponseHistory>() {
            @Override
            public void onResponse(Call<JSONResponseHistory> call, Response<JSONResponseHistory> response) {
                JSONResponseHistory jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getListHistory()));
                adapter = new HistoryAdapter(data, getActivity().getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponseHistory> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}
