package 左神算法初级班05;

public class Code_41_Islands {
    /**
     * 主函数
     * @param m 矩阵m
     * @return 矩阵m中岛的个数
     */
    public static int countIslands(int[][] m) {
        // base case
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length; // 行
        int M = m[0].length; // 列
        int res = 0; // 岛的个数
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) { // 遇到1
                    res++; // 岛的个数加1
                    infect(m, i, j, N, M); // 进入感染函数
                }
            }
        }
        return res;
    }

    /**
     * 感染函数
     * @param m 矩阵m
     * @param i 当前行
     * @param j 当前列
     * @param N 总行数
     * @param M 总列数
     */
    public static void infect(int[][] m, int i, int j, int N, int M) {
        // 递归终止条件：越界 或 当前元素不为1，停止感染
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2; // 当前位置被感染成2
        infect(m, i + 1, j, N, M); // 感染m[i][j]的上
        infect(m, i - 1, j, N, M); // 感染m[i][j]的下
        infect(m, i, j + 1, N, M); // 感染m[i][j]的右
        infect(m, i, j - 1, N, M); // 感染m[i][j]的左
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                          { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                          { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                          { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
                       };
        System.out.println(countIslands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                          { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                          { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                          { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                          { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
                       };
        System.out.println(countIslands(m2));
    }
}
