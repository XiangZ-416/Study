import java.util.Scanner;

/**
 * @Description: //TODO ������A��������B ����С��������ָ �ܱ�A��B��������С��������ֵ�����һ���㷨��������A��B����С��������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/2 17:25
 */
public class N01��С������ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        // ��С������ = (num1 * num2) / ���Լ��
        System.out.println((num1 * num2) / solve(num1, num2));
    }
    // ��num1��num2�����Լ��
    private static int solve(int num1, int num2) {
        if(num1 == num2) {
            return num1;
        }
        if(num1 > num2) {
            int num = num1 - num2;
            return solve(num, num2);
        } else {
            int num = num2 - num1;
            return solve(num1, num);
        }
    }
}
