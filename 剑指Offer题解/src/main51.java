import java.util.HashMap;

/**
 * @Description: //TODO 数组中重复的数字：在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 *                                      也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *                                      例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/6 21:34
 */
public class main51 {
    /**
     * @Author ZX
     * @Description //TODO 遍历两次：1.第一次统计numbers数组中每个元素出现的次数
     *                              2.第二次遇到numbers中元素对应的value > 1就赋值给duplication[0]，返回true
     *                     时间复杂度：0(N)
     *                     额外空间复杂度：O(N)
     * @Date 21:57 2020/4/6
     * @Param [numbers, length, duplication]
     * @return boolean
     **/
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        // base case
        if (numbers == null || length == 0)
            return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], 1);
            } else {
                map.put(numbers[i], map.get(numbers[i]) + 1);
            }
        }

        for (int i = 0; i < length; i++) {
            if (map.get(numbers[i]) > 1) {
                duplication[0] = numbers[i];
                return true;
            }
        }

        return false;
    }
}
