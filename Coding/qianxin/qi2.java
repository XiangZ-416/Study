/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/9/2 15:48
 */
public class qi2 {
    public static int house (int[] person) {
        int ans = 0;
        // write code here
        int minIndex = 0;
        int min = person[0];
        for (int i = 1; i < person.length; i++) {
            if (person[i] < min) {
                minIndex = i;
            }
        }
        ans = 1;
        min = 1;
        for (int i = minIndex + 1; i < person.length; i++) {
            if (person[i] > person[i - 1]) {
                min = min + 1;
                ans += min;
            }else {
                min = 1;
                ans += min;
            }
        }
        min = 1;
        for (int i = minIndex - 1; i >= 0; i--) {
            if (person[i] > person[i + 1]) {
                min = min + 1;
                ans += min;
            } else {
                min = 1;
                ans += min;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        System.out.println(house(nums));
    }
}
