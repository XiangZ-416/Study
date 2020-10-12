import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO С�����ͻ���·
 *                          ʱ�����ƣ� 3000MS
 *                          �ڴ����ƣ� 589824KB
 *                          ��Ŀ������
 *                              С�������ŵ�һ���ʻ����Ա���ʻ���һ�ֱ����ڷǳ��̵���Ʒ��������Ҫ�����͵��ͻ����У���˾�������ֵ�һ��Ҫ�����Ҫ�滮�ͻ�����
 *                              ·��ʹ�������������ж����ߵ�·�̾������١�(���ֿ�ʼ����ʱ������������Ҫ���͵Ļ�������ÿ���󷵻ػ��꣬·�̽����Ǵӻ����������
 *                              �������һ���ͻ�Ϊֹ������������һ���ͻ��һص������ʱ��)����˾�������ֵļ�Ч������ȡ��������ָ�꣬һ�Ǵӻ��굽���пͻ���ַ
 *                              �ľ���֮�ͣ���һ��������ʵ���ߵ�·�̡��軨��ʼ��λ��1��λ�ã��ͻ�����n-1��������Ϊ2~n����dis(i,j)��ʾi��λ�õ�j��λ�õľ�
 *                              �룬���ֱ���� , ������ʵ�����ߵ����·�̡�
 *                              Ϊ�˼����⣬����Լ����n��λ�ù��ɵ���һ��������ֻ��n-1���������л������ӣ��ұ�֤n����˴���ͨ��
 *                          ��������
 *                              �����һ�а���һ��������n��������Ϳͻ���������(1<=n<=30000)
 *                              ��������n-1�У�ÿ������������u,v,w����ʾ��u��v֮�����һ������Ϊw�ĵ�·��(1<=w<=1000)
 *                          �������
 *                              ������������������м��ÿո�������ֱ��ʾ���굽���пͻ���ַ�ľ���֮�ͺ�����ʵ���ߵ�·�̡�
 *                          ��������
 *                              5
 *                              1 2 3
 *                              1 3 1
 *                              1 4 2
 *                              2 5 1
 *                          �������
 *                              10 10
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/8 17:10
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n+1][n+1];
        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int sum  = 0;
        for (int i = 1; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            nums[x][y] = sc.nextInt();
            sum +=nums[x][y];
            if (x == 1) {
                res += nums[x][y];
            } else {
                list.add(x);
                res += nums[x][y];
            }
        }
        while (list.size() != 0) {
            Integer j = list.remove(0);
            if (nums[1][j] != 0) {
                res += nums[1][j];
                continue;
            } else {
                int min = Integer.MAX_VALUE;
                int t = n + 1;
                for (int i = 2; i < n;i ++) {
                    if (nums[i][j] != 0 && nums[i][j] < min) {
                        min = nums[i][j];
                        t = i;
                    }
                }
                res += nums[t][j];
                list.add(t);
            }
            list.remove(0);
        }
        System.out.println(res+" "+res);
    }
}
