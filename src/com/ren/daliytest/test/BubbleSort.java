package com.ren.daliytest.test;

/**
 * Created by dongao on 2018/10/25.
 */
public class BubbleSort {
    /**
     * 冒泡排序
     *实现了双层循环，内层循环将相邻两个数进行两两比较，
     * 将最大的一个数以冒泡（两两交换）的形式传送最队尾，
     * 一次只能将一个最大值传送到队尾；
     * 而外层循环实现了依次将当前最大值传送，最终实现排序；
     * @param source
     */
    public void bubble_sort(int[] source) {
        int length = source.length;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (source[j] > source[j + 1]) {
                    swap(source, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {//如果没有交换过数据，说明已经排好了，不需要再继续循环
                break;
            }
        }
    }

    public void swap(int[] source, int x, int y) {
        int temp = source[x];
        source[x] = source[y];
        source[y] = temp;
    }

    public static void main(String[] args) {
        int[] source = {2, 9, 8, 1, 0, 7, 4};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubble_sort(source);
        for (int i = 0; i < source.length; i++) {
            System.out.println(source[i]);
        }
    }
}
