package �����㷨������02;

import java.util.Arrays;

public class Code_07_NetherlandsFlagIn {
    /**
     * ��������
     * @param arr ��������
     * @param cur ��ǰ��������λ��
     * @param r ����������ұ߽�
     * @param num ��Ƚϵ�ֵ
     */
    public static void partition(int[] arr, int cur, int r, int num) {
        // С��������ұ߽�
        int less = cur - 1;
        // ����
        // ��current������ĩβʱֹͣ����
        while (cur <= (arr.length - 1)) {
            if (arr[cur] <= num) {
                Swap(arr, cur++, ++less);
            } else {
                cur++;
            }
        }
    }

    public static void Swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        // ��������
        int[] arr = {8, 5, 4, 7, 6};
        partition(arr, 0, arr.length - 1, 6);
        System.out.print(Arrays.toString(arr));
    }
}