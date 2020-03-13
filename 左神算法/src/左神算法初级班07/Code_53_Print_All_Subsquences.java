package 左神算法初级班07;

public class Code_53_Print_All_Subsquences {
    /**
     * 打印字符串所有子序列
     * @param str 字符串
     * @param i 下标
     * @param res 前一个位置传过来的字符串
     */
    public static void printAllSub(char[] str, int i, String res) {
        if (i == str.length) { // 遍历到字符串最后一个位置，输出
            System.out.println(res);
            return;
        }
        // 两条路：要/不要
        printAllSub(str, i + 1, res); // 不要当前位置字符
        printAllSub(str, i + 1, res + str[i]); // 要当前位置字符
    }

    public static void main(String[] args) {
        String test = "abc";
        //printAllSubsquence(test);
        printAllSub(test.toCharArray(), 0, "");
    }
}
