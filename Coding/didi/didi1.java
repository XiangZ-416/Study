import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO  熟悉的A+B
 *                            时间限制： 3000MS
 *                            内存限制： 589824KB
 *                            题目描述：
 *                              A+B问题又来了。
 *                              设a，b，c是0到9之间的整数（其中a，b，c互不相同），其中abc和acc是两个不同的三位数。
 *                              现给定一正整数n，问有多少对abc和acc能满足abc+acc=n（a≠0）？
 *                            输入描述
 *                               一个正整数n（100<n<2000）。
 *                            输出描述
 *                              第一行输出有多少对满足要求的数字。
 *                              接下来每一行输出一对abc和acc，以空格分隔。如果没有一对abc和acc的话，则直接输出0即可。
 *                              如果有多对，请按照abc升序的次序输出。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/21 19:42
 */
public class didi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    if (200 * a + 10*b + 12*c == n && a != b && b != c && a != c) {
                        res++;
                        list.add("" + a + b + c + " " + a + c + c);
                    }
                }
            }
        }
        System.out.println(res);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
