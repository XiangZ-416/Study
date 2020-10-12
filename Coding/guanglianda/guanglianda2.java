import java.util.Scanner;

/**
 * @Description: //TODO 机器人
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 你购买了一个机器人，它现在剩下C单位电量，你现在想让它做一些动作愉悦自己。它可以做n种动作，每种动作最多做一次，因为你觉得让机器人重复做一种动作是无聊的。每种动作都有一个固定电量花费ci单位电量，以及这个动作的愉悦度wi。请在你电量范围内让它做出让你最愉悦的动作。即做的动作的总电量消耗不能超过C，并使愉悦度之和最大。（我们将情景简化，电量在开始动作前就要扣除，若电量不足则无法开始作，不存在动作进行到一半的状态）
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/9/9 21:51
 */
public class guanglianda2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int C = sc.nextInt();
        float[] c = new float[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextFloat();
            w[i] = sc.nextInt();
        }
        long[] dp = new long[C + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = C; j >= c[i]; --j) {
                dp[j] = Math.max(dp[j], dp[(int)(j - c[i] + 0.5)] + w[i]);
            }
        }
        System.out.println(dp[C]);
    }
}
