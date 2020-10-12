import java.util.Scanner;

/**
 * @Description: //TODO ����647���ַ����л����Ӵ��ĸ���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/9/1 16:23
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
            solve(s, i, i); // ���Ĵ�����Ϊ����
            solve(s, i, i + 1); // ���Ĵ�����Ϊż��
        }
        System.out.println(ans);
    }

    // ������չ��
    private static void solve(String s, int l, int r) {
        while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
            ans++;
            l--;
            r++;
        }
    }
}
