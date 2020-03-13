/**
 *
 */
public class main13 {
    /**
     * 方法1：直接调用库函数
     * 时间复杂度：O(1)
     * @param base
     * @param exponent
     * @return
     */
    public static double Power1(double base, int exponent) {
        // base case
        if (exponent == 0) {
            return 1;
        }
        if (base == 0) {
            return 0;
        }

        return Math.pow(base, exponent);
    }

    /**
     * 方法2：自己实现Math.pow()
     * 注意分指数正、负
     * 时间复杂度：O(exponent)
     * @param base
     * @param exponent
     * @return
     */
    public static double Power2(double base, int exponent) {
        // base case
        if (exponent == 0) {
            return 1;
        }
        if (base == 0) {
            return 0;
        }

        double result = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }
        if (exponent > 0) {
            return result;
        }else {
            return 1 / result;
        }
    }

    /**
     * 方法3：分情况递归
     * 时间复杂度：O(exponent)
     * @param base
     * @param exponent
     * @return
     */
    public static double Power3(double base, int exponent) {
        // base case
        if (exponent == 0) {
            return 1;
        }
        if (base == 0) {
            return 0;
        }

        // 分情况递归
        if (exponent > 0) {
            return base * Power3(base, exponent - 1);
        }else {
            return 1 / (base * Power3(base, Math.abs(exponent) - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println("方法1："+Power1(0.2, 2));
        System.out.println("方法1："+Power1(2, -3));
        System.out.println("方法1："+Power1(2, 2));
        System.out.println("-----------");
        System.out.println("方法2："+Power2(0.2, 2));
        System.out.println("方法2："+Power2(2, -3));
        System.out.println("方法2："+Power2(2, 2));
        System.out.println("-----------");
        System.out.println("方法3："+Power3(0.2, 2));
        System.out.println("方法3："+Power3(2, -3));
        System.out.println("方法3："+Power3(2, 2));
    }
}
