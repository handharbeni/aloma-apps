package com.studio.illiyin.alomagoindonesia.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.studio.illiyin.alomagoindonesia.Models.AppInfo;
import com.studio.illiyin.alomagoindonesia.R;
import com.studio.illiyin.alomagoindonesia.fragment.Disclaimer;

import java.util.ArrayList;

/**
 * Created by fairuz on 2/5/2018.
 */

public class DisclaimerAdapter extends RecyclerView.Adapter<DisclaimerAdapter.ViewHolder> {
    private ArrayList<AppInfo> data;
    Context mContext;

    public DisclaimerAdapter(ArrayList<AppInfo> data, Context applicationContext){
        this.data = data;
        this.mContext = applicationContext;
    }

    @Override
    public DisclaimerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_disclaimer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DisclaimerAdapter.ViewHolder holder, int position) {
        holder.txtTitle.setText(data.get(position).getName());
        holder.txtContent.setText(data.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle, txtContent;
        public ViewHolder(View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.titleDisclaimer);
            txtContent = itemView.findViewById(R.id.contentDisclaimer);
        }
    }
}
