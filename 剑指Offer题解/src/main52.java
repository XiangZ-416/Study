/**
 * @Description: //TODO 构建乘积数组：给定一个数组A[0, 1, ..., n-1]，请构建一个数组B[0, 1, ..., n - 1]，其中B中的元素
 *                                   B[i] = A[0] * A[1] * ... * A[i - 1] * A[i + 1] * ... * A[n - 1]。不能使用除法。
 *                                   注意：规定B[0] = A[1] * A[2] * ... * A[n - 1]，B[n - 1] = A[0] * A[1] * ... * A[n - 2]。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/6 21:37
 */

public class main52 {
    /**
     * @Author ZX
     * @Description //TODO 分析：借助两个数组lefts和rights，一个记录B[i]值的左乘结果A[0] * A[1] * ... * A[i - 1]，
     *                                                    一个记录B[i]值的右乘结果A[i + 1] * A[i+2] * ... * A[n - 1]，
     *                                                    然后B[i] = lefts[i] * rights[i];
     *                           时间复杂度O(N)
     * @Date 23:47 2020/4/8
     * @Param [A]
     * @return int[]
     **/
    public int[] multiply(int[] a) {
        int len = a.length;
        int[] ans = new int[len];
        // base case
        if(a.length == 0)
            return ans;

        int[] leftMultiply = new int[len]; // 用来存每一个元素左边的连乘积
        int[] rightMultiply = new int[len]; // 用来存每一个元素右边的连乘积
        leftMultiply[0] = rightMultiply[len - 1] = 1; // 两个特殊位置

        // 获取每一个元素左边的连乘积
        for(int i = 1; i < len; i++) {
            leftMultiply[i] = a[i - 1] * leftMultiply[i - 1];
        }
        // 获取每一个元素右边的连乘积
        for(int i = len - 2; i >= 0; i--) {
            rightMultiply[i] = a[i + 1] * rightMultiply[i + 1];
        }
        // 最终的乘积数组
        for(int i = 0; i < len; i++) {
            ans[i] = leftMultiply[i] * rightMultiply[i];
        }

        return ans;
    }
}
