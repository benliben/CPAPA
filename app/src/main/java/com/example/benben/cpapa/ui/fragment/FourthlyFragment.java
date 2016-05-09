package com.example.benben.cpapa.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.os.TraceCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.benben.cpapa.R;
import com.example.benben.viewpage_library_ben.AlphaPageTransformer;
import com.example.benben.viewpage_library_ben.NonPageTransformer;
import com.example.benben.viewpage_library_ben.RotateDownPageTransformer;
import com.example.benben.viewpage_library_ben.RotateUpPageTransformer;
import com.example.benben.viewpage_library_ben.RotateYTransformer;
import com.example.benben.viewpage_library_ben.ScaleInTransformer;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by benben on 2016/5/9.
 */
public class FourthlyFragment extends BaseFragment {
    @InjectView(R.id.fourthly_content)
    ViewPager mContent;
    private View rootView;

    private PagerAdapter mAdapter;
    int[]mDatas={R.mipmap.hehe,R.mipmap.hehe1,R.mipmap.hehe2,R.mipmap.car,R.mipmap.car1};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_fourthly, container, false);
        }
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /**设置page间间距*/
        mContent.setPageMargin(40);
        /**设置缓存的页面数量*/
        mContent.setOffscreenPageLimit(3);
        mContent.setAdapter(mAdapter=new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView view1 = new ImageView(getActivity());
                view1.setScaleType(ImageView.ScaleType.FIT_XY);
                view1.setImageResource(mDatas[position]);
                container.addView(view1);
                return view1;
            }


            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View)object);
            }

            @Override
            public int getCount() {
                return mDatas.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        });
        mContent.setPageTransformer(true, new AlphaPageTransformer());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick(R.id.fourthly_content)
    public void onClick() {
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        String[] effects = this.getResources().getStringArray(R.array.magic_effect);
        for (String effect : effects)
            menu.add(effect);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = item.getTitle().toString();
        mContent.setAdapter(mAdapter);

        if ("RotateDown".equals(title))
        {
            mContent.setPageTransformer(true, new RotateDownPageTransformer());
        } else if ("RotateUp".equals(title))
        {
            mContent.setPageTransformer(true, new RotateUpPageTransformer());
        } else if ("RotateY".equals(title))
        {
            mContent.setPageTransformer(true, new RotateYTransformer(45));
        } else if ("Standard".equals(title))
        {
//            mViewPager.setClipChildren(false);
            mContent.setPageTransformer(true, NonPageTransformer.INSTANCE);
        } else if ("Alpha".equals(title))
        {
//            mViewPager.setClipChildren(false);
            mContent.setPageTransformer(true, new AlphaPageTransformer());
        } else if ("ScaleIn".equals(title))
        {
            mContent.setPageTransformer(true, new ScaleInTransformer());
        } else if ("RotateDown and Alpha".equals(title))
        {
            mContent.setPageTransformer(true, new RotateDownPageTransformer(new AlphaPageTransformer()));
        }else if ("RotateDown and Alpha And ScaleIn".equals(title))
        {
            mContent.setPageTransformer(true, new RotateDownPageTransformer(new AlphaPageTransformer(new ScaleInTransformer())));
        }



        return true;
    }
}
