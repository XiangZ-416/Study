package 左神算法初级班03;

public class Code_21_ReverseList {
    // 单向链表节点
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 单向链表
     * 遍历反转法：从前往后反转各个结点的指针域的指向。
     * @param head 头节点
     * @return 新的头节点
     */
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            // 将当前节点的下一个节点存起来
            next = head.next;
            // 反转当前节点的指针域
            head.next = pre;
            // 处理下一个节点
            pre = head;
            head = next;
        }
        return pre;
    }

    // 双向链表节点
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }
    /**
     * 双向链表
     * 遍历反转法：从前往后反转各个结点的两个指针域的指向。
     * @param head 头节点
     * @return 新的头节点
     */
    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            // 存当前节点的下一个节点
            next = head.next;
            // 反转当前节点的指针域
            head.next = pre;
            head.last = next;
            // 处理下一个节点
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseList(head2));
    }
}
