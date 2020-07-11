package 左神算法进阶班;

/**
 * @Description //TODO 给定两个字符串str和match，长度分别为N和M。实现一个算法，如果字符串str
 *                     中含有字串match，则返回match在str中的开始位置，不含有则返回-1。
 *                     时间复杂度O(N + M)
 * @Author ZX
 * @Date 14:40 2020/6/26
 * @Param
 * @return
 **/
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
        char[] sArray = s.toCharArray(); // 字符串变为字符类型的数组
        char[] mArray = m.toCharArray();
        int sIndex = 0; // sArray中的指针
        int mIndex = 0; // mArray中的指针
        int[] next = getNextArray(mArray); // 获取mArray各个元素的最长前缀与最长后缀字符串匹配
        while (sIndex < sArray.length && mIndex < mArray.length) {
            if (sArray[sIndex] == mArray[mIndex]) { // 两字符串当前位置字符相同
                // 两指针一起向右移
                sIndex++;
                mIndex++;
            } else if (next[mIndex] == -1) { // mIndex是mArray的0位置时，sArray的sArray[sIndex]与mArray[0]不相等
                // sArray的指针向右移
                sIndex++;
            } else { // mIndex是mArray的mIndex位置时（非0），sArray的sArray[sIndex]与mArray[mIndex]不相等
                // KMP算法的优势处：
                // mIndex跳到mArray[mIndex]的最长前缀与最长后缀字符串匹配处
                // 继续判断sArray[sIndex+1]是否等于mArray[next[mIndex]]
                mIndex = next[mIndex];
            }
        }
        // 如果mIndex指针滑过了所有mArray的元素，则找到了，返回sArray中匹配到的第一个位置
        return mIndex == mArray.length ? sIndex - mIndex : -1;
    }

    /**
     * 获取ms各个元素的最长前缀与最长后缀字符串匹配
     * @param mArray
     * @return
     */
    public static int[] getNextArray(char[] mArray) {
        if (mArray.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[mArray.length];
        // 人为规定ms中0，1位置的最长前缀与最长后缀字符串匹配为-1和0
        next[0] = -1;
        next[1] = 0;
        int cur = 2; // 当前要求最长前缀与最长后缀字符串匹配的位置
        int cn = 0; // 当前跳到的位置
        while (cur < next.length) {
            if (mArray[cur - 1] == mArray[cn]) { // 当前跳到的位置和当前位置的前面一个位置元素相同
                next[cur++] = ++cn; // cur位置处的最长前缀与最长后缀字符串匹配为跳到位置+1
            } else if (cn > 0) { // 不相等且cn还能往前跳
                // 跳到cn处的最长前缀与最长后缀字符串匹配的值
                cn = next[cn];
            } else { // 不相等且无处可跳
                // 当前位置最长前缀与最长后缀字符串匹配的值为0，继续求下一个位置的最长前缀与最长后缀字符串匹配的值
                next[cur++] = 0;
            }
        }
        return next;
    }

    /**
     * @return int
     * @Description //TODO 暴力法
     * @Author ZX
     * @Date 10:50 2020/6/24
     * @Param [str1, str2]
     **/
    public static int StringMatching(String str1, String str2) {
        int str1Len = str1.length();
        int str2Len = str2.length();
        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();

        int i = 0;
        int j = 0;

        // 匹配过程
        while (i < str1Len && j < str2Len) {
            if (str1Array[i] == str2Array[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == str2Len) { // 匹配成功
            return i - j;
        }
        return -1; // 匹配失败
    }

    public static void main(String[] args) {
        String str1 = "tkababcababtk";
        String str2 = "ababcababtk";
        System.out.println(getIndexOf(str1, str2));
        System.out.println(StringMatching(str1, str2));
    }
}
