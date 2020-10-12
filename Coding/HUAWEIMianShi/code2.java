/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/9/16 13:40
 */
public class code2 {
    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    ans[i] = j - i;
                    break;
                } else {
                    ans[i] = 0;
                }
            }
        }
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
