public class main06 {
    /**
     * ����1����������������������Сֵ
     * ʱ�临�Ӷȣ�O(N)
     * @param array
     * @return
     */
    public static int minNumberInRotateArray1(int[] array) {
        // �������СΪ0������0
        if (array == null) {
            return 0;
        }
        int min = Findmin(array);
        return min;
//        int ans = array[0];
//        for (int i = 1; i < array.length; i++){
//            ans = Math.min(ans, array[i]);
//        }
//        return ans;
    }

    public static int Findmin(int[] arr) {
        int Min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < Min) {
                Min = arr[i];
            }
        }
        return Min;
    }

    /**
     * ����2������ת������Ѱ��ԭ����ĵ�һ��Ԫ��
     * ʱ�临�Ӷȣ�O(logN)
     * @param array
     * @return
     */
    public static int minNumberInRotateArray2(int [] array) {
        if (array == null) {
            return 0;
        }

        int l = 0;
        int r = array.length - 1;
        while (l < r - 1) {
            int mid = (l + r) >> 1;
            if (array[l] <= array[mid]) { // mid��array�����ӷǵݼ�������
                l = mid;
            }else if (array[l] >= array[mid]) { // mid��array�����ӷǵݼ�������
                r = mid;
            }
        }
        return array[r];
    }

    public static void main(String[] args) {
        int[] arr1 = {2,2,2,0,1};
        System.out.println("����1��" + minNumberInRotateArray1(arr1));
        int[] arr = null;
        System.out.println("����1��" + minNumberInRotateArray1(arr));
        System.out.println("--------------");
        System.out.println("����2��" + minNumberInRotateArray2(arr));

    }
}
