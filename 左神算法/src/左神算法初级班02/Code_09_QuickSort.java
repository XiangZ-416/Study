package 左神算法初级班02;
/*
 * 左神改进的快排（自己实现）
 */
import java.util.Arrays;

public class Code_09_QuickSort {
    /**
     * 快排(判断数组是否为空/为单个元素)
     * @param arr 待排数组
     */
    public static void QuickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        QuickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快排
     * @param arr 待排数组
     * @param cur quickSort当前位置
     * @param r 待排数组右边界
     */
    public static void QuickSort(int[] arr, int cur, int r) {
        if (cur < r) {
            int[] p = partition(arr, cur, r);
            QuickSort(arr, cur ,p[0] - 1);
            QuickSort(arr, p[1] + 1, r);
        }
    }

    /**
     * 划分
     * @param arr 待排数组
     * @param Cur partition当前位置
     * @param R 待排数组右边界
     * @return 等于区域的首尾
     */
    public static int[] partition(int[] arr, int Cur, int R) {
        int less = Cur - 1;
        int more = R + 1;
        // 用测试数组最后一个元素作为num来比较
        int num = arr[R];
        while (Cur != more) {
            if (arr[Cur] < num) {
                Swap(arr, Cur++, ++less);
            } else if (arr[Cur] == num) {
                Cur++;
            }else {
                Swap(arr, Cur, --more);
            }
        }
        // 返回等于区域的起始下标
        return new int[] {less + 1, more - 1};
    }

    public static void Swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 4, 6};
        QuickSort(arr);
        System.out.print(Arrays.toString(arr));
    }
}