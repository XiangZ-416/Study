/**
 * @Description: //TODO  圆圈中最后剩下的数字：0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 *                                           求出这个圆圈里剩下的最后一个数字。
 *                       例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，
 *                            因此最后剩下的数字是3。
 *                       示例
 *                          输入: n = 5, m = 3
 *                          输出: 3
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/1 23:57
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
