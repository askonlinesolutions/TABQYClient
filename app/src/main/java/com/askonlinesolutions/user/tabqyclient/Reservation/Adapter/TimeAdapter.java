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

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.MyViewHolder> {


    private ArrayList<String> numbers = new ArrayList<>();
    private ArrayList<String> click_status = new ArrayList<>();
    Context context;
    TimeAdapterInterface timeAdapterInterface;


    public TimeAdapter(ArrayList<String> numbers, ArrayList<String> click_status,
                       Context context, TimeAdapterInterface timeAdapterInterface) {
        this.numbers = numbers;
        this.click_status = click_status;
        this.context = context;
        this.timeAdapterInterface = timeAdapterInterface;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reserveatable_time_items, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TimeAdapter.MyViewHolder holder, final int position) {

        holder.tv_numbers.setText(numbers.get(position));

        if (click_status.get(position).equals("1")) {
            holder.tv_numbers.setTextColor(context.getResources().getColor(R.color.white_color));
            holder.tv_numbers.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.button_pink_round));
        } else {
            holder.tv_numbers.setTextColor(context.getResources().getColor(R.color.light_prime));
            holder.tv_numbers.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.button_pink_hollow_round));
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

    public interface TimeAdapterInterface {
        void getDetails(int pos);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_numbers;
//        LinearLayout reservation_items_lin;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_numbers = itemView.findViewById(R.id.tv_time);
//            reservation_items_lin = itemView.findViewById(R.id.reservation_items_lin);

            tv_numbers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    timeAdapterInterface.getDetails(getAdapterPosition());
                }
            });
        }
    }


//    private ArrayList<String> time = new ArrayList<>();
//    private TimeAdapterInterface timeAdapterInterface;
//   ArrayList<String> click_status = new ArrayList<>();
//    Context context;
//
//    public TimeAdapter(Context context,ArrayList<String> time , ArrayList<String> click_status, TimeAdapterInterface timeAdapterInterface){
//        this.time = time;
//        this.context=context;
//       click_status=click_status;
//        this.timeAdapterInterface = timeAdapterInterface;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reserveatable_time_items,parent,false);
//        MyViewHolder myViewHolder = new MyViewHolder(view);
//        return myViewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.tv_time.setText(time.get(position));
//
//        if (click_status.get(position).equals("1")){
//            holder.tv_time.setTextColor(context.getResources().getColor(R.color.white_color));
//            holder.tv_time.setBackground(context.getResources().getDrawable(R.drawable.button_pink_round));
//        }
//
//        else {
//            holder.tv_time.setTextColor(context.getResources().getColor(R.color.light_prime));
//            holder.tv_time.setBackground(context.getResources().getDrawable(R.drawable.button_pink_hollow_round));
//        }

//
//    }
//
//    @Override
//    public int getItemCount() {
//        return time.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//        TextView tv_time;
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//
//            tv_time = itemView.findViewById(R.id.tv_time);
//            tv_time.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View v) {
////            if (time.get(getPosition()).equals("1")){
////               tv_time.setTextColor(context.getResources().getColor(R.color.white_color));
////               tv_time.setBackground(context.getResources().getDrawable(R.drawable.button_pink_round));
////            }
////
////            else {
////              tv_time.setTextColor(context.getResources().getColor(R.color.light_prime));
////                tv_time.setBackground(context.getResources().getDrawable(R.drawable.button_pink_hollow_round));
////            }
////
//
//            timeAdapterInterface.getDetails(getAdapterPosition());
//
//        }
//    }
//
//    public interface TimeAdapterInterface {
//        void getDetails(int pos);
//    }
}
