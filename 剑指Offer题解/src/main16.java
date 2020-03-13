import java.util.Stack;
/**
 * ��Ŀ����
 * ����һ��������ת��������������ı�ͷ��
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
     * ����1������ջ�洢ԭ��������ڵ㣬�ٸı�ջ���ڵ������next�����������
     * ʱ�临�Ӷ�O(2N)
     * @param head ԭ�����ͷ�ڵ�
     * @return �������ͷ�ڵ�
     */
    public static ListNode ReverseList1(ListNode head) {
        // base case
        if (head == null) {
            return null;
        }
        // 1����ԭ���� �ڵ� �浽ջ��
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        // ���θı�ջ���ڵ��next
        // 2�������µ�����ͷ�ڵ㣬����β�巨���ν���ת��Ľڵ�����������ͷ�ڵ��
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
     * ����2��˫ָ�룬�����ƶ��ڵ�1��ָ��ͬʱ�ƶ������ƶ��ڵ㣬ֱ���ƶ��ڵ�2Ϊ��
     * ע�⣺һ��Ҫɾ��ԭ����ͷ�ڵ��ָ����
     * �磺head->0->1->2->3->4->null
     *       |    |
     * @param head
     * @return
     */
    public static ListNode ReverseList2(ListNode head){
        // base case
        if (head == null) {
            return null;
        }

        ListNode moveNode1 = head; // �ƶ��ڵ�1
        ListNode moveNode2 = head.next; // �ƶ��ڵ�2

        // ���������ƶ��ڵ�
        while (moveNode2 != null) {
            ListNode nextTemp = moveNode2.next;// ���浱ǰ�ƶ��ڵ�2��ָ�����һ���ڵ�
            moveNode2.next = moveNode1; // ����
            // �����ƶ������ƶ��ڵ�
            moveNode1 = moveNode2;
            moveNode2 = nextTemp;
        }
        head.next = null; // ɾ��ԭ����ͷ�ڵ��ָ����
        return moveNode1;
    }



    public static void main(String[] args) {
        // β�巨��������forѭ������4����
        ListNode head = new ListNode(0);
        ListNode endNode = head;
        for (int i = 1; i < 5; i++) {
            ListNode curNode = new ListNode(i);
            curNode.next = null;
            endNode.next = curNode;
            endNode = curNode;
        }
        // ����
        ListNode HEAD = ReverseList1(head);
        while (HEAD != null) {
            System.out.print(HEAD.val);
            System.out.print("\t");
            HEAD = HEAD.next;
        }
    }
}
