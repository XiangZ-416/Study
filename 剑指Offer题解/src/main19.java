/**
 * ��Ŀ����
 * ���������Ķ�����������任ΪԴ�������ľ���
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
     * ˼·���ݹ�
     *      �����з�Ҷ�ڵ��������������λ��
     * @param root
     */
    public static void Mirror(TreeNode root) {
        // base case
        if (root == null) // ����
            return;
        if (root.left == null && root.right == null) // Ҷ�ӽڵ�
            return;

        // ����ǰ�ڵ�����Һ���λ�û���
        TreeNode helpNode = root.left;
        root.left = root.right;
        root.right = helpNode;

        // ��ǰ�ڵ�����Һ����ظ�������
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

        System.out.println("Դ�����������");
        midPrint(root);
        System.out.println();

        Mirror(root);

        System.out.println("���������������");
        midPrint(root);
    }
}
