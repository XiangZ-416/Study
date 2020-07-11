package 左神算法进阶班;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description: //TODO 时刻获取滑动窗口的最大值、最小值：单调双端队列
 * 每个数都只会进队列一次，出队列一次。所以时间复杂度0(N)
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/28 14:40
 */
public class Code_04_twoWayQueue {

    /**
     * @Description //TODO 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     * @Author ZX
     * @Date 15:46 2020/6/28
     **/
    public static class maxNumInWindow {
        public static int[] windowMaxNum(int[] nums, int k) {
            // base case
            if (nums == null || k == 0 || k > nums.length) {
                return new int[]{};
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

    /**
     * @Description //TODO 最大值减最小值小于或等于num的子数组数量
     * 要求：时间复杂度O(N)
     * @Author ZX
     * @Date 15:50 2020/6/28
     **/
    public static class validSubArrayNums {
        /**
         * @Description //TODO 暴力法：找到所有字串，当前字串满足要求，res++
         * 时间复杂度：O(N^3)
         * @Author ZX
         * @Date 16:06 2020/6/28
         **/
        public static int getNum1(int[] nums, int num) {
            int res = 0;
            // 两层for循环找到所有子串
            for (int start = 0; start < nums.length; start++) {
                for (int end = start; end < nums.length; end++) {
                    // 判断当前字串是否满足 最大值 - 最小值 <= num
                    if (isValid(nums, start, end, num)) {
                        res++;
                    }
                }
            }
            return res;
        }

        private static boolean isValid(int[] nums, int start, int end, int num) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = start; i <= end; i++) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
            }
            return max - min <= num;
        }

        /**
         * @Description //TODO 单调双端队列
         *                      结论1：L到R的子数组是满足要求，则该数组的任意子数组都达标
         *                      结论2：L到R的子数组不满足要求，则该数组的任意父数组都不达标
         * 时间复杂度：O(N)
         * @Author ZX
         * @Date 16:07 2020/6/28
         **/
        public static int getNum2(int[] nums, int num) {
            LinkedList<Integer> maxList = new LinkedList<>(); // 最大值栈：从大到小排
            LinkedList<Integer> minList = new LinkedList<>(); // 最小值栈：从小到大排
            int L = 0;
            int R = 0;
            int res = 0;
            while (L < nums.length) {
                // 寻找当前L符合要求的R
                while (R < nums.length) {
                    // 最大值队列加数
                    while (!maxList.isEmpty() && nums[R] >= nums[maxList.peekLast()]) {
                        maxList.pollLast();
                    }
                    maxList.add(R);
                    // 最小值队列加数
                    while (!minList.isEmpty() && nums[R] <= nums[minList.peekLast()]) {
                        minList.pollLast();
                    }
                    minList.add(R);
                    if (nums[maxList.peekFirst()] - nums[minList.peekFirst()] > num) {
                        break;
                    }
                    R++;
                }
                // 此时已经找到L位置开头符合要求的R
                res += R - L; // 以L开头所有符合要求的子字串数量
                // 最大值队列减数
                if (maxList.peekFirst() == L) {
                    maxList.pollFirst();
                }
                // 最小值队列减数
                if (minList.peekFirst() == L) {
                    minList.pollFirst();
                }
                L++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxNumInWindow.windowMaxNum(nums, 3)));

        int[] array = {1, 2, 3};
        System.out.println(validSubArrayNums.getNum1(array, 1));
        System.out.println(validSubArrayNums.getNum2(array, 1));
    }

}
