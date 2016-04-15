package com.example.administrator.myokhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements HttpCallBack {

    private TextView tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tw = (TextView) findViewById(R.id.text);
        MyRequest request = new MyRequest();
//        request.getRequest(this);
        request.myGetRequest(this);
//        request.postRequest(this);
       /* OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("https://github.com/hongyangAndroid")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
               final String  htmlStr = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tw.setText(htmlStr);
                    }
                });

            }
        });*/
    }

    @Override
    public void OnSuccess(final String string) {
        if (string != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    tw.setText(string);
                    Log.i("msg", string);
                }
            });
        } else {
            Toast.makeText(this, "数据为空", Toast.LENGTH_SHORT).show();
        }
    }
}
