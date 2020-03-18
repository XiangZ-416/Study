import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
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
     * 方法1：1.将搜索二叉树中序遍历的所有节点存入队列
     *       2.改变队列中所有节点的索引，形成双向链表
     * 时间复杂度：O(N)
     * 额外空间复杂度：O(N)
     */
    Queue<TreeNode> queue = new LinkedList<>();
    public TreeNode Convert1(TreeNode pRootOfTree) {
        // base case
        if (pRootOfTree == null)
            return null;

        // 1.先将中序遍历二叉树的所、有节点存到队列中
        midPrint(pRootOfTree);

        // 2.改变各个节点的指针域为双向链表
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

    // 二叉树的中序遍历
    public void midPrint(TreeNode root) {
        if (root == null)
            return;
        midPrint(root.left);
        queue.add(root);
        midPrint(root.right);
    }

    /**
     * 方法2：递归
     * 实现递归函数Process
     *      1.输入参数是头节点X
     *      2.功能是将以X为头节点的搜索二叉树转换为一个有序的双向链表
     *      3.返回值是这个有序双向链表的头节点和尾节点
     * 将头节点X的左孩子、右孩子进行Process；
     * 最后通过X把左右形成的双向链表连接起来。(即与中序遍历一样)
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert2(TreeNode pRootOfTree) {
        // base case
        if (pRootOfTree == null)
            return null;

        return Process(pRootOfTree).start;
    }

    // 定义递归函数返回值类型
    public class returnType{
        TreeNode start;
        TreeNode end;

        public returnType(TreeNode head, TreeNode end) {
            this.start = head;
            this.end = end;
        }
    }

    /**
     * 递归函数Process
     *      1.输入参数是头节点
     *      2.功能是将以root为头节点的搜索二叉树转换为一个有序的双向链表
     * @param root 头节点
     * @return 返回值是这个有序双向链表的头节点和尾节点
     */
    public returnType Process(TreeNode root) {
        // base case
        if (root == null)
            return new returnType(null, null);

        // 递归
        returnType leftList = Process(root.left);
        returnType rightList = Process(root.right);

        // 连接
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
