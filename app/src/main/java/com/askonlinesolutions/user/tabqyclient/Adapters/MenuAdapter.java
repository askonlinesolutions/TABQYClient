package com.askonlinesolutions.user.tabqyclient.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Model.MenuModel;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder> {
    Context mContext;
    List<MenuModel> mMenuList;
    private Interface_AdapterMenu click;

    public MenuAdapter(Context mContext, List<MenuModel> mMenuList, Interface_AdapterMenu click) {
        this.mContext = mContext;
        this.mMenuList = mMenuList;
        this.click = click;

    }

    class MenuHolder extends RecyclerView.ViewHolder {

        TextView menu_food, menu_time, menu_desc,plussign,integer_number;
        public ImageView iv_plus;
        RelativeLayout minus,plus;
        int stat= 1;

        public MenuHolder(View itemView) {
            super(itemView);

            menu_food = itemView.findViewById(R.id.fooditem);
            minus = itemView.findViewById(R.id.minus);
            plus = itemView.findViewById(R.id.plus);
            integer_number = itemView.findViewById(R.id.integer_number);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    click.click_AdapterMenu(getAdapterPosition());
                }
            });
            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(stat>1) {
                        stat = stat - 1;
                        displaytext(stat);
                    }
                }
            });
            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    stat = stat + 1;
                    displaytext(stat);
                }
            });
        }
            private void displaytext(int number) {
                TextView displayInteger = itemView.findViewById(
                        R.id.integer_number);
                displayInteger.setText(""  + stat);
            }

          /*  iv_plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.click_AdapterMenu_Plus(getAdapterPosition());
                }
            });*/
        }


    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rowView = LayoutInflater.from(mContext).inflate(R.layout.menu_item, parent, false);
        return new MenuHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, int position) {

        MenuModel menuModel = mMenuList.get(position);
        holder.menu_food.setText(menuModel.getFood_name());
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public interface Interface_AdapterMenu {

        void click_AdapterMenu(int position);

        void click_AdapterMenu_Plus(int position);
    }


}