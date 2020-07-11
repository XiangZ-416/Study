package 左神算法进阶班;

import java.util.HashMap;

/**
 * @Description: //TODO 针对无后效性问题的暴力递归改动态规划
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/3 8:53
 */
public class Code_12_DP {

    /**
     * @Description //TODO 换钱的方法数
     * @Author ZX
     * @Date 22:51 2020/7/3
     **/
    public static class ExchangeMethod {
        public static int exchangeMethod(int[] arr, int aim) {
            if (arr == null || arr.length == 0 || aim < 0) {
                return 0;
            }
            return process1(arr, 0, aim);
            //return process_map(arr, 0, aim);
        }

        // 暴力递归
        // index：可以任意自由使用index及其之后所有的钱
        // aim：目标钱数
        // 返回值：方法数
        private static int process1(int[] arr, int index, int aim) {
            int res = 0;
            if (index == arr.length) {
                res = aim == 0 ? 1 : 0;
            } else {
                for (int zhang = 0; arr[index] * zhang <= aim; zhang++) {
                    res += process1(arr, index + 1, aim - arr[index] * zhang);
                }
            }
            return res;
        }

        // 改进的暴力递归：记忆化搜索
        // key："index_aim"
        // value：返回值
        public static HashMap<String, Integer> map = new HashMap<>();

        // 将每次index、aim对应的res存起来
        // map中没有再递归；否则直接从map中取
        private static int process_map(int[] arr, int index, int aim) {
            int res = 0;
            if (index == arr.length) {
                res = aim == 0 ? 1 : 0;
            } else {
                for (int zhang = 0; arr[index] * zhang <= aim; zhang++) {
                    int nextAim = aim - arr[index] * zhang;
                    String key = String.valueOf(index + 1) + "_" + String.valueOf(nextAim);
                    if (map.containsKey(key)) {
                        res += map.get(key);
                    } else {
                        res += process_map(arr, index + 1, nextAim);
                    }
                }
            }
            // 加缓存
            map.put(String.valueOf(index) + "_" + String.valueOf(aim), res);
            return res;
        }

        // 动态规划：上述暴力递归改动态规划
        public static int dp1(int[] arr, int aim) {
            if (arr == null || arr.length == 0 || aim < 0) {
                return 0;
            }
            int[][] dp = new int[arr.length][aim + 1]; // 含义：货币中类遍历到i，想要兑换j元的方法数
            for (int i = 0; i < arr.length; i++) {
                dp[i][0] = 1;
            }
            for (int j = 1; arr[0] * j <= aim; j++) {
                dp[0][arr[0] * j] = 1;
            }
            for (int i = 1; i < arr.length; i++) {
                for (int j = 1; j <= aim; j++) {
                    dp[i][j] = dp[i - 1][j];
                    dp[i][j] += (j - arr[i]) >= 0 ? dp[i][j - arr[i]] : 0;
                }
            }
            return dp[arr.length - 1][aim];
        }

        public static int dp2(int[] arr, int aim) {
            if (arr == null || arr.length == 0 || aim < 0) {
                return 0;
            }

            int[][] dp = new int[arr.length + 1][aim + 1];
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[arr.length][j] = 1;
                } else {
                    dp[arr.length][j] = 0;
                }
            }

            for (int i = dp.length - 2; i >= 0; i--) {
                for (int j = 0; j < dp[0].length; j++) {
                    dp[i][j] = dp[i + 1][j];
                    for (int zhang = 1; zhang * arr[i] <= j && j - arr[i] * zhang >= 0; zhang++) {
                        dp[i][j] += dp[i + 1][j - arr[i] * zhang];
                    }
                }
            }
            return dp[0][aim];
        }

    }

    /**
     * @Description //TODO 两个绝顶聪明的人排成一条线的纸牌博弈问题
     * @Author ZX
     * @Date 9:39 2020/7/4
     **/
    public static class CardGame {
        //暴力递归方法(时间复杂度O(2^n),空间复杂度O(n))
        public static int win01(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
        }

        //  先拿：要最大的分数
        public static int f(int[] arr, int i, int j) {
            if (i == j) { // 只有一张纸牌，会被先拿纸牌的人拿走，所以返回arr[i];
                return arr[i];
            }
            return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
        }

        // 后拿：被先拿的给算计了，只能拿相对较差的方案
        public static int s(int[] arr, int i, int j) {
            if (i == j) { // 如果i==j，后拿纸牌的人什么也拿不到，返回0
                return 0;
            }
            return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
        }

        // 动态规划
        public static int win02(int[] arr) {
            if (arr == null || arr.length == 0)
                return 0;
            int n = arr.length;
            //first函数一个二维数组
            int[][] dp1 = new int[n][n];
            //second函数一个二维数组
            int[][] dp2 = new int[n][n];

            //根据base case初始化数组
            for (int i = 0; i < n; i++) {
                dp1[i][i] = arr[i];
                dp2[i][i] = 0;
            }

            //根据递归写状态转移方程
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    //先算f 后算s
                    dp1[i][j] = Math.max(arr[i] + dp2[i + 1][j], arr[j] + dp2[i][j - 1]);
                    dp2[i][j] = Math.min(dp1[i + 1][j], dp1[i][j - 1]);
                }
            }

            return Math.max(dp1[0][n - 1], dp2[0][n - 1]);
        }

    }

    /**
     * @Description //TODO 机器人到达指定位置的方法数
     * @Author ZX
     * @Date 16:21 2020/7/4
     **/
    public static class Ways {
        // 暴力递归
        public static int ways1(int N, int M, int P, int K) {
            if (N < 2 || M < 1 || M > N || P < 0 || K < 1 || K > N) {
                return 0;
            }
            if (P == 0) {
                return M == K ? 1 : 0;
            }
            int res = 0;
            if (M == 1) {
                res += ways1(N, M + 1, P - 1, K);
            } else if (M == N) {
                res += ways1(N, M - 1, P - 1, K);
            } else {
                res += ways1(N, M + 1, P - 1, K) + ways1(N, M - 1, P - 1, K);
            }
            return res;
        }

        // 动态规划
        public static int ways2(int N, int M, int P, int K) {
            if (N < 2 || M < 1 || M > N || P < 1 || K < 1 || K > N) {
                return 0;
            }
            int[][] dp = new int[P + 1][N + 1];
            dp[0][K] = 1;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (j == 1) {
                        dp[i][j] = dp[i - 1][j + 1];
                    } else if (j == N) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j + 1] + dp[i - 1][j - 1];
                    }
                }
            }
            return dp[P][M];
        }

    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2};
        System.out.println(ExchangeMethod.dp1(arr, 9));
        System.out.println(ExchangeMethod.dp2(arr, 9));
        System.out.println(CardGame.win01(arr));
        System.out.println(CardGame.win02(arr));

        System.out.println(Ways.ways1(5, 2, 3, 3));
        System.out.println(Ways.ways2(5, 2, 3, 3));

    }

}
