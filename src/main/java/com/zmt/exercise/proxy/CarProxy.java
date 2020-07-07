package com.zmt.exercise.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CarProxy implements InvocationHandler {
    private Object object;

    public CarProxy(Object object) {
        this.object = object;
    }

    public <E> E getProxy() {
        return (E) Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("顾客来到代理商，看中一台奔驰车并预定");
        Object result = method.invoke(object, args);
        System.out.println("预定时间到，顾客提车，代理商获得分成");
        return result;
    }
}
