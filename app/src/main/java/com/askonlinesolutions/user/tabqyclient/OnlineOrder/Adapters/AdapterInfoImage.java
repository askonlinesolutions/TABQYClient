package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.askonlinesolutions.user.tabqyclient.R;

/**
 * Created by Vaibhav.
 * Contact Number : +91 7737284476
 */
public class AdapterInfoImage extends RecyclerView.Adapter<AdapterInfoImage.MyViewHolder> {

    public AdapterInfoImage() {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView iv;

        public MyViewHolder(View view) {
            super(view);

            iv = view.findViewById(R.id.item_info_image);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_info_image, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        if(position == 0 || position == 2 || position == 4){
            holder.iv.setImageResource(R.drawable.info_image_1);
        } else {
            holder.iv.setImageResource(R.drawable.info_image_2);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}