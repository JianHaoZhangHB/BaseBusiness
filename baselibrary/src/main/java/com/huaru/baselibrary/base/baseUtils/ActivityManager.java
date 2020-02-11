package com.huaru.baselibrary.base.baseUtils;

import android.app.Activity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 管理activity的类,退出app的时候统一处理所有的activity
 * Created by zhangjianhao on 2018/5/8.
 */

public class ActivityManager {
    private static List<Activity> activityList = new LinkedList<>();

    public static List<Activity> getActivityList() {
        if (activityList == null) {
            return new LinkedList<>();
        }
        return activityList;
    }

    public static void addActivity(Activity currActivity) {
        activityList.add(currActivity);
    }

    public static void removeActivity(Activity removeActivity) {
        if (activityList != null) {
            activityList.remove(removeActivity);
        }

    }

    public static void finishAll(){
        for (Activity activity : activityList) {
            activity.finish();
        }
    }
    public static void finishElse(Activity activity){
        activityList.remove(activity);
        for (Activity activity1 : activityList) {
            activity1.finish();
        }
    }
    public static void finishLast(Class last) {
        Iterator<Activity> iterator = activityList.iterator();
        if (iterator.hasNext()) {

        } else {
            System.exit(0);
        }
    }

    public static void exitApp() {
        Iterator<Activity> iterator = activityList.iterator();
        if (iterator.hasNext()) {
            iterator.next().finish();
        } else {
            activityList.clear();
            activityList = null;
            android.os.Process.killProcess(android.os.Process.myPid());
        }

    }
}
