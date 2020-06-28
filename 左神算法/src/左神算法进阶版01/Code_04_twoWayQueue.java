package �����㷨���װ�01;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description: //TODO ʱ�̻�ȡ�������ڵ����ֵ����Сֵ������˫�˶���
 *                          ÿ������ֻ�������һ�Σ�������һ�Ρ�����ʱ�临�Ӷ�0(N)
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/28 14:40
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
                // ���ڼ���
                while (!linkedList.isEmpty() && nums[i] >= nums[linkedList.peekLast()]) {
                    linkedList.pollLast();
                }
                linkedList.add(i);
                // ���ڼ���
                if (i - k == linkedList.peekFirst()) {
                    linkedList.pollFirst();
                }
                // ���浱ǰ�������ֵ
                if (i >= k - 1) { // �����Ѿ��γ�����
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
