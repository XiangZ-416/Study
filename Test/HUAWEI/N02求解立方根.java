import java.util.Scanner;

/**
 * @Description: //TODO ��������:
 *                              �������� double����
 *                          �������:
 *                               ��������������� Ҳ��double����
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/2 17:27
 */
public class N02��������� {
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
