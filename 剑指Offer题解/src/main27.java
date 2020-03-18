import java.util.LinkedList;
import java.util.Queue;

/**
 * ��Ŀ����
 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * @author ZX
 * @date 2020/3/17 - 22:02
 */
public class main27 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * ����1��1.������������������������нڵ�������
     *       2.�ı���������нڵ���������γ�˫������
     * ʱ�临�Ӷȣ�O(N)
     * ����ռ临�Ӷȣ�O(N)
     */
    Queue<TreeNode> queue = new LinkedList<>();
    public TreeNode Convert1(TreeNode pRootOfTree) {
        // base case
        if (pRootOfTree == null)
            return null;

        // 1.�Ƚ���������������������нڵ�浽������
        midPrint(pRootOfTree);

        // 2.�ı�����ڵ��ָ����Ϊ˫������
        TreeNode head = queue.poll();
        TreeNode pre = head;
        pre.left = null;
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;

        return head;
    }

    // ���������������
    public void midPrint(TreeNode root) {
        if (root == null)
            return;
        midPrint(root.left);
        queue.add(root);
        midPrint(root.right);
    }

    /**
     * ����2���ݹ�
     * ʵ�ֵݹ麯��Process
     *      1.���������ͷ�ڵ�X
     *      2.�����ǽ���XΪͷ�ڵ������������ת��Ϊһ�������˫������
     *      3.����ֵ���������˫�������ͷ�ڵ��β�ڵ�
     * ��ͷ�ڵ�X�����ӡ��Һ��ӽ���Process��
     * ���ͨ��X�������γɵ�˫����������������(�����������һ��)
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert2(TreeNode pRootOfTree) {
        // base case
        if (pRootOfTree == null)
            return null;

        return Process(pRootOfTree).start;
    }

    // ����ݹ麯������ֵ����
    public class returnType{
        TreeNode start;
        TreeNode end;

        public returnType(TreeNode head, TreeNode end) {
            this.start = head;
            this.end = end;
        }
    }

    /**
     * �ݹ麯��Process
     *      1.���������ͷ�ڵ�
     *      2.�����ǽ���rootΪͷ�ڵ������������ת��Ϊһ�������˫������
     * @param root ͷ�ڵ�
     * @return ����ֵ���������˫�������ͷ�ڵ��β�ڵ�
     */
    public returnType Process(TreeNode root) {
        // base case
        if (root == null)
            return new returnType(null, null);

        // �ݹ�
        returnType leftList = Process(root.left);
        returnType rightList = Process(root.right);

        // ����
        if (leftList.end != null){
            leftList.end.right = root;
            root.left = leftList.end;
        }

        if (rightList.start != null){
            rightList.start.left = root;
            root.right = rightList.start;
        }

        return new returnType((leftList.start != null ? leftList.start : root),
                                (rightList.end != null ? rightList.end : root));
    }
}
