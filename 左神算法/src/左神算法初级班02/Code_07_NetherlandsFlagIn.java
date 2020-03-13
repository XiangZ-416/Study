package 左神算法初级班02;

import java.util.Arrays;

public class Code_07_NetherlandsFlagIn {
    /**
     * 划分问题
     * @param arr 测试数组
     * @param cur 当前遍历到的位置
     * @param r 测试数组的右边界
     * @param num 需比较的值
     */
    public static void partition(int[] arr, int cur, int r, int num) {
        // 小于区域的右边界
        int less = cur - 1;
        // 交换
        // 当current到数组末尾时停止划分
        while (cur <= (arr.length - 1)) {
            if (arr[cur] <= num) {
                Swap(arr, cur++, ++less);
            } else {
                cur++;
            }
        }
    }

    public static void Swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        // 测试数组
        int[] arr = {8, 5, 4, 7, 6};
        partition(arr, 0, arr.length - 1, 6);
        System.out.print(Arrays.toString(arr));
    }
}