package com.jyh.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * @author JYH
 * 2018/10/26 20:48
 */
public class RacerWithCountDownLatch {
    public static class Racer extends Thread{
        CountDownLatch latch;
        public Racer(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public void run(){
            try {
                this.latch.await();
                System.out.println(getName() + "start run" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        CountDownLatch latch = new CountDownLatch(1);
        Thread[] racers = new Thread[num];
        for (int i = 0; i < num; i++) {
            racers[i] = new Racer(latch);
            racers[i].start();
        }
        Thread.sleep(1000);
        latch.countDown();
    }
}
