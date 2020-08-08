import java.util.Scanner;

/**
 * @Description: //TODO 输入描述:
 *                              待求解参数 double类型
 *                          输出描述:
 *                               输入参数的立方根 也是double类型
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/2 17:27
 */
public class N02求解立方根 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("%.1f", solve(sc.nextDouble()));
    }
    private static double solve(double num) {
        double min = 0;
        double max = num;
        double mid = 0;
        while(max - min > 0.0001) {
            mid = (min + max) / 2;
            if(mid * mid * mid > num) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return mid;
    }
}
