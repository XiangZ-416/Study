import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO 输入描述:
 *                              输入任意个整数
 *                           输出描述:
 *                              输出负数个数以及所有非负数的平均值
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/2 17:28
 */
public class N04记负均正II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int negNum = 0; // 负数个数
        int nuNegNum = 0; // 非负数个数
        float sum = 0; // 注意最终的平均数是float型，如果此处用int，则无法保留一位小数
        ArrayList<Integer> list = new ArrayList<>(); // 用来存所有的非负数
        while(sc.hasNext()) {
            int num = sc.nextInt();
            if(num < 0) {
                negNum++;
            } else {
                nuNegNum++;
                sum += num; // 非负数的累加和
            }
        }
        System.out.println(negNum); // 输出负数的个数
        if( nuNegNum == 0) {
            System.out.println(0.0);
        } else {
            System.out.printf("%.1f\n", sum / nuNegNum);
        }
    }
}
