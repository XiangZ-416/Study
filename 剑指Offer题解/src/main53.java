/**
 * @Description: //TODO 正则表达式匹配：给你一个字符串s和一个字符规律p，请你来实现一个支持'.'和'*'的正则表达式匹配。
 *                                      '.' 匹配任意单个字符
 *                                      '*' 匹配零个或多个前面的那一个元素
 *                                      所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 *                               说明:
 *                                      s可能为空，且只包含从a-z的小写字母。
 *                                      p可能为空，且只包含从a-z的小写字母，以及字符.和*。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/6 21:39
 */
public class main53 {
    public static boolean match(String s, String p) {
        return solve(s, p, 0, 0);
    }

    /**
     * 字符串匹配
     * @param s 字符串1
     * @param p 字符串2
     * @param index1 字符串1的下标
     * @param index2 字符串2的下标
     * @return 当前s和p的匹配结果
     */
    private static boolean solve(String s, String p, int index1, int index2) {

        // 递归终止条件1
        if (index1 == s.length() && (index2 == p.length() || (index2 + 1 == p.length() - 1 && p.charAt(index2 + 1) == '*'))) {
            return true;
        }

        // 递归终止条件2
        if (index1 == s.length() || p.length() == index2) {
            if (index1 == s.length()) {
                return change(p, index2);
            } else {
                return false;
            }
        }

        // p当前字符的下一个位置的字符是*
        if(index2 + 1 < p.length() && p.charAt(index2 + 1) == '*') {
            if(judge(s.charAt(index1), p.charAt(index2))) {
                return solve(s, p, index1, index2 + 2) || solve(s, p, index1 + 1, index2);
            } else {
                return solve(s, p, index1, index2 + 2);
            }
        }

        // 当前两个下标所指的字符匹配
        if (judge(s.charAt(index1), p.charAt(index2))) {
            return solve(s, p, index1 + 1, index2 + 1);
        }

        return false; // 当前的index1所指的字符与index2所指的字符不一致
    }

    private static boolean change(String p, int index2) {
        while (index2 < p.length()) {
            if (index2 + 1 < p.length() && p.charAt(index2 + 1) == '*') {
                index2 += 2;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param s1 字符1
     * @param s2 字符2
     * @return 两个字符是否匹配的结果
     */
    private static boolean judge(char s1, char s2) {
        if (s1 == s2 || s2 == '.') {
            return true;
        }
        return false;
    }

    public static boolean match(char[] str, char[] pattern) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (char x : str) {
            s1.append(x);
        }
        for (char x : pattern) {
            s2.append(x);
        }
        return solve(s1.toString(), s2.toString(), 0, 0);
    }
}
