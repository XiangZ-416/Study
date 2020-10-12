import java.util.Scanner;

/**
 * @Description: //TODO 字符串frame的长度代表俄罗斯方块界面的宽度，每个字符('0'-'9')代表界面底部对应列上的格子个数
 *                           字符串brick为上部待下落的方块，每个字符的含义和限制如上
 *                           求砖块brick落在frame上时之后，整个界面还剩下的可能最小行数
 *                           保证brick都是向下突出的。
 *                           此外,形如
 *                           #k#
 *                           #
 *                           的brick不会存在
 *                           frame=="2212"代表界面 (k代表为空)
 *                           ||kkkk||
 *                           ||kkkk||
 *                           ||## #||
 *                           ||####||
 *                           brick = "121" 代表砖块
 *                           "###"
 *                           "k#k"
 *                           则输出为2
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/20 10:17
 */
public class main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int[] s11 = new int[s1.length()];
        int[] s22 = new int[s2.length()];
        for(int i=0; i < s2.length(); i++){
            s22[i] = s2.charAt(i)  - '0';
        }
        for (int i = 0; i < s1.length(); i++) {
            s11[i] = s1.charAt(i) - '0';
        }
        int res = Integer.MAX_VALUE;
        int[] sum = new int[s1.length()];
        int i = 0;
        while (i < s1.length() - s2.length()) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0;j< s1.length(); j++) {
                if (j >=i && j - i < s2.length()) {
                    sum[j] = s11[j] + s22[j - i];
                } else {
                    sum[j] = s11[j];
                }
                min = Math.min(min, sum[j]);
                max = Math.max(max, sum[j]);
            }
            res = Math.min(res, max - min);
            i++;
        }
        System.out.println(res);
    }
}
