import java.util.Scanner;

/**
 * @Description: //TODO ������
 * ʱ�����ƣ� 3000MS
 * �ڴ����ƣ� 589824KB
 * ��Ŀ������
 * �㹺����һ�������ˣ�������ʣ��C��λ��������������������һЩ���������Լ�����������n�ֶ�����ÿ�ֶ��������һ�Σ���Ϊ������û������ظ���һ�ֶ��������ĵġ�ÿ�ֶ�������һ���̶���������ci��λ�������Լ�������������ö�wi�������������Χ�������������������õĶ����������Ķ������ܵ������Ĳ��ܳ���C����ʹ���ö�֮����󡣣����ǽ��龰�򻯣������ڿ�ʼ����ǰ��Ҫ�۳����������������޷���ʼ���������ڶ������е�һ���״̬��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/9/9 21:51
 */
public class guanglianda2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int C = sc.nextInt();
        float[] c = new float[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextFloat();
            w[i] = sc.nextInt();
        }
        long[] dp = new long[C + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = C; j >= c[i]; --j) {
                dp[j] = Math.max(dp[j], dp[(int)(j - c[i] + 0.5)] + w[i]);
            }
        }
        System.out.println(dp[C]);
    }
}
