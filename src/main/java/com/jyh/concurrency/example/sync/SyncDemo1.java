package com.jyh.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JYH
 * 2018/10/27 9:42
 */
@Slf4j
public class SyncDemo1 {
    /**
     * 修饰一个代码块
     */
    public void test1(){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {}" + i);
            }
        }
    }

    /**
     * 修饰一个方法
     */
    public synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}" +j, i);
        }
    }

    public static void main(String[] args) {
        SyncDemo1 syncDemo1 = new SyncDemo1();
        SyncDemo1 syncDemo2 = new SyncDemo1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            syncDemo1.test2(1);
        });

        executorService.execute(() -> {
            syncDemo2.test2(2);
        });
    }
}
