package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.item_details;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.restaurentPoints.RestaurentPointsAdapter;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.menuResturent.MenuResponse;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;
import java.util.List;

public class ItemDetailsAdapter extends RecyclerView.Adapter<ItemDetailsAdapter.MyViewHolder> {


    private String[] dataSource;
    Context context;
  //  ItemDetailAdapterInterface itemDetailAdapterInterface;
    private OnItemClickLister onItemClickLister;

    List<ItemDetailResponse.DataEntity> dataEntities;

    public ItemDetailsAdapter(ItemsDetailActivity onItemClickLister,
                              List<ItemDetailResponse.DataEntity> dataEntities) {
        //this.context = context;
        // this.itemDetailAdapterInterface = itemDetailAdapterInterface;
        this.dataEntities = dataEntities;
        this.onItemClickLister = onItemClickLister;
        this.context = context;
    }

//    {
//        this.context = context;
//
//        this.dataEntities=dataEntities;
//    }
    //public ItemDetailsAdapter(Context context, OnItemClickLister onItemClickLister, ArrayList<MenuResponse.DataEntity> dataEntity) {
//        dataSource = dataArgs;
    // this.onItemClickLister = onItemClickLister;

    //  this.context = context;
//}


    @Override
    public ItemDetailsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_details_list_items, parent, false);

        return new ItemDetailsAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ItemDetailsAdapter.MyViewHolder holder, int i) {
        //  holder.textView.setText(dataSource[position]);
        holder.calories_tv.setText(dataEntities.get(i).getItem_name());
    }

    @Override
    public int getItemCount() {
        //return dataSource.length;
        return dataEntities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView canceleBtn, trackOrderBtn,calories_tv;

        public MyViewHolder(View itemView) {

            super(itemView);
            calories_tv=itemView.findViewById(R.id.calories_tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickLister.onItemClick(getAdapterPosition(), "ITEMS");
                }
            });

        }

    }

    interface OnItemClickLister {
        void onItemClick(int Pos, String type);
    }
//    private class ItemDetailAdapterInterface {
//    }
}
