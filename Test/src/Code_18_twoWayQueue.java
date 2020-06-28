import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description: //TODO ���������ֵ����Сֵ�ĸ��½ṹ������˫�����
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/27 21:39
 */
public class Code_18_twoWayQueue {

    /**
     * @Description //TODO ����һ������ nums �ͻ������ڵĴ�С k�����ҳ����л�������������ֵ��
     *                      ÿ������ֻ�������һ�Σ�������һ�Ρ�����ʱ�临�Ӷ�0(N)
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
                // ˫�˶��м���(ά��˫����д�ͷ��β������)
                while (!linkedList.isEmpty() && nums[linkedList.peekLast()] <= nums[i]) {
                    linkedList.pollLast();
                }
                linkedList.add(i);
                // ˫�˶��м���
                if (linkedList.peekFirst() == i - k) {
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
