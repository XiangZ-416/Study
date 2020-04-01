/**
 * @Description: //TODO 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *                      例如：
 *                          给定二叉树 [3,9,20,null,null,15,7]，
 *                           3
 *                          / \
 *                         9  20
 *                           /  \
 *                          15   7
 *                      返回它的最大深度 3
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/25 23:26
 */
public class main39 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * @Author ZX
     * @Description //TODO 方法2：别人写的递归
     *                           19ms
     * @Date 15:12 2020/3/26
     * @Param [root]
     * @return int
     **/
    public static int TreeDepth2(TreeNode root) {
        // base case
        if (root == null)
            return 0;

        return Math.max(TreeDepth2(root.left), TreeDepth2(root.right)) + 1;
    }

    /**
     * @Author ZX
     * @Description //TODO 方法1：自己写的递归：考虑当前节点的四种情况
     *                           27ms
     * @Date 15:03 2020/3/26
     * @Param [root]
     * @return int
     **/
    public static int TreeDepth1(TreeNode root) {
        // base case
        if (root == null)
            return 0;

        int ans = 1;

        if (root.left == null && root.right == null) { // 当前节点是叶子节点，返回ans
            return ans;
        } else if (root.left != null && root.right == null) { // 当前节点左孩子存在 && 右孩子不存在
            root = root.left; // 更新当前节点
        } else if (root.left == null) { // 当前节点左孩不存在 && 右孩子存在
            root = root.right; // 更新当前节点
        } else { // 当前节点左右孩子都存在
            int max = Math.max(TreeDepth1(root.left), TreeDepth1(root.right)); // 更新当前节点为深度较深的节点
            if (max == TreeDepth1(root.left)) {
                root = root.left;
            } else if (max == TreeDepth1(root.right)) {
                root = root.right;
            }
        }

        return ans + TreeDepth1(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(TreeDepth1(root));
        System.out.println(TreeDepth2(root));
    }
}
