package �����㷨���װ�;

import java.util.HashMap;

/**
 * @Description: //TODO ����޺�Ч������ı����ݹ�Ķ�̬�滮
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/3 8:53
 */
public class Code_12_DP {

    /**
     * @Description //TODO ��Ǯ�ķ�����
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

        // �����ݹ�
        // index��������������ʹ��index����֮�����е�Ǯ
        // aim��Ŀ��Ǯ��
        // ����ֵ��������
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

        // �Ľ��ı����ݹ飺���仯����
        // key��"index_aim"
        // value������ֵ
        public static HashMap<String, Integer> map = new HashMap<>();

        // ��ÿ��index��aim��Ӧ��res������
        // map��û���ٵݹ飻����ֱ�Ӵ�map��ȡ
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
            // �ӻ���
            map.put(String.valueOf(index) + "_" + String.valueOf(aim), res);
            return res;
        }

        // ��̬�滮�����������ݹ�Ķ�̬�滮
        public static int dp1(int[] arr, int aim) {
            if (arr == null || arr.length == 0 || aim < 0) {
                return 0;
            }
            int[][] dp = new int[arr.length][aim + 1]; // ���壺�������������i����Ҫ�һ�jԪ�ķ�����
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
     * @Description //TODO �����������������ų�һ���ߵ�ֽ�Ʋ�������
     * @Author ZX
     * @Date 9:39 2020/7/4
     **/
    public static class CardGame {
        //�����ݹ鷽��(ʱ�临�Ӷ�O(2^n),�ռ临�Ӷ�O(n))
        public static int win01(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
        }

        //  ���ã�Ҫ���ķ���
        public static int f(int[] arr, int i, int j) {
            if (i == j) { // ֻ��һ��ֽ�ƣ��ᱻ����ֽ�Ƶ������ߣ����Է���arr[i];
                return arr[i];
            }
            return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
        }

        // ���ã������õĸ�����ˣ�ֻ������Խϲ�ķ���
        public static int s(int[] arr, int i, int j) {
            if (i == j) { // ���i==j������ֽ�Ƶ���ʲôҲ�ò���������0
                return 0;
            }
            return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
        }

        // ��̬�滮
        public static int win02(int[] arr) {
            if (arr == null || arr.length == 0)
                return 0;
            int n = arr.length;
            //first����һ����ά����
            int[][] dp1 = new int[n][n];
            //second����һ����ά����
            int[][] dp2 = new int[n][n];

            //����base case��ʼ������
            for (int i = 0; i < n; i++) {
                dp1[i][i] = arr[i];
                dp2[i][i] = 0;
            }

            //���ݵݹ�д״̬ת�Ʒ���
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    //����f ����s
                    dp1[i][j] = Math.max(arr[i] + dp2[i + 1][j], arr[j] + dp2[i][j - 1]);
                    dp2[i][j] = Math.min(dp1[i + 1][j], dp1[i][j - 1]);
                }
            }

            return Math.max(dp1[0][n - 1], dp2[0][n - 1]);
        }

    }

    /**
     * @Description //TODO �����˵���ָ��λ�õķ�����
     * @Author ZX
     * @Date 16:21 2020/7/4
     **/
    public static class Ways {
        // �����ݹ�
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

        // ��̬�滮
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
