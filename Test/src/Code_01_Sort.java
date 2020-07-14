/**
 * @Description: //TODO ���������㷨
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/4 14:48
 */
public class Code_01_Sort {

    //��������Ԫ��
    private static void swap(int[] arr, int i, int j) {
        int help = arr[i];
        arr[i] = arr[j];
        arr[j] = help;
    }

    /**
     * @Description //TODO ð������ʱ�临�Ӷ�O(N^2)������ռ临�Ӷ�O(1)
     * @Author ZX
     * @Date 12:17 2020/6/7
     * @Param [arr]
     **/
    public static void bubbleSort(int[] arr) {
        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) { // ÿ�ι涨һ����Χ���ҳ��÷�Χ�������ŵ����
            for (int j = 0; j < i; j++) { // ����Ƚ����ڵ�����Ԫ��
                if (arr[j] > arr[j + 1]) { // ǰһ�������ں�һ����������
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * @Description //TODO ѡ������ʱ�临�Ӷ�O(N^2)������ռ临�Ӷ�O(1)
     * ��0 - n-1��һ����С�������ŵ�0λ�ã���1 - n-1��һ����С�����ŵ�1λ�ã�....
     * @Author ZX
     * @Date 12:17 2020/6/7
     * @Param [arr]
     **/
    public static void selectSort(int[] arr) {
        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * @Description //TODO ��������
     *                          ���������������򣩣�ʱ�临�Ӷ�O(N)
     *                          ������������������ʱ�临�Ӷ�O(N^2) ѡ����Ϊ���㷨�ĸ��Ӷ�
     *                          ����ռ临�Ӷ�O(1)
     * @Author ZX
     * @Date 12:16 2020/6/7
     * @Param [arr]
     **/
    public static void insertSort(int[] arr) {
        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                    swap(arr, j, j + 1);
            }
        }

    }

    /**
     * @Description //TODO �鲢����ʱ�临�Ӷ�O(N*logN)������ռ临�Ӷ�O(N)
     * @Author ZX
     * @Date 12:16 2020/6/7
     * @Param [arr]
     **/
    public static void mergeSort(int[] arr) {
        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        // ����L��R���е�
        int mid = (L + R) / 2;
        // L ~ mid�ź�
        sortProcess(arr, L, mid);
        // mid+1 ~ R�ź�
        sortProcess(arr, mid + 1, R);

        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        // ������������
        int[] help = new int[r - l + 1];
        // ��������ָ�룬�ֱ��������źõ�������ұ��źõ�����
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        // ���������źõ�����ض�����ֻ��һ��û��ȫ��������help��
        // �����û������
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        // ����ұ�û������
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        //����������help��Ԫ�ؿ�����ԭ����arr
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

    }

    /**
     * @Description //TODO ��������������״���й�
     * @Author ZX
     * @Date 12:16 2020/6/7
     * @Param [arr, L, R]
     **/
    public static void quickSort(int[] arr, int L, int R) {
        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        int[] equal = partition(arr, L, R);
        int l = equal[0];
        int r = equal[1];
        partition(arr, L, l);
        partition(arr, r, R);

    }

    private static int[] partition(int[] arr, int l, int r) {

        int less = l - 1;
        int more = r; // more���ü�1����Ϊ�����һ����Ϊ�ο����Ƚϣ��ٶ����һ����������more����
        int cur = l;

        while (cur < more) {
            if (arr[cur] < arr[r]) {
                swap(arr, cur, less + 1);
                less++;
                cur++;
            } else if (arr[cur] == arr[r]) {
                cur++;
            } else {
                swap(arr, cur, more - 1);
                more--;
            }
        }
        swap(arr, more, r); // ��more����ĵ�һ���������������һ������������Ϊarr[r]�ǲο���Ҳ�ǵ���arr[r]�����������λ
        return new int[]{less, more};
    }

    /**
     * @Description //TODO ������ţ���������ʱ�临�Ӷ�ΪO(N*logN)
     * @Author ZX
     * @Date 12:23 2020/6/7
     * @Param [arr, L, R]
     **/
    public static void randomQuickSort(int[] arr, int L, int R) {
        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        swap(arr, (int) (L + (Math.random() * (R - L + 1))), R); // ��arr�����ѡһ������Ϊ�Ƚ϶���

        int[] partition1 = partition(arr, L, R);
        int l = partition1[0];
        int r = partition1[1];
        partition(arr, L, l);
        partition(arr, r, R);

    }

    /**
     * @Description //TODO ������
     * @Author ZX
     * @Date 16:19 2020/6/7
     * @Param [arr]
     * @return void
     **/
    public static void heapSort(int[] arr) {

        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        // ��0 ~ i֮���Ԫ���γɴ����
        for(int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // ��ʱ��������arr�Ѿ��Ǵ���ѣ�������
        int heapSize = arr.length;
        swap(arr, 0, --heapSize); // ��������0 ~ N���Ԫ���Ƶ�ĩβ���ѳ��ȼ�1
        while (heapSize > 0) {
            heapify(arr, 0, heapSize); // ��ʣ�µ�N - 1��Ԫ�����µ���Ϊ����ѣ��Դ�����
            swap(arr, 0, --heapSize); // ����0 ~ N - 1���Ԫ�ص�N - 1λ�ã� �ѳ����ټ�1
        }

    }

    private static void heapInsert(int[] arr, int cur) {
        while (arr[cur] > arr[(cur - 1) / 2]) {
            swap(arr, cur, (cur - 1) / 2);
            cur = (cur - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int cur, int heapSize) {
        int left = cur * 2 + 1;
        while (left < heapSize) { // left�ڶ���
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left; // ������Һ��ӣ��ҳ����Һ��ӽϴ�Ľڵ��±�
            largest = arr[largest] > arr[cur] ? largest : cur; // �ҳ����ڵ������Һ��ӽϴ�Ľڵ��нϴ�Ľڵ��±�
            if (largest == cur) { // ������ڵ���������󣬲��õ���
                break;
            }
            swap(arr, largest, cur); // ������ڵ��³�
            cur = largest;
            left = cur * 2 + 1;
        }
    }


    public static void main(String[] args) {

        int[] arr = {4, 5, 2, 7};
        // ð������
        // bubbleSort(arr);

        // ѡ������
        // selectSort(arr);

        // ��������
        // insertSort(arr);

        // �鲢����
        // mergeSort(arr);

        // ��������
        // quickSort(arr, 0, arr.length - 1);

        // �����������
        // randomQuickSort(arr, 0, arr.length - 1);

        // ������
        heapSort(arr);

        for (int x : arr) {
            System.out.print(" " + x);
        }

    }
}
