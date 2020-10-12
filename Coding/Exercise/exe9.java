import java.util.Scanner;

/**
 * @Description: //TODO 剑指Offer42：连续子数组的最大和
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/9/1 17:08
 */
public class exe9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            max = Math.max(max, curSum);
            if (curSum < 0) { // 当前累加和小于0，当前位置不可能是最大累加和的左半部分，抛弃当前累加和
                curSum = 0;
            }
        }
        System.out.println(max);
    }
}
