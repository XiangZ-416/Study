import java.util.Scanner;
import java.util.Stack;

/**
 * @Description: //TODO 力扣20：有效的括号
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/31 10:55
 */
public class exe4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c == '(') {
                stack.push(')');
            } else if(c == '[') {
                stack.push(']');
            } else if(c == '{') {
                stack.push('}');
            } else if(stack.isEmpty() || c != stack.pop()) {
                System.out.println(false);
            }
        }
        System.out.println(stack.isEmpty()); // 可能为奇数个字符
    }
}
