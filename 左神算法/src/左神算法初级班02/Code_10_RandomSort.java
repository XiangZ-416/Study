package �����㷨������02;
/*
 * ����Ľ��Ŀ���
 * ����swap(arr, l + (int) (Math.random() * (r - l + 1)), r);��Ϊ�������
 * �������Ϊ�Ĳ��֣���С����+������+������+��������ĩβarr[r]������partition
 */
import java.util.Arrays;

public class Code_10_RandomSort {
    /**
     * ����(�ж������Ƿ�Ϊ��/Ϊ����Ԫ��)
     * @param arr ��������
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * ����
     * @param arr ��������
     * @param cur quickSort��ǰλ��
     * @param r ���������ұ߽�
     */
    public static void quickSort(int[] arr, int cur, int r) {
        if (cur < r) {
            swap(arr, cur + (int) (Math.random() * (r - cur + 1)), r);
            int[] p = partition(arr, cur, r);
            quickSort(arr, cur, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
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
        // ֱ����arr[r]��Ϊ�ȶ����֣���arr[r]������partition
        int more = R;
        while (Cur < more) {
            if (arr[Cur] < arr[R]) {
                swap(arr, ++less, Cur++);
            } else if (arr[Cur] > arr[R]) {
                swap(arr, --more, Cur);
            } else {
                Cur++;
            }
        }
        // ��ĩβarr[r]���������ĵ�һ�����������������Ϊ��С����+������+��������
        swap(arr, more, R);
        return new int[] { less + 1, more };
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 4, 6};
        quickSort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
