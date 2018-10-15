package com.askonlinesolutions.user.tabqyclient.customText;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


/**
 * Created by lenovo on 4/13/2018.
 */

public class CustomTextViewRegular extends android.support.v7.widget.AppCompatTextView {

    public CustomTextViewRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CustomTextViewRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextViewRegular(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-Regular.ttf");
        setTypeface(tf ,1);

    }

}
