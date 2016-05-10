package com.example.benben.cpapa.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.benben.ben_poster_library.PosterLayout;
import com.example.benben.cpapa.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 */
public class PullToListViewActivity extends BaseActivity {
    @InjectView(R.id.topLeft)
    ImageView topLeft;
    @InjectView(R.id.topTitle)
    TextView topTitle;
    @InjectView(R.id.topRight)
    ImageView topRight;
    @InjectView(R.id.pull_image_3)
    ImageView pullImage3;
    @InjectView(R.id.pull_image_1)
    ImageView pullImage1;
    @InjectView(R.id.pull_image_2)
    ImageView pullImage2;
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
        topLeft.setImageResource(R.mipmap.returns);
        topTitle.setText("一张图片");

        Glide.with(PullToListViewActivity.this)
                .load("http://img04.tooopen.com/images/20131211/sy_51301885361.jpg")
                .placeholder(R.mipmap.ic_launcher)
                .into(pullImage);
        Glide.with(PullToListViewActivity.this)
                .load("http://img04.tooopen.com/images/20131211/sy_51301885361.jpg")
                .placeholder(R.mipmap.ic_launcher)
                .into(pullImage2);
        Glide.with(PullToListViewActivity.this)
                .load("http://img04.tooopen.com/images/20131211/sy_51301885361.jpg")
                .placeholder(R.mipmap.ic_launcher)
                .into(pullImage3);
        Glide.with(PullToListViewActivity.this)
                .load("http://img04.tooopen.com/images/20131211/sy_51301885361.jpg")
                .placeholder(R.mipmap.ic_launcher)
                .into(pullImage1);
    }

    @OnClick(R.id.topLeft)
    public void OnClick() {
        finish();

    }


}
