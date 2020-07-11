/**
 * @Description: //TODO ������Ӵ�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/5 21:00
 */
public class Code_05_longestPalindrome {

    // �������
    public static String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1; // ����������鳤��
        int begin = 0; // ��������������
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

    // �ж�charArray�Ƿ����
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
            int len = Math.max(evenLen, oddLen); // iλ��Ϊ���ĵ��������Ӵ�����
            if(len > end - start + 1) {
                start = i - (len - 1) / 2; // iΪ��������ʱ����Ϊlen�����������
                end = i + len / 2; // iΪ��������ʱ����Ϊlen���������յ�
            }
        }

        return s.substring(start, end + 1);
    }

    public int judge(char[] arr, int L, int R) {
        while(L >= 0 && R < arr.length && arr[L] == arr[R]) {
            L--;
            R++;
        }
        return R - L - 1; // ����whileʱarr[L]��arr[R]�Ѿ�����
    }

    public static void main(String[] args) {
        String s = "abccbs";
        System.out.println(Code_05_longestPalindrome.longestPalindrome1(s));
    }

}
