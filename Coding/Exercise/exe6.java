import java.util.Scanner;

/**
 * @Description: //TODO 力扣468：验证IP地址
 *                                      IPv4：（1）.作为分隔符
 *                                             （2）分为四个部分
 *                                             （3）每个部分：每位值：0 ~ 255，位数n：0 < n <= 3
 *                                             （4）长度不为1的部分不以0开头
 *                                             （5）不能全是255
 *                                      IPv6：（1）：作为分隔符
 *                                             （2）分为8部分
 *                                             （3）每个部分：每位值：0 ~ 9 || a ~ f，位数n：0 < n <= 4
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/9/1 11:02
 */
public class exe6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String lowerCase = s.toLowerCase(); // 将所有字符转成小写
        boolean flag = false;
        String[] split = lowerCase.split("\\.", -1);
        if (split.length == 4) {
            String ans = checkIP4(split);
            flag = true;
            System.out.println(ans);
        }
        String[] split1 = lowerCase.split(":", -1);
        if (split1.length == 8) {
            String ans = checkIP6(split1);
            flag = true;
            System.out.println(ans);
        }
        if (!flag) {
            System.out.println("Neither");
        }
    }

    private static String checkIP6(String[] split) {
        for (String s : split) {
            int length = s.length();
            // 判断每部分长度length是否满足：0 < length <= 4
            if (length == 0 || length > 4) {
                return "Neither";
            }
            // 判断每部分的每一位是否属于：'0' ~ '9' 或 'a' ~ 'f'
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f')) {
                    continue;
                }
                return "Neither";
            }
        }
        return "IPv6";
    }

    private static String checkIP4(String[] split) {
        int flag = 0;
        for (String s : split) {
            int length = s.length();
            // 判断每部分长度length是否满足：0< length <=3
            if (length == 0 || length > 3) {
                return "Neither";
            }
            // 判断每部分的每一位是否都是数字
            for (int i = 0; i < length; i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    return "Neither";
                }
            }
//            for (int i = 0; i < length; i++) {
//                if (s.charAt(i) < '0' && s.charAt(i) > '9') {
//                    return "Neither";
//                }
//            }
            // 检查每部分值是否都在：0 <= part <= 255
            if (0 > Integer.parseInt(s) || Integer.parseInt(s) > 255) {
                return "Neither";
            }
            // 判断是否有长度不为1的部分以0开头
            if (length != 1 && s.charAt(0) == '0') {
                return "Neither";
            }
            // 不能全是255
            if (s.equals("255")) {
                flag++;
            }
            if (flag == split.length) {
                return "Neither";
            }
        }
        return "IPv4";
    }
}
