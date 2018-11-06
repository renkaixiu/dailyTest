package com.ren.daliytest.test;

/**
 * Created by dongao on 2018/9/27.
 * 子线程循环 10 次，接着主线程循环 100，接着又回到子线程循环 10 次，接着再回到主线程又循环 100，如此循环 50 次，请写出程序
 */
public class ThreadTest {
    public static void main(String[] args) {
        Bussines bussines = new ThreadTest().new Bussines();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    bussines.sub(i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("dxsd");
            }
        }).start();
        for (int i = 0; i < 5; i++) {
            bussines.main(i);
        }
    }
    public class Bussines{

         boolean flag = true;

        public synchronized void sub(int k){
                while (!flag){
                    try {
                        this.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 10 ; i++) {
                    System.out.println("sub thread of"+i+",loop of"+k);
                }
                flag = false;
                this.notify();

               abstract class methodInner{;
                   int a = 0;
                   abstract void a();
            }
        }

        public synchronized void main(int k){
                while (flag){
                    try {
                        this.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 20 ; i++) {
                    System.out.println("main thread of"+i+",loop of"+k);
                }
                flag = true;
                this.notify();
        }
    }
}
