/**
 * @Description:
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/20 12:00
 */
public class main32 {
    /**
     * @Author ZX
     * @Description
     * 方法1：直接法
     *      1.逐个判断0-n每个数1的个数
     *      3.累加1的个数
     * 时间复杂度：O(N*logN)
     * @Date 14:01 2020/3/20
     * @Param [n]
     * @return int
     **/
    public int NumberOf1Between1AndN_Solution1(int n) {
        // base case
        if (n < 1)
            return 0;

        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            ans += get1nums(i);
        }
        return ans;
    }

    // 获取0-n中每一个数字1出现的次数
    public int get1nums(int num) {
        int oneNums = 0;
        while (num != 0) {
            if (num % 10 == 1) { // 判断个位是否是1
                oneNums++;
            }
            num = num / 10; // 除了各位剩下的数
        }
        return oneNums;
    }

    /**
     * @Author ZX
     * @Description
     * 方法2：递归
     * 时间复杂度：O(logN)
     * @Date 14:07 2020/3/20
     * @Param [n]
     * @return int
     **/
    public int NumberOf1Between1AndN_Solution2(int n) {
        // base case
        if (n < 1)
            return 0;

        int ans = 0; // 最终结果

        String str = "" + n; // 将n转化为字符串便于获取n的位数
        int length = str.length(); // n一共length位
        int res = (int) Math.pow(10, length - 1); // 获取首位的幂级数
        int firstBit = n / res; // 获取最高位数字
        int otherBit = n % res; // 除最高位其他位组成的数字
        // 得到首位固定时1出现的次数
        ans = firstBit == 1 ? otherBit + 1 : res; // 首位是1，则首位固定时1出现的次数是除最高位剩下的数字+1，否则就是首位的幂级数
        // 其他位1出现的次数 = 首位数字 * otherBit的位数 * 10^(otherBit的位数 - 1)
        ans += firstBit * (length - 1) * Math.pow(10, length - 1 - 1);

        return ans + NumberOf1Between1AndN_Solution1(otherBit);
    }
}
