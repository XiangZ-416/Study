/**
 * @Description: //TODO 最长回文子串
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/5 21:00
 */
public class Code_05_longestPalindrome {

    // 暴力题解
    public static String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1; // 最长回文子数组长度
        int begin = 0; // 最长回文子数组起点
        char[] charArray = s.toCharArray();
        for (int start = 0; start < len - 1; start++) {
            for (int end = start; end < len - 1; end++) {
                if (end - start + 1 > maxLen && isPalindrome(charArray, start, end)) {
                    maxLen = end - start + 1;
                    begin = start;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    // 判断charArray是否回文
    private static boolean isPalindrome(char[] charArray, int start, int end) {
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public String longestPalindrome2(String s) {
        if(s.length() < 2) {
            return s;
        }
        char[] arr = s.toCharArray();
        int start = 0;
        int end = 0;
        for(int i = 0; i < arr.length; i++) {
            int evenLen = judge(arr, i, i);
            int oddLen = judge(arr, i, i + 1);
            int len = Math.max(evenLen, oddLen); // i位置为中心的最大回文子串长度
            if(len > end - start + 1) {
                start = i - (len - 1) / 2; // i为回文中心时长度为len的子数组起点
                end = i + len / 2; // i为回文中心时长度为len的子数组终点
            }
        }

        return s.substring(start, end + 1);
    }

    public int judge(char[] arr, int L, int R) {
        while(L >= 0 && R < arr.length && arr[L] == arr[R]) {
            L--;
            R++;
        }
        return R - L - 1; // 跳出while时arr[L]与arr[R]已经不等
    }

    public static void main(String[] args) {
        String s = "abccbs";
        System.out.println(Code_05_longestPalindrome.longestPalindrome1(s));
    }

}
