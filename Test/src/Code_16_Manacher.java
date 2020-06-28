/**
 * @Description //TODO 获取字符串最长回文子串
 * @Author ZX
 * @Date 15:41 2020/6/27
 **/
public class Code_16_Manacher {

    /**
     * @Description //TODO 暴力法
     * @Author ZX
     * @Date 15:40 2020/6/27
     **/
    public static class getLPSubstr {
        public static String getLPSub(String str) {
            char[] strArray = str.toCharArray();
            // base case
            if (strArray == null || strArray.length < 2) {
                return str;
            }
            int start = 0, end = 0; // 最长回文子串的起点、终点
            for (int i = 0; i < strArray.length; i++) {
                int evenLength = getProcess(strArray, i, i); // 空格为回文中点
                int oddLength = getProcess(strArray, i, i + 1); // 字符为回文中点
                int length = Math.max(evenLength, oddLength); // i位置最大回文长度
                // 根据i，length确定当前最长回文子串的起点、终点
                if (length > end - start) { // i + 1位置的最长回文子串长度 > i位置的时，start和end更新
                    start = i - (length - 1) / 2;
                    end = i + length / 2;
                }
            }
            return str.substring(start, end + 1);
        }

        // 获取每个位置的最长回文子串的长度
        private static int getProcess(char[] strArray, int L, int R) {
            while (L >= 0 && R < strArray.length && strArray[L] == strArray[R]) {
                L--;
                R++;
            }
            return R - L - 1;
        }
    }

    /**
     * @Description //TODO manacher
     * @Author ZX
     * @Date 15:40 2020/6/27
     **/
    public static class manacher {

        // 处理原字符串
        public static char[] produceNewStr(String str) {
            char[] strArray = str.toCharArray();
            char[] newArray = new char[strArray.length * 2 + 1];
            int index = 0;
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = (i & 1) == 0 ? '#' : strArray[index++];
            }
            return newArray;
        }

        public static int manacher(String str) {
            // base case
            if (str == null || str.length() < 1) {
                return 0;
            }
            char[] newStrArray = produceNewStr(str); // 处理过的字符串数组
            int[] Parr = new int[newStrArray.length]; // 回文半径数组
            int Pcenter = -1; // 回文中心
            int Pr = -1; // 回文右边界
            int max = Integer.MIN_VALUE; // 初始化最大回文子串长度
            for (int i = 0; i < newStrArray.length; i++) {
                Parr[i] = Pr > i ? Math.min(Parr[2 * Pcenter - i], Pr - i) : 1;
                while (i + Parr[i] < newStrArray.length && i - Parr[i] > -1) {
                    if (newStrArray[i + Parr[i]] == newStrArray[i - Parr[i]]) {
                        Parr[i]++;
                    } else {
                        break;
                    }
                }
                if (i + Parr[i] > Pr) {
                    Pr = i + Parr[i];
                    Pcenter = i;
                }
                max = Math.max(max, Parr[i]);
            }
            return max - 1;
        }
    }

    public static void main(String[] args) {
        String str = "abc1234321ab";
        System.out.println("暴力解法：" + getLPSubstr.getLPSub(str));
        System.out.println("Manacher：" + manacher.manacher(str));
    }

}
