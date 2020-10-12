import java.util.Scanner;

/**
 * @Description: //TODO С����������һ���Ρ�������ܶ�ܶ�쳲�������������һ���ߡ�ͻȻ�������Ǹ����������ͷ����С��һ�ڸ��̵�������ȥ�ˡ�
 *                           С���������ˣ����Ͻ��ñ���ֽ���滭��һ��쳲������ߡ�
 *                           ����һ�������ػص�쳲��������У�����һ��n*n�ľ���������ľ�����n=3����1�е�1�������ֵ��Ȼ����˳ʱ��Ĵ��������𽥱�С��
 *                           ������n=4ʱ�������
 *                           С��ϣ�����ܹ���дһ����������һ��������n��Ȼ�������������쳲��������ξ����е�Ԫ�ء�
 *                           ��������
 *                              �������룬��������ռһ�У�����һ��������n����ʾ쳲��������ξ���Ĵ�С��(n<10)
 *                           �������
 *                              �������ռһ�У��������У��ӵ�1�п�ʼ����n�У�ÿһ�дӵ�1�п�ʼ����n�У����쳲��������ξ����е�Ԫ�أ�ÿ��������֮����һ���ո������
 *                           ��������
 *                              3
 *                           �������
 *                              34 21 13
 *                              1 1 8
 *                              2 3 5
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/21 20:07
 */
public class didi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n > 10) {
            return;
        }
        int[] res = new int[n*n];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        int[][] matrix = new int[n][n];
        int l1 = 0;
        int l2 = 0;
        int r1 = matrix.length - 1;
        int r2 = matrix[0].length - 1;
        int count = n * n - 1;
        while (l1 <= r1 && l2 <= r2) {
            if (l1 == r1) {
                for (int i = l2; i <= r2; i++) {
                    matrix[l1][i] = res[count--];
                }
            } else if (l2 == r2) {
                for (int i = l1; i <= r1; i++) {
                    matrix[i][l2] = res[count--];
                }
            } else {
                for (int i = l2; i < r2; i++) {
                    matrix[l1][i] = res[count--];
                }
                for (int i = l1; i < r1; i++) {
                    matrix[i][r2] = res[count--];
                }
                for (int i = r2; i > l2; i--) {
                    matrix[r1][i] = res[count--];
                }
                for (int i = r1; i > l1; i--) {
                    matrix[i][l2] = res[count--];
                }
            }
            l1++;
            l2++;
            r1--;
            r2--;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
