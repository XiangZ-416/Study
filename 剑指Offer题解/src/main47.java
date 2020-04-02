/**
 * @Description: //TODO  ԲȦ�����ʣ�µ����֣�0,1,,n-1��n�������ų�һ��ԲȦ��������0��ʼ��ÿ�δ����ԲȦ��ɾ����m�����֡�
 *                                           ������ԲȦ��ʣ�µ����һ�����֡�
 *                       ���磬0��1��2��3��4��5���������һ��ԲȦ��������0��ʼÿ��ɾ����3�����֣���ɾ����ǰ4������������2��0��4��1��
 *                            ������ʣ�µ�������3��
 *                       ʾ��
 *                          ����: n = 5, m = 3
 *                          ���: 3
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/1 23:57
 */
public class main47 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static int lastRemaining(int n, int m) {
        ListNode head = new ListNode(0);
        head.next = null;
        for (int i = 1; i < n; i++) {
            ListNode node = new ListNode(i);
            head.next = node;
            head = node;
        }
        head.next = head;

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }
}
