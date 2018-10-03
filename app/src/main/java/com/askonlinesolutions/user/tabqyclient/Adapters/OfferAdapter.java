package com.askonlinesolutions.user.tabqyclient.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Model.OfferModel;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferHolder>
{
    Context mContext;
    List<OfferModel> mAllOffer;
    private static final String TAG = OfferAdapter.class.getSimpleName();

    public OfferAdapter(Context mContext, List<OfferModel> mAllOffer) {
        this.mContext = mContext;
        this.mAllOffer = mAllOffer;
    }

    @NonNull
    @Override
    public OfferHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View rowView=LayoutInflater.from(mContext).inflate(R.layout.offer_item_layout, parent,false);
        return new OfferHolder(rowView);
    }

    @Override
    public void onBindViewHolder(OfferHolder holder, int position)
    {
       OfferModel offerModel = mAllOffer.get(position);
        Log.d(TAG, "onBindViewHolder: " + offerModel.getName());
       holder.mFoodname.setText(offerModel.getName());
    }

    @Override
    public int getItemCount()
    {

        Log.d(TAG, "getItemCount: " + mAllOffer.size());
        return mAllOffer.size();

    }

    public class OfferHolder extends RecyclerView.ViewHolder
    {
          TextView mFoodname;
        public OfferHolder(View itemView)
        {
            super(itemView);
            mFoodname = itemView.findViewById(R.id.offer_food_name);
        }
    }
}
