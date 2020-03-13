package 左神算法初级班04;

public class Code_37_CompleteTreeNodeNumber {
    /**
     * 节点类型
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
     * 主函数
     * @param head 完全二叉树的头节点
     * @return 节点个数
     * 时间复杂度：O(logN^2)
     */
    public static int nodeNum(Node head) {
        // base case
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }
    /**
     * 求以当前节点为根的树的节点个数
     * @param node 当前节点
     * @param level 当前节点在第几层
     * @param H 整棵树的深度
     * @return 以当前节点为头的树的节点个数
     */
    public static int bs(Node node, int level, int H) {
        if (level == H) { // 如果当前节点来到最后一层
            return 1; // 即：以叶节点为头的树的节点个数为1
        }
        // 以当前节点为头的树的右子树的左边界到没到底（整棵树的深度）
        if (mostLeftLevel(node.right, level + 1) == H) {
            // 到底：左子树为满二叉树且高度为H - level，此时右子树为完全二叉树，与母问题相同
            return (1 << (H - level)) - 1 + 1 + bs(node.right, level + 1, H);
        } else { // 没到底：右子树为满二叉树且高度为H - level - 1，此时左子树为完全二叉树，与母问题相同
            return (1 << (H - level - 1)) - 1 + 1 + bs(node.left, level + 1, H);
        }
    }
    /**
     * 得到整棵树的深度h
     * @param node 当前节点
     * @param level
     * @return
     */
    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left; // 当前节点不断往左走
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));
    }
}
