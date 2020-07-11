package 左神算法进阶班;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: //TODO 数组都是正数，求累加和为aim的最长子数组长度
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/4 19:32
 */
public class Code_13_SumSubArray {

    // 数组都是正数，求累加和为aim的最长子数组长度
    public static class sumSubArr1 {
        // 暴力法O(N^3)
        public static int maxSumArray1(int[] arr, int aim) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int S = 0;
            int E = 0;
            int max = E - S;
            for (int start = 0; start < arr.length; start++) {
                for (int end = 0; end < arr.length; end++) {
                    int sum = 0;
                    for (int i = start; i < end; i++) {
                        sum += arr[i];
                        if (sum == aim) {
                            S = start;
                            E = end;
                            max = Math.max(max, E - S);
                        }
                    }
                }
            }
            return max;
        }

        // 双指针法
        public static int maxSumArray2(int[] arr, int aim) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int L = 0; // 左指针
            int R = 0; // 右指针
            int len = 0;
            int sum = arr[0]; // 0位置开始时sum为arr[0]
            for (int i = 0; i < arr.length; i++) {
                if (sum == aim) {
                    len = Math.max(len, R - L + 1);
                    sum += arr[++R];
                } else if (sum < aim) {
                    if (R == arr.length)
                        break;
                    sum += arr[++R];
                } else {
                    sum -= arr[L++];
                }
            }
            return len;
        }
    }

    // 数组中元素可正可负可为零，求和为aim的子数组
    public static class sumSubArr2 {
        // map存累加和及累加和出现的次数
        public int subarraySum(int[] nums, int aim) {
            if (nums == null) {
                return 0;
            }
            Map<Integer, Integer> map = new HashMap<>(); // map记录累加和出现的次数
            map.put(0, 1); // 和为0的子数组至少有一个，即[]
            int sum = 0;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i]; // 截至i位置时的累加和
                if (map.containsKey(sum - aim)) {
                    res += map.get(sum - aim);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return res;
        }
    }

    // 数组中元素可正可负可为零，累加和小于等于aim的最长子数O(N)
    public static class sumSubArr3 {
        public static int sumSubSmallEqual(int[] arr, int aim) {
            if (arr == null || arr.length == 0) {
                return 0;
            }

            int[] min_sum = new int[arr.length]; // i位置的最小累加和
            int[] min_sum_index = new int[arr.length]; // i位置的最小累加和的右边界
            min_sum[arr.length - 1] = arr[arr.length - 1];
            min_sum_index[arr.length - 1] = arr[arr.length - 1];

            for (int i = arr.length - 2; i >= 0; i--) { // 从右往左生成min_sum[i]、min_sum_index[i]
                if (min_sum[i + 1] < 0) {
                    min_sum[i] = arr[i] + min_sum[i + 1];
                    min_sum_index[i] = min_sum_index[i + 1];
                } else {
                    min_sum[i] = arr[i];
                    min_sum_index[i] = i;
                }
            }
            int R = 0; // 扩到的右边界
            int sum = 0;
            int len = 0;
            for (int start = 0; start < arr.length; start++) {
                while (R < arr.length && sum + min_sum[R] <= aim) {
                    sum += min_sum[R];
                    R = min_sum_index[R] + 1;
                }
                sum -= R > start ? arr[start] : 0;
                len = Math.max(len, R - start);
                R = Math.max(R, start + 1); // 第一个位置就扩不了，start向右移动
            }
            return len;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        System.out.println(sumSubArr1.maxSumArray1(arr, 3));
        System.out.println(sumSubArr1.maxSumArray2(arr, 3));
        System.out.println(sumSubArr1.maxSumArray1(arr, 4));
        System.out.println(sumSubArr1.maxSumArray2(arr, 4));
    }

}
