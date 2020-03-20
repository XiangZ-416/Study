import java.util.*;

/**
 * @Description:
 * ��Ŀ����
 * ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������[1,2,3,4]��
 *      1.����
 *      2.ȡǰK��������arrayList
 * ʱ�临�Ӷȣ�O(N*N)
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/19 17:02
 */
public class main30 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
       // base case
       if (input == null || k > input.length || k == 0)
            return new ArrayList<Integer>();

       // 1.����
       for (int i = 0; i < input.length; i++) {
           int min = i;
           for (int j = min + 1; j < input.length; j++) {
               if (input[j] < input[min]) {
                   int help = input[j];
                   input[j] = input[min];
                   input[min] = help;
               }
           }
       }

        // 2.ȡǰK��������arrayList
       for (int i = 0; i < k; i++) {
           arrayList.add(input[i]);
       }

       return arrayList;
    }

    public static void main(String[] args) {
        int[] array = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(array, 10));
    }
}
