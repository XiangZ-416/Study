import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/9/2 18:44
 */
public class L2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int M = Integer.parseInt(num.split(",")[0]); // MÐÐ
        int N = Integer.parseInt(num.split(",")[1]); // NÁÐ
        if (M <= 0 || N >= 1000) {
            throw new RuntimeException();
        }
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
//4,5
//SSHHH
//SSHHH
//HHSHH
//HHHSS
