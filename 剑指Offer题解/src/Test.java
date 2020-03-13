public class Test {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

         boolean result = false;
         if (root1.val == root2.val)
             result = SameStructure(root1,  root2);

         if (!result)
             result = HasSubtree(root1.left, root2);
         if (!result)
             result = HasSubtree(root1.right, root2);

         return result;
    }

    public static boolean SameStructure(TreeNode node1, TreeNode node2) {
        if (node2 == null)
            return true;
        if (node1 == null)
            return false;
        if (node1.val != node2.val)
            return false;

        return SameStructure(node1.left, node2.left) && SameStructure(node1.right, node2.right);
    }
}
