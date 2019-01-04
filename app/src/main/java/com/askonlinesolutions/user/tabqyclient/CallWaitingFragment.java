package com.askonlinesolutions.user.tabqyclient;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.databinding.FragmentTableMyCartBinding;


public class CallWaitingFragment extends Fragment {
    FragmentTableMyCartBinding binding;



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
            }
        });
    }
    }

