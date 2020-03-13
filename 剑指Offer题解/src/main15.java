/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点
 */
import java.util.ArrayList;
import java.util.Stack;

public class main15 {
    /**
     * 节点类型
     */
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法1：两个指针（head、moveNode），一个指向头节点，一个指向与头节点间隔为k的节点
     * 然后两个指针同步向后走，直到moveNode为空
     * 如：head->0->1->2->3->4->null
     *       |           |
     * 时间复杂度：O(N)
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail1(ListNode head, int k) {

        ListNode moveNode = head; // 1、初始两个移动节点都在头节点处
        while (k != 0) { // 2、moveNode向后移动k步
            if (moveNode == null) { // k大于链表长度，直接返回空值
                return null;
            }
            moveNode = moveNode.next;
            k--;
        }

        while (moveNode != null) { // 3、同时移动两个指针
            moveNode = moveNode.next;
            head = head.next;
        }
        return head;
    }

    /**
     * 方法2：利用栈，确定倒数第K个节点
     * 时间复杂度：O(2N)
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail2(ListNode head, int k) {
        // base case
        if (head == null || k == 0) {
            return null;
        }
        // 1、将原链表 节点 存到栈里
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        // 2、将栈顶节点依次取出放到arrayList
        ArrayList<ListNode> arrayList = new ArrayList<>();
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }

        // K大于原链表长度，则越界，返回空
        if (k > arrayList.size()) {
            return null;
        }
        // 取出原链表倒数第k个节点
        return arrayList.get(k - 1);
    }

    public static void main(String[] args) {
        // 新建链表 0->1->2->3->4
        ListNode head = new ListNode(0); // 哨兵节点
        ListNode endNode = head;
        for (int i = 1; i < 5; i++) {
            ListNode cur = new ListNode(i);
            cur.next = null;
            endNode.next = cur;
            endNode = cur;
        }
        // 测试
        ListNode node1 = FindKthToTail1(head, 3);
        System.out.print("方法1：");
        while (node1 != null) {
            System.out.print(node1.val);
            System.out.print("\t");
            node1 = node1.next;
        }

        System.out.println();

        FindKthToTail2(head, 3);
        ListNode node2 = FindKthToTail1(head, 3);
        System.out.print("方法2：");
        while (node2 != null) {
            System.out.print(node2.val);
            System.out.print("\t");
            node2 = node2.next;
        }
    }
}
