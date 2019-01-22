package com.askonlinesolutions.user.tabqyclient.Reservation.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;
import com.google.android.gms.vision.text.Text;

public class MyReservationAdapter extends RecyclerView.Adapter<MyReservationAdapter.MyViewHolder> {

    private Context context;
    MyReservationAdapterInterface myReservationAdapterInterface;
    private boolean isVisible = true;
    private boolean isShow = true;

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

        TextView accepted,cancel,menu_btn;
        RelativeLayout food_rel,food_menu_hide;
        LinearLayout food;

        public MyViewHolder(View itemView) {
            super(itemView);

            accepted = itemView.findViewById(R.id.tv_accepted);
            cancel = itemView.findViewById(R.id.tv_cancel);
            menu_btn=itemView.findViewById(R.id.menu_btn);
            food_rel =itemView.findViewById(R.id.food_rel);
            food_menu_hide=itemView.findViewById(R.id.food_menu_hide);
            food=itemView.findViewById(R.id.food);
            accepted.setOnClickListener(this);
            cancel.setOnClickListener(this);
            menu_btn.setOnClickListener(this);
            food_menu_hide.setOnClickListener(this);
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
                case  R.id.food_menu_hide:
                    if (isVisible) {
                        food_rel.setVisibility(View.GONE);
                        menu_btn.setBackgroundResource(R.drawable.ic_down_arrow_);
                        isVisible = false;
                    }else
                    {
                        food_rel.setVisibility(View.VISIBLE);
                        menu_btn.setBackgroundResource(R.drawable.ic_up_arrow);
                        isVisible=true;
                    }
                    break;


            }
        }
    }

    public interface MyReservationAdapterInterface {
        void getDetails(int getAdapterPosition, String Tag);
    }

}
