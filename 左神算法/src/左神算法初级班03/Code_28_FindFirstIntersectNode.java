package 左神算法初级班03;

public class Code_28_FindFirstIntersectNode {
    /**
     * 单链表结构
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 主函数
     * @param head1
     * @param head2
     * @return 返回第一个相交的节点；不相交返回null
     */
    public static Node getIntersectNode(Node head1, Node head2) {
        // 只要有一个单链表为空此时不可能相交
        if (head1 == null || head2 == null) {
            return null;
        }
        // 两个无环单链表的相交问题
        Node loop1 = getLoopNode(head1); // 得到head1的第一个入环节点；没有则返回null
        Node loop2 = getLoopNode(head2); // 得到head1的第一个入环节点；没有则返回null
        if (loop1 == null && loop2 == null) { // 两个无环单链表的相交问题
            return noLoop(head1, head2); // 返回第一个相交的节点；不相交返回null
        }
        // 两个有环单链表的相交问题
        if (loop1 != null && loop2 != null) { // 两个有环单链表的相交问题
            return bothLoop(head1, loop1, head2, loop2); // 返回第一个相交的节点；不相交返回null
        }
        // 一个有环一个无环，此时不可能相交
        return null;
    }

    /**
     * 问题1：判断一个单链表是否有环,如果有, 则返回第一个进入环的节点；没有则返回null
     * @param head 单链表的头节点
     * @return
     */
    public static Node getLoopNode(Node head) {
        // 单链表节点数<3不可能成环
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; // n1 -> slow
        Node n2 = head.next.next; // n2 -> fast
        while (n1 != n2) { // 快指针和慢指针在环中相遇的时候停
            if (n2.next == null || n2.next.next == null) { // 快指针和慢指针只要有一个走到尾部
                return null; // 则没有环
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; // 快指针回到head
        while (n1 != n2) { // 快指针和慢指针再次相遇的时候停
            // 此时快指针、慢指针每次都走1步
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1; // 相遇节点即为第一个入环的节点
    }

    /**
     * 问题2：两个无环单链表的相交问题
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
        //-----计算两个单链表长度的差值n-----//
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        //-----计算两个链表长度的差值n-----//
        if (cur1 != cur2) { // 如果两个单链表的最后一个节点不相等，他俩不可能相交
            return null;
        }
        cur1 = n > 0 ? head1 : head2; // cur1指向长链表的头部
        cur2 = cur1 == head1 ? head2 : head1; // cur2指向短链表的头部；如果长度相等，也要保证cur1和cur2指的是不同的东西
        n = Math.abs(n); // 长度差值的绝对值
        while (n != 0) {  // 长链表先走n的绝对值步
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) { // 长链表短链表一起走多少步，返回的就是第一个相交的节点
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 问题3：两个有环链表的相交问题
     * @param head1
     * @param loop1 head1的第一个入环节点
     * @param head2
     * @param loop2 head2的第一个入环节点
     * @return
     */
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        // 情况1：两个链表从同一个点入环
        // 这种情况下，我们只要考虑链表1从头开始到loop1这一段与链表2从头开始到loop2这一段，在那里第一次相交即可，
        // 而不用考虑进环该怎么处理，这就与问题2类似，只不过问题二是把null作为一个链表的终点，而这里是把loop1(loop2)作为链表的终点。
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
        } else { // 情况2：两个链表不从同一个点入环：可能相交；可能不相交
            // loop1绕自己的环转一圈，如果回到loop1都没遇到loop2则两个链表不相交；
            // 如果loop1遇到loop2，两链表相交；因为loop1和loop2都在两条链表上，
            // 所以，此时返回loop1或loop2都可以。
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
