/**
 * @Description: //TODO �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 *                           ����һ�����飬�����������е�����Ե�������
 *                      ʾ��:
 *                           ����: [7,5,6,4]
 *                           ���: 5
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/23 23:03
 */
public class main36 {
    /**
     * @Author ZX
     * @Description //TODO �ϲ�+ͳ��ÿһ�κϲ�ʱ���������
     * @Date 18:11 2020/3/24
     * @Param [Arr, L, M, R]
     * @return int
     **/
    private static long merge(int[] Arr, int L, int M, int R) {
        int p1 = L; // ���ָ��
        int p2 = M + 1; // �ұ�ָ��
        int[] help = new int[R - L + 1]; // ����ź����ԭ����
        int index = 0;
        long ANS = 0; // ��ʼ���������
        while (p1 <= M && p2 <= R) {
            ANS += (Arr[p1] > Arr[p2]) ? (M - p1 + 1) : 0;
            help[index++] = (Arr[p1] <= Arr[p2]) ? Arr[p1++] : Arr[p2++];
        }
        while (p1 <= M) {
            help[index++] = Arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = Arr[p2++];
        }
        for (index = 0; index < help.length; index++) { // ���ź�������鸳ֵ��ԭ���飬������ظ�ͳ��
            Arr[L + index] = help[index];
        }

        return ANS;
    }

    /**
     * @Author ZX
     * @Description //TODO ����ArrayΪ������
     * @Date 18:11 2020/3/24
     * @Param [Array, l, r]
     * @return int
     **/
    private static long Divide(int[] Array, int l, int r) {
        // base case
        if (l == r)
            return 0;

        int mid = l + ((r - l) >> 1); // �е�

        return Divide(Array, l, mid) + Divide(Array, mid + 1, r) + merge(Array, l, mid, r);

    }

    /**
     * @Author ZX
     * @Description //TODO �鲢���������ͳ�������
     * @Date 21:46 2020/3/24
     * @Param [array]
     * @return int
     **/
    public static int InversePairs(int [] array) {
        // base case
        if (array == null || array.length < 2)
            return 0;

        long ans = 0; // �������
        ans = Divide(array, 0, array.length - 1);

        return (int)ans;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 3, 1};
        System.out.println(InversePairs(array));
    }
}
