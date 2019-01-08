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
public class AdapterRestaurantList extends RecyclerView.Adapter<AdapterRestaurantList.MyViewHolder> {

    private Interface_AdapterRestaurant click;
    public AdapterRestaurantList(Interface_AdapterRestaurant click) {
        this.click = click;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        public MyViewHolder(View view) {
            super(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.method_AdapterRestaurant(getAdapterPosition());
                }
            });
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_restaurant_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public interface Interface_AdapterRestaurant{
        void method_AdapterRestaurant(int pos);

        void onConnectionSuspended(int i);
    }
}