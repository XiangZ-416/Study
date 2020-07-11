package 左神算法进阶班;

/**
 * @Description: //TODO 数组中第K小的数
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/26 22:30
 */
public class Code_03_BFPRT {

    // 用堆：O(N*logK)
    public static int[] getMinKNumsByHeap(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i != k; i++) { // 数组前K个元素构建大根堆
            heapInsert(kHeap, arr[i], i);
        }
        for (int i = k; i != arr.length; i++) { // 将数组中K + 1到 arr.length - 1中小于大根堆顶的元素加入上面的大根堆
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }

    // 建堆
    public static void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]) {
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    // 调堆
    public static void heapify(int[] arr, int cur, int heapSize) {
        int left = cur * 2 + 1; // 左孩子
        int right = cur * 2 + 2; // 右孩子
        int largest = cur;
        while (left < heapSize) {
            if (arr[left] > arr[cur]) { // 左孩子和根节点谁大谁是largest
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) { // 右孩子（如果存在）和左孩子谁大谁是largest
                largest = right;
            }
            if (largest != cur) {
                swap(arr, largest, cur);
            } else {
                break;
            }
            cur = largest;
            left = cur * 2 + 1;
            right = cur * 2 + 2;
        }
    }

    // BFPRT：O(N)
    public static int[] getMinKNumsByBFPRT(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
        int minKth = getMinKthByBFPRT(arr, k);
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i != arr.length; i++) {
            if (arr[i] < minKth) {
                res[index++] = arr[i];
            }
        }
        for (; index != res.length; index++) {
            res[index] = minKth;
        }
        return res;
    }

    // 得到最小的第K个数
    public static int getMinKthByBFPRT(int[] arr, int K) {
        int[] copyArr = copyArray(arr);
        return bfprt(copyArr, 0, copyArr.length - 1, K - 1);
    }

    public static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i != res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // bfprt算法本体
    // 在begin、end上返回数组arr第i小的数
    public static int bfprt(int[] arr, int begin, int end, int i) {
        if (begin == end) {
            return arr[begin];
        }
        int pivot = medianOfMedians(arr, begin, end); // 在在begin、end范围返回中位数数组的中位数pivot作为划分值
        int[] pivotRange = partition(arr, begin, end, pivot); // 在在begin、end范围将数组arr划分<、=、>区域，返回等于区域的位置
        if (i >= pivotRange[0] && i <= pivotRange[1]) { // i在等于区域
            return arr[i];
        } else if (i < pivotRange[0]) { // i在小于区域。递归
            return bfprt(arr, begin, pivotRange[0] - 1, i);
        } else { // i在大于区域。递归
            return bfprt(arr, pivotRange[1] + 1, end, i);
        }
    }

    // 求中位数数组
    public static int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1; // arr长度
        int offset = num % 5 == 0 ? 0 : 1; // 数组arr如果是5的倍数，则不用补位。否则补一个长度。
        int[] mArr = new int[num / 5 + offset]; // 中位数数组mArr
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    public static int[] partition(int[] arr, int begin, int end, int pivotValue) {
        int small = begin - 1;
        int cur = begin;
        int big = end + 1;
        while (cur != big) {
            if (arr[cur] < pivotValue) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivotValue) {
                swap(arr, cur, --big);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        // 返回等于区域的起末
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }

    public static int getMedian(int[] arr, int begin, int end) {
        insertionSort(arr, begin, end);
        int sum = end + begin;
        int mid = (sum / 2) + (sum % 2);
        return arr[mid];
    }

    public static void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin + 1; i != end + 1; i++) {
            for (int j = i; j != begin; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9 };
        // sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
        printArray(getMinKNumsByHeap(arr, 10));
        printArray(getMinKNumsByBFPRT(arr, 10));

    }


}
