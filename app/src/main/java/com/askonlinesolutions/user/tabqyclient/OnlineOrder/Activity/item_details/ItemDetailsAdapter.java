package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.item_details;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.restaurentPoints.RestaurentPointsAdapter;
import com.askonlinesolutions.user.tabqyclient.R;

public class ItemDetailsAdapter extends RecyclerView.Adapter<ItemDetailsAdapter.MyViewHolder> {


    private String[] dataSource;
    Context context;
    private OnItemClickLister onItemClickLister;

    public ItemDetailsAdapter(Context context, OnItemClickLister onItemClickLister) {
//        dataSource = dataArgs;
        this.onItemClickLister = onItemClickLister;
        this.context = context;
    }


    @Override
    public ItemDetailsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_details_list_items, parent, false);

        return new ItemDetailsAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ItemDetailsAdapter.MyViewHolder holder, int position) {
        //  holder.textView.setText(dataSource[position]);

    }

    @Override
    public int getItemCount() {
        //return dataSource.length;
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView canceleBtn, trackOrderBtn;

        public MyViewHolder(View itemView) {
            super(itemView);
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


}
