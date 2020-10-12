import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£∫ 2020/8/27 10:38
 */
public class ZTE1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n––
        int m = sc.nextInt(); // m¡–
        long[][] matrix = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        long[][] ans = new long[n][m];
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    ans[i][j] = matrix[i][j];
                } else {
                    ans[i][j] = matrix[i][j] + matrix[i - 1][j] + matrix[i + 1][j] + matrix[i][j - 1] + matrix[i][j + 1];
                    list.add(ans[i][j]);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
    }
}
