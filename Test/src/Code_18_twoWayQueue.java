import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description: //TODO 窗口内最大值或最小值的更新结构：单调双向队列
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/27 21:39
 */
public class Code_18_twoWayQueue {

    /**
     * @Description //TODO 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     *                      每个数都只会进队列一次，出队列一次。所以时间复杂度0(N)
     * @Author ZX
     * @Date 22:10 2020/6/27
     **/
    public static class maxNumInWindow {
        public static int[] windowMaxNum(int[] nums, int k) {
            // base case
            if (nums == null || k == 0) {
                return new int[]{};
            }
            LinkedList<Integer> linkedList = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                // 双端队列加数(维护双向队列从头到尾单调减)
                while (!linkedList.isEmpty() && nums[linkedList.peekLast()] <= nums[i]) {
                    linkedList.pollLast();
                }
                linkedList.add(i);
                // 双端队列减数
                if (linkedList.peekFirst() == i - k) {
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
