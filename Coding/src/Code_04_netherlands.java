/**
 * @Description: //TODO ������������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/5 21:09
 */
public class Code_04_netherlands {

    private static void swap(int[] arr, int i, int j) {
        int help = arr[i];
        arr[i] = arr[j];
        arr[j] = help;
    }

    /**
     * @Author ZX
     * @Description //TODO ����ΪС�ڵ��ڡ���������������
     * @Date 21:26 2020/6/5
     * @Param [arr, num]
     * @return void
     **/
    public static void partition1(int[] arr, int num) {

        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        int less = -1; // ��ʼ��С�ڵ���������ұ߽�
        int cur = 0; // ��ǰλ��

        while (cur < arr.length) {
              if (arr[cur] <= num) { // �����ǰ��С�ڵ���num
                  // ��ǰ����С�ڵ��������ұ߽����һ��Ԫ�ؽ���
                  swap(arr, cur, less + 1);
                  // С�ڵ�������������1
                  // ���µ�ǰλ��
                  less++;
                  cur++;
              } else {
                  // ���µ�ǰλ��
                  cur++;
              }
        }

    }

    /**
     * @Author ZX
     * @Description //TODO ����ΪС�ڡ����ڡ���������������
     * @Date 21:39 2020/6/5
     * @Param [arr, num]
     * @return void
     **/
    public static void partition2(int[] arr, int num) {

        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        int less = -1;
        int more = arr.length;
        int cur = 0;

        while (cur < more) {
            if (arr[cur] < num) {
                swap(arr, cur, less + 1);
                less++;
                cur++;
            } else if (arr[cur] == num) {
                cur++;
            } else {
                // ע��˴�cur���ܶ�����Ϊ���������ǰһ���Ǵ���������֪������num�Ĵ�С��ϵ
                swap(arr, cur, more -1);
                more--;
            }
        }

    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 3, 4, 2, 8};
        partition1(arr, 6);
        for (int i : arr) {
            System.out.print(" " + i);
        }
        System.out.println();
        partition2(arr, 5);
        for (int i : arr) {
            System.out.print(" " + i);
        }

    }

}
