package com.example.benben.cpapa.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.benben.cpapa.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by benben on 2016/5/3.
 */
public class MusicFragment extends BaseFragment {
    @InjectView(R.id.music_listView)
    ListView mListView;
    @InjectView(R.id.music_progressBar)
    ContentLoadingProgressBar mProgressBar;
    @InjectView(R.id.music_button_up)
    TextView mButtonUp;
    @InjectView(R.id.music_button_play)
    TextView mButtonPlay;
    @InjectView(R.id.music_button_stop)
    TextView mButtonStop;
    @InjectView(R.id.music_button_next)
    TextView mButtonNext;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_music, container, false);
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

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.music_button_up, R.id.music_button_play, R.id.music_button_stop, R.id.music_button_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.music_button_up:
                break;
            case R.id.music_button_play:
                break;
            case R.id.music_button_stop:
                break;
            case R.id.music_button_next:
                break;
        }
    }
}
