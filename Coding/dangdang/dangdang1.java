import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/30 13:59
 */
public class dangdang1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt(); // 除数d
        int n = sc.nextInt(); // 数组长度为n
        if (d == 0 || n == 0) {
            System.out.println(0);
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int ans = 0;
        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end < n; end++) {
                int add = 0;
                for (int i = start; i <= end; i++) {
                    add += nums[i];
                }
                if (add % d == 0) {
                    ans++;
                }
                add = 0;
            }
        }
        System.out.println(ans);
    }
}
