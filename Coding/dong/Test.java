/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/15 19:19
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {25, 84, 21, 47, 15, 27, 68, 35, 20};
        quickSort(arr, 0, arr.length - 1);
    }
    public static void quickSort(int[] arr, int L, int R) {
        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        int[] equal = partition(arr, L, R);
        int l = equal[0];
        int r = equal[1];

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();

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

    private static void swap(int[] arr, int i, int j) {
        int help = arr[i];
        arr[i] = arr[j];
        arr[j] = help;
    }
}
