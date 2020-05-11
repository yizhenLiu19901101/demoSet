package interview;

import java.util.Arrays;

/**
 * 堆排序演示（从小到大排序）
 * 堆的定义：n个关键字序列array[0，...，n-1]，当且仅当满足下列要求：(0 <= i <= (n-1)/2)
 ① array[i] <= array[2*i + 1] 且 array[i] <= array[2*i + 2]； 称为小根堆；
 ② array[i] >= array[2*i + 1] 且 array[i] >= array[2*i + 2]； 称为大根堆；
 * @author milo
 */
public class HeapSort {
    /**
     * 主程序
     * @param args
     */
    public static void main(String[] args) {
        int[] numArray = {16, 7, 3, 20, 17, 8};
        heapSort(numArray);
        Arrays.stream(numArray)
                .distinct()
                  .forEach(System.out::println);
    }


    /**
     * 创建堆，
     * @param arr 待排序列
     */
    private static void heapSort(int[] arr) {
        //创建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            // 从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //重新对堆进行调整
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整堆
     * @param arr 待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void adjustHeap(int[] arr, int parent, int length) {
        //将temp作为父节点
        int temp = arr[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }
            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[lChild]) {
                break;
            }
            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];
            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }
}