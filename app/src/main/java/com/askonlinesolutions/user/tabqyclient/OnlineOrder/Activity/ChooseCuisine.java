package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Commons.Adapters.AdapterChooseCuisine;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;

public class ChooseCuisine extends AppCompatActivity implements AdapterChooseCuisine.interface_AdapterChooseCuisine {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_cuisine);

        init();
    }

    private RecyclerView rv;
    private TextView tv_title;
    private ArrayList<String> arr_names = new ArrayList<>();
    private ArrayList<String> arr_check = new ArrayList<>();

    private void init(){

        tv_title = findViewById(R.id.item_choose_cuisine_name);
        rv = findViewById(R.id.activity_choose_cuisine_rv);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        arr_names.clear();
        arr_names.add("All Cuisines");
        arr_names.add("American");
        arr_names.add("Breakfast");
        arr_names.add("Burgers");
        arr_names.add("Cafe");
        arr_names.add("Chinese");
        arr_names.add("Desserts");
        arr_names.add("Healthy Food");
        arr_names.add("Indian");
        arr_names.add("Iranian");
        arr_names.add("Italian");
        arr_names.add("Japanese");
        arr_names.add("Lebanese");

        arr_check.clear();
        arr_check.add("1");
        arr_check.add("0");
        arr_check.add("0");
        arr_check.add("0");
        arr_check.add("0");
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
        AdapterChooseCuisine adapter = new AdapterChooseCuisine(getApplicationContext(), arr_names, arr_check, this);
        rv.setAdapter(adapter);
    }

    @Override
    public void click_AdapterChooseCuisine(int pos) {

        if(pos>=0){
            if(pos == 0){
                for(int i=0; i<arr_check.size(); i++){
                    arr_check.set(i, "0");
                }
                arr_check.set(0, "1");
            } else {
                for(int i=0; i<arr_check.size(); i++){
                    arr_check.set(i, "0");
                }
                arr_check.set(pos, "1");
            }
            onBackPressed();
            this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

            setMyAdapter();
        }
    }
}
