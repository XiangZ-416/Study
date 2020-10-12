import java.util.Scanner;

/**
 * @Description: //TODO µ∫”ÏŒ Ã‚
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£∫ 2020/9/1 17:27
 */
public class exe10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int M = Integer.parseInt(str.split(" ")[0]);
        int N = Integer.parseInt(str.split(" ")[1]);
        Character[][] matrix = new Character[M][N];
        for (int i = 0; i < M; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = s.charAt(j);
            }
        }
        int ans = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 'S') {
                    solve(matrix, i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static void solve(Character[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != 'S') {
            return;
        }
        matrix[i][j] = 'H';
        solve(matrix, i + 1, j);
        solve(matrix, i - 1, j);
        solve(matrix, i, j + 1);
        solve(matrix, i, j - 1);
    }

}
