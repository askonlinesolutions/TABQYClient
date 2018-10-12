package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.DetailActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters.AdapterRestaurantList;
import com.askonlinesolutions.user.tabqyclient.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestroFragment extends Fragment implements View.OnClickListener,
        AdapterRestaurantList.Interface_AdapterRestaurant {

//    List<String> mRestroList = new ArrayList<>();
//    RestroAdapter mRestro;
//    LinearLayout mCusisne;

    public RestroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rowView=inflater.inflate(R.layout.fragment_restro, null,true);

//        ListView mRecycler = rowView.findViewById(R.id.restro_recycler);
//        mCusisne = rowView.findViewById(R.id.cuisine_layout);
//        mCusisne.setOnClickListener(this);
//
//        mRestroList.clear();
//        mRestroList.add("Dao Xiang Restaurant");
//        mRestroList.add("Dao Xiang Restaurant");
//        mRestroList.add("Dao Xiang Restaurant");
//        mRestro = new RestroAdapter(getContext(),R.layout.restro_item_layout,mRestroList);
//
//        mRecycler.setAdapter(mRestro);
//
//        mRecycler.setOnItemClickListener(new AdapterView.OnItemClickListener()
//        {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
//            {
//                startActivity(new Intent(getContext(), DetailActivity.class));
//            }
//        });

        return rowView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private RecyclerView rv;

    private void init(){

        rv = getView().findViewById(R.id.fragment_restaurant_list_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new AdapterRestaurantList(this));
    }

    @Override
    public void onClick(View v)
    {
//        if (v==mCusisne)
//        {
//           startActivity(new Intent(getContext(), ChooseCuisine.class));
//        }
    }

    @Override
    public void method_AdapterRestaurant(int pos) {

        if(pos>=0){
            startActivity(new Intent(getContext(), DetailActivity.class));
            getActivity().overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
        }
    }
}