package �����㷨������07;

public class Code_57_Money_Problem {
    /**
     * ����1�������ݹ�
     * @param arr
     * @param i
     * @param sum
     * @param aim
     * @return
     */
    public static boolean process1(int[] arr, int i, int sum, int aim) {
        // base case
        if (i == arr.length) {  // ������arr���һ������
            return sum == aim; // ֻҪ���е���aim���ͷ���true
        }
        // ����·��Ҫ��ǰ�� || ��Ҫ��ǰ��
        return process1(arr, i + 1, sum, aim) || process1(arr, i + 1, sum + arr[i], aim);
    }

    /**
     * ����2����̬�滮
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
