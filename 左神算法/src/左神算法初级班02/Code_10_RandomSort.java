package 左神算法初级班02;
/*
 * 左神改进的快排
 * 加上swap(arr, l + (int) (Math.random() * (r - l + 1)), r);变为随机排序
 * 将数组分为四部分：【小于区+等于区+待定区+大于区】末尾arr[r]不参与partition
 */
import java.util.Arrays;

public class Code_10_RandomSort {
    /**
     * 快排(判断数组是否为空/为单个元素)
     * @param arr 待排数组
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快排
     * @param arr 待排数组
     * @param cur quickSort当前位置
     * @param r 待排数组右边界
     */
    public static void quickSort(int[] arr, int cur, int r) {
        if (cur < r) {
            swap(arr, cur + (int) (Math.random() * (r - cur + 1)), r);
            int[] p = partition(arr, cur, r);
            quickSort(arr, cur, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
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
        // 直接用arr[r]作为比对数字，且arr[r]不参与partition
        int more = R;
        while (Cur < more) {
            if (arr[Cur] < arr[R]) {
                swap(arr, ++less, Cur++);
            } else if (arr[Cur] > arr[R]) {
                swap(arr, --more, Cur);
            } else {
                Cur++;
            }
        }
        // 将末尾arr[r]与大于区域的第一个数交换，将数组变为【小于区+等于区+大于区】
        swap(arr, more, R);
        return new int[] { less + 1, more };
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 4, 6};
        quickSort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
