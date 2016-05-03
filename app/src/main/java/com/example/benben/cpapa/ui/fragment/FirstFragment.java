package com.example.benben.cpapa.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.benben.ben_poster_library.PosterLayout;
import com.example.benben.cpapa.R;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by bneben on 2016/5/2.
 */
public class FirstFragment extends BaseFragment {

    @InjectView(R.id.first_posterLayout)
    PosterLayout mPosterLayout;
    @InjectView(R.id.first_posterLayout2)
    PosterLayout mPosterLayout2;
    private View rootView;

    private List<Integer> imageViews;

    private int[] mData={R.mipmap.hehe,R.mipmap.hehe1,R.mipmap.hehe2,R.mipmap.hehe1,R.mipmap.hehe2,};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_first, container, false);
        }
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    private void initData() {


    }

    private void initView() {
        final List<String> urls = new ArrayList<>();
        urls.add("http://img4.imgtn.bdimg.com/it/u=2584974889,1768316857&fm=21&gp=0.jpg");
        urls.add("http://img04.tooopen.com/images/20131211/sy_51301885361.jpg");
        urls.add("http://img04.tooopen.com/images/20121219/tooopen_18092442.jpg");
        urls.add("http://pic.3h3.com/up/2012-12/20121249537219310.jpg");
        urls.add("http://gb.cri.cn/mmsource/images/2007/07/03/el070703186.jpg");
        urls.add("http://gb.cri.cn/mmsource/images/2007/07/03/el070703186.jpg");
        urls.add("http://gb.cri.cn/mmsource/images/2007/07/03/el070703186.jpg");

        mPosterLayout.setViewUrls(urls);


//        List<Integer> run = new ArrayList<>();
//        run.add(R.mipmap.hehe);
//        run.add(R.mipmap.hehe1);
//        run.add(R.mipmap.hehe2);
//        run.add(R.mipmap.car);
//        run.add(R.mipmap.car1);
//        mPosterLayout.setViewRes(run);

        /**监听事件*/

        mPosterLayout.setOnBannerItemClickListener(new PosterLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getActivity(), String.valueOf(position),Toast.LENGTH_SHORT).show();
            }
        });

        /**低于三张*/
        final List<String> urls2 = new ArrayList<>();
        urls2.add("http://images.ali213.net/picfile/pic/2013/12/07/927_20131207153100256.jpg");
        urls2.add("http://pic10.nipic.com/20101004/3320946_021726451306_2.jpg");
        mPosterLayout2.setViewUrls(urls2);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
