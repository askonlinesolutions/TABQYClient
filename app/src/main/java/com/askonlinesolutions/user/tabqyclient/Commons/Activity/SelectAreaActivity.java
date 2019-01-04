package com.askonlinesolutions.user.tabqyclient.Commons.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Activities.DrawerHomeActivity;
import com.askonlinesolutions.user.tabqyclient.Activities.MainActivity;
import com.askonlinesolutions.user.tabqyclient.Activities.filter.FilterActivity;
import com.askonlinesolutions.user.tabqyclient.Adapters.SearchAdapter;
import com.askonlinesolutions.user.tabqyclient.Commons.Adapters.AdapterAreaList;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.Reservation.Activity.FindRestaurants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectAreaActivity extends AppCompatActivity implements View.OnClickListener, AdapterAreaList.interface_AdapterAreaList {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_area);

        init();
    }

    private RecyclerView rv;
    private TextView tv_title;
    private ArrayList<String> arr_names = new ArrayList<>();
    private ArrayList<String> arr_check = new ArrayList<>();

    private void init(){
        tv_title = findViewById(R.id.activity_select_area_title);
        rv = findViewById(R.id.activity_select_area_rv);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        tv_title.setOnClickListener(this);

        arr_names.clear();
        arr_names.add("Dubai");
        arr_names.add("Abu Dhabi");
        arr_names.add("Sharjah");
        arr_names.add("Ajman");
        arr_names.add("Al Ain");
        arr_names.add("Fujairah");
        arr_names.add("Ras Al Khaima");
        arr_names.add("Umm Al-Quwain");

        arr_check.clear();
        arr_check.add("0");
        arr_check.add("0");
        arr_check.add("0");
        arr_check.add("0");
        arr_check.add("0");
        arr_check.add("0");
        arr_check.add("0");
        arr_check.add("0");

        setMyAdapter();
    }

    private void setMyAdapter(){

        AdapterAreaList adapter = new AdapterAreaList(getApplicationContext(), arr_names, arr_check, this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if(v == tv_title){

        }
    }

    @Override
    public void click_AdapterAreaList(int pos) {

        if(pos>=0) {
            for (int i = 0; i < arr_check.size(); i++) {
                arr_check.set(i, "0");
            }
            arr_check.set(pos, "1");
            setMyAdapter();
            Intent filterIntent = new Intent(SelectAreaActivity.this, DrawerHomeActivity.class);
            startActivity(filterIntent);
        }
    }
}
