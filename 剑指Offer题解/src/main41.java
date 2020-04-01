import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description: //TODO 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *                      要求时间复杂度是O(n)，空间复杂度是O(1)。
 *                      例如：
 *                          输入：nums = [4,1,4,6]
 *                          输出：[1,6] 或 [6,1]
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/27 16:11
 */
public class main41 {
    // 判断num中特定的位是否为1
    // 而num中要判断的位便是firstBit1中这唯一的1所在的位
    //
    private boolean IsBit1(int num, int firstBit1) {
        return (num & firstBit1) != 0;
    }

    // 返回num的最低位的1，其他各位都为0
    private int FindFirstBit1(int num) {
        // 结论：对于一个数字X，X&(-X)之后得到的数字，是把X中最右边的1保留下来
        return num & (- num);
    }

    /**
     * @Author ZX
     * @Description //TODO 异或去重（结论）：如果有多个数异或，其中有重复的数，则无论这些重复的数是否相邻，都可以根据异或的性质将其这些重复的数消去。
     *                              如果重复出现了偶数次，则异或后会全部消去，如果重复出现了奇数次，则异或后会保留一个
     *                     结论：对于一个数字X，X&(-X)之后得到的数字，是把X中最右边的1保留下来
     *                     时间复杂度O(N)
     *                     额外空间复杂度O(1)
     *                              https://blog.csdn.net/ns_code/article/details/27649027
     * 异或的性质
     *     1、交换律：a^b = b^a；s
     *     2、结合律：(a^b)^c = a^(b^c)；
     *     3、对于任意的a：a^a=0，a^0=a，a^(-1)=~a。
     * 结论： 对于任意的a，有a^b^c^d^a^k = b^c^d^k^(a^a) = b^c^d^k^0 = b^c^d^k
     *       也就是说，如果有多个数异或，其中有重复的数，则无论这些重复的数是否相邻，都可以根据异或的性质将其这些重复的数消去
     *       具体来说，如果重复出现了偶数次，则异或后会全部消去，如果重复出现了奇数次，则异或后会保留一个。
     * @Date 0:10 2020/3/28
     * @Param [array, num1, num2]
     * @return void
     **/
    public void FindNumsAppearOnce3(int[] array, int[] num1, int[] num2) {
        // base case
        if (array == null || array.length < 2) {
            return;
        }

        int i = 0;
        int AllXor = 0;
        // 全部异或 --> 得到两个只出现一次的数的异或结果
        for (i = 0; i < array.length; i++) {
            AllXor ^= array[i];
        }

        int firstBit1 = FindFirstBit1(AllXor); // 返回firstBit1的最低位的1，其他各位都为0

        num1[0] = num2[0] = 0; // 初始化输出结果

        i = 0;
        for (i = 0; i < array.length; i++) { // 将数组array分为两组：该位如果为1，就分到一个子数组；如果为0，就分到另一个子数组中
            if (IsBit1(array[i], firstBit1)) {
                num1[0] ^= array[i]; // 第一个子数组全部异或则去重只剩出现一次的数字
            } else {
                num2[0] ^= array[i]; // 第二个子数组全部异或则去重只剩出现一次的数字
            }
        }
    }

    /**
     * @Author ZX
     * @Description //TODO 利用map统计每个数字出现的次数（类似main29）
     *                     时间复杂度：O(N)
     *                     额外空间复杂度：O(N)
     * @Date 23:52 2020/3/27
     * @Param [array, num1, num2]
     * @return void
     **/
    public void FindNumsAppearOnce2(int[] array, int[] num1, int[] num2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int temp : array) {
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                map.put(temp, map.get(temp) + 1);
            }
        }
        int[] nums = new int[2];
        int i = 0;
        for (int temp : array) {
            if (map.get(temp) == 1) {
                nums[i++] = temp;
            }
        }

        num1[0] = nums[0];
        num2[0] = nums[1];
    }
    /**
     * @Author ZX
     * @Description //TODO 利用set去重，并且set.add()返回值的boolean
     *                     时间复杂度：O(N)
     *                     额外空间复杂度：O(N)
     * @Date 23:24 2020/3/27
     * @Param [array, num1, num2]
     * @return void
     **/
    public void FindNumsAppearOnce1(int[] array, int[] num1, int[] num2) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                set.remove(value);
            }
        }

        Object[] help = set.toArray();
        num1[0] = (int) help[0];
        num2[0] = (int) help[1];
    }
}
