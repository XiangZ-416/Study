import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£∫ 2020/8/29 20:01
 */
public class keda1_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int n = Integer.parseInt(num.split(",")[0]); // n––
        int m = Integer.parseInt(num.split(",")[1]); // m¡–
        int[][] matrix = new int[n][m];
        for (int i = 0;i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = dp[i - 1][1] + matrix[i - 1][0];
            dp[i][m] = dp[i - 1][m] + matrix[i - 1][m - 1];
        }
        for (int j = 1; j <= n; j++) {
            dp[1][j] = dp[1][j - 1] + matrix[0][j - 1];
            dp[m][j] = dp[m][j - 1] + matrix[m - 1][j - 1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + matrix[i - 1][j - 1];
            }
        }
        System.out.println(dp[m][n]);
    }
}
