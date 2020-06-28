package 左神算法进阶版01;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description: //TODO 时刻获取滑动窗口的最大值、最小值：单调双端队列
 *                          每个数都只会进队列一次，出队列一次。所以时间复杂度0(N)
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/28 14:40
 */
public class Code_04_twoWayQueue {

    public static class maxNumInWindow {

        public static int[] windowMaxNum(int[] nums, int k) {
            // base case
            if (nums == null || k == 0 || k > nums.length) {
                return new int[] {};
            }
            int[] res = new int[nums.length - k + 1];
            int index = 0;
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                // 窗口加数
                while (!linkedList.isEmpty() && nums[i] >= nums[linkedList.peekLast()]) {
                    linkedList.pollLast();
                }
                linkedList.add(i);
                // 窗口减数
                if (i - k == linkedList.peekFirst()) {
                    linkedList.pollFirst();
                }
                // 保存当前窗口最大值
                if (i >= k - 1) { // 窗口已经形成了吗
                    res[index++] = nums[linkedList.peekFirst()];
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxNumInWindow.windowMaxNum(nums, 3)));
    }

}
