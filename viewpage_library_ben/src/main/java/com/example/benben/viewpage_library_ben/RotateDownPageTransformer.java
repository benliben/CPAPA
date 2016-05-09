package com.example.benben.viewpage_library_ben;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by benben on 2016/5/9.
 */
public class RotateDownPageTransformer extends BasePageTransformer {

    private static final float DEFAULT_MAX_ROTATE = 15.0f;
    private float mMaxRotate = DEFAULT_MAX_ROTATE;

    public RotateDownPageTransformer() {

    }

    public RotateDownPageTransformer(float maxRotate) {
        this(maxRotate, NonPageTransformer.INSTANCE);
    }

    public RotateDownPageTransformer(ViewPager.PageTransformer pageTransformer) {
        this(DEFAULT_MAX_ROTATE, pageTransformer);
    }

    public RotateDownPageTransformer(float maxRotate, ViewPager.PageTransformer instance) {
        mPageTransformer = instance;
        mMaxRotate = maxRotate;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    protected void pageTransform(View view, float position) {
        if (position < -1) {
            view.setRotation(mMaxRotate * -1);
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight());
        } else if (position <= 1) {
            if (position < 0) {
                view.setPivotX(view.getWidth() * (DEFAULT_CENTER + DEFAULT_CENTER * (-position)));
                view.setPivotY(view.getHeight());
                view.setRotation(mMaxRotate * position);
            } else {
                view.setScaleX(view.getWidth() * DEFAULT_CENTER * (1 - position));
                view.setPivotY(view.getHeight());
                view.setRotation(mMaxRotate * position);
            }
        } else {
            view.setRotation(mMaxRotate);
            view.setPivotX(view.getWidth() * 0);
            view.setPivotY(view.getHeight());
        }
    }
}
