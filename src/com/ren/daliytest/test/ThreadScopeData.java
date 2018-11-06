package com.ren.daliytest.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dongao on 2018/9/28.
 * 线程范围内的数据
 */
public class ThreadScopeData extends Date {
    public static int data = 0;
    public int i = 0;
    static Map<Thread,Integer> threadMap = new HashMap<Thread,Integer>();
    static class a{
        ThreadScopeData s = new ThreadScopeData();

        public static void A(){
            System.out.println("data of thread"+Thread.currentThread()+threadMap.get(Thread.currentThread()));
        }
    }
    static class b{
        public static void B(){
            System.out.println("data of thread"+Thread.currentThread()+threadMap.get(Thread.currentThread()));
        }
    }

    public static void main(String[] args) {

        System.out.println(new ThreadScopeData().test());
        for (int i = 0; i < 2; i++) {
            new Thread(){
                @Override
                public void run() {
                    data = (int)(1+Math.random()*1000);
                    threadMap.put(Thread.currentThread(),data);
                    a.A();
                    b.B();
                }
            }.start();
        }

    }


        public int test(){
            int x = 1;
            try
            {
                return 1;
            }
            finally
            {
                return 2;
            }
        }

}
