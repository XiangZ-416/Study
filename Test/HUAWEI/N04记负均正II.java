import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO ��������:
 *                              �������������
 *                           �������:
 *                              ������������Լ����зǸ�����ƽ��ֵ
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/2 17:28
 */
public class N04�Ǹ�����II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int negNum = 0; // ��������
        int nuNegNum = 0; // �Ǹ�������
        float sum = 0; // ע�����յ�ƽ������float�ͣ�����˴���int�����޷�����һλС��
        ArrayList<Integer> list = new ArrayList<>(); // ���������еķǸ���
        while(sc.hasNext()) {
            int num = sc.nextInt();
            if(num < 0) {
                negNum++;
            } else {
                nuNegNum++;
                sum += num; // �Ǹ������ۼӺ�
            }
        }
        System.out.println(negNum); // ��������ĸ���
        if( nuNegNum == 0) {
            System.out.println(0.0);
        } else {
            System.out.printf("%.1f\n", sum / nuNegNum);
        }
    }
}
