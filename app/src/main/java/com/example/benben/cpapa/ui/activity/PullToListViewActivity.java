package com.example.benben.cpapa.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benben.cpapa.R;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by benben on 2016/5/3.
 */
public class PullToListViewActivity extends BaseActivity {
    @InjectView(R.id.topLeft)
    ImageView topLeft;
    @InjectView(R.id.topTitle)
    TextView topTitle;
    @InjectView(R.id.topRight)
    ImageView topRight;
    @InjectView(R.id.pull_image)
    ImageView pullImage;

    public static void startPullToListViewActivity(Activity activity) {
        Intent intent = new Intent(activity, PullToListViewActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        Picasso.with(PullToListViewActivity.this)
                .load("http://img04.tooopen.com/images/20131211/sy_51301885361.jpg")
                .into(pullImage);
    }


}
