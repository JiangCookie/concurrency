package com.jyh.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JYH
 * 2018/10/27 9:42
 */
@Slf4j
public class SyncDemo2 {
    /**
     * 修饰一个类
     */
    public static void test1(){
        synchronized (SyncDemo2.class){
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {}" + i);
            }
        }
    }

    /**
     * 修饰一个静态方法
     */
    public static synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}" +j, i);
        }
    }

    public static void main(String[] args) {
        SyncDemo2 syncDemo1 = new SyncDemo2();
        SyncDemo2 syncDemo2 = new SyncDemo2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            SyncDemo2.test2(1);
        });

        executorService.execute(() -> {
            SyncDemo2.test2(2);
        });
    }
}
