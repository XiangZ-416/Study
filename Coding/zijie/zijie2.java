import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/9/6 15:34
 */
public class zijie2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 数组长度
        long[] nums = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nums[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            ans.add(L(nums, i) * R(nums, i));
        }
        Collections.sort(ans);
        System.out.println(ans.get(ans.size() - 1));
    }

    private static int R(long[] nums, int i) {
        int res = 0;
        for (int k = i + 1; k < nums.length; k++) {
            if (nums[k] > nums[i]) {
                res = k;
                return res;
            }
        }
        return res;
    }

    private static int L(long[] nums, int i) {
        int res = 0;
        for (int j = 1; j < i; j++) {
            if (nums[j] > nums[i]) {
                res = j;
                if (j > res) {
                    res = j;
                }
            }
        }
        return res;
    }
}
