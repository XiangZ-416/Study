import java.util.Scanner;

/**
 * @Description: //TODO 小明昨晚做了一个梦。在梦里，很多很多斐波那契数连成了一条蛇。突然，最大的那个数变成了蛇头，把小明一口给吞到肚子里去了。
 *                           小明被吓醒了，他赶紧拿笔在纸上面画了一条斐波那契蛇。
 *                           这是一个蛇形迂回的斐波那契数列，它是一个n*n的矩阵，在上面的矩阵中n=3。第1行第1列是最大值，然后按照顺时针的次序数字逐渐变小。
 *                           下面是n=4时的情况：
 *                           小明希望你能够编写一个程序，输入一个正整数n，然后逐行逐列输出斐波那契蛇形矩阵中的元素。
 *                           输入描述
 *                              单组输入，输入数据占一行，包含一个正整数n，表示斐波那契蛇形矩阵的大小。(n<10)
 *                           输出描述
 *                              输出数据占一行，逐行逐列（从第1行开始到第n行，每一行从第1列开始到第n列）输出斐波那契蛇形矩阵中的元素，每两个数字之间用一个空格隔开。
 *                           样例输入
 *                              3
 *                           样例输出
 *                              34 21 13
 *                              1 1 8
 *                              2 3 5
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/21 20:07
 */
public class didi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n > 10) {
            return;
        }
        int[] res = new int[n*n];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        int[][] matrix = new int[n][n];
        int l1 = 0;
        int l2 = 0;
        int r1 = matrix.length - 1;
        int r2 = matrix[0].length - 1;
        int count = n * n - 1;
        while (l1 <= r1 && l2 <= r2) {
            if (l1 == r1) {
                for (int i = l2; i <= r2; i++) {
                    matrix[l1][i] = res[count--];
                }
            } else if (l2 == r2) {
                for (int i = l1; i <= r1; i++) {
                    matrix[i][l2] = res[count--];
                }
            } else {
                for (int i = l2; i < r2; i++) {
                    matrix[l1][i] = res[count--];
                }
                for (int i = l1; i < r1; i++) {
                    matrix[i][r2] = res[count--];
                }
                for (int i = r2; i > l2; i--) {
                    matrix[r1][i] = res[count--];
                }
                for (int i = r1; i > l1; i--) {
                    matrix[i][l2] = res[count--];
                }
            }
            l1++;
            l2++;
            r1--;
            r2--;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
