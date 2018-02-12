package com.studio.illiyin.alomagoindonesia.Adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.studio.illiyin.alomagoindonesia.MenuTab.Kabar;
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
    private ArrayList<KabarModel> data;
    private ArrayList<KabarModel> gambar;
    Context mContext;
    DetailKabar fragment = new DetailKabar();

    public DetailKabarAdapter(ArrayList<KabarModel> data, Context getApplicationContent){
        this.data = data;
        this.mContext = getApplicationContent;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_berita, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bundle bundle = fragment.getArguments();
        if(bundle != null){
            String i = bundle.getString("id", "");

            holder.txtJudul.setText(i);
            gambar = (ArrayList<KabarModel>) data.get(position).getImages();
            if(gambar!=null){
                Picasso.with(mContext.getApplicationContext()).load((Uri) data.get(position).getImages()).into(holder.imgIconContent);
            }else{
                Picasso.with(mContext.getApplicationContext()).load(R.drawable.img_one_cak).into(holder.imgIconContent);
            }

        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgIconContent;
        private TextView txtJudul;
        public ViewHolder(View itemView) {
            super(itemView);

            txtJudul=itemView.findViewById(R.id.judul_berita);
            imgIconContent = itemView.findViewById(R.id.img_contentNews);
        }
    }
}
