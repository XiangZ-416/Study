/**
 * @Description: //TODO ͳ��һ�����������������г��ֵĴ�����
 *                      ����: nums = [5,7,7,8,8,10], target = 8
 *                      ���: 2
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/24 23:41
 */
public class main38 {
    /**
     * @Author ZX
     * @Description //TODO ����2�����ַ�����
     *                          1.�ҵ���һ��target�����һ��target���±�
     *                          2.�ص㴦��nums���鲻����target�����
     *                          3.target���ֵĴ�����lastIndex - firstIndex + 1
     *
     * @Date 23:24 2020/3/25
     * @Param [nums, target]
     * @return int
     **/
    public static int GetNumberOfK2(int[] nums, int target) {
        // base case
        if (nums == null || nums.length == 0)
            return 0;

        int ans = 0; // ���

        // �ҵ�һ�������һ��target���±�
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
        if (nums[midIndex] != target && l == r) // nums���鲻����target
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
        if (nums[midIndex] != target && l == r) // nums���鲻����target
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
     * @Description //TODO ����1��ֱ�ӷ�
     *                     ʱ�临�Ӷȣ�O(N)
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
