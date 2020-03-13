package 左神算法初级班04;

public class Code_31_SuccessorNode {
    /**
     * 节点类型
     */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 查找当前节点的后继节点
     * @param node 当前节点
     * @return
     */
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        // 情况1：当前节点有右子树
        if (node.right != null) {
            return getLeftMost(node.right); // 返回当前节点右子树最左的节点
        } else { // 情况2：当前节点没有右子树
            Node parent = node.parent;
            while (parent != null && parent.left != node) { // 到达整颗树最顶端还没找到&&当前节点等于其父节点的左孩子停
               // 当前节点和其父节点一起向上移动
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    /**
     * 找某一棵子树最左的节点
     * @param node 某一颗子树的头部
     * @return 该子树最左的节点
     */
    public static Node getLeftMost(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));
    }
}
