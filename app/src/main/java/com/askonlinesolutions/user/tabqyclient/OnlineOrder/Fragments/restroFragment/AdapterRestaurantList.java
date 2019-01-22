package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.restroFragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.menuResturent.MainManuAdapter;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.restroFragment.ResturentList.ResturentResponse;
import com.askonlinesolutions.user.tabqyclient.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Vaibhav.
 * Contact Number : +91 7737284476
 */
public class AdapterRestaurantList extends RecyclerView.Adapter<AdapterRestaurantList.MyViewHolder> {

    int resturent_id;
   String latitude;
    String longitude;
    public Interface_AdapterRestaurant interface_adapterRestaurant;
    Context context;
    private List<ResturentResponse.DataEntity> dataEntities;

    public AdapterRestaurantList(Context context,
                                 List<ResturentResponse.DataEntity> dataEntities,Interface_AdapterRestaurant interface_adapterRestaurant) {
        this.context = context;
        this.interface_adapterRestaurant = interface_adapterRestaurant;
        this.dataEntities = dataEntities;
    }


    private Interface_AdapterRestaurant click;

    public AdapterRestaurantList(Interface_AdapterRestaurant click) {
        this.click = click;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView heading_text_restro, country_dish, open, distance, miles_restro, avg_restro, time, free_rest, min_order, sar_prize, rating,
                points, number;
        ImageView retro_image, discount_image, offer_image, free, payment_image, cash, cash_two, coins;
        RatingBar review_Rating_Bar;
        View view1;

      //     http://webdevelopmenttesting.com/tabqy1/upload/logoimages/       image url
        public MyViewHolder(View view) {
            super(view);
            retro_image = (ImageView) view.findViewById(R.id.retro_image);
            heading_text_restro = view.findViewById(R.id.heading_text_restro);
            discount_image = (ImageView) view.findViewById(R.id.discount_image);
            offer_image = (ImageView) view.findViewById(R.id.offer_image);
            open = view.findViewById(R.id.open);
            country_dish = view.findViewById(R.id.country_dish);
            distance = view.findViewById(R.id.distance);
            miles_restro = view.findViewById(R.id.miles_restro);
            avg_restro = view.findViewById(R.id.avg_restro);
            time = view.findViewById(R.id.time);
            free = view.findViewById(R.id.free);
            free_rest = view.findViewById(R.id.free_rest);
            min_order = view.findViewById(R.id.min_order);
            sar_prize = view.findViewById(R.id.sar_prize);
            payment_image = view.findViewById(R.id.payment_image);
            cash = view.findViewById(R.id.cash);
            cash_two = view.findViewById(R.id.cash_two);
            rating = view.findViewById(R.id.rating);
            points = view.findViewById(R.id.points);
            number = view.findViewById(R.id.number);
            coins = view.findViewById(R.id.coins);
            review_Rating_Bar = view.findViewById(R.id.review_Rating_Bar);
            view1 = view.findViewById(R.id.view);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    latitude=dataEntities.get(getAdapterPosition()).getResturantbrand_lattitude();
                    longitude=dataEntities.get(getAdapterPosition()).getResturantbrand_longitude();
                    resturent_id= dataEntities.get(getAdapterPosition()).getResturantbrand_id();
                    interface_adapterRestaurant.method_AdapterRestaurant(getAdapterPosition(), resturent_id);


                    //  click.method_AdapterRestaurant(getAdapterPosition());
                    //resturent_id= dataEntities.get(getAdapterPosition()).getResturantbrand_id();
                }
            });
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_restaurant_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int i) {


        holder.heading_text_restro.setText(dataEntities.get(i).getResturantbrand_name());
        holder.country_dish.setText(dataEntities.get(i).getResturantbrand_country());
        holder.sar_prize.setText(dataEntities.get(i).getResturantbrand_min_order_price());
        holder.miles_restro.setText(dataEntities.get(i).getResturantbrand_delivery_distance());
        holder.time.setText(dataEntities.get(i).getResturantbrand_delivery_avgtime());


        Picasso.with(context).
                load("http://webdevelopmenttesting.com/tabqy1/upload/logoimages/"+dataEntities.get(i).
                        getResturantbrand_file()) // URL or file
                .into(holder.retro_image);




      //  resturent_id= dataEntities.get(i).getResturantbrand_id();
//        holder.tvBookId.setText(dataEntities.get(position).getBooking_id());
//        holder.tvDeliveryAddress.setText(dataEntities.get(position).getBooking_drop());

    }

    @Override
    public int getItemCount() {

        return dataEntities.size();
    }

    public interface Interface_AdapterRestaurant  {
        void method_AdapterRestaurant(int pos,int resturent_id);

        void onConnectionSuspended(int i);

//        @Override
//        void onItemClick(int Pos, String type);
    }
}