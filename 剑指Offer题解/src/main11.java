/**
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class main11 {
    // 方法1：temp左移逐个判断n的每一位是否位1
    // 缺点：对于每一个数都需要将temp左移32次
    public int NumberOfOne1(int n) {
        int sum = 0; // 记录1的个数
        int temp = 1; // 用temp判断n的每一位是否为1
        while(temp != 0) { // int型变量为32位。temp左移32次之后，temp就会变为0。此时说明n遍历结束了
            sum = (n & temp) != 0 ? sum + 1 : sum;
            temp = temp << 1;
        }
        return sum;
    }


    // 方法2：n & (n -1)即消除n最右边的1
    public int NumberOfOne2(int n) {
        int sum = 0; // 记录1的个数
        while(n != 0) { // 说明n中至少有一个1
            sum++;
            n = n & (n - 1); // 利用n - 1消除n最右边的1
        }
        return sum;
    }
}
