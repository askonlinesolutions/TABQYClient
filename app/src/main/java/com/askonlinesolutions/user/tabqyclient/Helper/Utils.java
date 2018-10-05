package com.askonlinesolutions.user.tabqyclient.Helper;

import android.content.Context;
import android.util.Patterns;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by Vaibhav on 10/4/2018.
 */
public class Utils {

    public static Boolean checkemail(final String email) {
        if(email!=null)
        {
            Pattern pattern = Patterns.EMAIL_ADDRESS;
            if(pattern.matcher(email).matches())
            {
                return pattern.matcher(email).matches();
            }
        }
        return false;
    }

    public static boolean isValidMobile(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }

    private static Toast t;
    public static void showToast(Context context, String msg){
        if(t != null)
            t.cancel();
        t = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        t.show();
    }
}
