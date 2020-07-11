package 左神算法进阶班;

/**
 * @Description: //TODO Morris遍历：时间复杂度0(N)，额外空间复杂度O(1)
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/29 15:56
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
     * @Description //TODO Morris遍历
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
            // 情况2：cur有左孩子
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) { // 找当前节点左子树上最右的节点
                    mostRight = mostRight.right;
                }
                // 此时mostRight是左子树最右节点
                if (mostRight.right == null) { // mostRight的右孩子为空
                    mostRight.right = cur;
                    cur = cur.left;
                    continue; // 结束本次while循环
                } else { // mostRight的右孩子不为空
                    mostRight.right = null;
                }
            }
            // 情况1：cur没有左孩子，cur向右移动
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * @Description //TODO Morris遍历改先序遍历
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

                    System.out.print(cur.val + " "); // 先序遍历

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
     * @Description //TODO Morris遍历改中序遍历
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
            System.out.print(cur.val + " "); // 中序遍历
            cur = cur.right;
        }
        System.out.println();
    }


    /**
     * @Description //TODO Morris遍历实现后序遍历
     *                          只考虑出现两次的节点。第二次遇到时，逆序打印此节点左子树的右边界
     *                          最后再逆序打印整棵树的右边界
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
                    printEdge(cur.left); // 逆序打印当前节点左子树的右边界
                }
            }
            cur = cur.right;
        }
        printEdge(head); // 逆序打印当前节点左子树的右边界
        System.out.println();
    }

    // 逆序打印该节点的右边界
    private static void printEdge(Node node) {
        Node tail = reverseEdge(node); // 链表逆序
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        reverseEdge(tail); // 再逆序回来
    }

    // 链表逆序
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
