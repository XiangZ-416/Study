import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO С�������ּ�����
 *                          ʱ�����ƣ� 3000MS
 *                          �ڴ����ƣ� 589824KB
 *                          ��Ŀ������
 *                              ���Ŷ����̼ҵ�������ϵ��1-5��������ϵ���û�����ɶ���֮����Զ��̼Ҵ�1/2/3/4/5�ǣ����ڿͻ����ϣ��̼ҵ�����ȴ��һ�������������ǻ���ʾС������һλ��
 *                              ����Ȼ�����Ҫһ���������ˣ�С��ӵ����һЩ�̻����������ݣ�ϣ�����Լ�����̼��ڿͻ�������ʾ�������֡�
 *                              ������ֵļ���ǳ��򵥣����ǶԸ��̼ҵ����пͻ����Ǽ���������һ��ƽ����Ȼ��ȥβ����ʾС������һλ���ɣ�����ƽ���÷���3.55������ʾ����3.5������ĳ�̼�
 *                              �����1-5�����۸�һ��������ʾ��������(1+2+3+4+5)/5=3.0��
 *                              ����̼�û�л�����ۣ�����ʾ0.0��
 *                          ��������
 *                              �������5�����������ηֱ��ʾ�̼һ��1�ǵ�5�ǵ�����������ÿһ�����۵�������������1000��
 *                          �������
 *                              ���������һ������һλ��С������ʾ�̼��ڿͻ�������ʾ��������
 *                          ��������
 *                              2 2 1 1 2
 *                          �������
 *                              2.8
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/8 15:12
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<5;i++) {
            list.add(sc.nextInt());
        }
        String s = String.valueOf(process(list));
        String[] ss = s.split("\\.");
        System.out.println(ss[0]+"."+ss[1].charAt(0));
    }

    private static double process(ArrayList<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        int sum = 0; // ������
        double b = 0;

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            sum += num * (i + 1);
            b += num;
        }
        return sum / b;
    }
}
