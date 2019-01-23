package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.searchResturent;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.detail_id.DetailActivity;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.Utils.Utility;
import com.askonlinesolutions.user.tabqyclient.WebServices.APIClient;
import com.askonlinesolutions.user.tabqyclient.WebServices.OnResponseInterface;
import com.askonlinesolutions.user.tabqyclient.WebServices.ResponseListner;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivitySearchBinding;

import java.util.ArrayList;

import retrofit2.Call;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener, OnResponseInterface, SearchResturentAdapter.OnItemClickLister {

    ActivitySearchBinding binding;

    String id;
    RecyclerView resturent_list;
    private ArrayList<SearchResponse.DataEntity> dataEntity = new ArrayList<SearchResponse.DataEntity>();
    private String TAG = SearchActivity.class.getName();
//    private ArrayList<String> arr_names = new ArrayList<>();
//    private ArrayList<String> arr_check = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        binding.resturentList.setLayoutManager(new LinearLayoutManager(this));
//        id = binding.resturentDeatail.getText().toString().trim();

        init();

    }

    private void getSearchList(String id) {
        new Utility().showProgressDialog(this);
        Call<SearchResponse> searchResponseCall = APIClient.getInstance()
                .getApiInterface().getSearchResturentDetail(id);
        searchResponseCall.request().url();
        Log.d(TAG, "searchResturentlist: " + searchResponseCall.request().url());
        new ResponseListner(this).getResponse(searchResponseCall);
    }


    private void setAdapter() {
        SearchResturentAdapter searchResturentAdapter = new SearchResturentAdapter(this, dataEntity, this);
        binding.resturentList.setAdapter(searchResturentAdapter);
    }

    private void init() {
        binding.resturentDeatail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                id = binding.resturentDeatail.getText().toString().trim();
                getSearchList(id);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        binding.searchBackBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_back_btn:
                onBackPressed();
                this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;
        }
    }

    @Override
    public void onApiResponse(Object response) {
        new Utility().hideDialog();
        if (response != null) {
            SearchResponse searchResponse = (SearchResponse) response;
            if (searchResponse.getData() != null && searchResponse.getData().size() > 0) {
                dataEntity = searchResponse.getData();

//                country_dish.setText(detailResponse.getData().getResturantbrand_country());
                setAdapter();
            }
        }
    }

    @Override
    public void onApiFailure(String message) {

    }

    @Override
    public void onItemClick(int Pos, int id) {
        Intent intent = new Intent(SearchActivity.this, DetailActivity.class);
        intent.putExtra("resturentId", id);

        startActivity(intent);
//            startActivity(new Intent(getContext(), DetailActivity.class));

        this.overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}

