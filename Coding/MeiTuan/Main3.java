import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO 小美的送花线路
 *                          时间限制： 3000MS
 *                          内存限制： 589824KB
 *                          题目描述：
 *                              小美是美团的一名鲜花快递员，鲜花是一种保质期非常短的商品，所以需要尽快送到客户手中，公司对于骑手的一个要求就是要规划送花的线
 *                              路，使得骑手送完所有订单走的路程尽可能少。(骑手开始派送时带走了所有需要派送的花，不必每单后返回花店，路程结算是从花店出发，到
 *                              送完最后一名客户为止，不计算从最后一名客户家回到花店的时间)。公司对于骑手的绩效评价是取决于两个指标，一是从花店到所有客户地址
 *                              的距离之和，另一个是骑手实际走的路程。设花店始终位于1号位置，客户共有n-1个，其编号为2~n。令dis(i,j)表示i号位置到j号位置的距
 *                              离，即分别计算 , 和骑手实际所走的最短路程。
 *                              为了简化问题，我们约束这n个位置构成的是一棵树，即只有n-1条边在其中互相连接，且保证n个点彼此连通。
 *                          输入描述
 *                              输出第一行包含一个正整数n，即花店和客户的总数。(1<=n<=30000)
 *                              接下来有n-1行，每行有三个整数u,v,w，表示在u和v之间存在一条距离为w的道路。(1<=w<=1000)
 *                          输出描述
 *                              输出包含两个整数，中间用空格隔开，分别表示花店到所有客户地址的距离之和和骑手实际走的路程。
 *                          样例输入
 *                              5
 *                              1 2 3
 *                              1 3 1
 *                              1 4 2
 *                              2 5 1
 *                          样例输出
 *                              10 10
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/8 17:10
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n+1][n+1];
        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int sum  = 0;
        for (int i = 1; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            nums[x][y] = sc.nextInt();
            sum +=nums[x][y];
            if (x == 1) {
                res += nums[x][y];
            } else {
                list.add(x);
                res += nums[x][y];
            }
        }
        while (list.size() != 0) {
            Integer j = list.remove(0);
            if (nums[1][j] != 0) {
                res += nums[1][j];
                continue;
            } else {
                int min = Integer.MAX_VALUE;
                int t = n + 1;
                for (int i = 2; i < n;i ++) {
                    if (nums[i][j] != 0 && nums[i][j] < min) {
                        min = nums[i][j];
                        t = i;
                    }
                }
                res += nums[t][j];
                list.add(t);
            }
            list.remove(0);
        }
        System.out.println(res+" "+res);
    }
}
