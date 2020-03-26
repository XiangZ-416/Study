/**
 * @Description: //TODO 统计一个数字在排序数组中出现的次数。
 *                      输入: nums = [5,7,7,8,8,10], target = 8
 *                      输出: 2
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/24 23:41
 */
public class main38 {
    /**
     * @Author ZX
     * @Description //TODO 方法2：二分法查找
     *                          1.找到第一个target和最后一个target的下标
     *                          2.重点处理nums数组不存在target的情况
     *                          3.target出现的次数：lastIndex - firstIndex + 1
     *
     * @Date 23:24 2020/3/25
     * @Param [nums, target]
     * @return int
     **/
    public static int GetNumberOfK2(int[] nums, int target) {
        // base case
        if (nums == null || nums.length == 0)
            return 0;

        int ans = 0; // 结果

        // 找第一个、最后一个target的下标
        int firstIndex = findFirstIndex(nums, target, 0, nums.length - 1);
        int lastIndex = findLastIndex(nums, target, 0, nums.length - 1);

        if (firstIndex != -1 && lastIndex != -1) {
            ans = lastIndex - firstIndex + 1;
        }

        return ans;
    }

    private static int findLastIndex(int[] nums, int target, int l, int r) {
        if (l > r)
            return -1;

        int midIndex = l + ((r - l) >> 1);
        if (nums[midIndex] != target && l == r) // nums数组不存在target
            return -1;

        if (nums[midIndex] == target) {
            while (midIndex + 1 <= r && nums[midIndex + 1] == target) {
                midIndex++;
            }
            return midIndex;
        }else if (nums[midIndex] > target){
            return findLastIndex(nums, target, l, midIndex);
        }else {
            return findLastIndex(nums, target,midIndex + 1, r);
        }

    }

    private static int findFirstIndex(int[] nums, int target, int l, int r) {
        if (l > r)
            return -1;

        int midIndex = l + ((r - l) >> 1);
        if (nums[midIndex] != target && l == r) // nums数组不存在target
            return -1;

        if (nums[midIndex] == target) {
            while (midIndex - 1 >= l && nums[midIndex - 1] == target) {
                midIndex--;
            }
            return midIndex;
        } else if (nums[midIndex] > target) {
            return findFirstIndex(nums, target, l, midIndex);
        } else {
            return findFirstIndex(nums, target, midIndex + 1, r);
        }
    }

    /**
     * @Author ZX
     * @Description //TODO 方法1：直接法
     *                     时间复杂度：O(N)
     * @Date 23:49 2020/3/24
     * @Param [nums, target]
     * @return int
     **/
    public static int GetNumberOfK1(int[] nums, int target) {
        // base case
        if (nums == null || nums.length == 0)
            return 0;

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(GetNumberOfK2(nums, 6));
    }
}
