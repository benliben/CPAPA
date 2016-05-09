package com.example.benben.cpapa;

import android.support.v4.app.Fragment;

import com.example.benben.cpapa.model.LeftTagModel;
import com.example.benben.cpapa.ui.fragment.FirstFragment;
import com.example.benben.cpapa.ui.fragment.FourthlyFragment;
import com.example.benben.cpapa.ui.fragment.MusicFragment;
import com.example.benben.cpapa.ui.fragment.PictureFragment;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/2.
 */
public class FragmentContainer {

    private FragmentContainer() {

    }
    private static Map<String,LeftTagModel>getTagModel;

    public static Map<String, LeftTagModel> getTagModel() {
        if (getTagModel == null) {

            getTagModel = new HashMap<>();
            getTagModel.put(FirstFragment.class.getSimpleName(), createModel("第一项", new FirstFragment()));
            getTagModel.put(MusicFragment.class.getSimpleName(), createModel("音乐", new MusicFragment()));
            getTagModel.put(PictureFragment.class.getSimpleName(), createModel("图片", new PictureFragment()));
            getTagModel.put(FourthlyFragment.class.getSimpleName(), createModel("广告", new FourthlyFragment()));

        }
        return getTagModel;
    }

    private static LeftTagModel createModel(String name, Fragment fragment) {
        LeftTagModel list = new LeftTagModel();
        list.setName(name);
        list.setFragment(fragment);
        return list;
    }

}
