package com.studio.illiyin.alomagoindonesia.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.studio.illiyin.alomagoindonesia.Models.HistoryModel;
import com.studio.illiyin.alomagoindonesia.R;

import java.util.ArrayList;

/**
 * Created by Mindha on 18/06/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{
    private ArrayList<HistoryModel> data;
    Context mContext;

    public HistoryAdapter(ArrayList<HistoryModel> data, Context applicationContext){
        this.data = data;
        this.mContext = applicationContext;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtNumber.setText(data.get(position).getNomorTujuan());
        holder.txtTgl.setText(data.get(position).getTanggal());
        holder.txtNominal.setText(data.get(position).getTotalPulsaTransfer());
        if (data.get(position).getSent().equals("Y")){
            Picasso.with(mContext.getApplicationContext()).load(R.drawable.checked).into(holder.imgAlert);
        }else {
            Picasso.with(mContext.getApplicationContext()).load(R.drawable.danger).into(holder.imgAlert);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAlert;
        private TextView txtNumber, txtTgl, txtNominal;
        public ViewHolder(View itemView) {
            super(itemView);
            imgAlert = itemView.findViewById(R.id.icon_history);
            txtNumber = itemView.findViewById(R.id.txt_number);
            txtTgl = itemView.findViewById(R.id.txt_date);
            txtNominal = itemView.findViewById(R.id.txt_nominalTransfer);
        }
    }

}
