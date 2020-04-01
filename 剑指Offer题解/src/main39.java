/**
 * @Description: //TODO ����һ�ö������ĸ��ڵ㣬���������ȡ��Ӹ��ڵ㵽Ҷ�ڵ����ξ����Ľڵ㣨������Ҷ�ڵ㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 *                      ���磺
 *                          ���������� [3,9,20,null,null,15,7]��
 *                           3
 *                          / \
 *                         9  20
 *                           /  \
 *                          15   7
 *                      �������������� 3
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/25 23:26
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
     * @Description //TODO ����2������д�ĵݹ�
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
     * @Description //TODO ����1���Լ�д�ĵݹ飺���ǵ�ǰ�ڵ���������
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

        if (root.left == null && root.right == null) { // ��ǰ�ڵ���Ҷ�ӽڵ㣬����ans
            return ans;
        } else if (root.left != null && root.right == null) { // ��ǰ�ڵ����Ӵ��� && �Һ��Ӳ�����
            root = root.left; // ���µ�ǰ�ڵ�
        } else if (root.left == null) { // ��ǰ�ڵ��󺢲����� && �Һ��Ӵ���
            root = root.right; // ���µ�ǰ�ڵ�
        } else { // ��ǰ�ڵ����Һ��Ӷ�����
            int max = Math.max(TreeDepth1(root.left), TreeDepth1(root.right)); // ���µ�ǰ�ڵ�Ϊ��Ƚ���Ľڵ�
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
