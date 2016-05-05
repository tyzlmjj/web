package me.majiajie.okhttp.f;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * OkHttp工具类
 */
public class OkHttpUtil
{
    private static OkHttpClient okHttpClient;

    private static final int TIME_OUT = 25_000;

    static
    {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .build();
        Dispatcher dispatcher = okHttpClient.dispatcher();
    }

    private OkHttpUtil() {}



}
