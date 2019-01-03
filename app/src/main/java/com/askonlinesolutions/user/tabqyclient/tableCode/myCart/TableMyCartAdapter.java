package com.askonlinesolutions.user.tabqyclient.tableCode.myCart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.tableCode.menuList.MenuItemAdapter;

public class TableMyCartAdapter extends RecyclerView.Adapter<TableMyCartAdapter.MyViewHolder> {


    private String[] dataSource;
    Context context;
    private OnItemClickLister onItemClickLister;

    public TableMyCartAdapter(Context context, OnItemClickLister onItemClickLister) {
//        dataSource = dataArgs;
        this.onItemClickLister = onItemClickLister;
        this.context = context;
    }


    @Override
    public TableMyCartAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);

        return new TableMyCartAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(TableMyCartAdapter.MyViewHolder holder, int position) {
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

    public interface OnItemClickLister {
        void onItemClick(int Pos, String type);
    }


}
