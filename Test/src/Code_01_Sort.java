/**
 * @Description: //TODO 各种排序算法
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/4 14:48
 */
public class Code_01_Sort {

    //交换两个元素
    private static void swap(int[] arr, int i, int j) {
        int help = arr[i];
        arr[i] = arr[j];
        arr[j] = help;
    }

    /**
     * @Description //TODO 冒泡排序：时间复杂度O(N^2)，额外空间复杂度O(1)
     * @Author ZX
     * @Date 12:17 2020/6/7
     * @Param [arr]
     **/
    public static void bubbleSort(int[] arr) {
        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) { // 每次规定一个范围，找出该范围最大的数放到最后
            for (int j = 0; j < i; j++) { // 逐个比较相邻的两个元素
                if (arr[j] > arr[j + 1]) { // 前一个数大于后一个数，交换
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * @Description //TODO 选择排序：时间复杂度O(N^2)，额外空间复杂度O(1)
     * 在0 - n-1找一个最小的数，放到0位置；在1 - n-1找一个最小的数放到1位置；....
     * @Author ZX
     * @Date 12:17 2020/6/7
     * @Param [arr]
     **/
    public static void selectSort(int[] arr) {
        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * @Description //TODO 插入排序：
     *                          最好情况（数组有序）：时间复杂度O(N)
     *                          数组无序（最差情况）：时间复杂度O(N^2) 选最差的为此算法的复杂度
     *                          额外空间复杂度O(1)
     * @Author ZX
     * @Date 12:16 2020/6/7
     * @Param [arr]
     **/
    public static void insertSort(int[] arr) {
        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                    swap(arr, j, j + 1);
            }
        }

    }

    /**
     * @Description //TODO 归并排序：时间复杂度O(N*logN)，额外空间复杂度O(N)
     * @Author ZX
     * @Date 12:16 2020/6/7
     * @Param [arr]
     **/
    public static void mergeSort(int[] arr) {
        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        // 计算L和R的中点
        int mid = (L + R) / 2;
        // L ~ mid排好
        sortProcess(arr, L, mid);
        // mid+1 ~ R排好
        sortProcess(arr, mid + 1, R);

        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        // 创建辅助数组
        int[] help = new int[r - l + 1];
        // 创建两个指针，分别遍历左边排好的数组和右边排好的数组
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        // 左右两个排好的数组必定有且只有一个没有全部拷贝到help中
        // 如左边没拷贝完
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        // 如果右边没拷贝完
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        //将辅助数组help的元素拷贝回原数组arr
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

    }

    /**
     * @Description //TODO 快速排序：与数据状况有关
     * @Author ZX
     * @Date 12:16 2020/6/7
     * @Param [arr, L, R]
     **/
    public static void quickSort(int[] arr, int L, int R) {
        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        int[] equal = partition(arr, L, R);
        int l = equal[0];
        int r = equal[1];
        partition(arr, L, l);
        partition(arr, r, R);

    }

    private static int[] partition(int[] arr, int l, int r) {

        int less = l - 1;
        int more = r; // more不用加1，因为以最后一个数为参考来比较，假定最后一个数包括在more区域
        int cur = l;

        while (cur < more) {
            if (arr[cur] < arr[r]) {
                swap(arr, cur, less + 1);
                less++;
                cur++;
            } else if (arr[cur] == arr[r]) {
                cur++;
            } else {
                swap(arr, cur, more - 1);
                more--;
            }
        }
        swap(arr, more, r); // 将more区域的第一个数与数组中最后一个数交换。因为arr[r]是参考，也是等于arr[r]的数，让其归位
        return new int[]{less, more};
    }

    /**
     * @Description //TODO 随机快排：长期期望时间复杂度为O(N*logN)
     * @Author ZX
     * @Date 12:23 2020/6/7
     * @Param [arr, L, R]
     **/
    public static void randomQuickSort(int[] arr, int L, int R) {
        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        swap(arr, (int) (L + (Math.random() * (R - L + 1))), R); // 在arr中随机选一个数作为比较对象

        int[] partition1 = partition(arr, L, R);
        int l = partition1[0];
        int r = partition1[1];
        partition(arr, L, l);
        partition(arr, r, R);

    }

    /**
     * @Description //TODO 堆排序
     * @Author ZX
     * @Date 16:19 2020/6/7
     * @Param [arr]
     * @return void
     **/
    public static void heapSort(int[] arr) {

        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        // 将0 ~ i之间的元素形成大根堆
        for(int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // 此时整个数组arr已经是大根堆，但无序
        int heapSize = arr.length;
        swap(arr, 0, --heapSize); // 将数组中0 ~ N最大元素移到末尾，堆长度减1
        while (heapSize > 0) {
            heapify(arr, 0, heapSize); // 将剩下的N - 1个元素重新调整为大根堆，以此类推
            swap(arr, 0, --heapSize); // 交换0 ~ N - 1最大元素到N - 1位置， 堆长度再减1
        }

    }

    private static void heapInsert(int[] arr, int cur) {
        while (arr[cur] > arr[(cur - 1) / 2]) {
            swap(arr, cur, (cur - 1) / 2);
            cur = (cur - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int cur, int heapSize) {
        int left = cur * 2 + 1;
        while (left < heapSize) { // left在堆中
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left; // 如果有右孩子，找出左右孩子较大的节点下标
            largest = arr[largest] > arr[cur] ? largest : cur; // 找出根节点与左右孩子较大的节点中较大的节点下标
            if (largest == cur) { // 如果根节点是三者最大，不用调整
                break;
            }
            swap(arr, largest, cur); // 否则根节点下沉
            cur = largest;
            left = cur * 2 + 1;
        }
    }


    public static void main(String[] args) {

        int[] arr = {4, 5, 2, 7};
        // 冒泡排序
        // bubbleSort(arr);

        // 选择排序
        // selectSort(arr);

        // 插入排序
        // insertSort(arr);

        // 归并排序
        // mergeSort(arr);

        // 快速排序
        // quickSort(arr, 0, arr.length - 1);

        // 随机快速排序
        // randomQuickSort(arr, 0, arr.length - 1);

        // 堆排序
        heapSort(arr);

        for (int x : arr) {
            System.out.print(" " + x);
        }

    }
}
