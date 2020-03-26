import java.util.ArrayList;

/**
 * @Description: //TODO ��Ŀ���� ��ֻ����������2��3��5��������������Ugly Number����
 * �󰴴�С�����˳��ĵ�N��������
 * ����: n = 10
 * ���: 12
 * ����: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 ��ǰ 10 ��������
 * ˵��:
 *      1 �ǳ�����
 *      n ������1690
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/21 23:56
 */
public class main34 {
    /**
     * @Author ZX
     * @Description //TODO �ж�number�Ƿ�Ϊ����
     * @Date 17:55 2020/3/23
     * @Param [number]
     * @return boolean
     **/
    public static boolean isUglyNumber(int number) {
        // base case
        if (number == 1)
            return true;

        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;

        return number == 1;
    }

    /**
     * @Author ZX
     * @Description //TODO ����1��1.����ж��������Ƿ�Ϊ������
     *                                 2.�ǵĻ�����arrayList�����arrayList�ĳ��ȵ���index������arrayList�����һ��Ԫ��
     *                                 ʱ�临�Ӷȣ�O(N)
     * @Date 18:06 2020/3/23
     * @Param [n]
     * @return int
     **/
    public static int GetUglyNumber_Solution1(int n) {
        // base case
        if (n == 1)
            return 1;

        ArrayList<Integer> list = new ArrayList<>();

        // ����ж���Ȼ���Ƿ�ʱ����
        for (int i = 1; i < 1690; i++) {
            if (isUglyNumber(i)) {
                list.add(i);
            }
            if (list.size() == n) {
                break;
            }
        }

        return list.get(n - 1);
    }

    /**
     * @Author ZX
     * @Description //TODO ����2��һ������һ������һ����������2���߳���3���߳���5�õ�
     * @Date 18:07 2020/3/23
     * @Param [n]
     * @return int
     **/
    public static int GetUglyNumber_Solution2(int n) {
        // base case
        if (n < 6)
            return n;

        int[] ans = new int[n];
        ans[0] = 1;
        // ��ʼ�ֱ�ָ���������������һ��Ԫ��,������������������������ģ��ֱ����ugly����Ԫ�طֱ����2,3,5�õ���
        int index1 = 0; // ��������2���е��±�
        int index2 = 0; // ��������3���е��±�
        int index3 = 0; // ��������5���е��±�
        for (int i = 1; i < n; i++) {
            ans[i] = Math.min(Math.min(ans[index1] * 2, ans[index2] * 3), ans[index3] * 5);
            // ���������������ͬԪ�أ�����ֻҪ����С�ģ���Ҫ�ƶ�ָ��
            if (ans[i] == ans[index1] * 2)
                index1++;
            if (ans[i] == ans[index2] * 3)
                index2++;
            if (ans[i] == ans[index3] * 5)
                index3++;
        }

        return ans[n - 1];
    }

    public static void main(String[] args) {
        System.out.println("����1��" + GetUglyNumber_Solution1(100));
        System.out.println("����2��" + GetUglyNumber_Solution2(100));
    }
}
