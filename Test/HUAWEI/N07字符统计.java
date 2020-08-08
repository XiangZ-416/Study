import java.util.Scanner;

/**
 * @Description: //TODO 输入描述:
 *                              输入一串字符。
 *                           输出描述
 *                              对字符中的各个英文字符（大小写分开统计），数字，空格进行统计，并按照统计个数由多到少输出,如果统计的个数相同，
 *                              则按照ASII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
 *                           输入
 *                              aadddccddc
 *                           输出
 *                              dca
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/2 17:40
 */
public class N07字符统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {      //表示可以不断输入字符串的的得出结果，即多次测试
            String str = in.next();
            int max = 0;
            int[] count = new int[256];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i)]++;
                if (count[str.charAt(i)] > max) {
                    max = count[str.charAt(i)];
                }
            }
            while (max != 0) {
                for (int i = 0; i < 256; i++) {
                    if (count[i] == max) {
                        System.out.print((char) (i));
                    }
                }
                max--;
            }
            System.out.println();
        }
    }
}
