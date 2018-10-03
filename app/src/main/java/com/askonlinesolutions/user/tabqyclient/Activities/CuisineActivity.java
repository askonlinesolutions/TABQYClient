package com.askonlinesolutions.user.tabqyclient.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.askonlinesolutions.user.tabqyclient.Adapters.CuisineAdapter;
import com.askonlinesolutions.user.tabqyclient.Adapters.SearchAdapter;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CuisineActivity extends AppCompatActivity implements View.OnClickListener
{
    List<String> mCuisineList = new ArrayList<>();
    CuisineAdapter mCuisine;
    @BindView(R.id.cuisine_listview)ListView mListview;
    @BindView(R.id.toolbar_back_cuisine)ImageView mBack;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine);

        ButterKnife.bind(this);
        mBack.setOnClickListener(this);

        mCuisineList.add("American");
        mCuisineList.add("Burger");
        mCuisineList.add("Breakfast");
        mCuisineList.add("Indian");
        mCuisineList.add("Deserts");

        mCuisine = new CuisineAdapter(this,R.layout.cuisine_item,mCuisineList);
        mListview.setAdapter(mCuisine);

        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                finish();
                startActivity(new Intent(CuisineActivity.this,MainActivity.class));
                overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
            }
        });

    }

    @Override
    public void onClick(View v)
    {
       if (v==mBack)
       {
           finish();
           overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
       }
    }
}
