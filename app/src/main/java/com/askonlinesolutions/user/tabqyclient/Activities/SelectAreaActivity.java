package com.askonlinesolutions.user.tabqyclient.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.askonlinesolutions.user.tabqyclient.Adapters.SearchAdapter;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectAreaActivity extends AppCompatActivity
{
    List<String> mCityList = new ArrayList<>();
    @BindView(R.id.search_listview)ListView mSearchList;
    SearchAdapter mSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_area);

        ButterKnife.bind(this);
        mCityList.add("Dubai");
        mCityList.add("Abu Dhabi");
        mCityList.add("Sarjah");
        mCityList.add("Ajman");

        mSearch = new SearchAdapter(this,R.layout.search_result,mCityList);
        mSearchList.setAdapter(mSearch);


    }
}
