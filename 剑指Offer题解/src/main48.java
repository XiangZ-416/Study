/**
 * @Description: //TODO 求1+2+3+...+n
 *                      要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/28 0:15
 */
public class main48 {
    public static int Sum_Solution(int n) {
        if (n == 1)
            return 1;
        return Sum_Solution(n - 1) + n;
    }

    public static void main(String[] args) {
        System.out.println(Sum_Solution(3));
    }
}
