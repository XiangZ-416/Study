import java.util.Scanner;

/**
 * @Description: //TODO 类似顺时针打印数组。
 *                           有M行N列，左上角为[0,0],右下角为[M-1,N-1]，从左上角开始计数，第一个记为1，顺时针最外圈开始，
 *                           外圈结束后从里圈接着计数，当计数到个位是7且十位为奇数时，打印出该位置坐标，类似[1,2],[3,4]；
 *                           最后输出所有的结果，形式为：[[1,2],[3,4],[5,6]]。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/20 10:14
 */
public class main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        int startX = 0; // 起点x
        int startY = 0; // 起点y
        int endX = matrix.length - 1; // 终点x
        int endY = matrix[0].length - 1; // 终点y
        int count = 0;
        System.out.print("[");
        while (startX <= endX && startY <= endY) {
            if (startX == endX) { // matrix矩阵为单行矩阵
                for (int i = startY; i <= endY; i++) {
                    count++;
                    if (count % 10 == 7 && (count / 10) % 2 == 1) {
                        if (count == 17) {
                            System.out.print("[" +  startX + "," + i + "]");
                        } else  {
                            System.out.print(",[" +  startX + "," + i + "]");
                        }
                    }
                }
            } else if (startY == endY) { // // matrix矩阵为单列矩阵
                for (int i = startX; i <= endX; i++) {
                    count++;
                    if (count % 10 == 7 && (count / 10) % 2 == 1) {
                        if (count == 17) {
                            System.out.print("[" +  i + "," + startY + "]");
                        } else  {
                            System.out.print(",[" +  i + "," + startY + "]");
                        }
                    }
                }
            } else {
                for (int i = startY; i < endY; i++) { // 左上角 -> 右上角
                    count++;
                    if (count % 10 == 7 && (count / 10) % 2 == 1) {
                        if (count == 17) {
                            System.out.print("[" +  startX + "," + i + "]");
                        } else  {
                            System.out.print(",[" +  startX + "," + i + "]");
                        }
                    }
                }
                for (int i = startX; i < endX; i++) { // 右上角 -> 右下角
                    count++;
                    if (count % 10 == 7 && (count / 10) % 2 == 1) {
                        if (count == 17) {
                            System.out.print("[" +  i + "," + endY + "]");
                        } else  {
                            System.out.print(",[" +  i + "," + endY + "]");
                        }
                    }
                }
                for (int i = endY; i > startY; i--) { // 右下角 -> 左下角
                    count++;
                    if (count % 10 == 7 && (count / 10) % 2 == 1) {
                        if (count == 17) {
                            System.out.print("[" +  endX + "," + i + "]");
                        } else  {
                            System.out.print(",[" +  endX + "," + i + "]");
                        }
                    }
                }
                for (int i = endX; i > startX; i--) { // 左下角 -> 左上角
                    count++;
                    if (count % 10 == 7 && (count / 10) % 2 == 1) {
                        if (count == 17) {
                            System.out.print("[" +  i + "," + startY + "]");
                        } else  {
                            System.out.print(",[" +  i + "," + startY + "]");
                        }
                    }
                }
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
        System.out.print("]");
    }
}
