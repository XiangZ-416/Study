package �����㷨������03;

public class Code_28_FindFirstIntersectNode {
    /**
     * ������ṹ
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * ������
     * @param head1
     * @param head2
     * @return ���ص�һ���ཻ�Ľڵ㣻���ཻ����null
     */
    public static Node getIntersectNode(Node head1, Node head2) {
        // ֻҪ��һ��������Ϊ�մ�ʱ�������ཻ
        if (head1 == null || head2 == null) {
            return null;
        }
        // �����޻���������ཻ����
        Node loop1 = getLoopNode(head1); // �õ�head1�ĵ�һ���뻷�ڵ㣻û���򷵻�null
        Node loop2 = getLoopNode(head2); // �õ�head1�ĵ�һ���뻷�ڵ㣻û���򷵻�null
        if (loop1 == null && loop2 == null) { // �����޻���������ཻ����
            return noLoop(head1, head2); // ���ص�һ���ཻ�Ľڵ㣻���ཻ����null
        }
        // �����л���������ཻ����
        if (loop1 != null && loop2 != null) { // �����л���������ཻ����
            return bothLoop(head1, loop1, head2, loop2); // ���ص�һ���ཻ�Ľڵ㣻���ཻ����null
        }
        // һ���л�һ���޻�����ʱ�������ཻ
        return null;
    }

    /**
     * ����1���ж�һ���������Ƿ��л�,�����, �򷵻ص�һ�����뻷�Ľڵ㣻û���򷵻�null
     * @param head �������ͷ�ڵ�
     * @return
     */
    public static Node getLoopNode(Node head) {
        // ������ڵ���<3�����ܳɻ�
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; // n1 -> slow
        Node n2 = head.next.next; // n2 -> fast
        while (n1 != n2) { // ��ָ�����ָ���ڻ���������ʱ��ͣ
            if (n2.next == null || n2.next.next == null) { // ��ָ�����ָ��ֻҪ��һ���ߵ�β��
                return null; // ��û�л�
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; // ��ָ��ص�head
        while (n1 != n2) { // ��ָ�����ָ���ٴ�������ʱ��ͣ
            // ��ʱ��ָ�롢��ָ��ÿ�ζ���1��
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1; // �����ڵ㼴Ϊ��һ���뻷�Ľڵ�
    }

    /**
     * ����2�������޻���������ཻ����
     * @param head1
     * @param head2
     * @return
     */
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        //-----���������������ȵĲ�ֵn-----//
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        //-----�������������ȵĲ�ֵn-----//
        if (cur1 != cur2) { // �����������������һ���ڵ㲻��ȣ������������ཻ
            return null;
        }
        cur1 = n > 0 ? head1 : head2; // cur1ָ�������ͷ��
        cur2 = cur1 == head1 ? head2 : head1; // cur2ָ��������ͷ�������������ȣ�ҲҪ��֤cur1��cur2ָ���ǲ�ͬ�Ķ���
        n = Math.abs(n); // ���Ȳ�ֵ�ľ���ֵ
        while (n != 0) {  // ����������n�ľ���ֵ��
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) { // �����������һ���߶��ٲ������صľ��ǵ�һ���ཻ�Ľڵ�
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * ����3�������л�������ཻ����
     * @param head1
     * @param loop1 head1�ĵ�һ���뻷�ڵ�
     * @param head2
     * @param loop2 head2�ĵ�һ���뻷�ڵ�
     * @return
     */
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        // ���1�����������ͬһ�����뻷
        // ��������£�����ֻҪ��������1��ͷ��ʼ��loop1��һ��������2��ͷ��ʼ��loop2��һ�Σ��������һ���ཻ���ɣ�
        // �����ÿ��ǽ�������ô�������������2���ƣ�ֻ����������ǰ�null��Ϊһ��������յ㣬�������ǰ�loop1(loop2)��Ϊ������յ㡣
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else { // ���2������������ͬһ�����뻷�������ཻ�����ܲ��ཻ
            // loop1���Լ��Ļ�תһȦ������ص�loop1��û����loop2�����������ཻ��
            // ���loop1����loop2���������ཻ����Ϊloop1��loop2�������������ϣ�
            // ���ԣ���ʱ����loop1��loop2�����ԡ�
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }
}
