package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.myReceipt;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.myReceiptsDetails.MyReceiptsDetailsActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.tabqyPoints.TabqyPointsAdapter;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityMyReceiptBinding;

public class MyReceiptActivity extends AppCompatActivity implements MyReceiptAdapter.OnItemClickLister, View.OnClickListener {
    ActivityMyReceiptBinding binding;
    private MyReceiptAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_receipt);

        init();

    }

    private void init() {

        setUpRecyclerview();
binding.receiptBackBtn.setOnClickListener(this);

    }

    private void setUpRecyclerview() {

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this, GridLayoutManager.VERTICAL, false);
        binding.myReceiptRv.setLayoutManager(gridLayoutManager);
        adapter = new MyReceiptAdapter(this, this);
        binding.myReceiptRv.setAdapter(adapter);


    }


    @Override
    public void onItemClick(int Pos, String type) {
        if (type.equals("RECEIPT")) {
            Intent intentDetails = new Intent(this, MyReceiptsDetailsActivity.class);
            startActivity(intentDetails);
//            getApplication().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.receipt_back_btn:
                onBackPressed();
                this.overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                break;
        }
    }
}
