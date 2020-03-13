/**
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
import java.util.Scanner;

public class main10 {
    /**
     * 尾递归
     * 时间复杂度：O(logN)
     * @param target
     * @return
     */
    public static int RectCover(int target) {
        // base case
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return RectCover(target - 2) + RectCover(target - 1);
    }

    public static void main(String[] args) {
        System.out.println("请输入n：");
        Scanner input = new Scanner(System.in);
        int n =input.nextInt();
        System.out.println(RectCover(n));
    }
}
