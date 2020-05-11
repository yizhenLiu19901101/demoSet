package interview;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSortDemo {
    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args){
        int[] numArray = {3,2,4,8,1};
        quickSort(numArray, 0, numArray.length - 1);
        Arrays.stream(numArray).distinct().forEach(System.out::println);
    }

    /**
     * 快速排序
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low > high){
            return;
        }
        i = low;
        j = high;
        // temp就是基准位
        temp = arr[low];
        //
        while (i < j) {
            // 先看右边，依次往左递减,找小于基准数字的位序
            while (temp <= arr[j] && i < j) {
                j--;
            }
            // 再看左边，依次往右递增，找大于基准数字的位序
            while (temp >= arr[i] && i < j) {
                i++;
            }
            // 如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        // 最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数
        quickSort(arr, j+1, high);
    }
}
