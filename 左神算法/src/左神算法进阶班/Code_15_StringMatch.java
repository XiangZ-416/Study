package �����㷨���װ�;

/**
 * @Description: //TODO �ַ���ƥ������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/5 18:50
 */
public class Code_15_StringMatch {

    /**
     * �ַ���ƥ������
     * �����ַ���str, ������'.' �� '*'���ַ���exp������
     * ����'.'�� '*'����'*'����exp�����ַ�����������'*'
     * �����ڡ�
     * exp�е�'.'��������һ���ַ�, '*' ����'*'֮ǰ���ַ�
     * ������0������
     * �ж�str�Ƿ��ܱ�expƥ��
     */
    public static class stringMatch {

        //�ж����������Ƿ���Ч
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

        // ������
        public boolean isMatch(String str, String exp) {
            if (str == null || exp == null) {
                return false;
            }
            char[] arrStr = str.toCharArray();
            char[] arrExp = exp.toCharArray();
            return isValid(arrStr, arrExp) && process(arrStr, arrExp, 0, 0);
        }

        // �ݹ���̣�str[i..һֱ�����]����ַ������ܲ��ܱ�exp[j..һֱ�����]���ַ���ƥ��
        public boolean process(char[] str, char[] exp, int i, int j) {
            if (j == exp.length) { // �ַ���expƥ�����ˣ�strҲ����ƥ�����ʹtrue
                return i == str.length;
            }
            // ��ʱj���滹���ַ�������j + 1�����
            if (j + 1 == exp.length || exp[j + 1] != '*') {
                return i != str.length && (exp[j] == str[i] || exp[j] == '.')
                        && process(str, exp, i + 1, j + 1);
            }
            // ��ʱexp��j + 1λ�ã��������ַ�������'*'
            while (i != str.length && (exp[j] == str[i] || exp[j] == '.')) {
                if (process(str, exp, i, j + 2)) {
                    return true;
                }
                i++;
            }
            return process(str, exp, i, j + 2);
        }

        //��̬�滮���
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
