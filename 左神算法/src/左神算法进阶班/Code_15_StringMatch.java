package 左神算法进阶班;

/**
 * @Description: //TODO 字符串匹配问题
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/5 18:50
 */
public class Code_15_StringMatch {

    /**
     * 字符串匹配问题
     * 给定字符串str, 不含有'.' 和 '*'，字符串exp，可以
     * 含有'.'和 '*'，且'*'不是exp的首字符，任意两个'*'
     * 不相邻。
     * exp中的'.'代表任意一个字符, '*' 代表'*'之前的字符
     * 可以有0个或多个
     * 判断str是否能被exp匹配
     */
    public static class stringMatch {

        //判断两个数组是否有效
        public boolean isValid(char[] s, char[] e) {
            for (int i = 0; i < s.length; i++) {
                if (s[i] == '.' || s[i] == '*') {
                    return false;
                }
            }
            for (int i = 0; i < e.length; i++) {
                if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
                    return false;
                }
            }
            return true;
        }

        // 主函数
        public boolean isMatch(String str, String exp) {
            if (str == null || exp == null) {
                return false;
            }
            char[] arrStr = str.toCharArray();
            char[] arrExp = exp.toCharArray();
            return isValid(arrStr, arrExp) && process(arrStr, arrExp, 0, 0);
        }

        // 递归过程：str[i..一直到最后]这个字符串，能不能被exp[j..一直到最后]的字符串匹配
        public boolean process(char[] str, char[] exp, int i, int j) {
            if (j == exp.length) { // 字符串exp匹配完了，str也必须匹配完才使true
                return i == str.length;
            }
            // 此时j上面还有字符，考察j + 1的情况
            if (j + 1 == exp.length || exp[j + 1] != '*') {
                return i != str.length && (exp[j] == str[i] || exp[j] == '.')
                        && process(str, exp, i + 1, j + 1);
            }
            // 此时exp的j + 1位置，不仅有字符而且是'*'
            while (i != str.length && (exp[j] == str[i] || exp[j] == '.')) {
                if (process(str, exp, i, j + 2)) {
                    return true;
                }
                i++;
            }
            return process(str, exp, i, j + 2);
        }

        //动态规划求解
        public boolean isMatchDP(String str, String exp) {
            if (str == null || exp == null) {
                return false;
            }
            char[] s = str.toCharArray();
            char[] e = exp.toCharArray();
            if (!isValid(s, e)) {
                return false;
            }
            boolean[][] dp = initDP(s, e);
            for (int i = s.length - 1; i > -1; i--) {
                for (int j = e.length - 2; j > -1; j--) {
                    if (e[j + 1] != '*') {
                        dp[i][j] = (s[i] == e[j] || e[j] == '.') && dp[i + 1][j + 1];
                    } else {
                        int si = i;
                        while (si != s.length && (s[si] == e[j] || e[j] == '.')) {
                            if (dp[si][j + 2]) {
                                dp[i][j] = true;
                                break;
                            }
                            si++;
                        }
                        if (dp[i][j] != true) {
                            dp[i][j] = dp[si][j + 2];
                        }
                    }
                }
            }
            return dp[0][0];
        }

        public boolean[][] initDP(char[] s, char[] e) {
            int slen = s.length;
            int elen = e.length;
            boolean[][] dp = new boolean[slen + 1][elen + 1];
            dp[slen][elen] = true;
            for (int j = elen - 2; j > -1; j = j - 2) {
                if (e[j] != '*' && e[j + 1] == '*') {
                    dp[slen][j] = true;
                } else {
                    break;
                }
            }
            if (slen > 0 && elen > 0) {
                if (e[elen - 1] == '.' || e[elen - 1] == s[slen - 1]) {
                    dp[slen - 1][elen - 1] = true;
                }
            }
            return dp;
        }
    }

    public static void main(String[] args){
        stringMatch tmp = new stringMatch();

        String str1 = "abc";
        String exp1 = "a.c";
        System.out.println(tmp.isMatch(str1, exp1));

        String str2 = "abcd";
        String exp2 = ".*";
        System.out.println(tmp.isMatchDP(str2, exp2));
    }
}
