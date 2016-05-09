package com.example.benben.viewpage_library_ben;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by benben on 2016/5/9.
 */
public class NonPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        page.setScaleX(0.999f);
    }

    public static final ViewPager.PageTransformer INSTANCE = new NonPageTransformer();
}
