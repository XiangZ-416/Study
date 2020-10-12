import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/8/29 19:35
 */
public class keda3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String name = merge(string);
        name = trim(name);
        System.out.println(name);
    }

    private static int getNum(String s, int index) {
        if (index < s.length()) {
            if (s.charAt(index) == '_') {
                return getNum(s, index + 1) + 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    private static String trim(String s) {
        if (s.charAt(0) == '_') {
            s = s.substring(1, s.length());
        }
        if (s.charAt(s.length() - 1) == '_') {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    private static String merge(String s) {
        int numBlank = 0;
        String a1;
        String a2;
        for (int index = 0; index < s.length(); index++) {
            numBlank = getNum(s, index);
            if (numBlank >= 2) {
                a1 = s.substring(0, index);
                a2 = s.substring(index + numBlank - 1, s.length());
                s = a1 + a2;
            }
        }
        return s;
    }
}
