import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO 循环链表种插入新节点保证仍为循环链表
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/9/2 16:57
 */
public class exe11 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode head  = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 插入n
        ListNode newHead = solve(n, head);
        ListNode cur = newHead;
        System.out.print(cur.val + " ");
        while (cur.next != newHead) {
            System.out.print(cur.next.val + " ");
            cur = cur.next;
        }
    }

    private static ListNode solve(int n, ListNode head) {
        ListNode newNode = new ListNode(n); // 待插节点
        if (head == null) { // 原链表为空，待插节点自身组成循环链表并返回
            newNode.next = newNode;
            return newNode;
        }
        // 寻找符合升序的插入位置aimNode
        ListNode aimNode = null;
        ListNode curNode = head;
        while (curNode.next != head) {
            if (curNode.val <= newNode.val && curNode.next.val >= newNode.val) {
                aimNode = curNode;
                break;
            }
            curNode = curNode.next;
        }
        if (aimNode != null) { // 找到合适位置
            ListNode next = aimNode.next;
            aimNode.next = newNode;
            newNode.next = next;
            return head;
        }else { // 走到尾端仍未找到
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

