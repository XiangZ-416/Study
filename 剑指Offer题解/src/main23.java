/**
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
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
     * 利用队列实现二叉树的宽搜
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(); // 逐行从左到右放入树的节点，维护宽搜
        queue.add(root);

        if (root != null) {
            while (!queue.isEmpty()) {
                TreeNode node = queue.peek();
                ans.add(node.val); // 将队首节点的值放入arrayList

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                queue.poll(); // 删除队首节点
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
