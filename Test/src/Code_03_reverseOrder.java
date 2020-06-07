/**
 * @Description: //TODO ÄæĞò¶ÔÎÊÌâ
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/6/4 21:02
 */
public class Code_03_reverseOrder {

    public static int reverseOrder(int[] arr) {
        // base case
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return sortProcess(arr, 0, arr.length - 1);
    }

    private static int sortProcess(int[] arr, int L, int R) {

        if (L == R) {
            return 0;
        }

        int mid = (L + R) / 2;
        return sortProcess(arr, L, mid)
                + sortProcess(arr, mid + 1, R)
                + merge(arr, L, mid, R);

    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int reveresOrderNums = 0;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            reveresOrderNums += arr[p1] > arr[p2] ? (mid - p1 + 1) : 0;
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

        return reveresOrderNums;
    }

    public static void main(String[] args) {
        int[] arr= {1, 2, 1, 2, 1};
        System.out.println(reverseOrder(arr));
    }

}
