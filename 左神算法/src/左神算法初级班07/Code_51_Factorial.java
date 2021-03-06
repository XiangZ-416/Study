package 左神算法初级班07;

public class Code_51_Factorial {
    // 暴力递归：知道怎么试
    public static long getFactorial1(int n) {
        if (n == 1) {
            return 1L;
        }
        return (long) n * getFactorial1(n - 1);
    }
   // 一般思路：知道怎么算
    public static long getFactorial2(int n) {
        long result = 1L;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(getFactorial1(n));
        System.out.println(getFactorial2(n));
    }
}
