package com.askonlinesolutions.user.tabqyclient.Reservation.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.MyViewHolder> {

    private ArrayList<String> time = new ArrayList<>();
    private TimeAdapterInterface timeAdapterInterface;

    public TimeAdapter(ArrayList<String> time , TimeAdapterInterface timeAdapterInterface){
        this.time = time;
        this.timeAdapterInterface = timeAdapterInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reserveatable_time_items,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_time.setText(time.get(position));
    }

    @Override
    public int getItemCount() {
        return time.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_time;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_time = itemView.findViewById(R.id.tv_time);
            tv_time.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            timeAdapterInterface.getDetails();

        }
    }

    public interface TimeAdapterInterface {
        void getDetails();
    }
}
