import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/15 19:12
 */
public class Num3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(NumberOfOne2(num));
    }
    public static int NumberOfOne2(int n) {
        int sum = 0; // 记录1的个数
        while (n != 0) { // 说明n中至少有一个1
            sum++;
            n = n & (n - 1); // 利用n - 1消除n最右边的1
        }
        return sum;
    }
}
