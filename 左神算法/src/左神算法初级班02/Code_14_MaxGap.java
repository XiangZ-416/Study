package 左神算法初级班02;

public class Code_14_MaxGap {
    public static int maxGap(int[] nums) {
        // 如果数组为空或只有1个元素，最大差值为0
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        // 将最大设为最小，最小设为最大
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 遍历数组找到数组中的最大最小值
        for (int i = 0; i < len; i++) {
            // 与已知最小值比较，如果更小就更新
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        // 最小值等于最大值说明数组存的同一个数，最大差值为0
        if (min == max) {
            return 0;
        }
        // len+1个桶中存的3个信息
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        // 再次遍历数组arr，确定数组中的每个数在几号桶，并更新该桶的3个参数
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        // 找到每一个非空桶和离他最近的左边非空桶，用当前的最小 - 前一个的最大算出的差值看看是否找到了更大的差值
        for (; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    /**
     * 确定当前数属于几号桶
     * @param num 当前数
     * @param len 桶的个数
     * @param min arr的最小值
     * @param max arr的最大值
     * @return 桶号
     */
    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 5, 2};
        System.out.print(maxGap(arr));
    }
}
