package 左神算法初级班04;

class Code_34_IsBalancedTree {
    public static class Node {
        private  int value;
        private Node left;
        private Node right;

        public Node(int value) {
            value = this.value;
        }
    }

    public static class ReturnData {
        public boolean isB;
        public int h;

        public ReturnData(boolean isB, int h) {
            this.isB = isB; // 是否平衡
            this.h = h; // 高度
        }
    }

    public static ReturnData Process(Node head) {
        // base case
        if (head == null) {
            return new ReturnData(true, 0);
        }
        ReturnData leftData = Process(head.left); // 得到左子树是否平衡和高度信息
        if (!leftData.isB) { // 当前节点的左子树不平衡，整棵树都不平衡了，高度信息没有用了，直接就0
            return new ReturnData(false, 0);
        }
        ReturnData rightData = Process(head.right); // 得到右子树是否平衡和高度信息
        if (!rightData.isB) { // 当前节点的右子树不平衡，整棵树都不平衡了，高度信息没有用了，直接就0
            return new ReturnData(false, 0);
        }
        // 来到这里，说明当前节点的左右子树都平衡，需要对比左右子树的高度差是否大于1
        if (Math.abs(leftData.h - rightData.h) > 1) {
            return new ReturnData(false, 0);
        }
        // 左右子树都平衡，且高度差小于等于1，则此节点作为根节点的子树是平衡的
        // 高度则为左右子树中最高的高度+1
        return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);
    }
    // 主函数
    public static boolean isB(Node head) {
        return Process(head).isB;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isB(head));
    }
}
