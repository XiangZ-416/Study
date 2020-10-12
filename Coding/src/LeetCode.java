import java.util.LinkedList;
import java.util.List;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/18 11:17
 */
public class LeetCode {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 二叉树的层序遍历
    // 示例：
    //二叉树：[3,9,20,null,null,15,7],
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回其层次遍历结果：
    //[
    //  [3],
    //  [9,20],
    //  [15,7]
    //]
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }
            List<List<Integer>> res = new LinkedList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                List<Integer> ans = new LinkedList<>();
                while(count > 0) {
                    TreeNode curNode = queue.poll();
                    ans.add(curNode.val);
                    if (curNode.left != null) {
                        queue.add(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.add(curNode.right);
                    }
                    count--;
                }
                res.add(ans);
            }
            return res;
        }
    }

}
