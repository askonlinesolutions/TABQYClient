package com.askonlinesolutions.user.tabqyclient.Reservation.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;
import com.google.android.gms.vision.text.Text;

public class MyReservationAdapter extends RecyclerView.Adapter<MyReservationAdapter.MyViewHolder> {

    private Context context;
    MyReservationAdapterInterface myReservationAdapterInterface;

    public MyReservationAdapter(Context context,MyReservationAdapterInterface myReservationAdapterInterface){
        this.context = context;
        this.myReservationAdapterInterface = myReservationAdapterInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_reservation_items,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if (position==1){
            holder.accepted.setText(context.getResources().getText(R.string.pending));
        }
        else if (position==3){
            holder.accepted.setText(context.getResources().getText(R.string.pending));
        }
   }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView accepted,cancel;

        public MyViewHolder(View itemView) {
            super(itemView);

            accepted = itemView.findViewById(R.id.tv_accepted);
            cancel = itemView.findViewById(R.id.tv_cancel);

            accepted.setOnClickListener(this);
            cancel.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_accepted:
                    myReservationAdapterInterface.getDetails(getAdapterPosition(),"accepted");
                    break;
                case R.id.tv_cancel:
                    myReservationAdapterInterface.getDetails(getAdapterPosition(),"cancel");
                    break;
                    default:
                        break;
            }
        }
    }

    public interface MyReservationAdapterInterface {
        void getDetails(int getAdapterPosition, String Tag);
    }

}
