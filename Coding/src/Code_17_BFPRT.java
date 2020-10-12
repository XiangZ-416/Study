import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description: //TODO 数组中前K个小的数
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/27 19:42
 */
public class Code_17_BFPRT {

    public static class getMinKNums {

        static class myComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }

        public static int[] getMinLNum(int[] nums, int k) {
            // base case
            if (nums == null || k > nums.length) {
                return null;
            }

            PriorityQueue<Integer> heap = new PriorityQueue<>(new myComparator()); // 大根堆
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                heap.add(nums[i]);
            }
            for (int i = k; i < nums.length; i++) {
                if (nums[i] < heap.peek()) {
                    heap.poll();
                    heap.add(nums[i]);
                }
            }
            int index = 0;
            while (!heap.isEmpty()) {
                res[index] = heap.poll();
                index++;
            }
            return res;
        }

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 6, 4, 8};
        System.out.println(Arrays.toString(getMinKNums.getMinLNum(nums, 4)));
    }

}
