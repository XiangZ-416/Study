import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/8/29 19:36
 */
public class keda4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n);
    }

    private static void solve(int n) {
        for (int i = 2; i <= n; i++) {
            if (i == n) {
                System.out.print(i);
                return;
            }
            if (n > i && (n % i == 0)) {
                System.out.print(i + "*");
                solve(n / i);
                break;
            }
        }
    }
}
