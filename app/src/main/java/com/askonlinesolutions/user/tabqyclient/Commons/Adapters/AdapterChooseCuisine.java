package com.askonlinesolutions.user.tabqyclient.Commons.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;

public class AdapterChooseCuisine extends RecyclerView.Adapter<AdapterChooseCuisine.MyViewHolder> {

    private Context context;
    private ArrayList<String> arr_names = new ArrayList<>();
    private ArrayList<String> arr_check = new ArrayList<>();
    private interface_AdapterChooseCuisine click;

    public AdapterChooseCuisine(Context context, ArrayList<String> arr_names, ArrayList<String> arr_check,
                                interface_AdapterChooseCuisine click) {
        this.context = context;
        this.arr_names = arr_names;
        this.arr_check = arr_check;
        this.click = click;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tv;

        public MyViewHolder(View view) {
            super(view);

            tv = view.findViewById(R.id.item_choose_cuisine_name);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.click_AdapterChooseCuisine(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_choose_cuisine, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tv.setText(arr_names.get(position));
        if(arr_check.get(position).equals("1")){
            holder.tv.setTextColor(context.getResources().getColor(R.color.theme_color));
        } else {
            holder.tv.setTextColor(context.getResources().getColor(R.color.text_color));
        }
    }

    @Override
    public int getItemCount() {
        return arr_names.size();
    }

    public interface interface_AdapterChooseCuisine{
        void click_AdapterChooseCuisine(int pos);
    }
}