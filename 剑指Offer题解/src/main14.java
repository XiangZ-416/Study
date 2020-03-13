/**
 * ��Ŀ����
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿��,
 * ���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 */
public class main14 {
    /**
     * ����1�����������ռ�ֱ���������ż��
     * ʱ�临�Ӷȣ�O(N)
     * @param array
     */
    public static void reOrderArray1 (int [] array) {
        // base case
        if (array == null || array.length <=1) {
            return;
        }

        // 1����ȡ�桢ż
        int[] help1 = new int[array.length]; // ��ż��
        int[] help2 = new int[array.length]; // ������
        int j = 0;
        int h = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0){ // ��ǰ��Ϊż��
                help1[j++] = array[i]; // һ��j��ż��
            } else { // ��ǰ��������
                help2[h++] = array[i]; // һ��h������
            }
        }

        // 2�����
        int c = 0;
        for (int i = 0; i < h; i++) { // ��h�������浽array
            array[c++] = help2[i];
        }
        for (int i = 0; i < j; i++) { // ��j��ż���浽array
            array[c++] = help1[i];
        }
    }

    /**
     * ����2�����ò��������˼��
     * ʱ�临�Ӷ�O(N^2)
     * @param array
     */
    public static void reOrderArray2 (int [] array) {
        // base case
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length; i++) { // ��1��ʼ��������array
            if (array[i] % 2 != 0) { //��ǰ��������
                for (int j = i - 1; j >= 0; j--) {
                    if (array[j] % 2 == 0) { // ��ǰ��ǰһ������ż���ͽ���array[j + 1]��array[j]
                        int temp = array[j + 1];
                        array[j + 1] = temp;
                        array[j] = array[j + 1];
                    }else {  // ��ǰ��ǰһ����������ֹͣ����
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 7, 6, 9};
        reOrderArray1(array);
        System.out.println("����1��");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("------");
        reOrderArray2(array);
        System.out.println("����2��");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}