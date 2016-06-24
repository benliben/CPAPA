package com.example.benben.cpapa.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benben.cpapa.R;
import com.example.benben.cpapa.model.LeftTagModel;
import com.example.benben.cpapa.ui.activity.BaseActivity;
import com.example.benben.cpapa.ui.adpter.LeftAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by benben on 2016/5/18.
 * 发送跨程序的广播  与FirstLine合作
 */
public class BroadcastTestActivity extends BaseActivity {
    @InjectView(R.id.topLeft)
    ImageView mLeft;
    @InjectView(R.id.topTitle)
    TextView mTitle;
    @InjectView(R.id.content)
    RecyclerView mContent;


    private List<LeftTagModel> mModel = new ArrayList<>();
    private LeftAdapter mAdapter;
    private String[] mData = {"发送有序广播"};

    public static void startBroadcastTestActivity(Activity activity) {
        Intent intent = new Intent(activity, BroadcastTestActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_broadcast);
        ButterKnife.inject(this);
        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < mData.length; i++) {
            LeftTagModel model = new LeftTagModel();
            model.setName(mData[i]);
            mModel.add(model);
        }

    }

    private void initView() {
        mLeft.setImageResource(R.mipmap.returns);
        mTitle.setText("跨程序广播");

        mContent.setLayoutManager(new LinearLayoutManager(BroadcastTestActivity.this));
        mAdapter = new LeftAdapter(mData);
        mContent.setAdapter(mAdapter);
        mAdapter.setItemClickListener(new LeftAdapter.OnItemClickListener() {
            @Override
            public void ItemClickListener(View view, int position) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                }
            }
        });
    }

    @OnClick(R.id.topLeft)
    public void onClick() {
        finish();
    }
}
