package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.myReceipt;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.tabqyPoints.TabqyPointsAdapter;
import com.askonlinesolutions.user.tabqyclient.R;

public class MyReceiptAdapter extends RecyclerView.Adapter<MyReceiptAdapter.MyViewHolder> {


    private String[] dataSource;
    Context context;
    private OnItemClickLister onItemClickLister;

    public MyReceiptAdapter(Context context, OnItemClickLister onItemClickLister) {
//        dataSource = dataArgs;
        this.onItemClickLister = onItemClickLister;
        this.context = context;
    }


    @Override
    public MyReceiptAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_receipt_list_item, parent, false);

        return new MyReceiptAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyReceiptAdapter.MyViewHolder holder, int position) {
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
                    onItemClickLister.onItemClick(getAdapterPosition(), "RECEIPT");
                }
            });


        }

    }

    interface OnItemClickLister {
        void onItemClick(int Pos, String type);
    }


}
