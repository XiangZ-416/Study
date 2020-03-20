/**
 * @Description:
 * 题目描述
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 * 输入: array = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/19 21:06
 */
public class main31 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int max = Integer.MIN_VALUE; // 初始化max为整形在的最小数（因为数组中可能出现负数，所以初始化最大子序列累加和为整形中的最小数）
        int curSum = 0; // 初始化当前累加和为0
        // 每加一次数组中的新元素得到的curSum，就判断当前子数组累加和curSum与上一次累加和谁大，谁就是max。
        // 如果当前子数组累加和小于0，则当前子数组不可能是最大和子数组的左半部分，此时将当前子数组累加和重置为0。
        // 否则接下来每加一次数组中的新元素得到的curSum都可能组成最大和子数组
        for (int i = 0; i < array.length; i++) {
            curSum += array[i];
            max = Math.max(max, curSum);
//          curSum = curSum < 0 ? 0 : curSum;
            curSum = Math.max(curSum, 0);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(FindGreatestSumOfSubArray(array));
    }
}
