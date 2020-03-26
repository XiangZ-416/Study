/**
 * @Description: //TODO 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *                           输入一个数组，求出这个数组中的逆序对的总数。
 *                      示例:
 *                           输入: [7,5,6,4]
 *                           输出: 5
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/23 23:03
 */
public class main36 {
    /**
     * @Author ZX
     * @Description //TODO 合并+统计每一次合并时的逆序对数
     * @Date 18:11 2020/3/24
     * @Param [Arr, L, M, R]
     * @return int
     **/
    private static long merge(int[] Arr, int L, int M, int R) {
        int p1 = L; // 左边指针
        int p2 = M + 1; // 右边指针
        int[] help = new int[R - L + 1]; // 存放排好序的原数组
        int index = 0;
        long ANS = 0; // 初始化逆序对数
        while (p1 <= M && p2 <= R) {
            ANS += (Arr[p1] > Arr[p2]) ? (M - p1 + 1) : 0;
            help[index++] = (Arr[p1] <= Arr[p2]) ? Arr[p1++] : Arr[p2++];
        }
        while (p1 <= M) {
            help[index++] = Arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = Arr[p2++];
        }
        for (index = 0; index < help.length; index++) { // 将排好序的数组赋值回原数组，否则会重复统计
            Arr[L + index] = help[index];
        }

        return ANS;
    }

    /**
     * @Author ZX
     * @Description //TODO 划分Array为两部分
     * @Date 18:11 2020/3/24
     * @Param [Array, l, r]
     * @return int
     **/
    private static long Divide(int[] Array, int l, int r) {
        // base case
        if (l == r)
            return 0;

        int mid = l + ((r - l) >> 1); // 中点

        return Divide(Array, l, mid) + Divide(Array, mid + 1, r) + merge(Array, l, mid, r);

    }

    /**
     * @Author ZX
     * @Description //TODO 归并排序过程中统计逆序对
     * @Date 21:46 2020/3/24
     * @Param [array]
     * @return int
     **/
    public static int InversePairs(int [] array) {
        // base case
        if (array == null || array.length < 2)
            return 0;

        long ans = 0; // 逆序对数
        ans = Divide(array, 0, array.length - 1);

        return (int)ans;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 3, 1};
        System.out.println(InversePairs(array));
    }
}
