import java.util.Scanner;

/**
 * @Description: //TODO 力扣647：字符串中回文子串的个数
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/9/1 16:23
 */
public class exe8 {
    public static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s == null || s.length() == 0) {
            System.out.println(0);
        }
        for (int i = 0; i < s.length(); i++) {
            solve(s, i, i); // 回文串长度为奇数
            solve(s, i, i + 1); // 回文串长度为偶数
        }
        System.out.println(ans);
    }

    // 中心扩展法
    private static void solve(String s, int l, int r) {
        while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
            ans++;
            l--;
            r++;
        }
    }
}
