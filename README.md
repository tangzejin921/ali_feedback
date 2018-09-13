# 阿里反馈
**这个会导致崩溃后回到上一界面**
## 网址
>https://help.aliyun.com/product/51341.html?spm=a2c4g.11174283.6.54.8BGHH9
## 导入SDK 
    implementation files('libs/BaiduLBS_Android.jar')

## 添加服务
    
## 权限
        
## 混淆
    -keep class com.taobao.** {*;}
    -keep class com.alibaba.** {*;}
    -dontwarn com.taobao.**
    -dontwarn com.alibaba.**
    -keep class com.ut.** {*;}
    -dontwarn com.ut.**
    -keep class com.ta.** {*;}
    -dontwarn com.ta.**