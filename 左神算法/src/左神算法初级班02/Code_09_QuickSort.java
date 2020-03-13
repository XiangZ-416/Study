package �����㷨������02;
/*
 * ����Ľ��Ŀ��ţ��Լ�ʵ�֣�
 */
import java.util.Arrays;

public class Code_09_QuickSort {
    /**
     * ����(�ж������Ƿ�Ϊ��/Ϊ����Ԫ��)
     * @param arr ��������
     */
    public static void QuickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        QuickSort(arr, 0, arr.length - 1);
    }

    /**
     * ����
     * @param arr ��������
     * @param cur quickSort��ǰλ��
     * @param r ���������ұ߽�
     */
    public static void QuickSort(int[] arr, int cur, int r) {
        if (cur < r) {
            int[] p = partition(arr, cur, r);
            QuickSort(arr, cur ,p[0] - 1);
            QuickSort(arr, p[1] + 1, r);
        }
    }

    /**
     * ����
     * @param arr ��������
     * @param Cur partition��ǰλ��
     * @param R ���������ұ߽�
     * @return �����������β
     */
    public static int[] partition(int[] arr, int Cur, int R) {
        int less = Cur - 1;
        int more = R + 1;
        // �ò����������һ��Ԫ����Ϊnum���Ƚ�
        int num = arr[R];
        while (Cur != more) {
            if (arr[Cur] < num) {
                Swap(arr, Cur++, ++less);
            } else if (arr[Cur] == num) {
                Cur++;
            }else {
                Swap(arr, Cur, --more);
            }
        }
        // ���ص����������ʼ�±�
        return new int[] {less + 1, more - 1};
    }

    public static void Swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 4, 6};
        QuickSort(arr);
        System.out.print(Arrays.toString(arr));
    }
}