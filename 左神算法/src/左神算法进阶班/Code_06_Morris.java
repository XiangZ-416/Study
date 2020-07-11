package �����㷨���װ�;

/**
 * @Description: //TODO Morris������ʱ�临�Ӷ�0(N)������ռ临�Ӷ�O(1)
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/29 15:56
 */
public class Code_06_Morris {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * @Description //TODO Morris����
     * @Author ZX
     * @Date 20:14 2020/6/29
     **/
    public static void Morris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            // ���2��cur������
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) { // �ҵ�ǰ�ڵ������������ҵĽڵ�
                    mostRight = mostRight.right;
                }
                // ��ʱmostRight�����������ҽڵ�
                if (mostRight.right == null) { // mostRight���Һ���Ϊ��
                    mostRight.right = cur;
                    cur = cur.left;
                    continue; // ��������whileѭ��
                } else { // mostRight���Һ��Ӳ�Ϊ��
                    mostRight.right = null;
                }
            }
            // ���1��curû�����ӣ�cur�����ƶ�
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * @Description //TODO Morris�������������
     * @Author ZX
     * @Date 20:14 2020/6/29
     **/
    public static void MorrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;

                    System.out.print(cur.val + " "); // �������

                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
        System.out.println();
    }


    /**
     * @Description //TODO Morris�������������
     * @Author ZX
     * @Date 20:14 2020/6/29
     **/
    public static void MorrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.print(cur.val + " "); // �������
            cur = cur.right;
        }
        System.out.println();
    }


    /**
     * @Description //TODO Morris����ʵ�ֺ������
     *                          ֻ���ǳ������εĽڵ㡣�ڶ�������ʱ�������ӡ�˽ڵ����������ұ߽�
     *                          ����������ӡ���������ұ߽�
     * @Author ZX
     * @Date 20:14 2020/6/29
     **/
    public static void MorrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(cur.left); // �����ӡ��ǰ�ڵ����������ұ߽�
                }
            }
            cur = cur.right;
        }
        printEdge(head); // �����ӡ��ǰ�ڵ����������ұ߽�
        System.out.println();
    }

    // �����ӡ�ýڵ���ұ߽�
    private static void printEdge(Node node) {
        Node tail = reverseEdge(node); // ��������
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        reverseEdge(tail); // ���������
    }

    // ��������
    private static Node reverseEdge(Node node){
        Node pre = null;
        Node next = null;
        while (node != null) {
            next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}
