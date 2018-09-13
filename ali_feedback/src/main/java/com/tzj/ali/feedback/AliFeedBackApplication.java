package com.tzj.ali.feedback;

import android.app.Application;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;

public class AliFeedBackApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        init(this,"24949747","c006e90915738ac8bae113b45f92318c");
    }


    public static void init(Application application,String appkey,String appSecret){
        FeedbackAPI.init(application, appkey,appSecret);
    }
}
