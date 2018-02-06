package com.studio.illiyin.alomagoindonesia.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.studio.illiyin.alomagoindonesia.Models.AppInfo;
import com.studio.illiyin.alomagoindonesia.R;

import java.util.ArrayList;

/**
 * Created by fairuz on 2/6/2018.
 */

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.ViewHolder>{
    private ArrayList<AppInfo> data;
    Context mContext;

    public AboutAdapter(ArrayList<AppInfo> data, Context applicationContext){
        this.data = data;
        this.mContext = applicationContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_about, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
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

            txtTitle = itemView.findViewById(R.id.titleAbout);
            txtContent = itemView.findViewById(R.id.contentAbout);
        }
    }
}
