/**
 * ��Ŀ����
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 */
import java.util.Scanner;

public class main10 {
    /**
     * β�ݹ�
     * ʱ�临�Ӷȣ�O(logN)
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
        System.out.println("������n��");
        Scanner input = new Scanner(System.in);
        int n =input.nextInt();
        System.out.println(RectCover(n));
    }
}
