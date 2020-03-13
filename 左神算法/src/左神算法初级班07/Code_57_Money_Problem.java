package 左神算法初级班07;

public class Code_57_Money_Problem {
    /**
     * 方法1：暴力递归
     * @param arr
     * @param i
     * @param sum
     * @param aim
     * @return
     */
    public static boolean process1(int[] arr, int i, int sum, int aim) {
        // base case
        if (i == arr.length) {  // 遍历到arr最后一个数了
            return sum == aim; // 只要和有等于aim，就返回true
        }
        // 两条路：要当前数 || 不要当前数
        return process1(arr, i + 1, sum, aim) || process1(arr, i + 1, sum + arr[i], aim);
    }

    /**
     * 方法2：动态规划
     * @param arr
     * @param aim
     * @return
     */
    public static boolean process2(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 13};
        int aim = 9;
        System.out.println(process1(arr, 0, 0, aim));
        System.out.println(process2(arr, aim));
    }
}
