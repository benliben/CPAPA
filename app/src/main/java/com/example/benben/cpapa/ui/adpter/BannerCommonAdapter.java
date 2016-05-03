package com.example.benben.cpapa.ui.adpter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by benben on 2016/5/3.
 * 通用广告栏Adapter
 */
public class BannerCommonAdapter extends PagerAdapter {
    private Context context;
    private List<ImageView> mImageView;

    public BannerCommonAdapter(Context context, List<ImageView> mImageView) {
        this.context = context;
        this.mImageView = mImageView;
    }

    /**
     * 计数
     */
    @Override
    public int getCount() {
        /**设置最大值，使用户看不到边界*/
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition = position % mImageView.size();

        if (newPosition < 0) {
            position = mImageView.size() + newPosition;
        }
        ImageView view = mImageView.get(position);
        if (view.getParent() != null) {
            container.removeView(view);
        }
        container.addView(view);

        return view;
    }


}
