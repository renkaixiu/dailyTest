package com.ren.daliytest.testLuckyMoney;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by dongao on 2018/6/11.
 */
public class TestThread {
    public int a = 0;

    public int geta(){
        return ++a;
    }
    public void setA(int a){
        this.a = a;
    }
    public int gsA(){
        return ++a;
    }
    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        Thread thread1 = new Thread(){
            @Override
            public void run(){
               int a1 = testThread.gsA();
                testThread.setA(a1);
                System.out.println("thread1:"+a1);
            }
        };
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable创建线程");
            }
        });
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "callable创建线程";
            }
        });
        try {
            String result = future.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        thread1.start();
        thread2.start();
    }
}
