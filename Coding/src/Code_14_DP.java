/**
 * @Description: //TODO 递归和动态规划
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/21 21:10
 */
public class Code_14_DP {

    /**
     * @Description //TODO 计算num的阶乘
     * @Author ZX
     * @Date 21:29 2020/6/21
     * @Param
     * @return
     **/
    public static class calculate {
        public static int process(int num) {
            if (num == 1) {
                return 1;
            }
            return num * process(num - 1);
        }
    }

    /**
     * @Description //TODO 将N层汉诺塔从左边移到右边
     * @Author ZX
     * @Date 21:39 2020/6/21
     * @Param
     * @return
     **/
    public static class hanNuoTa {
        public static void process(int N, String from, String to, String help) {
            if (N == 1) {
                System.out.println("move 1 from " + from + "to" + to);
            } else {
                process(N - 1, from, help, to);
                System.out.println("move " + N + " from " + from + "to" + to);
                process(N - 1, help, to, from);
            }
        }
    }

    /**
     * @Description //TODO 打印所有的子字符串
     * @Author ZX
     * @Date 21:48 2020/6/21
     * @Param
     * @return
     **/
    public static class printSubString {
        public static void process(char[] str, int i, String res) {
            if (i == str.length) {
                System.out.print(res + " ");
                return;
            }
            process(str, i + 1, res); // 不要当前字符
            process(str, i + 1, res + str[i]); // 要当前字符
        }
    }

    /**
     * @Description //TODO 打印字符串的全排列
     * @Author ZX
     * @Date 21:57 2020/6/21
     * @Param
     * @return
     **/
    public static class printAllStrings {

    }

    /**
     * @Description //TODO 母牛数量
     * @Author ZX
     * @Date 22:04 2020/6/21
     * @Param
     * @return
     **/
    public static class NumberOfCows {

    }

    public static void main(String[] args) {
        System.out.println("计算num的阶乘：" + calculate.process(3));
        System.out.println();

        System.out.println("汉诺塔问题移动过程");
        hanNuoTa.process(3, "左", "右", "中");
        System.out.println();

        System.out.println("打印所有的子字符串");
        String str = "abc";
        printSubString.process(str.toCharArray(), 0, "");

    }

}
