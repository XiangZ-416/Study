/**
 *
 */
public class main04 {
    private static int index = 0;
    /**
     * 遍历前序序列将中序序列分为左右两个子序列
     * @param pre 前序序列
     * @param tempIn 中序序列的子序列
     * @return
     */
    private static TreeNode solve(int[] pre, int[] tempIn) {
        int len1 = 0; // 当前节点的左子树的节点的个数
        int len2 = 0; // 当前节点的右子树的节点的个数
        for (int i = 0; i < tempIn.length; i++ ) {
            if (pre[index] == tempIn[i]) {
                break;
            }
            len1++; // 左子树节点的个数++
        }
        len2 = tempIn.length - len1 - 1;

        int index1 = 0;
        int index2 = 0;
        int[] temp1 = new int[len1]; // 当前节点的左子树
        int[] temp2 = new int[len2]; // 当前节点的右子树
        boolean flag = false; // 表示还没找到pre[index] == tempIn[i]
        for (int i = 0; i < tempIn.length; i++) {
            if (pre[index] == tempIn[i]) {
                flag = true;
            } else if (!flag) { // 如果还没找到pre[index] == tempIn[i]
                temp1[index1++] = tempIn[i];
            } else { // 表示已经到了pre[index] == tempIn[i]的右边
                temp2[index2++] = tempIn[i];
            }
        }
        TreeNode node = new TreeNode(pre[index]);
        node.left = null;
        node.right = null;
        System.out.printf("%d左子树:", pre[index]);
        for (int i = 0; i< temp1.length; i++) {
            System.out.printf("%d", temp1[i]);
        }
        System.out.printf(", ");
        System.out.printf("%d右子树:", pre[index]);
        for (int i = 0; i< temp2.length; i++) {
            System.out.printf("%d", temp2[i]);
        }
        System.out.println();
        // 本次递归的核心
        if (index < pre.length && temp1.length > 0) { // 如果当前节点存在左子树
            index++; // 遍历前序序列的下标加1
            node.left = solve(pre, temp1); // 创建当前节点的左子树
        }
        if (index < pre.length && temp2.length > 0) { // 如果当前节点存在右子树
            index++; // 遍历前序序列的下标加1
            node.right = solve(pre, temp2); // 创建当前节点的右子树
        }
        return node;
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] mid) {
        index = 0; // 遍历前序序列的下标
        return solve(pre, mid);
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8}; // 前序遍历序列
        int[] mid = {4, 7, 2, 1, 5, 3, 8, 6}; // 中序遍历序列

        TreeNode root = reConstructBinaryTree(pre, mid);

        dfs1(root);
        System.out.println();
        dfs2(root);
        System.out.println();
        dfs3(root);
        System.out.println();
    }

    private static void dfs1(TreeNode node) { // 先序遍历
        System.out.printf("%d ", node.val);
        if (node.left != null) {
            dfs1(node.left);
        }
        if (node.right != null) {
            dfs1(node.right);
        }
    }
    private static void dfs3(TreeNode node) { // 后续遍历
        if (node.left != null) {
            dfs3(node.left);
        }
        if (node.right != null) {
            dfs3(node.right);
        }
        System.out.printf("%d ", node.val);
    }
    private static void dfs2(TreeNode node) { // 中序遍历
        if (node.left != null) {
            dfs2(node.left);
        }
        System.out.printf("%d ", node.val);
        if (node.right != null) {
            dfs2(node.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}