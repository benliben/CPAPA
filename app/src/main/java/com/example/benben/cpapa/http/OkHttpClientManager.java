package com.example.benben.cpapa.http;


import android.os.Handler;
import android.os.Looper;
import android.service.carrier.CarrierMessagingService;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;

/**
 * Created by benben on 2016/5/5.
 */
public class OkHttpClientManager  {
    private static OkHttpClientManager mInstance;
    private OkHttpClient mOkHttpClient;

    private OkHttpClientManager( ) {
        mOkHttpClient=new OkHttpClient();
        //cookie enabled
        mOkHttpClient.setCookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER));
        Handler mDelivery = new Handler(Looper.getMainLooper());
        Gson mGson = new Gson();
    }

    public static OkHttpClientManager getInstance() {
        if (mInstance == null) {
            synchronized (OkHttpClientManager.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpClientManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 同步的Get请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    private Response _getAsyn(String url) throws IOException{
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        return call.execute();
    }

    /**
     * 同步的Get请求
     *
     * @param url
     * @return 字符串
     * @throws IOException
     */
    private String _getAsString(String url)throws IOException{
        Response execute = _getAsyn(url);
        return execute.body().string();
    }


    /**
     * 异步的Get请求
     *
     * @param url
     * @param callback
     */
    private void _getAsyn(String url, final CarrierMessagingService.ResultCallback callback) {
        final Request request = new Request.Builder()
                .url(url)
                .build();
        deliveryResult(callback, request);

    }




    private void deliveryResult(final CarrierMessagingService.ResultCallback callback, Request request) {
    }

}
