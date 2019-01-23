package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.searchResturent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.item_details.ItemDetailsAdapter;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;

class SearchResturentAdapter extends RecyclerView.Adapter<SearchResturentAdapter.MyViewHolder> {
    private Context context;
    private OnItemClickLister onItemClickLister;
//    private ArrayList<String> arr_names = new ArrayList<>();
//    private ArrayList<String> arr_check = new ArrayList<>();

    ArrayList<SearchResponse.DataEntity> dataEntities= new ArrayList<SearchResponse.DataEntity>();;

    public SearchResturentAdapter(Context context,
                                  ArrayList<SearchResponse.DataEntity> dataEntities, OnItemClickLister onItemClickLister) {

        this.dataEntities = dataEntities;
        this.onItemClickLister = onItemClickLister;
        this.context = context;
    }

//    public SearchResturentAdapter(Context context, ArrayList<String> arr_names,
//                                  ArrayList<String> arr_check, SearchActivity searchActivity) {
//        this.context = context;
//        this.arr_names = arr_names;
//        this.arr_check = arr_check;
//        this.click = click;
//    }

    @NonNull
    @Override
    public SearchResturentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.serach_resturent, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchResturentAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(dataEntities.get(position).getResturantbrand_name());
    }

    @Override
    public int getItemCount() {

       return dataEntities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.item_area_list_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int id =dataEntities.get(getAdapterPosition()).getResturantbrand_id();
                    onItemClickLister.onItemClick(getAdapterPosition(),id);
                }
            });
        }
        }
    interface OnItemClickLister
    {
        void onItemClick(int Pos, int id);
    }
    }

