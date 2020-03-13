package 左神算法初级班03;

public class Code_22_ZigZagPrintMatrix {
    /**
     * 整体的调度逻辑
     * @param matrix
     */
    public static void printMatrixZigZag(int[][] matrix) {
        // A点的行号和列号
        int aR = 0;
        int aC = 0;
        // B点的行号和列号
        int bR = 0;
        int bC = 0;
        // 终止位置
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        // 取布尔类型标记从上还是从下打印
        boolean fromUp = false;
        // 如果A到达最后一行，即A,B行程结束（或者写B到达最后一列，即A,B行程结束）
        while (aR != endR + 1) {
            printLevel(matrix, aR, aC, bR, bC, fromUp);
            aR = aC == endC ? aR + 1 : aR; // A的行：如果A的列来到了最后一列，A的行+1，否则A的行不变
            aC = aC == endC ? aC : aC + 1; // A的列：如果A的列到达最后一列，A的列不变，否则A的列+1
            bC = bR == endR ? bC + 1 : bC; // B的列：如果B的行到达最后一行，B的列+1，否则B的列不变
            bR = bR == endR ? bR : bR + 1; // B的行：如果B的行到达最后一行，B的行不变，否则B的行+1
            fromUp = !fromUp; // 上一次从上到下，下一次就要从下到上
        }
        System.out.println();
    }

    /**
     * 将对角线上的元素打印
     * @param m 待打矩阵
     * @param aR A点行数
     * @param aC A点列数
     * @param bR B点行数
     * @param bC B点列数
     * @param f 从上到下打还是从下到上打印
     */
    public static void printLevel(int[][] m, int aR, int aC, int bR, int bC, boolean f) {
        if (f) {
            while (aR != bR + 1) {
                System.out.print(m[aR++][aC--] + " ");
            }
        } else {
            while (bR != aR - 1) {
                System.out.print(m[bR--][bC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);

    }
}
