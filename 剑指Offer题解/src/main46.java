import java.util.Arrays;

/**
 * @Description: //TODO 扑克牌顺子:从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 *                                2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *                      例子
 *                          输入: [1,2,3,4,5]
 *                          输出: True
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/1 17:57
 */
public class main46 {
    public static boolean isContinuous(int[] nums) {
        // base case
        if (nums.length != 5)
            return false;

        // 1.从小到大排序
        Arrays.sort(nums);
        // 2.统计0的个数
        int count = 0; // 初始化0的个数
        for (int temp : nums) {
            if (temp == 0)
                count++;
        }
        // 3.统计排序之后的数组中相邻数字之间的空缺总数
        int res = 0; // 初始化空缺总数
        int p1 = count; // 指针1（跳过所有0）
        int p2 = count + 1; // 指针2
        for (int i = p1; p2 < nums.length; i++) {
            if (nums[p2] - nums[p1] == 1 || nums[p2] - nums[p1] == -13) { // nums[p1]和nums[p2]连续 --> 判断下一对
                p1++;
                p2++;
            } else if (nums[p2] - nums[p1] == 0) { // 非0连续出现 --> 有对子一定不是顺子
                return false;
            } else { // nums[p1]和nums[p2]不连续 --> 统计空缺个数
                res += nums[p2] - nums[p1] - 1;
                p1++;
                p2++;
            }
        }
        // 4.大小王的个数等于 || 大于空缺总数就是顺子
        return count == res || count > res;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(isContinuous(nums));
    }
}
