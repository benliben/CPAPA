package com.example.benben.cpapa.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.benben.cpapa.R;
import com.example.benben.cpapa.model.LeftTagModel;
import com.example.benben.cpapa.broadcast.BroadcastTestActivity;
import com.example.benben.cpapa.ui.activity.PullToListViewActivity;
import com.example.benben.cpapa.ui.adpter.LeftAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/5/2.
 */
public class RithtFragment extends BaseFragment {
    @InjectView(R.id.right_toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.right_collapsingToolbarLayout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @InjectView(R.id.right_recyclerView)
    RecyclerView mRecyclerView;
    private View rootView;


    private String [] mData={"1","2","3","4"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_right, container, false);
        }
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();
    }

    private void initView() {
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//没有收缩的时候
        mCollapsingToolbarLayout.setCollapsedTitleGravity(Color.GREEN);//收缩后
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        LeftAdapter  mAdapter = new LeftAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setItemClickListener(new LeftAdapter.OnItemClickListener() {
            @Override
            public void ItemClickListener(View view, int position) {
                switch (position) {
                    case 0:
                        PullToListViewActivity.startPullToListViewActivity(getActivity());
                        break;
                    case 1:
                        BroadcastTestActivity.startBroadcastTestActivity(getActivity());
                        break;
                }
            }
        });
    }

    private void initData() {
        List<LeftTagModel>   mModel = new ArrayList<>();
        for (int i = 0; i < mData.length; i++) {
            LeftTagModel model = new LeftTagModel();
            model.setName(mData[i]);
            mModel.add(model);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
