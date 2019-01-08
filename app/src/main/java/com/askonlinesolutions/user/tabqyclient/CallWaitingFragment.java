package com.askonlinesolutions.user.tabqyclient;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Commons.Activity.HomeActivity;
import com.askonlinesolutions.user.tabqyclient.Commons.Activity.SplashActivity;
import com.askonlinesolutions.user.tabqyclient.databinding.FragmentTableMyCartBinding;
import com.askonlinesolutions.user.tabqyclient.tableCode.TableDashboardActivity;


public class CallWaitingFragment extends Fragment {
    FragmentTableMyCartBinding binding;
    private static final long SPLASH_TIME_OUT = 3000;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_call_waiting, container, false);

        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }
    TextView call_btn,ringing;



    private void init() {
        call_btn=getView().findViewById(R.id.call_btn);
        ringing=getView().findViewById(R.id.ringing);
        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ringing.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(getActivity(), TableDashboardActivity.class);
                        startActivity(i);

                    }
                }, SPLASH_TIME_OUT);

            }
        });

    }
    }

