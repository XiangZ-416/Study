/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/31 19:56
 */
public class tongcheng2 {
    /**
     *
     * @param a int整型
     * @param b int整型
     * @return int整型
     */
    public static int question (int a, int b) {
        // write code here
        int ans = 0;
        for (int i = 0; i <= 500; i++) {
            if (solve(i + a) && solve(i + b)) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    private static boolean solve(int p) {
        boolean flag = false;
        double help = Math.sqrt(p);
        int q = (int) help;
        if (p == Math.pow(q, 2)) {
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(question(100, 200));
    }
}
