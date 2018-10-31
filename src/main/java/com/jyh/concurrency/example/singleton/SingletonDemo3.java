package com.jyh.concurrency.example.singleton;

import com.jyh.concurrency.annoations.NotThreadSafe;
import com.jyh.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式
 * 单例的实例在第一次使用时进行创建
 * 不安全的
 * @author JYH
 * 2018/10/27 11:44
 */
@ThreadSafe
public class SingletonDemo3 {
    private SingletonDemo3(){

    }

    /**
     * 单例对象
     */
    private static SingletonDemo3 instance =  null;

    /**
     * 静态的工厂方法
     * @return
     */
    public static synchronized SingletonDemo3 getInstance(){
        if(instance == null){
            instance = new SingletonDemo3();
        }
        return instance;
    }
}
