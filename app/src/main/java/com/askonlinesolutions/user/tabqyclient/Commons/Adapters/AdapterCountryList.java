package com.askonlinesolutions.user.tabqyclient.Commons.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.askonlinesolutions.user.tabqyclient.R;
import java.util.ArrayList;

public class AdapterCountryList extends RecyclerView.Adapter<AdapterCountryList.MyViewHolder> {

    private Context context;
    private ArrayList<String> arr_names = new ArrayList<>();
    private ArrayList<String> arr_check = new ArrayList<>();
    private interface_AdapterCountryList click;

    public AdapterCountryList(Context context, ArrayList<String> arr_names, ArrayList<String> arr_check,
                              interface_AdapterCountryList click) {
        this.context = context;
        this.arr_names = arr_names;
        this.arr_check = arr_check;
        this.click = click;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tv;
        public ImageView iv_check;

        public MyViewHolder(View view) {
            super(view);

            tv = view.findViewById(R.id.item_country_list_name);
            iv_check = view.findViewById(R.id.item_country_list_check);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.click_AdapterCoutryList(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tv.setText(arr_names.get(position));

        if(arr_check.get(position).equals("1")){
            holder.itemView.setBackgroundResource(R.color.bg_color_1);

            holder.iv_check.setVisibility(View.VISIBLE);

        } else {
            holder.itemView.setBackgroundResource(R.color.white_color);
            holder.iv_check.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return arr_names.size();
    }

    public interface interface_AdapterCountryList{
        void click_AdapterCoutryList(int pos);
    }
}