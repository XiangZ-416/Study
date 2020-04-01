import java.util.ArrayList;

/**
 * @Description: //TODO 和为S的连续正数序列:输入一个正整数 target ，输出所有和为target的连续正整数序列（至少含有两个数）。
 *                                        序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *                      例如：
 *                          输入：target = 9
 *                          输出：[[2,3,4],[4,5]]
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/29 23:04
 */
public class main42 {
    /**
     * @Author ZX
     * @Description //TODO 力扣上的同一题：与方法1相同
     *                     将ArrayList<ArrayList<Integer>>转成二维数组
     * @Date 16:11 2020/4/1
     * @Param [sum]
     * @return int[][]
     **/
    public static int[][] findContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        // base case
        if (sum == 0)
            return null;

        int p1 = 1; // 左指针
        int p2 = 2; // 右指针
        while (p1 <= sum / 2 + 1) { // 题中知至少包含两个数p1、p2如果都在sum/2的右边，两个数加起来肯定大于sum
            if (sumP1ToP2(p1, p2) == sum) { // p1-p2区间元素之和等于sum
                ArrayList<Integer> list = new ArrayList<>(); // 将区间内的元素存在list
                int p1Num = p1; // 保存p1位置，为寻找下一个区间左准备
                while (p1 <= p2) {
                    list.add(p1++);
                }
                lists.add(list); // 将此找到的连续正整数序列存到lists
                p1 = p1Num;
                p1++; // p1或p2动都可以
            } else if (sumP1ToP2(p1, p2) < sum) { // p1-p2区间元素之和小于sum
                p2++; // p2右移
            } else { // p1-p2区间元素之和大于sum
                p1++; // p1右移
            }
        }

        // 将ArrayList<ArrayList<Integer>>转成二维数组
        int[][] ans = new int[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            ans[i] = new int[lists.get(i).size()];
            for (int j = 0; j < lists.get(i).size(); j++) {
                ans[i][j] = lists.get(i).get(j);
            }
        }

        return ans;
    }

    // 计算p1到p2区间元素之和
    private static int sumP1ToP2(int p1, int p2) {
        return (p1 + p2) * (p2 - p1 + 1) / 2;
    }

    /**
     * @Author ZX
     * @Description //TODO 方法1：双指针：一个等于1，一个等于2 ----> 控制滑动窗口元素之和等于sum
     *                            1.两指针间元素之和等于sum，将p1到p2的数字存到list
     *                            2.两指针间元素之和小于sum，p2++，扩大滑动窗口的数字之和
     *                            3.两指针间元素之和大于sum，p2++，减小滑动窗口的数字之和
     *                     时间复杂度：O(N)
     * @Date 15:11 2020/4/1
     * @Param [sum]
     * @return java.util.ArrayList<java.util.ArrayList<java.lang.Integer>>
     **/
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        // base case
        if (sum == 0)
            return null;

        int p1 = 1; // 左指针
        int p2 = 2; // 右指针
        while (p1 <= sum / 2 + 1) { // 题中知至少包含两个数p1、p2如果都在sum/2的右边，两个数加起来肯定大于sum
            if (sumP1ToP2(p1, p2) == sum) { // p1-p2区间元素之和等于sum
                ArrayList<Integer> list = new ArrayList<>(); // 将区间内的元素存在list
                int p1Num = p1; // 保存p1位置，为寻找下一个区间左准备
                while (p1 <= p2) {
                    list.add(p1++);
                }
                lists.add(list); // 将此找到的连续正整数序列存到lists
                p1 = p1Num;
                p1++; // p1或p2动都可以
            } else if (sumP1ToP2(p1, p2) < sum) { // p1-p2区间元素之和小于sum
                p2++; // p2右移
            } else { // p1-p2区间元素之和大于sum
                p1++; // p1右移
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(findContinuousSequence2(9));
    }
}
