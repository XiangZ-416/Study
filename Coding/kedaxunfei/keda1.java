import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£∫ 2020/8/29 18:52
 */
public class keda1 {
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
        System.out.println(solve(matrix, 0, 0, 0));
    }
    private static int solve(int[][] matrix, int x, int y, int ans) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
            return ans;
        }
        ans += matrix[x][y];
        if (x == matrix.length && y == matrix[0].length) {
            return ans;
        }
        if (x+1 < matrix.length && matrix[x+1][y] > matrix[x][y+1]) {
            return solve(matrix, x+1, y, ans);
        } else {
           return solve(matrix, x, y+1, ans);
        }
    }
}
