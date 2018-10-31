package com.jyh.concurrency.example.singleton;

import com.jyh.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉模式  --> 双重同步锁单例模式
 * 单例的实例在第一次使用时进行创建
 * 不安全的
 * @author JYH
 * 2018/10/27 11:44
 */
@NotThreadSafe
public class SingletonDemo4 {
    private SingletonDemo4(){

    }

    /**
     * 单例对象
     */
    private static SingletonDemo4 instance =  null;

    /**
     * 静态的工厂方法
     *
     * 1.memory = allocate 分配对象的内存空间
     * 2. ctroInstance 初始化对象
     * 3. instance = memory 设置instance指向刚分配的内存
     * @return
     */
    public static SingletonDemo4 getInstance(){

        if(instance == null){
            synchronized (SingletonDemo4.class){
                if(instance == null){
                    instance = new SingletonDemo4();
                }
            }

        }
        return instance;
    }
}
