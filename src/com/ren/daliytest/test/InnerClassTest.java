package com.ren.daliytest.test;

/**
 * Created by dongao on 2018/10/10.
 * 内部类
 */
public class InnerClassTest {
    public int normalVar = 0;
    public static int staticVar = 0;

//方法外部定义的内部类
    class InnerClass{
        /*public  static int innerVar = 0;*/
        public final  static int finalinnerVar = 0;
         public void method(){
             normalVar = 1;
             staticVar = 1;
             System.out.println("normalVar = "+normalVar+" staticVar="+staticVar);
         }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClassTest().new InnerClass();
        innerClass.method();
    }

    //方法内部定义的内部类
    public void outMethod(){
         int outMethodVar = 0;
         class outMethodInnerClass{
             int a = 0;
             final static int b = 0;
            public void outMethodInnerClassMethod(){
                normalVar = 2;
                staticVar = 2;
                int a = outMethodVar;
            }
        }
    }

    //静态内部类

    static class StaticInnerClass{
        int a = 0;
        static int  b = 0;
        public void staticInnerClassMerhod(){
            staticVar = 3;
            InnerClassTest innerClassTest = new InnerClassTest();
            innerClassTest.normalVar = 3;
        }
    }

    //匿名内部类
    public void start(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        }){
            int a = 0;
            final static int b = 0;

        }.start();
    }
}
