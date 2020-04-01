/**
 * @Description: //TODO 左旋转字符串：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 *                                   比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/29 23:44
 */
public class main44 {
    /**
     * @Author ZX
     * @Description //TODO 借助main43思路
     *                    cdefgab --> gfedcba --> 'cdefg'+'ab'
     * @Date 17:53 2020/4/1
     * @Param [s, n]
     * @return java.lang.String
     **/
    public static String LeftRotateString3(String s, int n) {
        String firstReverse = new StringBuilder(s).reverse().toString();
        System.out.println("s反转之后：" + firstReverse.toString());
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
     * @Description //TODO 以索引n为分界点，分别遍历，再合并
     *                     时间复杂度O(N)
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
     * @Description //TODO  substring(beginIndex, endIndex) 方法返回字符串的子字符串
     *                      beginIndex -- 起始索引（包括）, 索引从 0 开始
     *                      endIndex -- 结束索引（不包括）
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
