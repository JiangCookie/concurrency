package com.jyh.concurrency.example.singleton;

import com.jyh.concurrency.annoations.NotThreadSafe;

/**
 * 饿汉模式
 * 单例的实例类装载时进行创建
 * 安全的
 * @author JYH
 * 2018/10/27 11:44
 */
@NotThreadSafe
public class SingletonDemo2 {
    private SingletonDemo2(){

    }

    /**
     * 单例对象
     */
    private static SingletonDemo2 instance =  new SingletonDemo2();

    /**
     * 静态的工厂方法
     * @return
     */
    public static SingletonDemo2 getInstance(){

        return instance;
    }
}
