package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.askonlinesolutions.user.tabqyclient.R;

/**
 * Created by Vaibhav.
 * Contact Number : +91 7737284476
 */
public class AdapterOfferList extends RecyclerView.Adapter<AdapterOfferList.MyViewHolder> {

    public AdapterOfferList() {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        public MyViewHolder(View view) {
            super(view);

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_offer_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}