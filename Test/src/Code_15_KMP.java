/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/25 15:43
 */
public class Code_15_KMP {

    /**
     * @Description //TODO KMP主函数
     * @Author ZX
     * @Date 16:27 2020/6/25
     * @Param [s, m]
     * @return int
     **/
    public static int strMatch(String s, String m) {
        // base case
        if (s == null || m == null || s.length() == 0 || m.length() == 0|| s.length() < m.length()) {
            return -1;
        }

        char[] sArray = s.toCharArray();
        char[] mArray = m.toCharArray();
        int sIndex = 0;
        int mIndex = 0;
        int[] next = getNextArray(mArray);
        while (sIndex < sArray.length && mIndex < mArray.length) {
            if (sArray[sIndex] == mArray[mIndex]) {
                sIndex++;
                mIndex++;
            } else if (mIndex > 0) {
                mIndex = next[mIndex] + 1;
            } else {
                sIndex++;
            }
        }
        if (mIndex == mArray.length) { // 匹配成功
            return sIndex - mIndex;
        } else {
            return -1;
        }
    }

    /**
     * @Description //TODO 求匹配数组的next数组
     * @Author ZX
     * @Date 16:28 2020/6/25
     * @Param [mArray]
     * @return int[]
     **/
    private static int[] getNextArray(char[] mArray) {
        // base case
        if (mArray.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[mArray.length];
        next[0] = -1;
        next[1] = 0;
        int cur = 2; // 求当前位置的最长前缀最长后缀匹配长度
        int cn = 0; // 比较对象的位置
        while (cur < mArray.length) {
            if (mArray[cur - 1] == mArray[cn]) { // 当前位置的前一个字符与目标位置匹配
                next[cur++] = cn + 1;
            } else if (cn > 0) {
                cn = next[cn] + 1;
            } else {
                next[cur++] = 0;
            }
        }
        return next;
    }

    /**
     * @Description //TODO 暴力匹配
     * @Author ZX
     * @Date 16:29 2020/6/25
     * @Param [s, m]
     * @return int
     **/
    public static int StrMatch(String s, String m) {
        // base case
        if (s == null || m == null || s.length() == 0 || m.length() == 0 || s.length() < m.length()) {
            return -1;
        }

        char[] sArray = s.toCharArray();
        char[] mArray = m.toCharArray();
        int sIndex = 0;
        int mIndex = 0;

        while (sIndex < sArray.length && mIndex < mArray.length) {
            if (sArray[sIndex] == mArray[mIndex]) {
                sIndex++;
                mIndex++;
            } else {
                sIndex = sIndex - mIndex + 1;
                mIndex = 0;
            }
        }

        if (mIndex == mArray.length) { // 匹配成功
            return sIndex - mIndex;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String s = "tkababcababtk";
        String m = "ababcababtk";
        System.out.println("KMP:" + strMatch(s, m));
        System.out.println("暴力法：" + StrMatch(s, m));
    }

}
