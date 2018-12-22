package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.MyViewHolder>  {




    private String[] dataSource;
    Context context;
    public ReviewAdapter(Context context){
//        dataSource = dataArgs;
        this.context=context;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_list_item, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
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
