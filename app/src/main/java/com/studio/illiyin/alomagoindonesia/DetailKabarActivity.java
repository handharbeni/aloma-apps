package com.studio.illiyin.alomagoindonesia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.studio.illiyin.alomagoindonesia.Adapter.DetailKabarAdapter;
import com.studio.illiyin.alomagoindonesia.Generator.ServiceGenerator;
import com.studio.illiyin.alomagoindonesia.Models.DetailKabarModel;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponse2;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponseDetailKabar;
import com.studio.illiyin.alomagoindonesia.Models.KabarModel;
import com.studio.illiyin.alomagoindonesia.fragment.DetailKabar;
import com.studio.illiyin.alomagoindonesia.service.RrequestInterface;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class DetailKabarActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<DetailKabarModel> dataModels;
    private DetailKabarAdapter adapter;
    RrequestInterface request;

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kabar);
        //image
        img = findViewById(R.id.imageKabarBurung);
        Intent intent = getIntent();
        intent.getStringExtra("id");

        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadData();
    }

    private void loadData() {

            request = ServiceGenerator.createService(RrequestInterface.class);
//            Toast.makeText(getApplicationContext(), "DATA : "+request.getContentKabar(), Toast.LENGTH_SHORT).show();
            Call<JSONResponseDetailKabar<DetailKabarModel>> call = request.getContentKabar();
            call.enqueue(new Callback<JSONResponseDetailKabar<DetailKabarModel>>() {
                @Override
                public void onResponse(Call<JSONResponseDetailKabar<DetailKabarModel>> call, Response<JSONResponseDetailKabar<DetailKabarModel>> response) {
                    JSONResponseDetailKabar<DetailKabarModel> jsonResponse = response.body();
                    dataModels = new ArrayList<>(Arrays.asList(jsonResponse.getData()));
                    adapter = new DetailKabarAdapter(dataModels, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<JSONResponseDetailKabar<DetailKabarModel>> call, Throwable t) {
                    Log.d(TAG, "Error" + t.getMessage());
                }
            });

    }
}
