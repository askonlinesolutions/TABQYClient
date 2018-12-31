package com.askonlinesolutions.user.tabqyclient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class RecentSearchAdapter extends RecyclerView.Adapter<RecentSearchAdapter.ViewHolder> {

    ArrayList name;
    Context context;
    public RecentSearchAdapter(CheckoutAddAddressActivity checkoutAddAddressActivity, ArrayList name) {
        this.context = checkoutAddAddressActivity;
        this.name =name;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_searches,parent,false);
        RecentSearchAdapter.ViewHolder vh =new RecentSearchAdapter.ViewHolder(view);
        return new RecentSearchAdapter.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(name.get(position).toString());

    }


    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView =(TextView)itemView.findViewById(R.id.text);

        }
    }
}
