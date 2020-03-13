package �����㷨������02;

import java.util.Arrays;

public class Code_08_NetherlandsFlag {
    /**
     * ��������
     * @param arr ��������
     * @param current ��ǰ��������λ��
     * @param r ����������ұ߽�
     * @param num ��Ƚϵ�ֵ
     */
    public static void partition(int[]arr, int current, int r ,int num) {
        // ����С��������ұ߽�
        int less = current - 1;
        // ��������������߽�
        int more = r + 1;
        // �жϲ�����
        // ��ǰλ��������������߽�ʱ
        while (current != more) { // ��ǰλ���ص�����������߽�λ��ʱֹͣ����
            if (arr[current] < num) { // ��ǰλ��Ԫ��С��num
                // ��ǰλ��Ԫ����С�������ұ߽���һλλ��Ԫ�ؽ�������ǰλ������һλ��С�������ұ߽�����һλ
                Swap(arr, current++, ++less);
            }else if (arr[current] == num) { // ��ǰλ��Ԫ�ص���num
                // ��ǰλ������һλ
                current++;
            }else { // ��ǰλ��Ԫ�ش���num
                // ��ǰλ��Ԫ�������������߽�ǰһλԪ�ؽ�������ǰλ�ò��䣬����������߽�����һλ
                Swap(arr, current, --more);
            }
        }
    }

    public static void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // ������������
        int[] arr = {1, 5, 3, 4, 2, 8};
        // ���û��ַ���
        partition(arr, 0, arr.length - 1, 5);
        // �����ֺ���ַ�����ӡ
        System.out.println(Arrays.toString(arr));
    }
}