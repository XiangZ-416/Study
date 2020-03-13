/**
 * ��Ŀ����
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
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
     * ˼·���ݹ�
     *  ��
     *      1.�ж���1��ǰ�ڵ��ֵ�Ƿ����2�ĸ��ڵ��ֵ��ȣ�
     *      2.�����ȣ��жϵ�ǰ�ڵ�����Ľṹ�Ƿ�����2���ڵ�����Ľṹ��ȫ��ͬ��
     *  ��
     *      3.�������ȣ��ж���1��ǰ�ڵ�������Ƿ����2�ĸ��ڵ��ֵ��ȣ�
     *      4.�����ȣ��жϵ�ǰ�ڵ����������Ľṹ�Ƿ�����2���ڵ�����Ľṹ��ȫ��ͬ��
     *  ��
     *      5.�������ȣ��ж���1��ǰ�ڵ���Һ����Ƿ����2�ĸ��ڵ��ֵ��ȣ�
     *      6.�����ȣ��жϵ�ǰ�ڵ���Һ�������Ľṹ�Ƿ�����2���ڵ�����Ľṹ��ȫ��ͬ��
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
        // ��ǰ�ڵ�ֵ��ͬ
        if (root1.val == root2.val) {
            // �жϵ�ǰ�ڵ���µĽṹ�Ƿ���ͬ
            result = Judge(root1, root2);
        }
        // �����ǰ�ڵ㲻��ȣ��жϵ�ǰ�ڵ�������Ƿ��뵱ǰ�ڵ��ֵ���
        if (!result)
            result = HasSubtree(root1.left, root2);

        // �����ǰ�ڵ�����Ӳ���ȣ��жϵ�ǰ�ڵ���Һ����Ƿ��뵱ǰ�ڵ��ֵ���
        if (!result)
            result = HasSubtree(root1.right, root2);

        return result;
    }

    /**
     * �жϵ�ǰ�ڵ�����Ľṹ�Ƿ�����2���ڵ�����Ľṹ��ȫ��ͬ
     * ע�⣺�����Ƿ�Ϊ�գ����ж�ֵ�Ƿ����
     * @param node1
     * @param node2
     * @return
     */
    public static boolean Judge(TreeNode node1, TreeNode node2) {
        // һ�����ж������Ƿ�Ϊ�գ���Ϊ���node1 == null��node2����Ҳ�Ѿ�Ϊnull�ˣ�Ҳ��������node1== null && node2 == null�������
        // ���Tree2�Ѿ��������˶��ܶ�Ӧ���ϣ�����true
        if (node2 == null)
            return true;
        // ���Tree2��û�б����꣬Tree1ȴ�������ˡ�����false
        if (node1 == null)
            return false;
        // ���������һ����û�ж�Ӧ�ϣ�����false
        if (node1.val != node2.val)
            return false;

        // ������ڵ��Ӧ���ϣ���ô�ͷֱ�ȥ�ӽڵ�����ƥ��
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
