package 左神算法初级班02;
/*
 * 逻辑：
 * 全部排成大根堆heapInsert
 * 交换
 * 去尾巴
 * 调整heapify
 * 交换
 * 去尾巴
 * ....
 * 数组长度 < 0 停止;
 */

import java.util.Arrays;

public class Code_12_HeapSort_Zx {
    public static void HeapSort(int[] arr){
        if (arr.length < 2 || arr == null) {
            return;
        }

        for (int i = 0; i < arr.length; i++ ) {
            heapInsert(arr, i); // 0-i之间实现大根堆
        }

        int r = arr.length - 1; // 数组右边界
        Swap(arr, 0, r);
        r = r - 1; // 数组右边界 - 1
        while (r >= 0) { // 数组长度大于0
            heapify(arr, 0, r);
            Swap(arr, 0, r);
            r = r - 1;
        }

    }

    // 向上
    public static void heapInsert(int[] Arr, int cur) {
        int father = (cur - 1) / 2;
        while (Arr[cur] > Arr[father]) {
            Swap(Arr, cur, father);
            cur = father;
        }
    }

    // 向下
    public static void heapify(int[] ARR, int Cur, int size) {
        int left = 2 * Cur + 1;
        while (left < size){
            int right = left + 1;
            // 找出左、右、父最大值的下标
            int largest = ARR[left] > ARR[right] && right < size ? left : right;
            largest = ARR[largest] > ARR[Cur] ? largest : Cur;
            if (largest == Cur) {
                break;
            }
            Swap(ARR, Cur, largest);
            Cur = largest; // 当前位置下沉
            left = 2 * Cur + 1;
        }
    }

    public static void Swap(int[] Arr, int i, int j) {
        int temp = Arr[j];
        Arr[j] = Arr[i];
        Arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 5, 2};
        HeapSort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
