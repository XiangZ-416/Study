/**
 * @Description: //TODO 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/26 16:05
 */
public class main40 {
    // 遍历每个节点需要得到该节点的信息：该节点是否平衡、该节点的高度
    public static class returnData {
        boolean isAVL;
        int height;

        public returnData(boolean isAVL, int height) {
            this.isAVL = isAVL;
            this.height = height;
        }
    }

    /**
     * @Author ZX
     * @Description //TODO 递归获取以node为根节点的树是否为二叉树、此树的高度(0为基准)
     * @Date 16:10 2020/3/27
     * @Param [node]
     * @return main40.returnData
     **/
    protected static returnData Process(TreeNode node) {
        //base case
        if (node == null)
            return new returnData(true, 0); // 返回匿名对象

        returnData leftData = Process(node.left); // 遍历当前节点的左子树
        leftData.height++; // 左子树高度+1
        returnData rightData = Process(node.right); // 遍历当前节点的右子树
        rightData.height++;  // 右子树高度+1

        if (leftData.isAVL && rightData.isAVL && Math.abs(leftData.height - rightData.height) < 2) // 平衡二叉树定义
            return new returnData(true, Math.max(leftData.height, rightData.height)); // 以节点node为根节点的树是平衡二叉树，高度为左子树、右子树高度的较大值（树高度的定义）

        return new returnData(false, 0); // 以节点node为根节点的树不是平衡二叉树，高度信息没用
    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        // base case
        if (root == null)
            return true;

        returnData leftReturnData = Process(root.left); // 遍历当前节点的左子树
        returnData rightReturnData = Process(root.right); // 遍历当前节点的右子树

        return leftReturnData.isAVL && rightReturnData.isAVL && Math.abs(leftReturnData.height - rightReturnData.height) < 2; // 平衡二叉树定义
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println(IsBalanced_Solution(root));
    }
}
