package 左神算法进阶班;

/**
 * @Description: //TODO 求字符串的最长回文子串的长度，时间复杂度O(N)
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/25 16:58
 */
public class Code_02_Manacher {

    // 处理原始字符串：str的每个字符前加'#'
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1]; // 新字符串
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
     }

    // 主函数：返回最长回文子串的长度
    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str); // 处理过的字符串数组
        int[] pArr = new int[charArr.length]; // 回文半径数组
        int index = -1; // 初始回文中心
        int pR = -1; // 初始回文半径右边界
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < charArr.length; i++) {
            // 2 * index - i：i关于index的对称位置
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1; // 情况1、2会接下来会执行while中的break
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) { // i + pArr[i]：回文右边界；i - pArr[i]：回文左边界
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i]; // 更新整个数组的回文右边界
                index = i; // 更新回文中心
            }
            max = Math.max(max, pArr[i]); // 更新最长回文子串的长度
        }
        return max - 1;
    }

    /**
     * @Description //TODO 暴力法：时间复杂度O(N^2)
     * @Author ZX
     * @Date 16:31 2020/6/26
     * @Param [s]
     * @return java.lang.String
     **/
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0; // 初始化最长回文子串的起始和终止位置
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); //从一个字符扩展
            int len2 = expandAroundCenter(s, i, i + 1); //从两个字符之间扩展
            int len = Math.max(len1, len2);
            //根据 i 和 len 求得字符串的相应下标
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // 中心扩散法：得到i位置的的最长回文长度
    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
        //System.out.println(longestPalindrome(str1));
    }

}
