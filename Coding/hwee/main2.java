import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description: //TODO ����Ϊ����
 *                              ��һ�У�N �������Ľڵ����
 *                              �ڶ��У�N�����֣�ÿ������Ϊ�ڵ����ȣ���û����ԭ����������������
 *                          ������������������Ķ������ĸ��������(%10^9+)
 *                          ������
 *                              ����
 *                                  4
 *                                  1 0 2 2
 *                              ���
 *                                  2
 *                          ��������4���ڵ㣬��һ���ڵ�����Ϊ1����һ���ڵ�����Ϊ0����2���ڵ�����Ϊ2�����ܵĶ��������£�
 *                              x                   x
 *                             /                      \
 *                           x                          x
 *                         /   \                      /   \
 *                       x       x                  x       x
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/20 10:18
 */
public class main2 {
    public static final int Mod  = 1000000007;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // n���ڵ�

        // ��¼ÿһ���Ӧ�Ľڵ���Ŀ
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLevel = 0;
        int level = 0;
        for(int i=0; i < n; i++) {
            level = in.nextInt();
            map.put(level, map.getOrDefault(level, 0) + 1);
            maxLevel = Math.max(maxLevel, level);
        }

        long res = 1;
        int preLNums = 1;
        int curLNums = 1;
        for(int i=1; i <= maxLevel; i++) {
            curLNums = map.get(i);
            res *= getNums(preLNums, curLNums);
            res = res % Mod;
            preLNums = curLNums;
        }
        System.out.println(res);
    }

    private static long getNums(int preLNums, int curLNums) {
        int nums = 2*preLNums;
        double count = 1;
        for(int i=0; i < curLNums; i++) {
            // �������
            count *= (double)(nums - i)/(double)(curLNums-i); // long��int���Ͳ��У�ÿ��ֱ�ӳ���������,n=5,m=3�����6��n=5,m=2,�����6��
            count %= Mod;
        }
        return (long)count;
    }
}
