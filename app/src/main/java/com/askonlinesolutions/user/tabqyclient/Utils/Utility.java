package com.askonlinesolutions.user.tabqyclient.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.util.Base64;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.askonlinesolutions.user.tabqyclient.R;

import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.util.regex.Pattern;



public class Utility {
    public static Boolean checkemail(final String emai) {
        if(emai!=null)
        {
            Pattern pattern = Patterns.EMAIL_ADDRESS;
            if(pattern.matcher(emai).matches())
            {
                return pattern.matcher(emai).matches();
            }
        }
        return false;
    }

    public static String BitMapToString(Bitmap bitmap){
        String temp="";
        if(bitmap!=null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
            byte[] b = baos.toByteArray();
            temp = Base64.encodeToString(b, Base64.DEFAULT);
        }
        return temp;
    }

//    public static Dialog createErrorDialog(Context context, Dialog dialog, String msg){
//        if (dialog==null){
//            dialog = new Dialog(context);
//            dialog.setContentView(R.layout.error_alert_dialog);
//            dialog.setCancelable(true);
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//            final TextView txtOk = dialog.findViewById(R.id.dialog_error_ok);
//            final TextView txtMsg = dialog.findViewById(R.id.dialog_error_msg);
//            final Dialog finalDialog = dialog;
//            txtOk.setOnClickListener(view -> finalDialog.dismiss());
//            txtMsg.setText(msg);
//        } else {
//            final TextView txtOk = dialog.findViewById(R.id.dialog_error_ok);
//            final TextView txtMsg = dialog.findViewById(R.id.dialog_error_msg);
//            final Dialog finalDialog = dialog;
//            txtOk.setOnClickListener(view -> finalDialog.dismiss());
//            txtMsg.setText(msg);
//        }
//
//        return dialog;
//    }
//
    private static ProgressDialog progressDialog;
    public static void showProgressDialog(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        progressDialog.setMessage("Please wait...");
    }

    public static void hideDialog(){
        progressDialog.dismiss();
    }

//    public static DecimalFormat df2 = new DecimalFormat("#0.00");
//
//    private static Toast t;
//    public static void showToast(Context context, String msg){
//        if(t != null)
//            t.cancel();
//        t = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
//        t.show();
//    }
//
//    public static void hideKeyboard(Activity activity) {
//        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
//        //Find the currently focused view, so we can grab the correct window token from it.
//        View view = activity.getCurrentFocus();
//        //If no view currently has focus, create a new one, just so we can grab a window token from it
//        if (view == null) {
//            view = new View(activity);
//        }
//        assert imm != null;
//        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//    }
//
//    public static Boolean isNetworkConnected(Context context) {
//        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        assert connectivityManager != null;
//        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
//        if (networkInfo!=null && networkInfo.isConnectedOrConnecting())
//            return true;
//
//        return false;
//    }
//
//    public static void no_internet(final Activity activity, final Context context) {
//        View v = activity.findViewById(android.R.id.content);
//        Snackbar.make(v,"No Internet Connection", Snackbar.LENGTH_INDEFINITE)
//                .setAction(context.getResources().getString(R.string.retry),
//                        v1 -> {
//                            if(!isNetworkConnected(context)){
//                                no_internet(activity, context);
//                            }
////                                no_internet(v, context);
//                        }).setActionTextColor(context.getResources().getColor(R.color.back_white)).show();
//
//    }

}
