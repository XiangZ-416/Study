import java.util.Scanner;

/**
 * @Description: //TODO ��һ���ַ���str�����ݵߵ��������������str�ĳ��Ȳ�����100���ַ��� �磺���롰I am a student���������tneduts a ma I����
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/2 17:27
 */
public class N03�ַ����� {
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
