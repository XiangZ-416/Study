package 左神算法高级班01;
/**
 *【题目】
 * 给定两个字符串str和match，长度分别为N和M。实现一个算法，如果字符串str
 * 中含有字串match，则返回match在str中的开始位置，不含有则返回-1。
 */
public class Code_01_KMP {
    /**
     * 主方法
     * @param s
     * @param m
     * @return
     */
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray(); // 字符串变为字符类型的数组
        char[] ms = m.toCharArray();
        int si = 0; // ss中的指针
        int mi = 0; // mi中的指针
        int[] next = getNextArray(ms); // 获取ms各个元素的最长前缀与最长后缀字符串匹配
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) { // 两字符串当前位置字符相同
                // 两指针一起向右移
                si++;
                mi++;
            } else if (next[mi] == -1) { // mi是ms的0位置时，ss的ss[si]与ms[0]不相等
                // ss的指针向右移
                si++;
            } else { // mi是ms的mi位置时（非0），ss的ss[si]与ms[mi]不相等
                // KMP算法的优势处：
                // mi跳到ms[mi]的最长前缀与最长后缀字符串匹配处
                // 继续判断ss[si+1]是否等于ms[next[mi]]
                mi = next[mi];
            }
        }
        // 如果mi指针滑过了所有ms的元素，则找到了，返回ss中匹配到的第一个位置
        return mi == ms.length ? si - mi : -1;
    }

    /**
     * 获取ms各个元素的最长前缀与最长后缀字符串匹配
     * @param ms
     * @return
     */
    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        // 人为规定ms中0，1位置的最长前缀与最长后缀字符串匹配为-1和0
        next[0] = -1;
        next[1] = 0;
        int pos = 2; // 当前要求最长前缀与最长后缀字符串匹配的位置
        int cn = 0; // 当前跳到的位置
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) { // 当前跳到的位置和当前位置的前面一个位置元素相同
                next[pos++] = ++cn; // pos位置处的最长前缀与最长后缀字符串匹配为跳到位置+1
            } else if (cn > 0) { // 不相等且cn还能往前跳
                // 跳到cn处的最长前缀与最长后缀字符串匹配的值
                cn = next[cn];
            } else { // 不相等且无处可跳
                // 当前位置最长前缀与最长后缀字符串匹配的值为0，继续求下一个位置的最长前缀与最长后缀字符串匹配的值
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str1 = "tkababcababtk";
        String str2 = "ababcababtk";
        System.out.println(getIndexOf(str1, str2));
    }
}
