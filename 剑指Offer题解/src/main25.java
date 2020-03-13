import java.util.ArrayList;
/**
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class main25 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * 思路：深度优先遍历+权值累加+回溯+排序
     * @param root
     * @param target
     * @return
     */
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // 存放各个权值和等于target的路径
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> list = new ArrayList<>(); // 存放经过的节点
        // 1.找到所有等于target的路径：深度优先遍历+权值累加+回溯
        sovle(root, target, 0, list);

        // 2.给ans中存放的各个路径按长度从大到小排序
        Sort(ans);

        return ans;
    }
    /**
     * 选择排序
     * @param ans
     */
    private void Sort(ArrayList<ArrayList<Integer>> ans) {
        for (int i = 0; i < ans.size(); i++) {
            int maxIndex = i; // 假设i处为最大元素
            for (int j = maxIndex + 1; j < ans.size(); j++) {
                if (ans.get(j).size() > ans.get(maxIndex).size()) {
                    // 更新maxIndex
                    maxIndex = j;
                    // 交换maxIndex处元素和i处元素

                }
            }
            if (i != maxIndex) { // 最大值位置不是i位置，交换i和maxIndex
                ArrayList<Integer> help = ans.get(i);
                ans.set(i, ans.get(maxIndex));
                ans.set(maxIndex, help);
            }
        }
    }
    /**
     * 深度优先遍历+权值累加+回溯
     * 寻找权值等于target的路径
     * @param node 当前节点
     * @param target 目标权值
     * @param pathSum 当前路径和
     * @param list 当前路径
     */
    private void sovle(TreeNode node, int target, int pathSum, ArrayList<Integer> list) {
        // base case
        if (node == null)
            return;

        pathSum += node.val;
        list.add(node.val);

        if (node.left == null && node.right == null && pathSum == target) { // 如果node是叶子节点且当前路径和等于target
            // 将当前路径列表复制到res中，因为java中链表、图都是用引用来操作，后续改list，会破坏当前存放的路径
            ArrayList<Integer> res = new ArrayList<>(list);
            ans.add(res); // 将当前等于target的路径存到ans中
        }else { // node不是叶子节点
            sovle(node.left, target, pathSum, list);
            sovle(node.right, target, pathSum, list);
        }
        list.remove(list.size() - 1); // 回溯删掉当前节点
    }
}