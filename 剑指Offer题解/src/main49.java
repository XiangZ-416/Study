/**
 * @Description: //TODO 不用加减乘除做加法：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *                                   示例
 *                                      输入: a = 1, b = 1
 *                                      输出: 2
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/2 17:08
 */
public class main49 {
    /**
     * @Author ZX
     * @Description //TODO 如：5 + 7 = 12，可以看作 2 + 10。即：“不考虑进位的5 + 7” + “只考虑进位的5 + 7”
     *                     再看二进制下的理解：不考虑进位相当于：num1 ^ num2；考虑进位相当于：(num1 & num2) << 1
     *                          num1：101 不考虑进位 num1 = sum1：010
     *                                 +                          +
     *                          num2：111 只考虑进位 num2 = sum2：1010
     *                       循环
     *                          num1： 010 不考虑进位 num1 = sum1：1000
     *                                  +                          +
     *                          num2：1010 只考虑进位 num2 = sum2：0100
     *                       循环直到num2为0 ---> 也就是num1 + num2没有进位 ---> 也就是sum1为最终num1 + num2的结果
     *                          num1：1000 不考虑进位 num1 = sum1：1100 ---> 12
     *                           +                          +
     *                          num2： 100 只考虑进位 num2 = sum2：0000
     * @Date 17:44 2020/4/2
     * @Param [num1, num2]
     * @return int
     **/
    public static int add(int num1, int num2) {
        int sum1; // 不考虑进位 num1 + num2
        int sum2; // 只考虑进位 num1 + num2
        do {
            sum1 = num1 ^ num2;
            sum2 = (num1 & num2) << 1;
            num1 = sum1;
            num2 = sum2;
        } while (sum2 != 0); // 直到sum2为0 ---> 没有进位

        return sum1;
    }

    public static void main(String[] args) {
        System.out.println(add(5, 7));
    }
}
