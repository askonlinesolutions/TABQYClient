package com.askonlinesolutions.user.tabqyclient.tableCode.menuList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.restaurentPoints.RestaurentPointsAdapter;
import com.askonlinesolutions.user.tabqyclient.R;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MyViewHolder> {

    private String[] dataSource;
    Context context;
    private OnItemClickLister onItemClickLister;

    public MenuItemAdapter(Context context,OnItemClickLister onItemClickLister) {
//        dataSource = dataArgs;
        this.onItemClickLister = onItemClickLister;
        this.context = context;
    }


    @Override
    public MenuItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.table_menu_list_item, parent, false);

        return new MenuItemAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MenuItemAdapter.MyViewHolder holder, int position) {
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
                    onItemClickLister.onItemClick(getAdapterPosition(), "MENU_ITEM");
                }
            });

        }

    }

    interface OnItemClickLister {
        void onItemClick(int Pos, String type);
    }


}
