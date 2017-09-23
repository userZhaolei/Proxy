package com.zl.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * create user zhaolei  代码无bug
 * 时间:2017/9/18
 */

public class PersonHanlder implements InvocationHandler {
    public Object object;

    public PersonHanlder(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Log.e("aaaa", "before");
        Object invoke = method.invoke(o, objects);
        Log.e("aaaa", "after");
        return invoke;
    }
}
