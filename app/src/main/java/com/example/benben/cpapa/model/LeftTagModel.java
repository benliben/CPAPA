package com.example.benben.cpapa.model;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2016/5/2.
 */
public class LeftTagModel {
    String name;
    Fragment fragment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
