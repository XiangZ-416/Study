package �����㷨���װ�;

/**
 * @Description: //TODO ���ַ�����������Ӵ��ĳ��ȣ�ʱ�临�Ӷ�O(N)
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/25 16:58
 */
public class Code_02_Manacher {

    // ����ԭʼ�ַ�����str��ÿ���ַ�ǰ��'#'
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1]; // ���ַ���
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
     }

    // ������������������Ӵ��ĳ���
    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str); // ��������ַ�������
        int[] pArr = new int[charArr.length]; // ���İ뾶����
        int index = -1; // ��ʼ��������
        int pR = -1; // ��ʼ���İ뾶�ұ߽�
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < charArr.length; i++) {
            // 2 * index - i��i����index�ĶԳ�λ��
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1; // ���1��2���������ִ��while�е�break
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) { // i + pArr[i]�������ұ߽磻i - pArr[i]��������߽�
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i]; // ������������Ļ����ұ߽�
                index = i; // ���»�������
            }
            max = Math.max(max, pArr[i]); // ����������Ӵ��ĳ���
        }
        return max - 1;
    }

    /**
     * @Description //TODO ��������ʱ�临�Ӷ�O(N^2)
     * @Author ZX
     * @Date 16:31 2020/6/26
     * @Param [s]
     * @return java.lang.String
     **/
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0; // ��ʼ��������Ӵ�����ʼ����ֹλ��
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); //��һ���ַ���չ
            int len2 = expandAroundCenter(s, i, i + 1); //�������ַ�֮����չ
            int len = Math.max(len1, len2);
            //���� i �� len ����ַ�������Ӧ�±�
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // ������ɢ�����õ�iλ�õĵ�����ĳ���
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
