import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description: //TODO 输入为两行
 *                              第一行：N 代表树的节点个数
 *                              第二行：N个数字，每个数字为节点的深度（你没看错，原样表述就是这样）
 *                          输出：满上上述条件的二叉树的个数，结果(%10^9+)
 *                          举例：
 *                              输入
 *                                  4
 *                                  1 0 2 2
 *                              输出
 *                                  2
 *                          二叉树有4个节点，有一个节点的深度为1，有一个节点的深度为0，有2个节点的深度为2。可能的二叉树如下：
 *                              x                   x
 *                             /                      \
 *                           x                          x
 *                         /   \                      /   \
 *                       x       x                  x       x
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/20 10:18
 */
public class main2 {
    public static final int Mod  = 1000000007;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // n个节点

        // 记录每一层对应的节点数目
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLevel = 0;
        int level = 0;
        for(int i=0; i < n; i++) {
            level = in.nextInt();
            map.put(level, map.getOrDefault(level, 0) + 1);
            maxLevel = Math.max(maxLevel, level);
        }

        long res = 1;
        int preLNums = 1;
        int curLNums = 1;
        for(int i=1; i <= maxLevel; i++) {
            curLNums = map.get(i);
            res *= getNums(preLNums, curLNums);
            res = res % Mod;
            preLNums = curLNums;
        }
        System.out.println(res);
    }

    private static long getNums(int preLNums, int curLNums) {
        int nums = 2*preLNums;
        double count = 1;
        for(int i=0; i < curLNums; i++) {
            // 不会溢出
            count *= (double)(nums - i)/(double)(curLNums-i); // long或int类型不行，每项直接除会积累误差,n=5,m=3结果是6，n=5,m=2,结果是6。
            count %= Mod;
        }
        return (long)count;
    }
}
