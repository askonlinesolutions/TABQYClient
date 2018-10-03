package com.askonlinesolutions.user.tabqyclient.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.askonlinesolutions.user.tabqyclient.Activities.CuisineActivity;
import com.askonlinesolutions.user.tabqyclient.Activities.DetailActivity;
import com.askonlinesolutions.user.tabqyclient.Activities.ItemsDetailActivity;
import com.askonlinesolutions.user.tabqyclient.Adapters.RestroAdapter;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestroFragment extends Fragment implements View.OnClickListener
{
    List<String> mRestroList = new ArrayList<>();

    RestroAdapter mRestro;
    LinearLayout mCusisne;

    public RestroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {


        View rowView=inflater.inflate(R.layout.fragment_restro, null,true);

        ListView mRecycler = rowView.findViewById(R.id.restro_recycler);
        mCusisne = rowView.findViewById(R.id.cuisine_layout);
        mCusisne.setOnClickListener(this);
        mRestroList.clear();
        mRestroList.add("Dao Xiang Restaurant");
        mRestroList.add("Dao Xiang Restaurant");
        mRestroList.add("Dao Xiang Restaurant");
        mRestro = new RestroAdapter(getContext(),R.layout.restro_item_layout,mRestroList);
        mRecycler.setAdapter(mRestro);

        mRecycler.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                startActivity(new Intent(getContext(), DetailActivity.class));
            }
        });

        return rowView;
    }

    @Override
    public void onClick(View v)
    {
        if (v==mCusisne)
        {
           startActivity(new Intent(getContext(), CuisineActivity.class));
        }
    }
}
