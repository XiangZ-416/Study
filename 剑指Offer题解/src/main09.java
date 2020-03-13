/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
import java.util.Scanner;

public class main09 {
    /**
     * 方法1：除了最后一个台阶，每一个台阶都有跳或者不跳两种可能
     * @param target 目标阶数
     * @return 跳法
     */
    public static int jumpFloorII1(int target) {
        return (int)(Math.pow(2, target - 1));
    }

    /**
     * 方法2：跳到第n阶的跳法 = 跳到第n-1阶的跳法 + 1
     * @param target 目标阶数
     * @return 跳法
     */
    public static int jumpFloorII2(int target) {
        // base case
        if (target == 1) {
            return  1;
        }

        int[] arr = new int[target + 1];
        int sum = 1; // 跳到第n-1阶共有sum种跳法
        for (int n = 2; n < arr.length; n++) {
            arr[n] = sum + 1; // 跳到第i阶的跳法 = 跳到第i-1阶的跳法 + 1（直接跳到第i阶）
            sum += arr[n];
        }
        return arr[target];
    }

    public static void main(String[] args) {
        System.out.println("输入台阶数");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("方法1："+jumpFloorII1(n));
        System.out.println("--");
        System.out.println("方法2："+jumpFloorII2(n));
    }
}
