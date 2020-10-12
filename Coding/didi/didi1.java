import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO  ��Ϥ��A+B
 *                            ʱ�����ƣ� 3000MS
 *                            �ڴ����ƣ� 589824KB
 *                            ��Ŀ������
 *                              A+B���������ˡ�
 *                              ��a��b��c��0��9֮�������������a��b��c������ͬ��������abc��acc��������ͬ����λ����
 *                              �ָ���һ������n�����ж��ٶ�abc��acc������abc+acc=n��a��0����
 *                            ��������
 *                               һ��������n��100<n<2000����
 *                            �������
 *                              ��һ������ж��ٶ�����Ҫ������֡�
 *                              ������ÿһ�����һ��abc��acc���Կո�ָ������û��һ��abc��acc�Ļ�����ֱ�����0���ɡ�
 *                              ����ж�ԣ��밴��abc����Ĵ��������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/21 19:42
 */
public class didi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    if (200 * a + 10*b + 12*c == n && a != b && b != c && a != c) {
                        res++;
                        list.add("" + a + b + c + " " + a + c + c);
                    }
                }
            }
        }
        System.out.println(res);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
