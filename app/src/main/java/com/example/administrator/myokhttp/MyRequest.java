package com.example.administrator.myokhttp;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/4/11.
 */

public class MyRequest {
    //15e0569aa297b76ecc08a552d3f4e680
    public  final static String KEYID = "15e0569aa297b76ecc08a552d3f4e680";  // key = KEYID
    public  final static String MYURL = "http://apis.juhe.cn/cook/category"; // 只需要key
    public  final static String MY_GET_URL = "http://apis.juhe.cn/cook/category?key=15e0569aa297b76ecc08a552d3f4e680";
    public  final static String WLY = "http://112.124.117.205:8083/crm/customerController.do?getCustomerList&page=1&rows=5&orgId=8a22cc32537836a1015379daaa133497";
    /*public void getRequest( final HttpCallBack httpCallBack)
    {
        //判断是否有网络没有写

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("https://github.com/hongyangAndroid").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String  htmlStr = response.body().string();
                httpCallBack.OnSuccess(htmlStr);
            }
        });
    }*/

   /* public void postRequest(final HttpCallBack httpCallBack)
    {
        OkHttpUtils.post().url(MYURL)
                .addParams("key",KEYID)
                .build().execute(new com.zhy.http.okhttp.callback.Callback() {
            @Override
            public Object parseNetworkResponse(Response response) throws Exception {
                return null;
            }

            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(Object response) {

            }
        });
    }*/

    /*public void postRequest(final HttpCallBack httpCallBack)
    {
        OkHttpUtils.post().url(MYURL)
                .addParams("key",KEYID)
                .build().execute(new com.zhy.http.okhttp.callback.Callback() {
            @Override
            public Object parseNetworkResponse(Response response) throws Exception {
                return null;
            }

            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(Object response) {

            }
        });
    }*/

    public void myGetRequest(final HttpCallBack httpCallBack)
    {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(WLY).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Log.i("msg",s);
                httpCallBack.OnSuccess(s);
            }
        });

    }

    public void postRequest(final HttpCallBack httpCallBack)
    {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder().add("key",KEYID).build();
        final Request request = new Request.Builder().url(MYURL).post(requestBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                httpCallBack.OnSuccess(s);
            }
        });
    }
}
