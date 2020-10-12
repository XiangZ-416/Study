import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/8/23 15:05
 */
public class qushi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1 || n > 20) {
            System.out.println("error");
            return;
        }
        int[][] nums = new int[n][n];
        int flag = 1;
        int l = 0, r = n - 1;
        int u = 0, d = n - 1;
        while (true) {
            for (int i = u; i <= d; i++) {
                nums[i][r] = flag++;
            }
            r--;
            if (l > r || u > d)
                break;
            for (int j = r; j >= l; j--) {
                nums[d][j] = flag++;
            }
            d--;
            if (l > r || u > d)
                break;
            for (int j = d; j >= u; j--) {
                nums[j][l] = flag++;
            }
            l++;
            if (l > r || u > d)
                break;
            for (int j = l; j <= r; j++) {
                nums[u][j] = flag++;
            }
            u++;
            if (l > r || u > d)
                break;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%4d", nums[i][j]));
            }
            if (i < n - 1) {
                System.out.println();
            }
        }
    }
}
