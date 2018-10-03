package com.askonlinesolutions.user.tabqyclient.Activities;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.askonlinesolutions.user.tabqyclient.Adapters.NationAdapter;
import com.askonlinesolutions.user.tabqyclient.Adapters.SearchAdapter;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectCountryActivity extends AppCompatActivity
{
    List<String> mCityList = new ArrayList<>();
    @BindView(R.id.search_listview_country)ListView mSearchList;
    NationAdapter mNation;

    ImageView mImageview;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_country);

        ButterKnife.bind(this);

        mCityList.add("KUWAIT");
        mCityList.add("UAE");
        mCityList.add("SAUDI");
        mCityList.add("ARAB");



        mNation = new NationAdapter(this,R.layout.search_country_result,mCityList);
        mSearchList.setAdapter(mNation);

        mSearchList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                 // where myresource (without the extension) is the file



            }
        });
    }
}
