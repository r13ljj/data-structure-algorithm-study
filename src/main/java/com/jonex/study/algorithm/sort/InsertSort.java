package com.jonex.study.algorithm.sort;

/**
 * Created by xubai on 2018/01/17 上午1:02.
 * 1.插入排序
 * 2.希尔排序
 */
public class InsertSort {

    /**
     * 算法步骤：
     * 1）将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     * 2）从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
     */
    void insertSort(int[] a){
        int len = a.length;
        int i, j;
        int tmp;
        for(i=1; i<len; i++){
            tmp = a[i];
            for(j=i; (j > 0) && (a[j-1] > tmp); j--){
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    /**
     * 1）选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 2）按增量序列个数k，对序列进行k 趟排序；
     * 3）每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     */
    void shellSort(){

    }

}
