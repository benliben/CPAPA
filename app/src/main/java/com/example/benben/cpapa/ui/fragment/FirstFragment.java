package com.example.benben.cpapa.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.benben.cpapa.R;
import com.example.benben.cpapa.ui.adpter.BannerCommonAdapter;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/5/2.
 */
public class FirstFragment extends BaseFragment {
    @InjectView(R.id.first_viewPager)
    ViewPager mViewPager;
    private View rootView;

    private PageRunHandler mHandler=null;
    private List<ImageView> mImageView;
    private int[] mData = {R.mipmap.hehe, R.mipmap.hehe1, R.mipmap.hehe2, R.mipmap.car1, R.mipmap.car};
    private BannerCommonAdapter mAdapter;
    private static final int BANNER_CHANG_TIME = 3000;//图片自动滑动的时间

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_first, container, false);
        }
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
    }

    private void initView() {
        initBannerView();
        mAdapter = new BannerCommonAdapter(getActivity(), mImageView);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(Integer.MAX_VALUE/2);//设置为最大值的一半
        startBannerRun();//开启滑动
    }
    /**处理页面*/
      class  PageRunHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    int indexPosition = mViewPager.getCurrentItem();
                    mViewPager.setCurrentItem(indexPosition + 1);
                    break;
            }
        }
    }
    private void startBannerRun() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("lyx", "mHandeler: "+mHandler);
                Log.i("lyx", "BANNER_CHANG_TIME: "+BANNER_CHANG_TIME);
//                mHandler.removeMessages(0);
                mHandler.sendEmptyMessageDelayed(0, BANNER_CHANG_TIME);
            }
        }).start();
    }
    /**图片资源*/
    private void initBannerView() {
        mImageView = new ArrayList<>();
        for (int i = 0; i < mData.length; i++) {
            ImageView view = new ImageView(getActivity());
            view.setImageResource(mData[i]);
            mImageView.add(view);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

}
