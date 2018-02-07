package com.studio.illiyin.alomagoindonesia.MenuTab;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.studio.illiyin.alomagoindonesia.Adapter.KabarAdapter;
import com.studio.illiyin.alomagoindonesia.Generator.ServiceGenerator;
import com.studio.illiyin.alomagoindonesia.Models.AppInfo;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponse2;
import com.studio.illiyin.alomagoindonesia.Models.KabarModel;
import com.studio.illiyin.alomagoindonesia.R;
import com.studio.illiyin.alomagoindonesia.service.RrequestInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class Kabar extends Fragment {

//    private static String endpointUri = String.valueOf(R.string.endpointUri);
//
//    View v;
//    private static KabarAdapter adapter;
//    ArrayList<KabarModel> dataModels;
//    ListView listViewMessage;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        v = inflater.inflate(R.layout.fragment_berita_burung, container, false);
//        listViewMessage = (ListView) v.findViewById(R.id.listBerita);
//        dummyBerita();
//        initAdapter();
////        new HttpAsyncTask().execute("http://hmkcode.appspot.com/rest/controller/get.json");
//        return v;
//    }
//
//    public void content(){
//
//    }
//
//    public void dummyBerita(){
//        dataModels = new ArrayList<>();
//        for (int i=0;i<20;i++){
//            String uri = "@drawable/icon_bird_bak_bak.png";
//            dataModels.add(new KabarModel(i, uri, "Judul Berita "+(i+1), "2017-02-02"));
//        }
//    }
//
//
//    public void initAdapter(){
//        adapter = new KabarAdapter(dataModels,getActivity().getApplicationContext());
//
//        listViewMessage.setAdapter(adapter);
//        listViewMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                KabarModel dataModel= dataModels.get(position);
//            }
//        });
//
//    }

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
