import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/30 13:59
 */
public class dangdang1_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt(); // 除数d
        int n = sc.nextInt(); // 数组长度为n
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            int modulus = (sum % d + d) % d;
            int same = map.getOrDefault(modulus, 0);
            ans += same;
            map.put(modulus, same + 1);
        }
        System.out.println(ans);
    }
}
