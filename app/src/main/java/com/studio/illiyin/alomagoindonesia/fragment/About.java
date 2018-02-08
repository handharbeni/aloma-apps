package com.studio.illiyin.alomagoindonesia.fragment;

        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.studio.illiyin.alomagoindonesia.Adapter.AboutAdapter;
        import com.studio.illiyin.alomagoindonesia.Generator.ServiceGenerator;
        import com.studio.illiyin.alomagoindonesia.MainActivityTab;
        import com.studio.illiyin.alomagoindonesia.Models.AppInfo;
        import com.studio.illiyin.alomagoindonesia.Models.JSONResponse;
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

public class About extends Fragment{
    View view;
    private RecyclerView recyclerView;
    private ArrayList<AppInfo> data;
    private AboutAdapter adapter;
    RrequestInterface request;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_about,container,false);
        getActivity().setTitle("About");
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
        Call<JSONResponse> call = request.getInfoAbout();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getData()));
                adapter = new AboutAdapter(data, getActivity().getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

}
