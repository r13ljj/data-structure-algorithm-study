package com.jonex.study.algorithm.sort;

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

    /**
     * 算法步骤：
     * 1 从数列中挑出一个元素，称为 “基准”（pivot），
     * 2 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * 3 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * 递归的最底部情形，是数列的大小是零或一，也就是永远都已经被排序好了。虽然一直递归下去，但是这个算法总会退出，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
     */
    void quickSort(int[] a, int low, int high){
        if(low > high){
            return;
        }
        int first = low;
        int last = high;
        int pivot = a[first];
        while (first < last){
            while(first < last && a[last] >= pivot){
                --last;
            }
            a[first] = a[last];/*将比第一个小的移到低端*/
            while(first < last && a[first] <= pivot){
                ++first;
            }
            a[last] = a[first];/*将比第一个大的移到高端*/
        }
        a[first] = pivot;/*枢轴记录到原位*/
        quickSort(a, low, first-1);
        quickSort(a, first+1, high);
    }



    public static void main(String[] args) {
        int[] a = {95, 45, 15, 78, 84, 51, 24, 12};
        SwapSort test = new SwapSort();
        //test.bubbleSort2(a);
        test.quickSort(a, 0, 7);
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }

}
