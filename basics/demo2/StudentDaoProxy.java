package com.algorithm.basics.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类必须与业务类实现同一个接口
 * 代理类通过这个接口知道 业务类的方法名
 */
public class StudentDaoProxy implements InvocationHandler {

    private Object object;

    public Object bind(Object object){
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader()
        ,object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("处理前操作");
        method.invoke(object,args);
        return result;
    }
}
