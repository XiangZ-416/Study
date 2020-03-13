/**
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class main18 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路：递归
     *  根
     *      1.判断树1当前节点的值是否和树2的根节点的值相等；
     *      2.如果相等，判断当前节点下面的结构是否与树2根节点下面的结构完全相同；
     *  左
     *      3.如果不相等，判断树1当前节点的左孩子是否和树2的根节点的值相等；
     *      4.如果相等，判断当前节点的左孩子下面的结构是否与树2根节点下面的结构完全相同；
     *  右
     *      5.如果不相等，判断树1当前节点的右孩子是否和树2的根节点的值相等；
     *      6.如果相等，判断当前节点的右孩子下面的结构是否与树2根节点下面的结构完全相同；
     * @param root1
     * @param root2
     * @return
     */
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        // base case
        if (root1 == null || root2 == null) {
            return false;
        }

        boolean result = false;
        // 当前节点值相同
        if (root1.val == root2.val) {
            // 判断当前节点底下的结构是否相同
            result = Judge(root1, root2);
        }
        // 如果当前节点不相等，判断当前节点的左孩子是否与当前节点的值相等
        if (!result)
            result = HasSubtree(root1.left, root2);

        // 如果当前节点的左孩子不相等，判断当前节点的右孩子是否与当前节点的值相等
        if (!result)
            result = HasSubtree(root1.right, root2);

        return result;
    }

    /**
     * 判断当前节点下面的结构是否与树2根节点下面的结构完全相同
     * 注意：先判是否为空，再判断值是否相等
     * @param node1
     * @param node2
     * @return
     */
    public static boolean Judge(TreeNode node1, TreeNode node2) {
        // 一定先判断子树是否为空，因为如果node1 == null，node2可能也已经为null了，也就是少了node1== null && node2 == null这种情况
        // 如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null)
            return true;
        // 如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null)
            return false;
        // 如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val)
            return false;

        // 如果根节点对应的上，那么就分别去子节点里面匹配
        return Judge(node1.left,node2.left) && Judge(node1.right,node2.right);
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(2);
        head1.right = new TreeNode(3);

        TreeNode head2 = new TreeNode(2);
        head2.left = new TreeNode(1);
        //head2.right = new TreeNode(3);

        System.out.println(HasSubtree(head1, head2));
    }
}
