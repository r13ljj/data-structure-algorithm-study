package com.jonex.study.algorithm.sort;

/**
 * Created by xubai on 2018/01/17 上午12:28.
 * 1.归并排序
 *
 */
public class MergeSort {

    /**
     * 算法步骤：
     * 1. 申请空间，使其大小为两个已知排序序列之和，该空间用来存放合并后的序列
     * 2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置
     * 3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     * 4. 重复步骤3直到某一指针达到序列尾
     * 5. 将另一序列剩下的所有元素直接复制到合并序列尾
     */
    void mergeSort(int[] sourceArr, int[] tempArr, int startIndex, int endIndex){
        int middleIndex;
        if(startIndex < endIndex){
            middleIndex = (startIndex + endIndex) / 2;
            mergeSort(sourceArr, tempArr, startIndex, middleIndex);
            mergeSort(sourceArr, tempArr, middleIndex+1, endIndex);
            int i = startIndex, j=middleIndex+1, k = startIndex;
            while(i != middleIndex + 1 && j != endIndex + 1)
            {
                if(sourceArr[i] >= sourceArr[j]) {
                    tempArr[k++] = sourceArr[j++];
                }else{
                    tempArr[k++] = sourceArr[i++];
                }
            }
            while(i != middleIndex+1){
                tempArr[k++] = sourceArr[i++];
            }
            while(j != endIndex+1){
                tempArr[k++] = sourceArr[j++];
            }
            for(i = startIndex; i <= endIndex; i++){
                sourceArr[i] = tempArr[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {50, 10, 20, 30, 70, 40, 80, 60};
        int[] b = new int[8];
        MergeSort test = new MergeSort();
        test.mergeSort(a, b, 0, 7);
        for(int i=0; i<8; i++) {
            System.out.println(String.format("%d", a[i]));
        }
    }

}
