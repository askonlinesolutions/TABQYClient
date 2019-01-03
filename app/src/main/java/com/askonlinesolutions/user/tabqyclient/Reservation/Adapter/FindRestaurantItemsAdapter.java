package com.askonlinesolutions.user.tabqyclient.Reservation.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;

public class FindRestaurantItemsAdapter extends RecyclerView.Adapter<FindRestaurantItemsAdapter.MyViewHolder> {

    private FindRestaurantInterface findRestaurantInterface;

    public FindRestaurantItemsAdapter(FindRestaurantInterface findRestaurantInterface){
        this.findRestaurantInterface = findRestaurantInterface;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_restaurants_items,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_open,tv_reserve;

        public MyViewHolder(View itemView) {
            super(itemView);

            /*tv_open = itemView.findViewById(R.id.tv_open);
            tv_open.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    findRestaurantInterface.getPosition("open");
                }
            });*/
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findRestaurantInterface.getPosition("reserve_view");
                }
            });

            tv_reserve = itemView.findViewById(R.id.tv_reserve);
            tv_reserve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    findRestaurantInterface.getPosition("reserve");
                }
            });
        }
    }


    public interface FindRestaurantInterface{
        void getPosition(String Tag);
    }
}
