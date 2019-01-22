package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.menuResturent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.restroFragment.AdapterRestaurantList;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.restroFragment.ResturentList.ResturentResponse;
import com.askonlinesolutions.user.tabqyclient.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainManuAdapter  extends RecyclerView.Adapter<MainManuAdapter.MyViewHolder> {

    public OnItemClickLister onItemClick;
    Context context;
    private ArrayList<MenuResponse.DataEntity> dataEntities;
  //  String iv_res = "http://webdevelopmenttesting.com/tabqy1/upload/images";

    public MainManuAdapter(Context context,ArrayList<MenuResponse.DataEntity> dataEntities,
                           OnItemClickLister onItemClick) {
        this.context = context;
        this.onItemClick = onItemClick;
        this.dataEntities = dataEntities;

    }
//    private MainManuAdapter.OnItemClickLister click;

//    public MainManuAdapter(AdapterRestaurantList.Interface_AdapterRestaurant click) {
//        this.click = (OnItemClickLister) click;
//    }

//    private String[] dataSource;
//    private OnItemClickLister onItemClickLister;

//    public MainManuAdapter(Context context,OnItemClickLister onItemClickLister) {
////        dataSource = dataArgs;
//      //  this.onItemClickLister = onItemClickLister;
//        this.context = context;
//    }


    @Override
    public MainManuAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_list_items, parent, false);

        return new MainManuAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MainManuAdapter.MyViewHolder holder, int i) {
        //  holder.textView.setText(dataSource[position]);
        holder.fooditem.setText(dataEntities.get(i).getItem_name());
        holder.loren.setText(dataEntities.get(i).getItem_description());
        holder.loren2.setText(dataEntities.get(i).getItem_code());
        holder.price.setText(dataEntities.get(i).getItem_defaultprice());
//        Picasso.with(context).load("http://webdevelopmenttesting.com/tabqy1/upload/images"+dataEntities.get(i).getItem_image()) // URL or file
//                .into(holder.iv_res);
      // Picasso.with(context).load("http://webdevelopmenttesting.com/tabqy1/upload/images).into(holder.iv_res"+dataEntities.get(i).getItem_image());
//

        // An ImageView object to show the loaded image
      //  holder.iv_res.setImageResource(dataEntities.get(i).getItem_image());
    }

    @Override
    public int getItemCount() {
        //return dataSource.length;
        return  dataEntities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView addBtn,iv_res;
        public TextView fooditem,loren,price,loren2;


        public MyViewHolder(View itemView) {
            super(itemView);

            addBtn=itemView.findViewById(R.id.menu_add_item_iv);
            iv_res =itemView.findViewById(R.id.iv_res);
            price=itemView.findViewById(R.id.defaultprice);
            fooditem=itemView.findViewById(R.id.fooditem);
            loren2=itemView.findViewById(R.id.loren2);
            loren =itemView.findViewById(R.id.loren);
            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClick.onItemClick(getAdapterPosition(), "ADD");
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClick.onItemClick(getAdapterPosition(), "MENU");
                }
            });

        }

    }

    public interface OnItemClickLister   {
        void click_AdapterMenu(int position);
        void onItemClick(int Pos, String type);


     //   void method_AdapterMenu(int pos);
    }
//    public interface Interface_AdapterMenu {
//        void method_AdapterMenu(int pos);
//    }

}
