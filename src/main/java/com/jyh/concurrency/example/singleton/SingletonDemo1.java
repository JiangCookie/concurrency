package com.jyh.concurrency.example.singleton;

import com.jyh.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉模式
 * 单例的实例在第一次使用时进行创建
 * 不安全的
 * @author JYH
 * 2018/10/27 11:44
 */
@NotThreadSafe
public class SingletonDemo1 {
    private SingletonDemo1(){

    }

    /**
     * 单例对象
     */
    private static SingletonDemo1 instance =  null;

    /**
     * 静态的工厂方法
     * @return
     */
    public static SingletonDemo1 getInstance(){
        if(instance == null){
            instance = new SingletonDemo1();
        }
        return instance;
    }
}
