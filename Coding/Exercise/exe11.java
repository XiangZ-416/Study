import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO ѭ�������ֲ����½ڵ㱣֤��Ϊѭ������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/9/2 16:57
 */
public class exe11 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode head  = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // ����n
        ListNode newHead = solve(n, head);
        ListNode cur = newHead;
        System.out.print(cur.val + " ");
        while (cur.next != newHead) {
            System.out.print(cur.next.val + " ");
            cur = cur.next;
        }
    }

    private static ListNode solve(int n, ListNode head) {
        ListNode newNode = new ListNode(n); // ����ڵ�
        if (head == null) { // ԭ����Ϊ�գ�����ڵ��������ѭ����������
            newNode.next = newNode;
            return newNode;
        }
        // Ѱ�ҷ�������Ĳ���λ��aimNode
        ListNode aimNode = null;
        ListNode curNode = head;
        while (curNode.next != head) {
            if (curNode.val <= newNode.val && curNode.next.val >= newNode.val) {
                aimNode = curNode;
                break;
            }
            curNode = curNode.next;
        }
        if (aimNode != null) { // �ҵ�����λ��
            ListNode next = aimNode.next;
            aimNode.next = newNode;
            newNode.next = next;
            return head;
        }else { // �ߵ�β����δ�ҵ�
            ListNode next = curNode.next;
            curNode.next = newNode;
            newNode.next = next;
            if (n < head.val) {
                return newNode;
            } else {
                return head;
            }
        }
    }
}

