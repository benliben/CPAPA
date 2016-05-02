package com.example.benben.cpapa.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.benben.cpapa.R;

/**
 * Created by Administrator on 2016/5/2.
 */
public class FirstFragment extends BaseFragment {
    private View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_first, container, false);
        }
        return rootView;
    }
}
