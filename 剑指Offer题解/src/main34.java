import java.util.ArrayList;

/**
 * @Description: //TODO 题目描述 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第N个丑数。
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *      1 是丑数。
 *      n 不超过1690
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/21 23:56
 */
public class main34 {
    /**
     * @Author ZX
     * @Description //TODO 判断number是否为丑数
     * @Date 17:55 2020/3/23
     * @Param [number]
     * @return boolean
     **/
    public static boolean isUglyNumber(int number) {
        // base case
        if (number == 1)
            return true;

        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;

        return number == 1;
    }

    /**
     * @Author ZX
     * @Description //TODO 方法1：1.逐个判断正整数是否为丑数；
     *                                 2.是的话存入arrayList，如果arrayList的长度等于index，返回arrayList中最后一个元素
     *                                 时间复杂度：O(N)
     * @Date 18:06 2020/3/23
     * @Param [n]
     * @return int
     **/
    public static int GetUglyNumber_Solution1(int n) {
        // base case
        if (n == 1)
            return 1;

        ArrayList<Integer> list = new ArrayList<>();

        // 逐个判断自然数是否时丑数
        for (int i = 1; i < 1690; i++) {
            if (isUglyNumber(i)) {
                list.add(i);
            }
            if (list.size() == n) {
                break;
            }
        }

        return list.get(n - 1);
    }

    /**
     * @Author ZX
     * @Description //TODO 方法2：一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到
     * @Date 18:07 2020/3/23
     * @Param [n]
     * @return int
     **/
    public static int GetUglyNumber_Solution2(int n) {
        // base case
        if (n < 6)
            return n;

        int[] ans = new int[n];
        ans[0] = 1;
        // 初始分别指向三个有序数组第一个元素,这三个有序链表是想象出来的，分别就是ugly数组元素分别乘以2,3,5得到的
        int index1 = 0; // 遍历乘以2队列的下标
        int index2 = 0; // 遍历乘以3队列的下标
        int index3 = 0; // 遍历乘以5队列的下标
        for (int i = 1; i < n; i++) {
            ans[i] = Math.min(Math.min(ans[index1] * 2, ans[index2] * 3), ans[index3] * 5);
            // 三个数组可能有相同元素，所以只要是最小的，都要移动指针
            if (ans[i] == ans[index1] * 2)
                index1++;
            if (ans[i] == ans[index2] * 3)
                index2++;
            if (ans[i] == ans[index3] * 5)
                index3++;
        }

        return ans[n - 1];
    }

    public static void main(String[] args) {
        System.out.println("方法1：" + GetUglyNumber_Solution1(100));
        System.out.println("方法2：" + GetUglyNumber_Solution2(100));
    }
}
