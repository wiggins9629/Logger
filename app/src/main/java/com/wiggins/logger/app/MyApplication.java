package com.wiggins.logger.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.wiggins.logger.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    public static Context mContext;
    private static List<Activity> activityList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        initLogger();
    }

    public static Context getContext() {
        return mContext;
    }

    private void initLogger() {
        Logger.init(Constant.LOG_TAG)            // 自定义日志TAG，默认TAG为PRETTYLOGGER
                .logLevel(LogLevel.FULL);        // NONE设置日志不输出，默认为FULL日志输出
    }

    /**
     * @Description 添加Activity到activityList，在onCreate()中调用
     */
    public static void addActivity(Activity activity) {
        if (activityList != null && activityList.size() > 0) {
            if (!activityList.contains(activity)) {
                activityList.add(activity);
            }
        } else {
            activityList.add(activity);
        }
    }

    /**
     * @Description 结束Activity到activityList，在onDestroy()中调用
     */
    public static void finishActivity(Activity activity) {
        if (activity != null && activityList != null && activityList.size() > 0) {
            activityList.remove(activity);
        }
    }

    /**
     * @Description 结束所有Activity
     */
    public static void finishAllActivity() {
        if (activityList != null && activityList.size() > 0) {
            for (Activity activity : activityList) {
                if (null != activity) {
                    activity.finish();
                }
            }
        }
        activityList.clear();
    }
}
