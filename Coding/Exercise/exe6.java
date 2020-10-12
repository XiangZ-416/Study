import java.util.Scanner;

/**
 * @Description: //TODO ����468����֤IP��ַ
 *                                      IPv4����1��.��Ϊ�ָ���
 *                                             ��2����Ϊ�ĸ�����
 *                                             ��3��ÿ�����֣�ÿλֵ��0 ~ 255��λ��n��0 < n <= 3
 *                                             ��4�����Ȳ�Ϊ1�Ĳ��ֲ���0��ͷ
 *                                             ��5������ȫ��255
 *                                      IPv6����1������Ϊ�ָ���
 *                                             ��2����Ϊ8����
 *                                             ��3��ÿ�����֣�ÿλֵ��0 ~ 9 || a ~ f��λ��n��0 < n <= 4
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/9/1 11:02
 */
public class exe6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String lowerCase = s.toLowerCase(); // �������ַ�ת��Сд
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
            // �ж�ÿ���ֳ���length�Ƿ����㣺0 < length <= 4
            if (length == 0 || length > 4) {
                return "Neither";
            }
            // �ж�ÿ���ֵ�ÿһλ�Ƿ����ڣ�'0' ~ '9' �� 'a' ~ 'f'
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
            // �ж�ÿ���ֳ���length�Ƿ����㣺0< length <=3
            if (length == 0 || length > 3) {
                return "Neither";
            }
            // �ж�ÿ���ֵ�ÿһλ�Ƿ�������
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
            // ���ÿ����ֵ�Ƿ��ڣ�0 <= part <= 255
            if (0 > Integer.parseInt(s) || Integer.parseInt(s) > 255) {
                return "Neither";
            }
            // �ж��Ƿ��г��Ȳ�Ϊ1�Ĳ�����0��ͷ
            if (length != 1 && s.charAt(0) == '0') {
                return "Neither";
            }
            // ����ȫ��255
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
