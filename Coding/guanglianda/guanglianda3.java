import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description: //TODO ������ͬ
 * ʱ�����ƣ� 3000MS
 * �ڴ����ƣ� 589824KB
 * ��Ŀ������
 * ����ϣ��һ�������е�Ԫ���Ǹ�����ͬ�ģ������������ʵ�������в��ġ����ڸ���һ������A������������Щ��ͬ��Ԫ�أ������ṩ��һ�ֱ仯��ʽ��ʹ�þ������ɴβ�����һ�����Եõ�һ��Ԫ�ظ�����ͬ�����С�
 *
 * ��������������ģ���xΪ��������С�����ظ������֣�����Ҫɾ������������һ��x�����ѵڶ���x�滻Ϊ2*x��
 *
 * ����������յ����С�
 *
 * ����ԭ������[2,2,1,1,1],һ�α任���Ϊ[2,2,2,1]�����α任���Ϊ[4,2,1]���任����
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/9/9 21:49
 */
public class guanglianda3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                arr[map.get(arr[i])] = -1;
                map.remove(arr[i]);
                arr[i] = 2 * arr[i];
                while (map.containsKey(arr[i])) {
                    arr[map.get(arr[i])] = -1;
                    map.remove(arr[i]);
                    arr[i] = 2 * arr[i];
                }
                map.put(arr[i], i);
            } else {
                map.put(arr[i], i);
            }
        }
        for (int num : arr) {
            if (num !=  -1) {
                System.out.print(num + " ");
            }
        }
        for (int i = 0; i < arr.length; i++) {
            while (map.containsKey(arr[i])) {
                arr[map.get(arr[i])] = -1;
                map.remove(arr[i]);
                arr[i] = 2 * arr[i];
            }
            map.put(arr[i], i);
        }
    }
}
