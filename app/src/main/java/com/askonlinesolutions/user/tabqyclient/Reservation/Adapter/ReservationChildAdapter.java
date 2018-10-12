package com.askonlinesolutions.user.tabqyclient.Reservation.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;

public class ReservationChildAdapter extends RecyclerView.Adapter<ReservationChildAdapter.MyViewHolder> {

    Context context;
    ArrayList<String> numbers = new ArrayList<>();
    ArrayList<String> click_status = new ArrayList<>();
    ReservationChildAdapterInterface reservationChildAdapterInterface;

    public ReservationChildAdapter(Context context,ArrayList<String> numbers,ArrayList<String> click_status,ReservationChildAdapterInterface reservationChildAdapterInterface) {
        this.context = context;
        this.numbers = numbers;
        this.click_status = click_status;
        this.reservationChildAdapterInterface = reservationChildAdapterInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservation_items_third,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_numbers_third.setText(numbers.get(position));

        if (click_status.get(position).equals("1")){
            holder.tv_numbers_third.setTextColor(context.getResources().getColor(R.color.white_color));
            holder.tv_numbers_third.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.button_pink_round));
        }

        else {
            holder.tv_numbers_third.setTextColor(context.getResources().getColor(R.color.sketch_black));
            holder.tv_numbers_third.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.button_white));
        }
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_numbers_third;
        LinearLayout reservation_items_third_lin;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_numbers_third = itemView.findViewById(R.id.tv_numbers_third);
            reservation_items_third_lin = itemView.findViewById(R.id.reservation_items_third_lin);

            reservation_items_third_lin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reservationChildAdapterInterface.getDetailsChild(getAdapterPosition());
                }
            });
        }
    }

    public interface ReservationChildAdapterInterface{
        void getDetailsChild(int adapterPosition);
    }
}
