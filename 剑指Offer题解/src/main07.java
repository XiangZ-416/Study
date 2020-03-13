import java.util.Scanner;
/**
 * ��Ŀ����
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����
 * n<=39
 */
public class main07 {
    /**
     * ����1�����и���n�ķ�Χ�����õ��Ƹ�ֵ������
     * @param n
     * @return
     */
    public static int FibonacciMethod1(int n) {
        int[] arr = new int[40];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < 40; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * ����2��������������õ��Ƹ�ֵ
     * @param n
     * @return
     */
    public static int FibonacciMethod2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * ����3������β�ݹ�
     * @param n
     * @return
     */
    public static int FibonacciMethod3(int n) {
        if (n == 0) { // �ݹ���ֹ����
            return 0;
        }
        if (n == 1 || n == 2) { // �ݹ���ֹ����
            return 1;
        }
        return FibonacciMethod3(n - 1) + FibonacciMethod3(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("������n��");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("��1��"+FibonacciMethod1(n));
        System.out.println("��2��"+FibonacciMethod2(n));
        System.out.println("��3��"+FibonacciMethod3(n));
    }
}
