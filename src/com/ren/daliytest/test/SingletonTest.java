package com.ren.daliytest.test;

/**
 * Created by dongao on 2018/9/27.
 * 单例模式
 */
public class SingletonTest {


    private SingletonTest(){};

    //懒汉式，线程不安全
    private static SingletonTest singletonTest1;

    public static SingletonTest getSingleton1(){
        if (singletonTest1 == null){
            singletonTest1 = new SingletonTest();
        }
        return singletonTest1;
    }

    //懒汉式，线程安全
    private static SingletonTest singletonTest2;

    public static synchronized SingletonTest getSingleton(){
        if (null != singletonTest2){
            singletonTest2 = new SingletonTest();
        }
        return singletonTest2;
    }

    //饿汉式
    private static SingletonTest singletonTest3 = new SingletonTest();

    public static SingletonTest getSingleton3(){
        return singletonTest3;
    }

    //双检锁

    private static volatile SingletonTest singletonTest4;

    public static SingletonTest getSingleton4(){
       if (singletonTest4 == null){
           synchronized (SingletonTest.class){
               if (singletonTest4 == null){
                   singletonTest4 = new SingletonTest();
               }
           }
       }
       return singletonTest4;
    }


}
