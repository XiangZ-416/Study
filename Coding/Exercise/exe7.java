import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO 力扣17：电话号码的字母组合
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/9/1 12:21
 */
public class exe7 {
    public static void main(String[] args) {
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Scanner sc = new Scanner(System.in);
        String nums = sc.nextLine();
        ArrayList<String> ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        if (nums == null || nums.length() == 0) {
            System.out.println(ans.toString());
        }
        solve(map, nums, 0, ans, sb);
        System.out.println(ans.toString());
    }

    private static void solve(String[] map, String nums, int index, ArrayList<String> ans, StringBuffer sb) {
        if (index == nums.length()) { // 枚举到最后一位电话号码时index已经是nums.length()
            ans.add(sb.toString());
            return;
        }
        int curNum = nums.charAt(index) - '0';
        int len = sb.length();
        for (int i = 0; i < map[curNum].length(); i++) {
            sb.append(map[curNum].charAt(i));
            solve(map, nums, index + 1, ans, sb);
            sb.setLength(len); // 回溯
        }
    }
}
