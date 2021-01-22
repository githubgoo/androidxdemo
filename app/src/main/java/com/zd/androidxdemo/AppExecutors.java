package com.zd.androidxdemo;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @ClassName: AppExecutors
 * @Description:
 * @Author: zhangdi
 * @Date: 20-12-28 上午10:50
 */
public class AppExecutors {
    private final Executor mDiskIO;
    private final Executor mNetworkIO;
    private final Executor mMainThread;
    private static AppExecutors sInstance;

    private AppExecutors() {
        mDiskIO = Executors.newSingleThreadExecutor();
        mNetworkIO = Executors.newFixedThreadPool(4);
        mMainThread = new MainThreadExecutor();
    }

    public static AppExecutors getInstance() {
        if (sInstance == null) {
            synchronized (AppExecutors.class) {
                if (sInstance == null) {
                    sInstance = new AppExecutors();
                }
            }
        }
        return sInstance;
    }

    public Executor getDiskIO() {
        return mDiskIO;
    }

    public Executor getNetworkIO() {
        return mNetworkIO;
    }

    public Executor getMainThread() {
        return mMainThread;
    }

    private static class MainThreadExecutor implements Executor {
        private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
