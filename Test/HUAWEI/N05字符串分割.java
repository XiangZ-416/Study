import java.util.Scanner;

/**
 * @Description: //TODO 输入描述:
 *                              首先输入数字n，表示要输入多少个字符串。连续输入字符串(输出次数为N,字符串长度小于100)。
 *                           输出描述
 *                              按长度为8拆分每个字符串后输出到新的字符串数组，长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/2 17:33
 */
public class N05字符串分割 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0; // 输入的字符串个数
        while(sc.hasNext()) {
            num = sc.nextInt();
            for(int i = 0; i < num; i++) {
                String str = sc.next();
                while(str.length() % 8 != 0 ) { // 当前读取到的str的长度不是8的整数倍
                    str += '0'; // 补'0'直到长度是8的j整数倍
                }
                for(int j = 0; j < str.length(); j += 8) { // 分割读到的每个字符串，8位字符为一组
                    System.out.println(str.substring(j, j + 8));
                }
            }
        }
    }
}
