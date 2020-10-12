import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO 剑指Offer25：合并有序链表
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/30 22:53
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class exe3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 链表1长度
        int m = sc.nextInt(); // 链表2长度
        ListNode head1 = new ListNode(sc.nextInt());
        ListNode head1Cur = head1;
        for (int i = 1; i < n; i++) {
            head1Cur.next = new ListNode(sc.nextInt());
            head1Cur = head1Cur.next;
        }
        ListNode head2 = new ListNode(sc.nextInt());
        ListNode head2Cur = head2;
        for (int i = 1; i < m; i++) {
            head2Cur.next = new ListNode(sc.nextInt());
            head2Cur = head2Cur.next;
        }
        // 合并两个排序链表
        if(head1 == null && head2 == null) {
            System.out.println(head1);
        }
        if(head1 == null && head2 != null) {
            System.out.println(head2);
        }
        if(head1 != null && head2 == null) {
            System.out.println(head1);
        }
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ArrayList<ListNode> list = new ArrayList<>();
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                list.add(cur1);
                cur1 = cur1.next;
            } else {
                list.add(cur2);
                cur2 = cur2.next;
            }
        }
        while (cur1 != null) {
            list.add(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            list.add(cur2);
            cur2 = cur2.next;
        }
        ListNode newHead = list.get(0);
        ListNode cur = newHead;
        for (int i = 1; i < list.size(); i++) {
            cur.next = list.get(i);
            cur = cur.next;
        }
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
