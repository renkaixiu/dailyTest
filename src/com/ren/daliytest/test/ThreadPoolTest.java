package com.ren.daliytest.test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dongao on 2018/10/10.
 * 线程池
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int j = 0; j < 10; j++) {
            final int t = j;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(30);
                        }catch (InterruptedException ex){
                           /* ex.printStackTrace();*/
                        }
                        System.out.println(Thread.currentThread().getName()+" is looping of "+i+" of task"+t);
                    }
                }
            });
        }
        threadPool.shutdownNow();
    }
}
