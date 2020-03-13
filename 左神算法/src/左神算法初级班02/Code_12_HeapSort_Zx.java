package �����㷨������02;
/*
 * �߼���
 * ȫ���ųɴ����heapInsert
 * ����
 * ȥβ��
 * ����heapify
 * ����
 * ȥβ��
 * ....
 * ���鳤�� < 0 ֹͣ;
 */

import java.util.Arrays;

public class Code_12_HeapSort_Zx {
    public static void HeapSort(int[] arr){
        if (arr.length < 2 || arr == null) {
            return;
        }

        for (int i = 0; i < arr.length; i++ ) {
            heapInsert(arr, i); // 0-i֮��ʵ�ִ����
        }

        int r = arr.length - 1; // �����ұ߽�
        Swap(arr, 0, r);
        r = r - 1; // �����ұ߽� - 1
        while (r >= 0) { // ���鳤�ȴ���0
            heapify(arr, 0, r);
            Swap(arr, 0, r);
            r = r - 1;
        }

    }

    // ����
    public static void heapInsert(int[] Arr, int cur) {
        int father = (cur - 1) / 2;
        while (Arr[cur] > Arr[father]) {
            Swap(Arr, cur, father);
            cur = father;
        }
    }

    // ����
    public static void heapify(int[] ARR, int Cur, int size) {
        int left = 2 * Cur + 1;
        while (left < size){
            int right = left + 1;
            // �ҳ����ҡ������ֵ���±�
            int largest = ARR[left] > ARR[right] && right < size ? left : right;
            largest = ARR[largest] > ARR[Cur] ? largest : Cur;
            if (largest == Cur) {
                break;
            }
            Swap(ARR, Cur, largest);
            Cur = largest; // ��ǰλ���³�
            left = 2 * Cur + 1;
        }
    }

    public static void Swap(int[] Arr, int i, int j) {
        int temp = Arr[j];
        Arr[j] = Arr[i];
        Arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 5, 2};
        HeapSort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
