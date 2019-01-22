package com.askonlinesolutions.user.tabqyclient.WebServices;

public interface OnResponseInterface {
    void onApiResponse(Object response);
    void onApiFailure(String message);
}
