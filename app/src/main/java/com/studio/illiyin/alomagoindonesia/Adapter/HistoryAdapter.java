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
import com.studio.illiyin.alomagoindonesia.Models.HistoryModel;
import com.studio.illiyin.alomagoindonesia.R;

import java.util.ArrayList;

/**
 * Created by Mindha on 18/06/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{
    //    private int lastPosition = -1;
//    private ArrayList<HistoryModel> dataSet;
//    Context mContexte;
//
//    private static class ViewHolder {
//        ImageView icon;
//        TextView txtNumber, txtDate, txtTime, txtPrice;
//        LinearLayout itemHistory;
//    }
//    HistoryAdapter.ViewHolder viewHolder;
//
//    public HistoryAdapter(ArrayList<HistoryModel> data, Context context) {
//        super(context, R.layout.item_history, data);
//        this.dataSet = data;
//        this.mContexte=context;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        HistoryModel dataModel = getItem(position);
//        final View result;
//        if (convertView == null) {
//            viewHolder = new HistoryAdapter.ViewHolder();
//            LayoutInflater inflater = LayoutInflater.from(mContexte);
//            convertView = inflater.inflate(R.layout.item_history, parent, false);
//            viewHolder.itemHistory= (LinearLayout) convertView.findViewById(R.id.itemHistory);
//            viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon_history);
//            viewHolder.txtNumber= (TextView) convertView.findViewById(R.id.number);
//            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.txt_date);
//            viewHolder.txtTime = (TextView) convertView.findViewById(R.id.txt_time);
//            viewHolder.txtPrice = (TextView) convertView.findViewById(R.id.harga);
//
//            result=convertView;
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (HistoryAdapter.ViewHolder) convertView.getTag();
//            result=convertView;
//        }
//
//        lastPosition = position;
//
//        viewHolder.itemHistory.setVisibility(View.VISIBLE);
//
//        Glide.with(mContexte)
//                .load(dataModel.getPhoto())
//                .into(viewHolder.icon);
//
//        viewHolder.txtNumber.setText(dataModel.getNumber());
//        viewHolder.txtDate.setText(dataModel.getDay());
//        viewHolder.txtTime.setText(dataModel.getTime());
//        viewHolder.txtPrice.setText(dataModel.getPrice());
//
//        return convertView;
//    }

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
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNumber, txtTgl, txtNominal;
        public ViewHolder(View itemView) {
            super(itemView);

            txtNumber = itemView.findViewById(R.id.txt_number);
            txtTgl = itemView.findViewById(R.id.txt_date);
            txtNominal = itemView.findViewById(R.id.txt_nominalTransfer);
        }
    }

}
