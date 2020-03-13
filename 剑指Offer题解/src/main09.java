/**
 * ��Ŀ����
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 */
import java.util.Scanner;

public class main09 {
    /**
     * ����1���������һ��̨�ף�ÿһ��̨�׶��������߲������ֿ���
     * @param target Ŀ�����
     * @return ����
     */
    public static int jumpFloorII1(int target) {
        return (int)(Math.pow(2, target - 1));
    }

    /**
     * ����2��������n�׵����� = ������n-1�׵����� + 1
     * @param target Ŀ�����
     * @return ����
     */
    public static int jumpFloorII2(int target) {
        // base case
        if (target == 1) {
            return  1;
        }

        int[] arr = new int[target + 1];
        int sum = 1; // ������n-1�׹���sum������
        for (int n = 2; n < arr.length; n++) {
            arr[n] = sum + 1; // ������i�׵����� = ������i-1�׵����� + 1��ֱ��������i�ף�
            sum += arr[n];
        }
        return arr[target];
    }

    public static void main(String[] args) {
        System.out.println("����̨����");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("����1��"+jumpFloorII1(n));
        System.out.println("--");
        System.out.println("����2��"+jumpFloorII2(n));
    }
}
