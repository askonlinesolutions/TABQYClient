package com.askonlinesolutions.user.tabqyclient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.Viewholder> {
    ArrayList name;
    Context context;
    public CheckoutAdapter(Checkout_cardActivity checkout_cardActivity, ArrayList name) {
        this.context =checkout_cardActivity;
        this.name =name;



    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkout_orderinglist,parent,false);
        Viewholder vh =new Viewholder(view);
        return new Viewholder(view) {
        };
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        holder.textView.setText(name.get(position).toString());
    }


    @Override
    public int getItemCount() {
        return name.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView textView;
        public Viewholder(View itemView) {
            super(itemView);
            textView =(TextView)itemView.findViewById(R.id.text);
        }
    }
}
