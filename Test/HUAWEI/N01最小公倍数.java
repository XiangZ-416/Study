import java.util.Scanner;

/**
 * @Description: //TODO 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/2 17:25
 */
public class N01最小公倍数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        // 最小公倍数 = (num1 * num2) / 最大公约数
        System.out.println((num1 * num2) / solve(num1, num2));
    }
    // 求num1和num2的最大公约数
    private static int solve(int num1, int num2) {
        if(num1 == num2) {
            return num1;
        }
        if(num1 > num2) {
            int num = num1 - num2;
            return solve(num, num2);
        } else {
            int num = num2 - num1;
            return solve(num1, num);
        }
    }
}
