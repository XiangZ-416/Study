import java.util.Scanner;

/**
 * @Description: //TODO ��������:
 *                              ������������n����ʾҪ������ٸ��ַ��������������ַ���(�������ΪN,�ַ�������С��100)��
 *                           �������
 *                              ������Ϊ8���ÿ���ַ�����������µ��ַ������飬���Ȳ���8���������ַ������ں��油����0�����ַ���������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/2 17:33
 */
public class N05�ַ����ָ� {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0; // ������ַ�������
        while(sc.hasNext()) {
            num = sc.nextInt();
            for(int i = 0; i < num; i++) {
                String str = sc.next();
                while(str.length() % 8 != 0 ) { // ��ǰ��ȡ����str�ĳ��Ȳ���8��������
                    str += '0'; // ��'0'ֱ��������8��j������
                }
                for(int j = 0; j < str.length(); j += 8) { // �ָ������ÿ���ַ�����8λ�ַ�Ϊһ��
                    System.out.println(str.substring(j, j + 8));
                }
            }
        }
    }
}
