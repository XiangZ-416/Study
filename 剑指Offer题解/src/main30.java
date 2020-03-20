import java.util.*;

/**
 * @Description:
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是[1,2,3,4]。
 *      1.排序
 *      2.取前K个数存入arrayList
 * 时间复杂度：O(N*N)
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/19 17:02
 */
public class main30 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
       // base case
       if (input == null || k > input.length || k == 0)
            return new ArrayList<Integer>();

       // 1.排序
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

        // 2.取前K个数存入arrayList
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
