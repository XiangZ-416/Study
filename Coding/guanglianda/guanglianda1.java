import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description: //TODO �ֲ�
 * ʱ�����ƣ� 3000MS
 * �ڴ����ƣ� 589824KB
 * ��Ŀ������
 * �ܷ�ǳ�ϲ���ֲݣ����Լ���һƬ�ݵأ�Ϊ�˷�����������ǰ���Ƭ�ݵؿ���һ�д����ң����ҵ� i ��λ�õĲݵĸ߶���hi��
 *
 * �ܷ����̵��й�����mƿħ��ҩ����ÿƿħ��ҩ��������һ��ݳ���x���ܷ�ϣ��ÿ�ζ���������Ե�ʹ��ҩ����Ҳ�����õ�ǰ�������С�ݾ����ߣ����ڽܷ��������������ʹ����mƿħ��ҩ��֮�����С�����������������ܵ����١�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/9/9 21:42
 */
public class guanglianda1 {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int n, m, x;
        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        int res;
        for (int i = 0; i < n; i++) {
            res = sc.nextInt();
            queue.add(res);
        }
        for (int i = 0; i < m; i++) {
            res = queue.poll() + x;
            queue.add(res);
        }
        System.out.println(queue.poll());
    }
}
