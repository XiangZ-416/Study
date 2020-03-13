package 左神算法初级班02;

import java.util.Arrays;

public class Code_11_HeapSort {
    /**
     * （大根）堆排序
     * @param arr 待排数组
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i); // 0-i之间形成大根堆
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    /**
     * 加堆：上移（捕获新的数进入大根堆中）
     * @param arr 待排数组
     * @param cur 当前位置
     */
    public static void heapInsert(int[] arr, int cur) {
        // 父位置（index - 1) / 2
        while (arr[cur] > arr[(cur - 1) / 2]) {
            swap(arr, cur, (cur - 1) / 2);
            // 当前位置挪到当前位置的父位置处继续判断
            cur = (cur - 1) / 2;
        }
    }

    /**
     * 减堆：下沉（去掉大根堆中已有的数，剩下的还要是大根堆）
     * @param Arr 剩下的数组
     * @param Cur 当前位置
     * @param size 剩下数组的长度，size <= arr.length()
     */
    public static void heapify(int[] Arr, int Cur, int size) {
        int left = Cur * 2 + 1;
        // 判断当前位置的左孩子有没有越右边界
        while (left < size) {
            // 左孩子和右孩子(不越右边界)谁大，谁的下标就是largest
            int largest = left + 1 < size && Arr[left + 1] > Arr[left]
                    ? left + 1
                    : left;
            // 左右孩子的最大值和当前位置谁大，谁就是largest
            largest = Arr[largest] > Arr[Cur]
                    ? largest
                    : Cur;
            // 如果当前位置和左右孩子相比，最大值是当前位置，则当前位置不用向下沉
            if (largest == Cur) {
                break;
            }
            // 否则将当前位置元素和largest位置元素交换
            swap(Arr, largest, Cur);
            // 将当前位置挪到largest位置处，即当前位置向下沉
            Cur = largest;
            // 继续寻找当前位置的左孩子
            left = Cur * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 5, 2};
        heapSort(arr);
        System.out.print(Arrays.toString(arr));
    }
}