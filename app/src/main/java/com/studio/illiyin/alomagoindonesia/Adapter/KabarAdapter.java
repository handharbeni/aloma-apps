package com.studio.illiyin.alomagoindonesia.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.studio.illiyin.alomagoindonesia.DetailKabarActivity;
import com.studio.illiyin.alomagoindonesia.Models.KabarModel;
import com.studio.illiyin.alomagoindonesia.R;

import java.util.ArrayList;

/**
 * Created by Mindha on 18/06/2017.
 */

public class KabarAdapter extends RecyclerView.Adapter<KabarAdapter.ViewHolder> {
    private ArrayList<KabarModel> data;
    private ArrayList<KabarModel> gambar;
    Context mContext;
    View view;


    public KabarAdapter (ArrayList<KabarModel> data, Context applicationContext){
        this.data = data;
        this.mContext = applicationContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_berita, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtJudulBerita.setText(data.get(position).getJudul());
        holder.txtTglBerita.setText(data.get(position).getTanggalWaktu().getDatetime());

        gambar = (ArrayList<KabarModel>) data.get(position).getImages();
        if(gambar!=null){
            Picasso.with(mContext.getApplicationContext()).load((Uri) data.get(position).getImages()).into(holder.imgKabar);
        }else {
            Picasso.with(mContext.getApplicationContext()).load(R.drawable.burung).into(holder.imgKabar);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imgKabar;
        private TextView txtJudulBerita, txtTglBerita;
        public ViewHolder(View itemView) {
            super(itemView);
            imgKabar = itemView.findViewById(R.id.imagenews);
            txtJudulBerita = itemView.findViewById(R.id.judul_berita);
            txtTglBerita = itemView.findViewById(R.id.tgl_berita);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

//            Toast.makeText(mContext, ""+data.get(getAdapterPosition()).getId(),Toast.LENGTH_SHORT).show();
            String id=data.get(getAdapterPosition()).getId();
            Intent intent = new Intent(mContext, DetailKabarActivity.class);
            intent.putExtra("id", id);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);


        }
    }
}
