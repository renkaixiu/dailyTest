package com.ren.daliytest.testLuckyMoney;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dongao on 2018/4/24.
 */
public class testLuckyMoney {
    public int b=99;
    private static int x=100;
    //二倍均值法
    public static List<Double> getLuckyMoneyList(Double totalMoney,int totalPerson){
        List<Double> accountList = new ArrayList<Double>();
        Double restMoney = totalMoney;
        int restPerson = totalPerson;
        Random random = new Random();
        //循环每一个人，获得每个人得到的红包金额
        for (int i = 0; i <totalPerson-1 ; i++) {
            //每个人获得的随机金额
            Double money = Math.random()*(restMoney / restPerson*2)+0.01;
            accountList.add(money);
            restMoney -= money;
            restPerson--;
        }
        accountList.add(restMoney);
        return accountList;
    }

    public static void main(String[] args) {
        List<Double> aList = testLuckyMoney.getLuckyMoneyList(100.0,10);
        for (Double d:aList) {
            System.out.println("随机金额："+d);
        }

        testLuckyMoney hs1=new testLuckyMoney();
        hs1.x++;
        testLuckyMoney  hs2=new testLuckyMoney();
        hs2.x++;
        hs1=new testLuckyMoney();
        hs1.x++;
        testLuckyMoney.x--;
        System.out.println("x="+x);
    }

}
