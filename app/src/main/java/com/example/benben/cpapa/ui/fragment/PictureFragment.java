package com.example.benben.cpapa.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.benben.cpapa.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by benben on 2016/5/3.
 */
public class PictureFragment extends BaseFragment {
    @InjectView(R.id.picture_linearLayout)
    LinearLayout mLinearLayout;
    private View rootView;
    
    private int [] mImgids={R.mipmap.hehe,R.mipmap.hehe1,R.mipmap.hehe2,R.mipmap.car,R.mipmap.car1};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_picture, container, false);
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

    private void initData() {
    }

    private void initView() {
        for (int i = 0; i < mImgids.length; i++) {
         LayoutInflater   mInflater = LayoutInflater.from(getActivity());
            View view = mInflater.inflate(R.layout.item_picure, mLinearLayout, false);
            ImageView img = (ImageView) view.findViewById(R.id.item_picture_image);
            img.setImageResource(mImgids[i]);
            TextView txt = (TextView) view.findViewById(R.id.item_picture_text);
            txt.setText("some info");
            mLinearLayout.addView(view);
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
