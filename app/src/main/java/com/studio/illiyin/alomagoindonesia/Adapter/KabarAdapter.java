package com.studio.illiyin.alomagoindonesia.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.studio.illiyin.alomagoindonesia.Models.AppInfo;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponse2;
import com.studio.illiyin.alomagoindonesia.Models.KabarModel;
import com.studio.illiyin.alomagoindonesia.R;

import java.util.ArrayList;

/**
 * Created by Mindha on 18/06/2017.
 */

public class KabarAdapter extends RecyclerView.Adapter<KabarAdapter.ViewHolder> {
    private ArrayList<KabarModel> data;
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
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//        private ImageView imgKabar;
        private TextView txtJudulBerita, txtTglBerita;
        public ViewHolder(View itemView) {
            super(itemView);
//            imgKabar = itemView.findViewById(R.id.imagenews);
            txtJudulBerita = itemView.findViewById(R.id.judul_berita);
            txtTglBerita = itemView.findViewById(R.id.tgl_berita);
        }
    }
//    private int lastPosition = -1;
//    private ArrayList<KabarModel> dataSet;
//    Context mContext;
//    private static class ViewHolder {
//        ImageView photo_thumbnail;
//        TextView itemJudul, txtTanggal;
//        LinearLayout itemBerita;
//
//    }
//    KabarAdapter.ViewHolder viewHolder;
//    public KabarAdapter(ArrayList<KabarModel> data, Context context) {
//        super(context, R.layout.item_berita, data);
//        this.dataSet = data;
//        this.mContext=context;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        KabarModel dataModel = getItem(position);
//        final View result;
//        if (convertView == null) {
//            viewHolder = new KabarAdapter.ViewHolder();
//            LayoutInflater inflater = LayoutInflater.from(mContext);
//            convertView = inflater.inflate(R.layout.item_berita, parent, false);
//            viewHolder.itemBerita= convertView.findViewById(R.id.itemBerita);
//            viewHolder.photo_thumbnail = convertView.findViewById(R.id.imagenews);
//            viewHolder.itemJudul= convertView.findViewById(R.id.judul_berita);
//            viewHolder.txtTanggal = convertView.findViewById(R.id.tgl_berita);
//
//            result=convertView;
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (KabarAdapter.ViewHolder) convertView.getTag();
//            result=convertView;
//        }
//
//        lastPosition = position;
//
//        viewHolder.itemBerita.setVisibility(View.VISIBLE);
//        Glide.with(mContext)
//                .load(dataModel.getPhoto())
//                .into(viewHolder.photo_thumbnail);
//
//        viewHolder.itemJudul.setText(dataModel.getJudul());
//        viewHolder.txtTanggal.setText(dataModel.getDate());
//
//
//
//        return convertView;
//    }
}
