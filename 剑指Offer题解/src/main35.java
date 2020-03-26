import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description: //TODO 题目描述 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 *                              如果没有则返回 -1（需要区分大小写）.
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/23 21:11
 */
public class main35 {
    /**
     * @Author ZX
     * @Description //TODO 暴力法，逐个比较i位置处的字符是否在i之前或之后出现过
     *                          时间复杂度：O(N^2)
     * @Date 22:24 2020/3/23
     * @Param [str]
     * @return int
     **/
    public static int FirstNotRepeatingChar1(String str) {
        // base case
        if (str == null || str.length() == 0)
            return -1;

        int ans = -1;
        ArrayList<Character> behind = new ArrayList<>();
        ArrayList<Character> before = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            int j = i + 1;
            while (j < str.length()) {
                behind.add(str.charAt(j));
                j++;
            }
            int h = i - 1;
            while (h >= 0 && h < i) {
                before.add(str.charAt(h));
                h++;
            }
            if (!before.contains(temp) && !behind.contains(temp))
                return ans = i;
            behind.clear();
        }
        return ans;
    }

    /**
     * @Author ZX
     * @Description //TODO 利用哈希表：Key：字符，Value：该字符出现的次数
     *                          时间复杂度：O(N)
     * @Date 22:27 2020/3/23
     * @Param [s]
     * @return int
     **/
    public static int FirstNotRepeatingChar2(String str) {
        // base case
        if (str == null || str.length() == 0)
            return -1;

        int ans = -1; // 需要返回的结果
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), 0);
        }
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("方法1：" + FirstNotRepeatingChar1("abaccdeff"));
        System.out.println("方法2：" + FirstNotRepeatingChar2("abaccdeff"));
    }
}
