package com.studio.illiyin.alomagoindonesia.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.studio.illiyin.alomagoindonesia.Models.HistoriesModel;
import com.studio.illiyin.alomagoindonesia.R;

import java.util.ArrayList;

/**
 * Created by Mindha on 18/06/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{
    private ArrayList<HistoriesModel> message;
    Context mContext;

    public HistoryAdapter(ArrayList<HistoriesModel> message, Context applicationContext){
        this.message = message;
        this.mContext = applicationContext;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtNumber.setText(message.get(position).getNomorTujuan());
        holder.txtTgl.setText(message.get(position).getTanggal());
        holder.txtNominal.setText(message.get(position).getTotalPulsaTransfer());
        if (message.get(position).getSent().equals("Y")){
            Picasso.with(mContext.getApplicationContext()).load(R.drawable.checked).into(holder.imgAlert);
        }else {
            Picasso.with(mContext.getApplicationContext()).load(R.drawable.danger).into(holder.imgAlert);
        }
    }

    @Override
    public int getItemCount() {
        return message.size();
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
