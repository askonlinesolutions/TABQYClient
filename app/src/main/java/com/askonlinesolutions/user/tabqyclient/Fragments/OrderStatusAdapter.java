package com.askonlinesolutions.user.tabqyclient.Fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters.ReviewAdapter;
import com.askonlinesolutions.user.tabqyclient.R;

public class OrderStatusAdapter  extends RecyclerView.Adapter<OrderStatusAdapter.MyViewHolder> {


    private String[] dataSource;
    Context context;
    public OrderStatusAdapter(Context context){
//        dataSource = dataArgs;
        this.context=context;
    }



    @Override
    public OrderStatusAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_list_item, parent, false);

        return new OrderStatusAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(OrderStatusAdapter.MyViewHolder holder, int position) {
        //  holder.textView.setText(dataSource[position]);

    }

    @Override
    public int getItemCount() {
        //return dataSource.length;
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
//            textView = (TextView) itemView.findViewById(R.id.news_tv);
        }

    }

}
