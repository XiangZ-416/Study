import java.util.*;

/**
 * @Description: //TODO 剑指Offer48：找字符串最长不重复子串长度
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/30 22:44
 */
public class exe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str== null || str.length() == 0) {
            System.out.println(0);
        }
        char[] chars = str.toCharArray();
        ArrayList<StringBuffer> list = new ArrayList<>();
        for (int start = 0; start < chars.length; start++) {
            HashSet<Character> set = new HashSet<>();
            StringBuffer sb = new StringBuffer();
            list.add(sb.append(chars[start]));
            set.add(chars[start]);
            int end = start + 1;
            while (end < chars.length && !set.contains(chars[end])) {
                list.add(sb.append(chars[end]));
                set.add(chars[end]);
                end++;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i).length();
        }
        Arrays.sort(ans);
        System.out.println(ans[ans.length - 1]);
    }

    // 方法二：用set维护一个不含重复字符的窗口l ~ r
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for(int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while(set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
