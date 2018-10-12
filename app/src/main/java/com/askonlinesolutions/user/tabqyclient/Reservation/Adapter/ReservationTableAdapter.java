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

public class ReservationTableAdapter extends RecyclerView.Adapter<ReservationTableAdapter.MyViewHolder> {

    private ArrayList<String> numbers = new ArrayList<>();
    private ArrayList<String> click_status = new ArrayList<>();
    Context context;
    ReservationAdapterTableInterface reservationadaptertableInterface;


    public ReservationTableAdapter(ArrayList<String> numbers, ArrayList<String> click_status,
                                   Context context, ReservationAdapterTableInterface reservationadaptertableInterface) {
        this.numbers = numbers;
        this.click_status = click_status;
        this.context = context;
        this.reservationadaptertableInterface = reservationadaptertableInterface;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservation_items,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_numbers.setText(numbers.get(position));

        if (click_status.get(position).equals("1")) {
            holder.tv_numbers.setTextColor(context.getResources().getColor(R.color.white_color));
            holder.tv_numbers.setBackgroundDrawable(context
                    .getResources().getDrawable(R.drawable.button_pink_round));

        } else{
            holder.tv_numbers.setTextColor(context.getResources().getColor(R.color.sketch_black));
            holder.tv_numbers.setBackgroundDrawable(context
                    .getResources().getDrawable(R.drawable.button_white));
        }
        }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public interface ReservationAdapterTableInterface {
        void getDetails(int adapterPosition);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {

        TextView tv_numbers;
        LinearLayout reservation_items_lin;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_numbers = itemView.findViewById(R.id.tv_numbers);
            reservation_items_lin = itemView.findViewById(R.id.reservation_items_lin);

            reservation_items_lin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reservationadaptertableInterface.getDetails(getAdapterPosition());
                }
            });
        }
    }
}