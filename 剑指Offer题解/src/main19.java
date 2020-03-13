/**
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 */
public class main19 {
    public static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路：递归
     *      将所有非叶节点的左右子树互换位置
     * @param root
     */
    public static void Mirror(TreeNode root) {
        // base case
        if (root == null) // 空树
            return;
        if (root.left == null && root.right == null) // 叶子节点
            return;

        // 将当前节点的左右孩子位置互换
        TreeNode helpNode = root.left;
        root.left = root.right;
        root.right = helpNode;

        // 当前节点的左右孩子重复父过程
        Mirror(root.right);
        Mirror(root.left);
    }

    //for test
    public static void midPrint(TreeNode root) {
        if (root == null)
            return;

        midPrint(root.left);
        System.out.print(root.val+" ");
        midPrint(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println("源树中序遍历：");
        midPrint(root);
        System.out.println();

        Mirror(root);

        System.out.println("镜像树中序遍历：");
        midPrint(root);
    }
}
