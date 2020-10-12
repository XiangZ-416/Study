import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description: //TODO 种草
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 杰夫非常喜欢种草，他自己有一片草地，为了方便起见，我们把这片草地看成一行从左到右，并且第 i 个位置的草的高度是hi。
 *
 * 杰夫在商店中购买了m瓶魔法药剂，每瓶魔法药剂可以让一株草长高x，杰夫希望每次都能有针对性的使用药剂，也就是让当前长得最矮的小草尽量高，现在杰夫想请你告诉他在使用了m瓶魔法药剂之后，最矮的小草在这种情况下最高能到多少。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/9/9 21:42
 */
public class guanglianda1 {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int n, m, x;
        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        int res;
        for (int i = 0; i < n; i++) {
            res = sc.nextInt();
            queue.add(res);
        }
        for (int i = 0; i < m; i++) {
            res = queue.poll() + x;
            queue.add(res);
        }
        System.out.println(queue.poll());
    }
}
