import java.util.Scanner;

/**
 * @Description: //TODO ��ָOffer42�����������������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/9/1 17:08
 */
public class exe9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            max = Math.max(max, curSum);
            if (curSum < 0) { // ��ǰ�ۼӺ�С��0����ǰλ�ò�����������ۼӺ͵���벿�֣�������ǰ�ۼӺ�
                curSum = 0;
            }
        }
        System.out.println(max);
    }
}
