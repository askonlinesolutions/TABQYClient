package com.askonlinesolutions.user.tabqyclient.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.askonlinesolutions.user.tabqyclient.R;

import java.util.List;

public class RestroImageAdapter extends RecyclerView.Adapter<RestroImageAdapter.RestroHolder>
{
    Context mContext;
    List<int[]> mAllOffer;
    private static final String TAG = OfferAdapter.class.getSimpleName();

    public RestroImageAdapter(Context mContext, List<int[]> mAllOffer) {
        this.mContext = mContext;
        this.mAllOffer = mAllOffer;
    }

    @NonNull
    @Override
    public RestroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View rowView= LayoutInflater.from(mContext).inflate(R.layout.info_item_list, parent,false);
        return new RestroHolder(rowView);
    }

    @Override
    public void onBindViewHolder(RestroHolder holder, int position)
    {

//       holder.mFoodname.setText(offerModel.getName());
    }

    @Override
    public int getItemCount()
    {

        Log.d(TAG, "getItemCount: " + mAllOffer.size());
        return mAllOffer.size();

    }

    public class RestroHolder extends RecyclerView.ViewHolder
    {
        ImageView mRestro_image;
        public RestroHolder(View itemView)
        {
            super(itemView);
            mRestro_image = itemView.findViewById(R.id.restro_image);
        }
    }
}

