package com.askonlinesolutions.user.tabqyclient.tableCode.qrCode;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.askonlinesolutions.user.tabqyclient.R;

public class QrCodeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_qr_code, container, false);
    }


}
