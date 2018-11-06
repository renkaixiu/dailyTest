package com.ren.daliytest.testLuckyMoney;

import org.omg.CORBA.INTERNAL;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dongao on 2018/5/10.
 */
public class test {
    static final int N = 50000;

    private String[] status = {"AL","AK"};

    public String[] getStatus(){
        return status;
    }

    static long timeList(List list) {
        long start = System.currentTimeMillis();
        Object o = new Object();
        for (int i = 0; i < N; i++) {
            list.add(i, o);
        }
        return System.currentTimeMillis() - start;
    }

    static long readList(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0, j = list.size(); i < j; i++) {

        }
        return System.currentTimeMillis() - start;
    }

    static List addList(List list) {
        Object o = new Object();
        for (int i = 0; i < N; i++) {
            list.add(i, o);
        }
        return list;
    }

    public void test1(int a){
        a=++a;
        System.out.println("a0="+a);
    }

    public void test2(testLuckyMoney obj){
        obj = new testLuckyMoney();
        obj.b = 100;
        System.out.println("b0="+obj.b);
    }

    public static void main(String[] args) throws Exception {
       /* ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        System.out.println(list.indexOf("1"));
        System.out.println(list.lastIndexOf("1"));
        System.out.println(list.get(0));
        String s = list.set(0,"1111");
        System.out.println("s:"+s);
        System.out.println(list.get(0));*/
      /* int iten = 10;
       long lten = 10l;
       double dten = 10.0;
        System.out.println(iten == lten);
        System.out.println(iten == dten);
        System.out.println(dten == lten);

        String a = "ab";
        String b = "a"+"b";
        System.out.println(a == b);*/

/*      ArrayList<String> arrayList = new ArrayList<String>();
      arrayList.add("1");
      arrayList.add("2");
      arrayList.add("3");
      LinkedList<String> linkedList = new LinkedList<String>();
      linkedList.add("1");
      linkedList.add("2");
      linkedList.add("3");
      long startTime1=System.nanoTime();
      arrayList.add(2,"123");
      long endTime1=System.nanoTime(); //获取结束时间
      System.out.println("ArrayList程序运行时间： "+(endTime1-startTime1)+"ns");
      long startTime2=System.nanoTime();
     *//* linkedList.add(1,"123");*//*
      long endTime2=System.nanoTime(); //获取结束时间
      System.out.println("LinkedList程序运行时间： "+(endTime2-startTime2)+"ns");
        System.out.println(linkedList.remove());*/


/*        System.out.println("ArrayList添加" + N + "条耗时：" + timeList(new ArrayList()));
        System.out.println("LinkedList添加" + N + "条耗时：" + timeList(new LinkedList()));

        List list1 = addList(new ArrayList<>());
        List list2 = addList(new LinkedList<>());
        System.out.println("ArrayList查找" + N + "条耗时：" + readList(list1));
        System.out.println("LinkedList查找" + N + "条耗时：" + readList(list2));*/


 /*       Class c = Class.forName("com.ren.daliytest.testLuckyMoney.test");
        Object obj = c.newInstance();
        Field field = c.getDeclaredField("status");
        field.set(obj,new String[]{"12345"});
        test test = (test)obj;
        String[] styArr = test.getStatus();

        Map<String,Object> map = new HashMap<String,Object>();

        Map map1 = new Hashtable();
        map.put("as","dwe");
        map.containsKey("as");
        System.out.println(map1.containsKey("dwe"));
        for (Map.Entry e : map.entrySet()){

        }

        Map conMap = new ConcurrentHashMap();
        conMap.put("1",1);
        conMap.put("2",2);
        conMap.put("3",3);
        System.out.println();*/

       /* test t = new test();
        int a=99;
        t.test1(a);//这里传递的参数a就是按值传递
        System.out.println("a="+a);

        testLuckyMoney obj=new testLuckyMoney();
        t.test2(obj);//这里传递的参数obj就是引用传递
        System.out.println("b="+obj.b);*/

    /*   List<Integer> list = new ArrayList<Integer>();
       list.add(1);
       list.add(3);
       list.add(2);
       int a = list.indexOf(3);
        Collections.sort(list);
        System.out.println("a="+a);
        System.out.println(list.indexOf(3));*/

      /*  System.out.println(Integer.MAX_VALUE*6);*/
     /*   File file = new File("D:\\工作文档");
        String[] names = file.list();*/

      /*  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("D:\\BugReport.txt")));
        bufferedWriter.write("hi\nhello");
        bufferedWriter.close();

        FileReader fin = new FileReader(new File("D:\\BugReport.txt"));
        BufferedReader bufferedReader = new BufferedReader(fin);
        String s = "";
        while ((s=bufferedReader.readLine()) != null){
            System.out.println(s);
        }
        bufferedReader.close();*/

        /*int i = 3,j = 2;
        System.out.println(++i+j);
        System.out.println(i+++j);*/

       /* System.out.println(new BigDecimal(1/3.0).multiply(new BigDecimal(100)));*/

        change(8000);

    }

    public static void change(int second){
        int h = 0;
        int d = 0;
        int temp = second%3600;
        if(second > 3600){//满一个小时
            h= second/3600;//小时
            if(temp!=0){
                if(temp>60){//超过60秒
                    d = temp/60;//分钟
                }
                System.out.println(h+"小时"+d+"分钟");
            }
            System.out.println(h+"小时");
        }else{//不满一个小时
            d = second/60;
            System.out.println(d+"分钟");
        }

    }
}
