package 左神算法初级班04;
/**
 * 实现二叉树的先序、中序、后序遍历，包括递归方式和非递归方式
 */
import java.util.Stack;

public class Code_29_PreInPosTraversal {
    /**
     * 二叉树结构
     */
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 递归：前序
     * @param head 当前节点
     */
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 递归：中序
     * @param head 当前节点
     */
    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    /**
     * 递归：后序
     * @param head 当前节点
     */
    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 非递归：前序
     * 先序遍历：中左右
     * 思路：压栈顺序：中右左
     * @param head 当前节点
     */
    public static void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归：中序
     * 中序：左中右
     * 思路：当前节点为空，从栈顶拿出并且打印，把当前节点向右；
     *       当前节点不为空，将当前节点压入栈中，当前节点向左。
     * @param head 当前节点
     */
    public static void inOrderUnRecur(Node head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else { // 此时当前节点为空，栈不为空时
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归：后序1
     * 后序：左右中
     * 思路：利用两个栈；
     *       先利用非递归的先序遍历思想实现（中右左）；
     *       再实现后续遍历（左右中）。
     * @param head 当前节点
     */
    public static void posOrderUnRecur1(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head); // s1弹出的存到s2里实现：中右左-->左右中
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }

    /**
     * 非递归：后序2
     * @param h 当前节点
     */
    public static void posOrderUnRecur2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);
    }
}
