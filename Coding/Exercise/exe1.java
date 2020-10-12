import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description: //TODO 一个整数数组统计数组每个元素中比他小的个数
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/30 21:47
 */
public class exe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 数组长度为n
        int[] nums = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] copyNums = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        ans[0] = 0;
        map.put(nums[0], ans[0]);
        for (int i = 1; i < n; i++) {
            int index = i - 1;
            int sum = 0;
            while (nums[index--] < nums[i] && index >= 0) {
                sum++;
            }
            ans[i] = sum + 1;
            map.put(nums[i], ans[i]);
        }
        for (int num : copyNums) {
            System.out.print(map.get(num) + " ");
        }
    }
}
