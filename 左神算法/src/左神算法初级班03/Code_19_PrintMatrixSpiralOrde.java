package 左神算法初级班03;
/**
 * 转圈打印矩阵
 * 利用两个点：左上角t、右下角d
 */
class Code_19_PrintMatrixSpiralOrde {
    // 左上角、右下角确定一个矩形区域
    // 改变左上角、右下角向内扩
    public static void printMatrix(int [][] matrix) {
        // 左上角
        int tr = 0, tc = 0;
        // 右下角
        int dr = matrix.length - 1;
        int dc = matrix[0].length - 1;

        // 当左上角点与右下角点不冲突时一直顺时针打印
        while (tr <= dr && tc <= dc) {
            printMatrix(matrix, tr++, tc++, dr--, dc--);
        }
    }

    public static void printMatrix(int[][] m, int tR, int tC, int dR, int dC) {
        // 两个特殊情况
        // 当tc = dc时,即m是列向量时
        if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else if (tR == dR) { // 当tr = dr时,即m是行向量时
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        }else {
            // 顺时针分别打印四个边上的元素
            int curR = tR, curC = tC; // 当前位置
            while (curC < dC) {
                System.out.print(m[tR][curC++] + " ");
            }
            while (curR < dR) {
                System.out.print(m[curR++][dC] + " ");
            }
            while (curC > tC) {
                System.out.print(m[dR][curC--] + " ");
            }
            while (curR > tR) {
                System.out.print(m[curR--][tC] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3, 4}, {5, 6, 7, 8},
                {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrix(matrix);
    }
}
