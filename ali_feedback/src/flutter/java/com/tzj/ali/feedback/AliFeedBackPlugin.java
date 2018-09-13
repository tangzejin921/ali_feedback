package com.tzj.ali.feedback;

import android.app.Activity;

import com.tzj.ali.feedback.util.UtilFeedBack;

import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import io.flutter.plugin.common.JSONUtil;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** AliPayPlugin */
public class AliFeedBackPlugin implements MethodCallHandler {
  private final WeakReference<Activity> mActivityWeak;
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), AliFeedBackPlugin.class.getSimpleName());
    channel.setMethodCallHandler(new AliFeedBackPlugin(registrar.activity()));
  }

  public AliFeedBackPlugin(Activity mActivity) {
    this.mActivityWeak = new WeakReference<Activity>(mActivity);
  }

  @Override
  public void onMethodCall(MethodCall call, final Result result) {
    if(call.method.equals("open")){
      HashMap<String, String> extInfo = call.arguments();
      JSONObject js = new JSONObject(extInfo);
      UtilFeedBack.openActivity(js);
      result.success(null);
    }else if(call.method.equals("getUnreadCount")){
      UtilFeedBack.getUnreadCount(new UtilFeedBack.IUnreadCountCallback(){
        @Override
        public void onSuccess(int var1) {
          result.success(var1);
        }
        @Override
        public void onError(int var1, String var2) {
          result.error(var1+"",var2,null);
        }
      });
    } else {
      result.notImplemented();
    }
  }
}
