import java.util.Scanner;

/**
 * @Description: //TODO �ַ���frame�ĳ��ȴ������˹�������Ŀ�ȣ�ÿ���ַ�('0'-'9')�������ײ���Ӧ���ϵĸ��Ӹ���
 *                           �ַ���brickΪ�ϲ�������ķ��飬ÿ���ַ��ĺ������������
 *                           ��ש��brick����frame��ʱ֮���������滹ʣ�µĿ�����С����
 *                           ��֤brick��������ͻ���ġ�
 *                           ����,����
 *                           #k#
 *                           #
 *                           ��brick�������
 *                           frame=="2212"������� (k����Ϊ��)
 *                           ||kkkk||
 *                           ||kkkk||
 *                           ||## #||
 *                           ||####||
 *                           brick = "121" ����ש��
 *                           "###"
 *                           "k#k"
 *                           �����Ϊ2
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/20 10:17
 */
public class main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int[] s11 = new int[s1.length()];
        int[] s22 = new int[s2.length()];
        for(int i=0; i < s2.length(); i++){
            s22[i] = s2.charAt(i)  - '0';
        }
        for (int i = 0; i < s1.length(); i++) {
            s11[i] = s1.charAt(i) - '0';
        }
        int res = Integer.MAX_VALUE;
        int[] sum = new int[s1.length()];
        int i = 0;
        while (i < s1.length() - s2.length()) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0;j< s1.length(); j++) {
                if (j >=i && j - i < s2.length()) {
                    sum[j] = s11[j] + s22[j - i];
                } else {
                    sum[j] = s11[j];
                }
                min = Math.min(min, sum[j]);
                max = Math.max(max, sum[j]);
            }
            res = Math.min(res, max - min);
            i++;
        }
        System.out.println(res);
    }
}
