package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String actionString = intent.getAction();
        Toast.makeText(context, actionString, Toast.LENGTH_LONG).show();
        try {
            if(isOnline(context)) {
                Toast.makeText(context, "Network Connected", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "Not Connected!", Toast.LENGTH_SHORT).show();
            }
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private boolean isOnline(Context context) {
        try{
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnected());
        }catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}