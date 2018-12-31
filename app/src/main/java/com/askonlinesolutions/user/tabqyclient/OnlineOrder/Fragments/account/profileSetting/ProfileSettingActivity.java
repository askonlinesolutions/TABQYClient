package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.profileSetting;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityProfileSettingBinding;

public class ProfileSettingActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityProfileSettingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_profile_setting);

        init();
    }

    private void init() {
        binding.profileBackBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_back_btn:
                onBackPressed();
                this.overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                break;
        }
    }
}
