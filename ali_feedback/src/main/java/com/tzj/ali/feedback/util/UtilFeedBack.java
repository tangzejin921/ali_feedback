package com.tzj.ali.feedback.util;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;

import org.json.JSONObject;

public class UtilFeedBack {
    public static void getUnreadCount(final IUnreadCountCallback callback){
        FeedbackAPI.getFeedbackUnreadCount(new com.alibaba.sdk.android.feedback.util.IUnreadCountCallback() {
            @Override
            public void onSuccess(int i) {
                callback.onSuccess(i);
            }
            @Override
            public void onError(int i, String s) {
                callback.onError(i,s);
            }
        });
    }

    public static void openActivity(JSONObject extInfo){
        FeedbackAPI.setAppExtInfo(extInfo);
        FeedbackAPI.openFeedbackActivity();
    }

    public interface IUnreadCountCallback {
        void onSuccess(int var1);
        void onError(int var1, String var2);
    }
}
