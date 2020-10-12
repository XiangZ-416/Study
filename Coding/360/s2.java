import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/9/11 21:01
 */
public class s2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String password = sc.nextLine();
            if (checkPassword(password)) {
                System.out.println("Ok");
            } else {
                System.out.println("Irregular password");
            }
        }
    }

    private static boolean checkPassword(String s) {
        Pattern compile = Pattern.compile("^(?=.*[0-9])(?![!@#$%^&*_-]+$)(?=.*[a-z][A-Z])(.{8,20})$");
        Matcher matcher = compile.matcher(s);
        return matcher.matches();
    }
}
