import java.util.ArrayList;

/**
 * @Description: //TODO ��ΪS��������������:����һ�������� target ��������к�Ϊtarget���������������У����ٺ�������������
 *                                        �����ڵ�������С�������У���ͬ���а����׸����ִ�С�������С�
 *                      ���磺
 *                          ���룺target = 9
 *                          �����[[2,3,4],[4,5]]
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/29 23:04
 */
public class main42 {
    /**
     * @Author ZX
     * @Description //TODO �����ϵ�ͬһ�⣺�뷽��1��ͬ
     *                     ��ArrayList<ArrayList<Integer>>ת�ɶ�ά����
     * @Date 16:11 2020/4/1
     * @Param [sum]
     * @return int[][]
     **/
    public static int[][] findContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        // base case
        if (sum == 0)
            return null;

        int p1 = 1; // ��ָ��
        int p2 = 2; // ��ָ��
        while (p1 <= sum / 2 + 1) { // ����֪���ٰ���������p1��p2�������sum/2���ұߣ��������������϶�����sum
            if (sumP1ToP2(p1, p2) == sum) { // p1-p2����Ԫ��֮�͵���sum
                ArrayList<Integer> list = new ArrayList<>(); // �������ڵ�Ԫ�ش���list
                int p1Num = p1; // ����p1λ�ã�ΪѰ����һ��������׼��
                while (p1 <= p2) {
                    list.add(p1++);
                }
                lists.add(list); // �����ҵ����������������д浽lists
                p1 = p1Num;
                p1++; // p1��p2��������
            } else if (sumP1ToP2(p1, p2) < sum) { // p1-p2����Ԫ��֮��С��sum
                p2++; // p2����
            } else { // p1-p2����Ԫ��֮�ʹ���sum
                p1++; // p1����
            }
        }

        // ��ArrayList<ArrayList<Integer>>ת�ɶ�ά����
        int[][] ans = new int[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            ans[i] = new int[lists.get(i).size()];
            for (int j = 0; j < lists.get(i).size(); j++) {
                ans[i][j] = lists.get(i).get(j);
            }
        }

        return ans;
    }

    // ����p1��p2����Ԫ��֮��
    private static int sumP1ToP2(int p1, int p2) {
        return (p1 + p2) * (p2 - p1 + 1) / 2;
    }

    /**
     * @Author ZX
     * @Description //TODO ����1��˫ָ�룺һ������1��һ������2 ----> ���ƻ�������Ԫ��֮�͵���sum
     *                            1.��ָ���Ԫ��֮�͵���sum����p1��p2�����ִ浽list
     *                            2.��ָ���Ԫ��֮��С��sum��p2++�����󻬶����ڵ�����֮��
     *                            3.��ָ���Ԫ��֮�ʹ���sum��p2++����С�������ڵ�����֮��
     *                     ʱ�临�Ӷȣ�O(N)
     * @Date 15:11 2020/4/1
     * @Param [sum]
     * @return java.util.ArrayList<java.util.ArrayList<java.lang.Integer>>
     **/
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        // base case
        if (sum == 0)
            return null;

        int p1 = 1; // ��ָ��
        int p2 = 2; // ��ָ��
        while (p1 <= sum / 2 + 1) { // ����֪���ٰ���������p1��p2�������sum/2���ұߣ��������������϶�����sum
            if (sumP1ToP2(p1, p2) == sum) { // p1-p2����Ԫ��֮�͵���sum
                ArrayList<Integer> list = new ArrayList<>(); // �������ڵ�Ԫ�ش���list
                int p1Num = p1; // ����p1λ�ã�ΪѰ����һ��������׼��
                while (p1 <= p2) {
                    list.add(p1++);
                }
                lists.add(list); // �����ҵ����������������д浽lists
                p1 = p1Num;
                p1++; // p1��p2��������
            } else if (sumP1ToP2(p1, p2) < sum) { // p1-p2����Ԫ��֮��С��sum
                p2++; // p2����
            } else { // p1-p2����Ԫ��֮�ʹ���sum
                p1++; // p1����
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(findContinuousSequence2(9));
    }
}
