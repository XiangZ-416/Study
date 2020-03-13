package �����㷨������02;

import java.util.Arrays;

public class Code_11_HeapSort {
    /**
     * �������������
     * @param arr ��������
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i); // 0-i֮���γɴ����
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    /**
     * �Ӷѣ����ƣ������µ������������У�
     * @param arr ��������
     * @param cur ��ǰλ��
     */
    public static void heapInsert(int[] arr, int cur) {
        // ��λ�ã�index - 1) / 2
        while (arr[cur] > arr[(cur - 1) / 2]) {
            swap(arr, cur, (cur - 1) / 2);
            // ��ǰλ��Ų����ǰλ�õĸ�λ�ô������ж�
            cur = (cur - 1) / 2;
        }
    }

    /**
     * ���ѣ��³���ȥ������������е�����ʣ�µĻ�Ҫ�Ǵ���ѣ�
     * @param Arr ʣ�µ�����
     * @param Cur ��ǰλ��
     * @param size ʣ������ĳ��ȣ�size <= arr.length()
     */
    public static void heapify(int[] Arr, int Cur, int size) {
        int left = Cur * 2 + 1;
        // �жϵ�ǰλ�õ�������û��Խ�ұ߽�
        while (left < size) {
            // ���Ӻ��Һ���(��Խ�ұ߽�)˭��˭���±����largest
            int largest = left + 1 < size && Arr[left + 1] > Arr[left]
                    ? left + 1
                    : left;
            // ���Һ��ӵ����ֵ�͵�ǰλ��˭��˭����largest
            largest = Arr[largest] > Arr[Cur]
                    ? largest
                    : Cur;
            // �����ǰλ�ú����Һ�����ȣ����ֵ�ǵ�ǰλ�ã���ǰλ�ò������³�
            if (largest == Cur) {
                break;
            }
            // ���򽫵�ǰλ��Ԫ�غ�largestλ��Ԫ�ؽ���
            swap(Arr, largest, Cur);
            // ����ǰλ��Ų��largestλ�ô�������ǰλ�����³�
            Cur = largest;
            // ����Ѱ�ҵ�ǰλ�õ�����
            left = Cur * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 5, 2};
        heapSort(arr);
        System.out.print(Arrays.toString(arr));
    }
}