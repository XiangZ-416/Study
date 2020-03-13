import java.util.Scanner;
/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class main07 {
    /**
     * 方法1：题中给定n的范围，利用递推赋值给数列
     * @param n
     * @return
     */
    public static int FibonacciMethod1(int n) {
        int[] arr = new int[40];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < 40; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 方法2：分情况，并利用递推赋值
     * @param n
     * @return
     */
    public static int FibonacciMethod2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 方法3：利用尾递归
     * @param n
     * @return
     */
    public static int FibonacciMethod3(int n) {
        if (n == 0) { // 递归终止条件
            return 0;
        }
        if (n == 1 || n == 2) { // 递归终止条件
            return 1;
        }
        return FibonacciMethod3(n - 1) + FibonacciMethod3(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("请输入n：");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("法1："+FibonacciMethod1(n));
        System.out.println("法2："+FibonacciMethod2(n));
        System.out.println("法3："+FibonacciMethod3(n));
    }
}
