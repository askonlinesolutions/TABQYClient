package com.askonlinesolutions.user.tabqyclient.Fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;

public class OldOrderStatusAdapter extends RecyclerView.Adapter<OldOrderStatusAdapter.MyViewHolder> {


    private String[] dataSource;
    Context context;
    private OnItemClickLister onItemClickLister;

    public OldOrderStatusAdapter(Context context, OnItemClickLister onItemClickLister) {
//        dataSource = dataArgs;
        this.onItemClickLister = onItemClickLister;
        this.context = context;
    }


    @Override
    public OldOrderStatusAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.old_order_list_items, parent, false);

        return new OldOrderStatusAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(OldOrderStatusAdapter.MyViewHolder holder, int position) {
        //  holder.textView.setText(dataSource[position]);

    }

    @Override
    public int getItemCount() {
        //return dataSource.length;
        return 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView canceleBtn, trackOrderBtn;

        public MyViewHolder(View itemView) {
            super(itemView);
//            canceleBtn = (TextView) itemView.findViewById(R.id.cancele_btn_tv);
//            trackOrderBtn = itemView.findViewById(R.id.track_order_tv);
//
//            canceleBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    onItemClickLister.onItemClick(getAdapterPosition(), "CANCELE");
//                }
//            });
//
//            trackOrderBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    onItemClickLister.onItemClick(getAdapterPosition(), "TRACK");
//                }
//            });

        }

    }

    interface OnItemClickLister {
        void onItemClick(int Pos, String type);
    }


}
