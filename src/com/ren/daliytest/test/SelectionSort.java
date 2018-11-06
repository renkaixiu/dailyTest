package com.ren.daliytest.test;

/**
 * Created by dongao on 2018/10/25.
 */
public class SelectionSort {
    public void selection_sort(int[] source){
        int lenght = source.length;
        for (int i = 0; i < lenght; i++) {
            for (int j = i+1; j < lenght; j++) {
                if (source[i]>source[j]){
                    swap(source,i,j);
                }
            }
        }
    }
    public void swap(int[] source, int x, int y) {
        int temp = source[x];
        source[x] = source[y];
        source[y] = temp;
    }
}
