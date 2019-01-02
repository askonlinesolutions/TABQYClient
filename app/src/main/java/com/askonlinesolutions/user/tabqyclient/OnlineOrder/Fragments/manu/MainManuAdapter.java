package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.manu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Adapters.MenuAdapter;
import com.askonlinesolutions.user.tabqyclient.Model.MenuModel;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.restaurentPoints.RestaurentPointsAdapter;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.List;

public class MainManuAdapter  extends RecyclerView.Adapter<MainManuAdapter.MyViewHolder> {



    private String[] dataSource;
    Context context;
    private OnItemClickLister onItemClickLister;

    public MainManuAdapter(Context context,OnItemClickLister onItemClickLister) {
//        dataSource = dataArgs;
        this.onItemClickLister = onItemClickLister;
        this.context = context;
    }


    @Override
    public MainManuAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_list_items, parent, false);

        return new MainManuAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MainManuAdapter.MyViewHolder holder, int position) {
        //  holder.textView.setText(dataSource[position]);

    }

    @Override
    public int getItemCount() {
        //return dataSource.length;
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView addBtn;

        public MyViewHolder(View itemView) {
            super(itemView);

            addBtn=itemView.findViewById(R.id.menu_add_item_iv);
            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickLister.onItemClick(getAdapterPosition(), "ADD");
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickLister.onItemClick(getAdapterPosition(), "MENU");
                }
            });

        }

    }

    public interface OnItemClickLister {
        void onItemClick(int Pos, String type);
    }


}
