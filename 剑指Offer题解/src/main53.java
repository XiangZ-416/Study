/**
 * @Description: //TODO ������ʽƥ�䣺����һ���ַ���s��һ���ַ�����p��������ʵ��һ��֧��'.'��'*'��������ʽƥ�䡣
 *                                      '.' ƥ�����ⵥ���ַ�
 *                                      '*' ƥ���������ǰ�����һ��Ԫ��
 *                                      ��νƥ�䣬��Ҫ���������ַ���s�ģ������ǲ����ַ�����
 *                               ˵��:
 *                                      s����Ϊ�գ���ֻ������a-z��Сд��ĸ��
 *                                      p����Ϊ�գ���ֻ������a-z��Сд��ĸ���Լ��ַ�.��*��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/6 21:39
 */
public class main53 {
    public static boolean match(String s, String p) {
        return solve(s, p, 0, 0);
    }

    /**
     * �ַ���ƥ��
     * @param s �ַ���1
     * @param p �ַ���2
     * @param index1 �ַ���1���±�
     * @param index2 �ַ���2���±�
     * @return ��ǰs��p��ƥ����
     */
    private static boolean solve(String s, String p, int index1, int index2) {

        // �ݹ���ֹ����1
        if (index1 == s.length() && (index2 == p.length() || (index2 + 1 == p.length() - 1 && p.charAt(index2 + 1) == '*'))) {
            return true;
        }

        // �ݹ���ֹ����2
        if (index1 == s.length() || p.length() == index2) {
            if (index1 == s.length()) {
                return change(p, index2);
            } else {
                return false;
            }
        }

        // p��ǰ�ַ�����һ��λ�õ��ַ���*
        if(index2 + 1 < p.length() && p.charAt(index2 + 1) == '*') {
            if(judge(s.charAt(index1), p.charAt(index2))) {
                return solve(s, p, index1, index2 + 2) || solve(s, p, index1 + 1, index2);
            } else {
                return solve(s, p, index1, index2 + 2);
            }
        }

        // ��ǰ�����±���ָ���ַ�ƥ��
        if (judge(s.charAt(index1), p.charAt(index2))) {
            return solve(s, p, index1 + 1, index2 + 1);
        }

        return false; // ��ǰ��index1��ָ���ַ���index2��ָ���ַ���һ��
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
     * @param s1 �ַ�1
     * @param s2 �ַ�2
     * @return �����ַ��Ƿ�ƥ��Ľ��
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
