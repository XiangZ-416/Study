/**
 * ��Ŀ����
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class main23 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * ���ö���ʵ�ֶ������Ŀ���
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(); // ���д����ҷ������Ľڵ㣬ά������
        queue.add(root);

        if (root != null) {
            while (!queue.isEmpty()) {
                TreeNode node = queue.peek();
                ans.add(node.val); // �����׽ڵ��ֵ����arrayList

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                queue.poll(); // ɾ�����׽ڵ�
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(PrintFromTopToBottom(root));
    }
}
