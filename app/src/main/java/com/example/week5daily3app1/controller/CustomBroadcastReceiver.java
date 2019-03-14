package com.example.week5daily3app1.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null) {
            String receivedString = intent.getStringExtra("message");
            if(receivedString != null) {
                Toast.makeText(context, "String Passed = " + receivedString, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
