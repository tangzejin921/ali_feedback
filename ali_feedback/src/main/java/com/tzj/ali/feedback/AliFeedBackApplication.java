package com.tzj.ali.feedback;

import android.app.Application;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;

public class AliFeedBackApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        init(this,getString(R.string.aliyun_key),getString(R.string.aliyun_secret));
    }


    public static void init(Application application,String appkey,String appSecret){
        FeedbackAPI.init(application, appkey,appSecret);
    }
}
