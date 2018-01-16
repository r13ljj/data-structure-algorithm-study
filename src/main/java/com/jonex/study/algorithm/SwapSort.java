package com.jonex.study.algorithm;

/**
 * Created by xubai on 2018/01/16 下午7:26.
 *
 * 1.快速排序
 * 2.冒泡排序
 */
public class SwapSort {

    /**
     * 算法步骤：
     * 1）比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2）对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 3）针对所有的元素重复以上的步骤，除了最后一个。
     * 4）持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */
    void bubbleSort(int[] a){
        int i, j, temp;
        int len = a.length;
        for(i=0; i<len-1; i++){
            for(j=len-1; j>0; j--){
                if (a[j] < a[j-1]){
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
                System.out.println("i:"+i+" j:"+j);
            }
        }
    }
    void bubbleSort1(int[] a){
        int len = a.length;
        int i = len-1;
        while(i > 0){
            //每趟开始时,无记录交换
            int pos = 0;
            for(int j=0; j<i; j++){
                if(a[j] > a[j+1]){
                    pos = j;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
                System.out.println("j:"+j+" pos:"+pos);
            }
            //为下一趟排序作准备
            i = pos;
        }
    }
    void bubbleSort2(int[] a){
        int low = 0;
        int high = a.length - 1;
        int tmp, i;
        while(low < high){
            for(i=low; i<high; ++i){//正向冒泡,找到最大者
                if(a[i] > a[i+1]){
                    tmp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = tmp;
                }
                --high;//修改high值, 前移一位
                for(i=high; i>low; --i){//反向冒泡,找到最小者
                    if(a[i] < a[i-1]){
                        tmp = a[i];
                        a[i] = a[i-1];
                        a[i-1] = tmp;
                    }
                    ++low;//修改low值,后移一位
                }
            }
        }
    }

    void quickSort(int[] a, int low, int high){

    }



    public static void main(String[] args) {
        int[] a = {95, 45, 15, 78, 84, 51, 24, 12};
        SwapSort test = new SwapSort();
        test.bubbleSort2(a);
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }

}
