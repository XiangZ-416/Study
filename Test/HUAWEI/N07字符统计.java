import java.util.Scanner;

/**
 * @Description: //TODO ��������:
 *                              ����һ���ַ���
 *                           �������
 *                              ���ַ��еĸ���Ӣ���ַ�����Сд�ֿ�ͳ�ƣ������֣��ո����ͳ�ƣ�������ͳ�Ƹ����ɶൽ�����,���ͳ�Ƶĸ�����ͬ��
 *                              ����ASII����С����������� ������������ַ��������Щ�ַ����ý���ͳ�ơ�
 *                           ����
 *                              aadddccddc
 *                           ���
 *                              dca
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/2 17:40
 */
public class N07�ַ�ͳ�� {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {      //��ʾ���Բ��������ַ����ĵĵó����������β���
            String str = in.next();
            int max = 0;
            int[] count = new int[256];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i)]++;
                if (count[str.charAt(i)] > max) {
                    max = count[str.charAt(i)];
                }
            }
            while (max != 0) {
                for (int i = 0; i < 256; i++) {
                    if (count[i] == max) {
                        System.out.print((char) (i));
                    }
                }
                max--;
            }
            System.out.println();
        }
    }
}
