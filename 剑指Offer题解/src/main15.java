/**
 * ��Ŀ����
 * ����һ����������������е�����k�����
 */
import java.util.ArrayList;
import java.util.Stack;

public class main15 {
    /**
     * �ڵ�����
     */
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * ����1������ָ�루head��moveNode����һ��ָ��ͷ�ڵ㣬һ��ָ����ͷ�ڵ���Ϊk�Ľڵ�
     * Ȼ������ָ��ͬ������ߣ�ֱ��moveNodeΪ��
     * �磺head->0->1->2->3->4->null
     *       |           |
     * ʱ�临�Ӷȣ�O(N)
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail1(ListNode head, int k) {

        ListNode moveNode = head; // 1����ʼ�����ƶ��ڵ㶼��ͷ�ڵ㴦
        while (k != 0) { // 2��moveNode����ƶ�k��
            if (moveNode == null) { // k���������ȣ�ֱ�ӷ��ؿ�ֵ
                return null;
            }
            moveNode = moveNode.next;
            k--;
        }

        while (moveNode != null) { // 3��ͬʱ�ƶ�����ָ��
            moveNode = moveNode.next;
            head = head.next;
        }
        return head;
    }

    /**
     * ����2������ջ��ȷ��������K���ڵ�
     * ʱ�临�Ӷȣ�O(2N)
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail2(ListNode head, int k) {
        // base case
        if (head == null || k == 0) {
            return null;
        }
        // 1����ԭ���� �ڵ� �浽ջ��
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        // 2����ջ���ڵ�����ȡ���ŵ�arrayList
        ArrayList<ListNode> arrayList = new ArrayList<>();
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }

        // K����ԭ�����ȣ���Խ�磬���ؿ�
        if (k > arrayList.size()) {
            return null;
        }
        // ȡ��ԭ��������k���ڵ�
        return arrayList.get(k - 1);
    }

    public static void main(String[] args) {
        // �½����� 0->1->2->3->4
        ListNode head = new ListNode(0); // �ڱ��ڵ�
        ListNode endNode = head;
        for (int i = 1; i < 5; i++) {
            ListNode cur = new ListNode(i);
            cur.next = null;
            endNode.next = cur;
            endNode = cur;
        }
        // ����
        ListNode node1 = FindKthToTail1(head, 3);
        System.out.print("����1��");
        while (node1 != null) {
            System.out.print(node1.val);
            System.out.print("\t");
            node1 = node1.next;
        }

        System.out.println();

        FindKthToTail2(head, 3);
        ListNode node2 = FindKthToTail1(head, 3);
        System.out.print("����2��");
        while (node2 != null) {
            System.out.print(node2.val);
            System.out.print("\t");
            node2 = node2.next;
        }
    }
}
