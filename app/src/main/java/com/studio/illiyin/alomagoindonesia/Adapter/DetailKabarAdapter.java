package com.studio.illiyin.alomagoindonesia.Adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.studio.illiyin.alomagoindonesia.DetailKabarActivity;
import com.studio.illiyin.alomagoindonesia.MenuTab.Kabar;
import com.studio.illiyin.alomagoindonesia.Models.DetailKabarModel;
import com.studio.illiyin.alomagoindonesia.Models.KabarModel;
import com.studio.illiyin.alomagoindonesia.R;
import com.studio.illiyin.alomagoindonesia.fragment.DetailKabar;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;

/**
 * Created by fairuz on 2/8/2018.
 */

public class DetailKabarAdapter extends RecyclerView.Adapter<DetailKabarAdapter.ViewHolder> {
    private ArrayList<DetailKabarModel> data;
    Context mContext;

    public DetailKabarAdapter(ArrayList<DetailKabarModel> dataModels, Context applicationContext) {
        this.data = dataModels;
        this.mContext = applicationContext;
    }

    @Override
    public DetailKabarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_kabar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailKabarAdapter.ViewHolder holder, int position) {
        if(data.get(position).getImages() == null){
            Picasso.with(mContext.getApplicationContext()).load(R.drawable.burung).into(holder.img);
        }else {
            Picasso.with(mContext.getApplicationContext()).load((Uri) data.get(position).getImages()).into(holder.img);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageKabarBurung);
        }
    }

}
