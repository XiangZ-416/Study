import java.util.ArrayList;
/**
 * ��Ŀ����
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 */
public class main17 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * ����1�������ƶ��ڵ�moveNode1��moveNode2��ʼ�ֱ�ָ��list1��list2��ͷ�ڵ㣬�Ƚ������ƶ��ڵ��ֵ
     *        ���moveNode1��ֵ <= moveNode2��ֵ����moveNode1�浽arrayList�У������ƶ�moveNode1��
     *        ���moveNode1��ֵ > moveNode2��ֵ����moveNode2�浽arrayList�У������ƶ�moveNode2��
     * ע�⣺��arrayList�еĽڵ������������γ�������Ϊ����ֻ�ǽ��ڵ����arrayList��������������������û���γ�һ������
     * ʱ�临�Ӷȣ�O(N)
     * @param list1
     * @param list2
     * @return �������ͷ�ڵ�
     */
    public static ListNode Merge1(ListNode list1, ListNode list2) {
        // base case
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ArrayList<ListNode> arrayList = new ArrayList<>();
        ListNode moveNode1 = list1; // �ƶ��ڵ�1
        ListNode moveNode2 = list2; // �ƶ��ڵ�2

        int i = 0; // ͳ��arrayList��һ����ŵĽڵ���
        // ˫ָ���жϡ����ơ����
        while (moveNode1 != null && moveNode2 != null) {
            if (moveNode1.val <= moveNode2.val) {
                arrayList.add(moveNode1);
                moveNode1 = moveNode1.next;
                i++;
            }else {
                arrayList.add(moveNode2);
                moveNode2 = moveNode2.next;
                i++;
            }
        }

        // list1��list2�ĸ�û�����꣬���ĸ�ʣ��Ľڵ�ȫ���浽arrayList��
        while (moveNode1 != null) {
            arrayList.add(moveNode1);
            moveNode1 = moveNode1.next;
        }
        while (moveNode2 != null) {
            arrayList.add(moveNode2);
            moveNode2 = moveNode2.next;
        }

        // �ı�arrayList��������ڵ������
        for (int j = 0; j < i; j++) {
            arrayList.get(j).next = arrayList.get(j + 1);
        }

        return arrayList.get(0);
    }

    /**
     * ����2��˼·ͬ����1�������Ż���������
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge2(ListNode list1, ListNode list2) {
        // base case
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode headNode; /// ���պϳ������ͷ�ڵ㡣
        if (list1.val > list2.val) {
            headNode = list2;
            list2 = list2.next;
        } else {
            headNode = list1;
            list1 = list1.next;
        }
        ListNode endNode = headNode; /// ��ʵ�ڵ�ǰλ�þ��Ǻϳ�����ó���Ϊ1��ͷ�ڵ��β�ڵ���һ���ġ�

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                endNode.next = list2; /// ���ϳ������β���ڵ��������2�е�ǰ��ָ��Ľڵ�
                endNode = list2; /// ȥ���ºϳ������β���ڵ�
                list2 = list2.next;
            } else {
                endNode.next = list1; /// ���ϳ������β���ڵ��������2�е�ǰ��ָ��Ľڵ�
                endNode = list1; /// ȥ���ºϳ������β���ڵ�
                list1 = list1.next;
            }
        }

        /// ��ʵ���ǽ�ʣ�������1�еĽڵ���뵽�ϳ�������
        while (list1 != null) {
            endNode.next = list1;
            endNode = list1;
            list1 = list1.next;
        }
        /// ��ʵ���ǽ�ʣ�������2�еĽڵ���뵽�ϳ�������
        while (list2 != null) {
            endNode.next = list2;
            endNode = list2;
            list2 = list2.next;
        }
        return headNode;
    }

    public static void main(String[] args) {
        // list1��1->3->5
        ListNode head1 = new ListNode(1);
        ListNode end1 = head1;
        for (int i = 3; i < 6; i = i + 2) {
            ListNode newNode1 = new ListNode(i);
            newNode1.next = null;
            end1.next = newNode1;
            end1 = newNode1;
        }
        // list2��2->4->6
        ListNode head2 = new ListNode(2);
        ListNode end2 = head2;
        for (int j = 4; j < 7; j = j + 2) {
            ListNode newNode2 = new ListNode(j);
            newNode2.next = null;
            end2.next = newNode2;
            end2 = newNode2;
        }
        // ����1
        ListNode head = Merge1(head1, head2);
        while (head != null) {
            System.out.print("\t" + head.val);
            head = head.next;
        }
        // ����2
        ListNode Head = Merge2(head1, head2);
        while (Head != null) {
            System.out.print("\t" + Head.val);
            Head = Head.next;
        }
    }
}