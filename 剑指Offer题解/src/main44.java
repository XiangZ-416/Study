/**
 * @Description: //TODO ����ת�ַ������ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β�����붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ�
 *                                   ���磬�����ַ���"abcdefg"������2���ú�������������ת��λ�õ��Ľ��"cdefgab"��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/29 23:44
 */
public class main44 {
    /**
     * @Author ZX
     * @Description //TODO ����main43˼·
     *                    cdefgab --> gfedcba --> 'cdefg'+'ab'
     * @Date 17:53 2020/4/1
     * @Param [s, n]
     * @return java.lang.String
     **/
    public static String LeftRotateString3(String s, int n) {
        String firstReverse = new StringBuilder(s).reverse().toString();
        System.out.println("s��ת֮��" + firstReverse.toString());
        StringBuilder ans = new StringBuilder();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < firstReverse.length(); i++) {
            if (i < n) {
                s1.append(s.charAt(i));
            }else {
                s2.append(s.charAt(i));
            }
        }
        System.out.println("s1:" + s1.toString());
        System.out.println("s2:" + s2.toString());
        return s2.append(s1).toString();
    }

    /**
     * @Author ZX
     * @Description //TODO ������nΪ�ֽ�㣬�ֱ�������ٺϲ�
     *                     ʱ�临�Ӷ�O(N)
     * @Date 0:52 2020/3/30
     * @Param [s, n]
     * @return java.lang.String
     **/
    public static String LeftRotateString2(String s, int n) {
        // base case
        if (s == null || n > s.length())
            return "";

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < n; i++) s1.append(s.charAt(i));
        for (int i = n; i < s.length(); i++) s2.append(s.charAt(i));

        return s2.toString() + s1;
    }

    /**
     * @Author ZX
     * @Description //TODO  substring(beginIndex, endIndex) ���������ַ��������ַ���
     *                      beginIndex -- ��ʼ������������, ������ 0 ��ʼ
     *                      endIndex -- ������������������
     * @Date 0:40 2020/3/30
     * @Param [s, n]
     * @return java.lang.String
     **/
    public static String LeftRotateString1(String s, int n) {
        // base case
        if (s == null || n > s.length())
            return "";

        return s.substring(n, s.length()) + s.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(LeftRotateString3("abcdefg", 2));
    }
}
