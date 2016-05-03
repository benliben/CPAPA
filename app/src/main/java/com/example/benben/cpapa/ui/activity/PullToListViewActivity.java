package com.example.benben.cpapa.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.example.benben.cpapa.R;


/**
 * Created by tangjunjie on 2016/5/3.
 */
public class PullToListViewActivity extends BaseActivity {
    public static void startPullToListViewActivity(Activity activity) {
        Intent intent = new Intent(activity, PullToListViewActivity.class);
        ActivityCompat.startActivity(activity,intent,null);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);
    }
}
