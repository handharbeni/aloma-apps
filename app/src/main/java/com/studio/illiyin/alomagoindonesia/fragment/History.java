package com.studio.illiyin.alomagoindonesia.fragment;

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
import android.widget.Toast;

import com.studio.illiyin.alomagoindonesia.Adapter.HistoryAdapter;
import com.studio.illiyin.alomagoindonesia.Generator.ServiceGenerator;
import com.studio.illiyin.alomagoindonesia.MenuTab.SignIn;
import com.studio.illiyin.alomagoindonesia.Models.HistoriesModel;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponseHistories;
import com.studio.illiyin.alomagoindonesia.R;
import com.studio.illiyin.alomagoindonesia.service.RrequestInterface;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Mindha on 16/06/2017.
 */

public class History extends Fragment{
    View view;
    private RecyclerView recyclerView;
    private ArrayList<HistoriesModel> message;
    private HistoryAdapter adapter;
    RrequestInterface request;

    String UNIQ_KEY;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
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

        String uniq_key = SignIn.UNIQ_KEY;
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        String key = preferences.getString("key", uniq_key);
        Log.d(TAG, "UNIQ_KEY_SHARED=\t"+key);

        if(key!=null){
            request = ServiceGenerator.createService(RrequestInterface.class);
            Call<JSONResponseHistories> call = request.ListHistories(key);
            call.enqueue(new Callback<JSONResponseHistories>() {

                @Override
                public void onResponse(Call<JSONResponseHistories> call, Response<JSONResponseHistories> response) {
                    JSONResponseHistories jsonResponse = response.body();
                    message = new ArrayList<>(Arrays.asList(jsonResponse.getListHistory()));
                    adapter = new HistoryAdapter(message, getActivity().getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<JSONResponseHistories> call, Throwable t) {
                    Log.d("error", t.getMessage());
                }
            });
        }else{
            Toast.makeText(getContext(), "Silahkan Login Untuk Melihat History Transaksi Anda !",Toast.LENGTH_SHORT ).show();
        }
    }
}
