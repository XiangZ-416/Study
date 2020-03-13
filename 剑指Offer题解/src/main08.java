/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class main08 {
    /**
     * 方法1：递推
     * @param target
     * @return
     */
    public static int JumpFloor1(int target) {
        if (target  == 1) {
            return 1;
        }
        int[] arr = new int[target];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < target; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr[target - 1];
    }

    /**
     * 方法2：尾递归
     * @param target
     * @return
     */
    public static int JumpFloor2(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor2(target - 2) + JumpFloor2(target - 1);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor1(3));
        System.out.println("--");
        System.out.println(JumpFloor2(3));
    }
}
