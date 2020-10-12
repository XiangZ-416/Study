import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO 小美的评分计算器
 *                          时间限制： 3000MS
 *                          内存限制： 589824KB
 *                          题目描述：
 *                              美团对于商家的评价体系是1-5星评价体系，用户在完成订单之后可以对商家打1/2/3/4/5星，而在客户端上，商家的评级却不一定是整数，而是会显示小数点后的一位。
 *                              很显然这就需要一个计算器了，小美拥有了一些商户的评价数据，希望可以计算出商家在客户端上显示出的评分。
 *                              这个评分的计算非常简单，就是对该商家的所有客户的星级评价做求一个平均，然后去尾法显示小数点后的一位即可，例如平均得分是3.55，则显示的是3.5。例如某商家
 *                              获得了1-5星评价各一个，则显示的评分是(1+2+3+4+5)/5=3.0。
 *                              如果商家没有获得评价，则显示0.0。
 *                          输入描述
 *                              输入包含5个整数，依次分别表示商家获得1星到5星的评价数量，每一种评价的数量都不大于1000。
 *                          输出描述
 *                              输出仅包含一个保留一位的小数，表示商家在客户端上显示的评级。
 *                          样例输入
 *                              2 2 1 1 2
 *                          样例输出
 *                              2.8
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/8 15:12
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<5;i++) {
            list.add(sc.nextInt());
        }
        String s = String.valueOf(process(list));
        String[] ss = s.split("\\.");
        System.out.println(ss[0]+"."+ss[1].charAt(0));
    }

    private static double process(ArrayList<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        int sum = 0; // 总评分
        double b = 0;

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            sum += num * (i + 1);
            b += num;
        }
        return sum / b;
    }
}
