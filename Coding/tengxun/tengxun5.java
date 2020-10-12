import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/9/6 20:03
 */
public class tengxun5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.nextLine();
        String[] nums = sc.nextLine().split(" ");
        HashMap<Character, Integer> map1 = new HashMap<>(); // 字符 -> 下标
        HashMap<Integer, Integer> map2 = new HashMap<>(); // 下标 -> 编号
        for (int i = 0; i < str.length(); i++) {
            map1.put(str.charAt(i), i);
        }
        for (int i = 0; i < str.length(); i++) {
            map2.put(i, Integer.parseInt(nums[i]));
        }
        int ans = 0; // 交换次数

    }
}
