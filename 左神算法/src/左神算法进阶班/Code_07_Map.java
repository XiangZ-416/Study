package 左神算法进阶班;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: //TODO map相关的题
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/1 10:37
 */
public class Code_07_Map {

    /**
     * @Description //TODO 数组中有0，有正，有负。求其子数组累加和为aim的最长子数组的长度。
     * @Author ZX
     * @Date 10:38 2020/7/1
     **/
    public static class maxSubArray1 {
        public static int maxLength(int[] arr, int aim) {
            if (arr == null || arr.length == 0) {
                return 0;
            }

            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1); // important
            int len = 0;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (map.containsKey(sum - aim)) {
                    len = Math.max(i - map.get(sum - aim), len);
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
            }
            return len;
        }
    }

    /**
     * @Description //TODO 数组中都是整数，求数组中奇数和偶数相等的最长子数组的长度
     *                      用上面的题思路。遇到奇数改为1，偶数改为-1。即求累加和为0的最长子数组的长度。
     * @Author ZX
     * @Date 11:04 2020/7/1
     **/
    public static class maxSubArray2 {

    }
    
    /**
     * @Description //TODO 数组中只要0，1，2，求数组中1的数量等于2的数量的最长子数组的长度
     *                      用上面的题思路。遇到2改为-1。即求累加和为0的最长子数组的长度。
     * @Author ZX
     * @Date 11:08 2020/7/1
     **/
    public static class maxSubArray3 {

    }


    /**
     * @Description //TODO 切分数组，使得切分的子数组各个内部异或和为0最多。返回最多子数组的个数。
     * @Author ZX
     * @Date 11:39 2020/7/1
     **/
    public static class mostEOR {
        public static int mostEor(int[] arr) {
            int ans = 0;
            int xor = 0; // 异或和
            int[] dp = new int[arr.length];
            Map<Integer, Integer> map = new HashMap<>(); // key表示异或结果，value表示异或结果出现最晚的下标
            map.put(0, -1); // 最初异或和为0的位置为-1
            for (int i = 0; i < arr.length; i++) {
                xor ^= arr[i];
                if (map.containsKey(xor)) {
                    int pre = map.get(xor);
                    dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
                }
                if (i > 0) {
                    dp[i] = Math.max(dp[i - 1], dp[i]);
                }
                map.put(xor, i);
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }

}
