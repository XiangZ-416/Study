package 左神算法初级班07;

public class Code_56_MinPath {
    public static int minPath1(int[][] matrix) {
        return process1(matrix, matrix.length - 1, matrix[0].length - 1);
    }
    /**
     * 方法1：暴力递归：右边界、下边界、普通位置
     * 时间复杂度很高：有大量的重复计算
     * @param matrix
     * @param i 当前行
     * @param j 当前列
     * @return 最短路径和
     */
    public static int process1(int[][] matrix, int i, int j) {
        // 已经到达右下角
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        // 到达最后一行，只能往右走
        // 递归思路，等于当前位置的右边位置到达右下角的最短距离 + 当前位置的数值
        if (i == matrix.length - 1) {
            return matrix[i][j] + process1(matrix, i , j + 1);
        }
        // 到达最后一列,只能往下走
        // 递归思路，等于当前位置的下下方位置到达右下角的最短距离 + 当前位置的数值
        if (j == matrix.length - 1) {
            return matrix[i][j] + process1(matrix, i + 1, j);
        }
        // 普遍情况：可以往下走，也可以往右走
        // 往右走，递归思路，等于当前位置的右边位置到达右下角的最短距离 + 当前位置的数值
        // 往下走，递归思路，等于当前位置的下下方位置到达右下角的最短距离 + 当前位置的数值
        int right = process1(matrix, i, j + 1); // right：右边位置到右下角的最短路径和
        int down = process1(matrix, i + 1, j);  // down：下边位置到右下角的最短路径和
        // 选择下、右较小的再加上当前位置的值
        return matrix[i][j] + Math.min(right, down);
    }
    /**
     * 方法2：动态规划
     * 暴力递归改动态规划
     * （记忆化搜索）将暴力递归重复计算的数据缓存，下次计算时，先搜索是否计算过，计算过就用map把结果取出来
     * @param m
     * @return 最短路径和
     */
    public static int minPath2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }
}
