/**
 * @Description: //TODO 求1+2+3+...+n
 *                      要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/28 0:15
 */
public class main48 {
    /**
     * @Author ZX
     * @Description //TODO 不用if的递归
     * @Date 17:04 2020/4/2
     * @Param [n]
     * @return int
     **/
    public static int Sum_Solution2(int n) {
        boolean flag = (n > 0) && (n += Sum_Solution2(n - 1)) > 0;
        return n;
    }


    /**
     * @Author ZX
     * @Description //TODO 普通递归
     * @Date 17:04 2020/4/2
     * @Param [n]
     * @return int
     **/
    public static int Sum_Solution1(int n) {
        if (n == 1)
            return 1;
        return n + Sum_Solution1(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(Sum_Solution2(3));
    }
}
