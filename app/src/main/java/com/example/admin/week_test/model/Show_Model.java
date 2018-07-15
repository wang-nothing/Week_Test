package com.example.admin.week_test.model;

import android.util.Log;

import com.example.admin.week_test.GoodBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Show_Model {
    private OkHttpClient client;
    public void getData(final Imodel imodel){
        client = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .build();
        Request request = new Request.Builder()
                .url("https://www.zhaoapi.cn/product/getProducts?pscid=1")
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                imodel.onFail(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.i("TAG", "onResponse: -----"+json.toString());
                Gson gson = new Gson();
                GoodBean goodBean = gson.fromJson(json, GoodBean.class);
                imodel.onSuccess(goodBean);
            }
        });
    }
}
