package com.huaru.baselibrary.utils;

import android.os.Environment;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.LogcatLogStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangjianhao on 2018/7/9.
 */

public class LoggerHelper {
    private static volatile LoggerHelper instance;

    public static LoggerHelper getInstance() {
        synchronized (LoggerHelper.class) {
            if (instance == null) {
                return new LoggerHelper();
            }
        }
        return instance;
    }

    private LoggerHelper() {

    }

    public void init() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
                .logStrategy(new LogcatLogStrategy()) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("ZJH TAG")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    /**
     * 打印数组
     *
     * @param content
     * @param <T>
     * @return
     */
    public static <T extends Object> LoggerHelper d(T content) {
        Logger.d(content);
        return instance;
    }

    public static <T extends Object> LoggerHelper d(String title, T content) {
        Logger.t(title).d(content);
        return instance;
    }

    public static LoggerHelper e(String message) {
        Logger.e(message);
        return instance;
    }

    public static LoggerHelper e(String tag, String message) {
        Logger.t(tag).e(message);
        return instance;
    }

    public static LoggerHelper e(String tag, boolean message) {
        Logger.t(tag).e(message + "");
        return instance;
    }

    public static LoggerHelper w(String message) {
        Logger.w(message);
        return instance;
    }

    public static LoggerHelper v(String message) {
        Logger.v(message);
        return instance;
    }

    public static LoggerHelper i(String message) {
        Logger.i(message);
        return instance;
    }

    public static LoggerHelper i(String title, String message) {
        Logger.t(title).i(message);
        return instance;
    }

    public static LoggerHelper wtf(String message) {
        Logger.wtf(message);
        return instance;
    }

    public static LoggerHelper json(String json) {
        Logger.json(json);
        return instance;
    }

    public static LoggerHelper xml(String xml) {
        Logger.xml(xml);
        return instance;
    }

    public static void file(String fileContent) {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fileName = sdf.format(new Date());
                File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "EBookReader" + File.separator + "fileCrash");
                Log.i("CrashHandler", dir.toString());
                if (!dir.exists()) {
                    dir.mkdir();
                    FileOutputStream fos = new FileOutputStream(new File(dir,
                            fileName));
                    fos.write(fileContent.toString().getBytes());
                    fos.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class CustomeStrategy extends LogcatLogStrategy {
        public CustomeStrategy() {
            super();
        }

        @Override
        public void log(int priority, String tag, String message) {
            super.log(priority, tag, message);
        }
    }
}
