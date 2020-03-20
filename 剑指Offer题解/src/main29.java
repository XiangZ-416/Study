import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/19 0:20
 */
public class main29 {
    /**
     * @Author ZX
     * @Description
     *      1.利用HashMap存放：key：array[i]，value：array[i]出现的次数
     *      2.遍历key，如果key对应的value大于array长度的一半，输出key
     * 时间复杂度：O(N)
     * 额外空间复杂度：O(多少个不同数字)
     * @Date 16:43 2020/3/19
     * @Param [array]
     * @return int
     **/
    public static int MoreThanHalfNum_Solution(int[] array) {
        // base case
        if (array == null || array.length == 0)
            return 0;

        // 1
        Map<Integer, Integer> map = new HashMap<>();
        for (int temp : array) {
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            }else {
                map.put(temp, map.get(temp) + 1);
            }
        }

        // 2
        for (int key : map.keySet()) {
            if (map.get(key) > array.length / 2) {
                return key;
            }
        }
        return 0;
    }

    // For test
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }
}
