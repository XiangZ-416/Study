package �����㷨���װ�;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description: //TODO ʱ�̻�ȡ�������ڵ����ֵ����Сֵ������˫�˶���
 * ÿ������ֻ�������һ�Σ�������һ�Ρ�����ʱ�临�Ӷ�0(N)
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/28 14:40
 */
public class Code_04_twoWayQueue {

    /**
     * @Description //TODO ����һ������ nums �ͻ������ڵĴ�С k�����ҳ����л�������������ֵ��
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

    /**
     * @Description //TODO ���ֵ����СֵС�ڻ����num������������
     * Ҫ��ʱ�临�Ӷ�O(N)
     * @Author ZX
     * @Date 15:50 2020/6/28
     **/
    public static class validSubArrayNums {
        /**
         * @Description //TODO ���������ҵ������ִ�����ǰ�ִ�����Ҫ��res++
         * ʱ�临�Ӷȣ�O(N^3)
         * @Author ZX
         * @Date 16:06 2020/6/28
         **/
        public static int getNum1(int[] nums, int num) {
            int res = 0;
            // ����forѭ���ҵ������Ӵ�
            for (int start = 0; start < nums.length; start++) {
                for (int end = start; end < nums.length; end++) {
                    // �жϵ�ǰ�ִ��Ƿ����� ���ֵ - ��Сֵ <= num
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
         * @Description //TODO ����˫�˶���
         *                      ����1��L��R��������������Ҫ�������������������鶼���
         *                      ����2��L��R�������鲻����Ҫ�������������⸸���鶼�����
         * ʱ�临�Ӷȣ�O(N)
         * @Author ZX
         * @Date 16:07 2020/6/28
         **/
        public static int getNum2(int[] nums, int num) {
            LinkedList<Integer> maxList = new LinkedList<>(); // ���ֵջ���Ӵ�С��
            LinkedList<Integer> minList = new LinkedList<>(); // ��Сֵջ����С������
            int L = 0;
            int R = 0;
            int res = 0;
            while (L < nums.length) {
                // Ѱ�ҵ�ǰL����Ҫ���R
                while (R < nums.length) {
                    // ���ֵ���м���
                    while (!maxList.isEmpty() && nums[R] >= nums[maxList.peekLast()]) {
                        maxList.pollLast();
                    }
                    maxList.add(R);
                    // ��Сֵ���м���
                    while (!minList.isEmpty() && nums[R] <= nums[minList.peekLast()]) {
                        minList.pollLast();
                    }
                    minList.add(R);
                    if (nums[maxList.peekFirst()] - nums[minList.peekFirst()] > num) {
                        break;
                    }
                    R++;
                }
                // ��ʱ�Ѿ��ҵ�Lλ�ÿ�ͷ����Ҫ���R
                res += R - L; // ��L��ͷ���з���Ҫ������ִ�����
                // ���ֵ���м���
                if (maxList.peekFirst() == L) {
                    maxList.pollFirst();
                }
                // ��Сֵ���м���
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
