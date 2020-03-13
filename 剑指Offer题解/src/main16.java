import java.util.Stack;
/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class main16 {
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法1：利用栈存储原链表各个节点，再改变栈顶节点的索引next，组成新链表
     * 时间复杂度O(2N)
     * @param head 原链表的头节点
     * @return 新链表的头节点
     */
    public static ListNode ReverseList1(ListNode head) {
        // base case
        if (head == null) {
            return null;
        }
        // 1、将原链表 节点 存到栈里
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        // 依次改变栈顶节点的next
        // 2、创建新的链表头节点，采用尾插法依次将反转后的节点插入新链表的头节点后
        ListNode NewHead = stack.pop();
        ListNode EndNode = NewHead;
        while (!stack.isEmpty()) {
            ListNode newNode = stack.pop();
            newNode.next = null;
            EndNode.next = newNode;
            EndNode = newNode;
        }
        return NewHead;
    }

    /**
     * 方法2：双指针，反置移动节点1的指向，同时移动两个移动节点，直到移动节点2为空
     * 注意：一定要删除原链表头节点的指针域
     * 如：head->0->1->2->3->4->null
     *       |    |
     * @param head
     * @return
     */
    public static ListNode ReverseList2(ListNode head){
        // base case
        if (head == null) {
            return null;
        }

        ListNode moveNode1 = head; // 移动节点1
        ListNode moveNode2 = head.next; // 移动节点2

        // 反置两个移动节点
        while (moveNode2 != null) {
            ListNode nextTemp = moveNode2.next;// 保存当前移动节点2所指向的下一个节点
            moveNode2.next = moveNode1; // 反置
            // 向右移动两个移动节点
            moveNode1 = moveNode2;
            moveNode2 = nextTemp;
        }
        head.next = null; // 删除原链表头节点的指针域
        return moveNode1;
    }



    public static void main(String[] args) {
        // 尾插法创建链表（for循环里面4步）
        ListNode head = new ListNode(0);
        ListNode endNode = head;
        for (int i = 1; i < 5; i++) {
            ListNode curNode = new ListNode(i);
            curNode.next = null;
            endNode.next = curNode;
            endNode = curNode;
        }
        // 测试
        ListNode HEAD = ReverseList1(head);
        while (HEAD != null) {
            System.out.print(HEAD.val);
            System.out.print("\t");
            HEAD = HEAD.next;
        }
    }
}
