package com.example.benben.cpapa.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
 * 广告滑动页面
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
    }


    private void initView() {
        final List<String> urls = new ArrayList<>();
        urls.add("http://fj.heze.cc/attachments/forum/month_0907/20090726_3a990fc8bcb6fa1d3878pAMBPjA75B65.jpg");
        urls.add("http://img04.tooopen.com/images/20131211/sy_51301885361.jpg");
        urls.add("http://gb.cri.cn/mmsource/images/2007/07/03/el070703186.jpg");
        urls.add("http://pic.3h3.com/up/2012-12/20121249537219310.jpg");
        urls.add("http://hiphotos.baidu.com/xjpgh/pic/item/b1f850314236c62debc4afb7.jpg");
        urls.add("http://img04.tooopen.com/images/20121219/tooopen_18092442.jpg");
        urls.add("http://imgsrc.baidu.com/forum/pic/item/dcc451da81cb39dbf3c1c7c4d0160924ab18301a.jpg");
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

        mPosterLayout2.setOnBannerItemClickListener(new PosterLayout.OnBannerItemClickListener() {
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

    @Override
    public void onPause() {
        super.onPause();
        Log.i("lyx", "暂停了: ");
        PosterLayout posterLayout = new PosterLayout(getActivity());
        posterLayout.stopAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("lyx", "停止了: ");
        PosterLayout posterLayout = new PosterLayout(getActivity());
        posterLayout.stopAutoPlay();
    }
}
