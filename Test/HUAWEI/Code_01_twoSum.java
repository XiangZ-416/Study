/**
 * @Description: //TODO 两数之和
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/5 22:41
 */
public class Code_01_twoSum {

    // 暴力解
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[] {};
        }

        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

}
