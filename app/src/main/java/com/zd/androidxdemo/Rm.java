package com.zd.androidxdemo;

import android.util.Log;

/**
 * @ClassName: Rm
 * @Description: 测试静态块 构造方法调用顺序
 * @Author: zhangdi
 * @Date: 20-12-24 下午3:28
 */
public class Rm {
    private static final String TAG = "zzzddd";
    static int a;
    static int b;

    private static final A sA = new A();
    private static final B sB = new B();

    private Rm() {
        a = 100;
        b = 99;
        Log.e(TAG, "a: " + a);
        Log.e(TAG, "b: " + b);
    }

    static {
        a = 100;
        b = 99;
        Log.e(TAG, "a: " + a);
        Log.e(TAG, "b: " + b);
        sA.a();
    }

    public static void tttt() {
        Log.e(TAG, "tttt-> a: " + a + ", b: " + b);
    }

    static class A {
        A() {
            Log.e(TAG, "A");
        }

        void a() {
            Log.e(TAG, "call A a");
        }
    }

    static class B {
        B() {
            Log.e(TAG, "B");
        }
    }
}
