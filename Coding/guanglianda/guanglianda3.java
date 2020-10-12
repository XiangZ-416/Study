import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description: //TODO 各不相同
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 我们希望一个序列中的元素是各不相同的，但是理想和现实往往是有差距的。现在给出一个序列A，其中难免有些相同的元素，现在提供了一种变化方式，使得经过若干次操作后一定可以得到一个元素各不相同的序列。
 *
 * 这个操作是这样的，令x为序列中最小的有重复的数字，你需要删除序列左数第一个x，并把第二个x替换为2*x。
 *
 * 请你输出最终的序列。
 *
 * 例如原序列是[2,2,1,1,1],一次变换后变为[2,2,2,1]，两次变换后变为[4,2,1]，变换结束
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/9/9 21:49
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
