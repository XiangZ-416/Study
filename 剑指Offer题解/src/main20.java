import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 *      则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class main20 {
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    /**
     * 方法1：左上角、右下角确定一个矩形区域；改变左上角、右下角向内扩
     *         打印时，分情况：矩阵是行向量、列向量、一般矩阵
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix1(int [][] matrix) {
        // base case
        if (matrix == null)
            return null;

        // 左上角
        int tr = 0, tc = 0;
        // 右下角
        int dr = matrix.length - 1;
        int dc = matrix[0].length - 1;

        // 当arrayList中的元素个数小于矩阵中的元素个数时循环打印
        while (arrayList.size() < (matrix.length * matrix[0].length)) {
            printMatrix(matrix, tr++, tc++, dr--, dc--);
        }

        return arrayList;
    }

    public static void printMatrix(int[][] m, int tR, int tC, int dR, int dC) {
        // base case
        // m是列向量
        if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                arrayList.add(m[i][tC]);
            }
        } else if (tR == dR) { // m是行向量
            for (int i = tC; i <= dC; i++) {
                arrayList.add(m[tR][i]);
            }
        }else { // m是一般矩阵
            int curR = tR, curC = tC; // 当前位置
            // 顺时针分别打印四个边上的元素
            while (curC < dC) {
                arrayList.add(m[tR][curC++]);
            }
            while (curR < dR) {
                arrayList.add(m[curR++][dC]);
            }
            while (curC > tC) {
                arrayList.add(m[dR][curC--]);
            }
            while (curR > tR) {
                arrayList.add(m[curR--][tC]);
            }
        }
    }

    /**
     * 方法2：依次判断每一个元素、并判断是否越界、是否已经遍历过、对应的flag是多少
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix2(int [][] matrix) {
        // base case
        if (matrix == null)
            return null;

        ArrayList<Integer> arrayList = new ArrayList<>();
        int flag = 1; // 1 -> right, 2 -> down, 3 -> left, 4 -> up

        int x = 0, y = 0; // 初始位置的行、列
        boolean[][] m = new boolean[matrix.length][matrix[0].length]; // 用来该元素标记是否已经标记过

        // arrayList中元素的个数小于原矩阵中元素的个数时一直循环遍历矩阵中的每一个元素
        while (arrayList.size() < (matrix.length * matrix[0].length)) {
            // 越界后的处理
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || m[x][y]) {
                // 矩形四个顶点处越界的处理
                if (flag == 1) {
                    x++;
                    y--;
                    flag = 2;
                }else if (flag == 2) {
                    x--;
                    y--;
                    flag = 3;
                }else if (flag == 3) {
                    x--;
                    y++;
                    flag = 4;
                }else if (flag == 4) {
                    x++;
                    y++;
                    flag = 1;
                }
            }else { // 没越界就存到arrayList中
                arrayList.add(matrix[x][y]);
                m[x][y] = true; // 标记该元素已经遍历过

                // 顺时针遍历
                if (flag == 1) {
                    y++;
                }else if (flag == 2) {
                    x++;
                }else if (flag == 3) {
                    y--;
                }else if (flag == 4) {
                    x--;
                }
            }
        }

        return arrayList;
    }

    public static void main(String[] args) {
        int[][] matrix = { {1, 2}, {3, 4}};
        System.out.println("方法1：" + printMatrix1(matrix));

        System.out.println("方法2：" + printMatrix2(matrix));
    }
}