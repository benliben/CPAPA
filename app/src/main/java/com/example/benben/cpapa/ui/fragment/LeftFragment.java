package com.example.benben.cpapa.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.benben.cpapa.FragmentContainer;
import com.example.benben.cpapa.R;
import com.example.benben.cpapa.model.LeftTagModel;
import com.example.benben.cpapa.ui.activity.MainActivity;
import com.example.benben.cpapa.ui.adpter.LeftAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/5/2.
 */
public class LeftFragment extends BaseFragment {
    @InjectView(R.id.left_content)
    RecyclerView mContent;

    private View rootView;
    private List<LeftTagModel> mModels;
    private LeftAdapter mAdapter;
    private String[] mData = {"a", "b", "c","d"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView =inflater.inflate(R.layout.fragment_left, container, false);
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
        mContent.setLayoutManager(new LinearLayoutManager(getActivity()));
        mContent.setAdapter(mAdapter);
        mAdapter.setItemClickListener(new LeftAdapter.OnItemClickListener() {
            @Override
            public void ItemClickListener(View view, int position) {
                mAdapter.setChoosePosition(position);
                ((MainActivity) getActivity()).swticFragmentContent(mModels.get(position));
            }
        });
    }

    private void initData() {
        mModels = new ArrayList<>();
        for (int i = 0; i < mData.length; i++) {
            LeftTagModel model = new LeftTagModel();
            model.setName(mData[i]);
            mModels.add(model);
        }
        initModel();
        mAdapter = new LeftAdapter(mData);
    }

    private void initModel() {
        mModels = getTagModelFromMap();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    public List<LeftTagModel> getTagModelFromMap() {
        List<LeftTagModel> list = new ArrayList<>();
        /**左边*/
        list.add(FragmentContainer.getTagModel().get(FirstFragment.class.getSimpleName()));
        list.add(FragmentContainer.getTagModel().get(MusicFragment.class.getSimpleName()));
        list.add(FragmentContainer.getTagModel().get(PictureFragment.class.getSimpleName()));
        list.add(FragmentContainer.getTagModel().get(FourthlyFragment.class.getSimpleName()));


        return list;
    }
}
