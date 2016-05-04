package com.example.benben.cpapa.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benben.cpapa.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
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
        Uri uri=Uri.parse("http://img04.tooopen.com/images/20131211/sy_51301885361.jpg");

        Picasso.with(PullToListViewActivity.this)
//                .load("http://img04.tooopen.com/images/20131211/sy_51301885361.jpg")
                .load(uri)
                .resize(1024,680)
                .placeholder(R.mipmap.hehe)//未加载完成
                .error(R.mipmap.hehe1)//未成功加载
                .into(pullImage);
    }


}
