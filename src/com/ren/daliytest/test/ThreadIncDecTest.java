package com.ren.daliytest.test;

/**
 * Created by dongao on 2018/9/30.
 * 设计 4 个线程，其中两个线程每次对 j 增加 1，另外两个线程对 j 每次减少1
 */
public class ThreadIncDecTest {
    public static void main(String[] args) {
        ThreadIncDecTest mydata = new ThreadIncDecTest();
        for (int i = 0; i < 2; i++) {
            new Thread(mydata.new MyIncThread()).start();
            new Thread(mydata.new MyDescThread()).start();
        }
    }
    class MyIncThread implements Runnable{
        @Override
        public void run() {
            increment();
        }
    }
     class MyDescThread implements Runnable{
        @Override
        public void run() {
           descrement();
        }
    }

        private int j = 100;
        public synchronized void increment(){
            j++;
            System.out.println("j++ = "+j);
        }
        public synchronized void descrement(){
            j--;
            System.out.println("j-- = "+j);

    }
}
