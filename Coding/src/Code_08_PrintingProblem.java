/**
 * @Description: //TODO 宏观思维解决打印问题
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/11 20:10
 */
public class Code_08_PrintingProblem {

    /**
     * @Description //TODO 转圈打印矩阵
     * @Author ZX
     * @Date 20:14 2020/6/11
     **/
    public static class circlePrintingMatrix {

        public static void print(int[][] matrix) {

            int lx = 0, ly = 0; // 左上角x，y
            int rx = matrix.length - 1, ry = matrix[0].length - 1; // 右下角x,y

            while (lx <= rx && ly <= ry) {
                printProcess(matrix,lx, ly, rx, ry);
                lx++;
                ly++;
                rx--;
                ry--;
            }

        }

        private static void printProcess(int[][] matrix, int lx, int ly, int rx, int ry) {
            if (lx == rx) {
                while (ly <= ry) {
                    System.out.print(matrix[lx][ly++] + " ");
                }
            } else if (ly == ry) {
                while (lx <= rx) {
                    System.out.print(matrix[lx++][ly] + " ");
                }
            } else {
                int curX = lx, curY = ly;
                while (curX < rx) {
                    System.out.print(matrix[curX++][curY] + " ");
                }
                while (curY < ry) {
                    System.out.print(matrix[curX][curY++] + " ");
                }
                while (curX > lx) {
                    System.out.print(matrix[curX--][curY] + " ");
                }
                while (curY > ly) {
                    System.out.print(matrix[curX][curY--] + " ");
                }
            }
        }
    }

    /**
     * @Description //TODO "之"字形打印矩阵
     * @Author ZX
     * @Date 16:43 2020/6/14
     **/
    public static class zigzagPrintingMatrix {
        public static void printProcess(int[][] matrix) {
            // base case
            if (matrix == null) {
                return;
            }

            // 设置两个点，来确定一个对角线
            int ax = 0, ay = 0;
            int bx = 0, by = 0;
            boolean flag = false; // false：从上向下打印；反之从下向上打印

            while (ax <= bx && ay >= by) {
                if (!flag) {
                    topToBottomPrint(matrix, ax, ay, bx, by);
                } else {
                    bottomToTopPrint(matrix, ax, ay, bx, by);
                }
                flag = !flag;
                if (ay < matrix.length - 1) {
                    ay++;
                } else {
                    ax++;
                }
                if (bx < matrix[0].length - 1) {
                    bx++;
                } else {
                    by++;
                }
            }
        }

        // 从上到下打印 flag = false
        private static void topToBottomPrint(int[][] matrix, int ax, int ay, int bx, int by) {
            while (ax <= bx && ay >= by) {
                System.out.print(matrix[ax++][ay--] + " ");
            }
        }

        // 从下到上打印 flag = true
        private static void bottomToTopPrint(int[][] matrix, int ax, int ay, int bx, int by) {
            while (bx >= ax && by <= ay) {
                System.out.print(matrix[bx--][by++] + " ");
            }
        }
    }

    /**
     * @Description //TODO 在排好序的二维数组中判断指定数字是否存在
     * @Author ZX
     * @Date 22:54 2020/6/14
     **/
    public static class searchNum {
        public static boolean searchProcess(int[][] matrix, int num) {
            boolean result = false;
            // base case
            if (matrix == null || (matrix.length == 0 && matrix[0].length == 0)) {
                return result;
            }

            int x = 0, y = matrix[0].length - 1;
            int base = matrix[x][y]; // 最初比较对象
            while (x < matrix.length - 1 && y >= 0) {
                if (num < base) {
                    y--;
                } else {
                    x++;
                }
                base = matrix[x][y];
                if (base == num) {
                    result = true;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        System.out.println("转圈打印矩阵");
        circlePrintingMatrix.print(matrix);

        System.out.println();
        System.out.println("====================");

        System.out.println("'之'字形打印矩阵");
        zigzagPrintingMatrix.printProcess(matrix);

        System.out.println();
        System.out.println("====================");

        System.out.println("在排好序的二维数组sortMatrix中判断指定数字是否存在");
        int[][] sortMatrix = new int[][] {{1, 3, 5, 6},
                                          {2, 5, 7, 9},
                                          {4, 6, 8, 10}};
        System.out.println(searchNum.searchProcess(sortMatrix, 4));

    }

}
