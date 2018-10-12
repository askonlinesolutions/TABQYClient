package com.askonlinesolutions.user.tabqyclient.Commons.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Commons.Adapters.AdapterCountryList;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;

public class SelectCountryActivity extends AppCompatActivity implements View.OnClickListener, AdapterCountryList.interface_AdapterCountryList {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_country);

//        ButterKnife.bind(this);

        init();
    }

    private RecyclerView rv;
    private TextView tv_title;
    private ArrayList<String> arr_names = new ArrayList<>();
    private ArrayList<String> arr_check = new ArrayList<>();

    private void init(){

        tv_title = findViewById(R.id.activity_select_country_title);
        rv = findViewById(R.id.activity_select_country_rv);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        tv_title.setOnClickListener(this);

        arr_names.clear();
        arr_names.add("KUWAIT");
        arr_names.add("UAE");
        arr_names.add("KSA");
        arr_names.add("BAHRAIN");
        arr_names.add("QATAR");
        arr_names.add("OMAN");
        arr_names.add("JORDAN");

        arr_check.clear();
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
        AdapterCountryList adapter = new AdapterCountryList(getApplicationContext(), arr_names, arr_check, this);
        rv.setAdapter(adapter);
    }
    @Override
    public void onClick(View v) {

    }

    @Override
    public void click_AdapterCoutryList(int pos) {

        if (pos >= 0) {
            for (int i = 0; i < arr_check.size(); i++) {
                arr_check.set(i, "0");
            }
            arr_check.set(pos, "1");
            setMyAdapter();
        }
    }
}