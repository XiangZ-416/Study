import java.util.Scanner;

/**
 * @Description: //TODO 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。 如：输入“I am a student”，输出“tneduts a ma I”。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/2 17:27
 */
public class N03字符逆序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solve(str));
    }

    private static String solve(String str) {
        if(str == null) return null;
        StringBuilder sb = new StringBuilder();
        char[] array = str.toCharArray();
        for(int i = array.length - 1; i >= 0; i--) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
}
