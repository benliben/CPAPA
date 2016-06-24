package com.example.benben.cpapa.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by benebn on 2016/5/18.
 */
public class AnotherBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "由AnotherBroadcastReceiver发送", Toast.LENGTH_SHORT).show();
    }
}
