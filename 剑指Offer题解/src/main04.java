/**
 *
 */
public class main04 {
    private static int index = 0;
    /**
     * ����ǰ�����н��������з�Ϊ��������������
     * @param pre ǰ������
     * @param tempIn �������е�������
     * @return
     */
    private static TreeNode solve(int[] pre, int[] tempIn) {
        int len1 = 0; // ��ǰ�ڵ���������Ľڵ�ĸ���
        int len2 = 0; // ��ǰ�ڵ���������Ľڵ�ĸ���
        for (int i = 0; i < tempIn.length; i++ ) {
            if (pre[index] == tempIn[i]) {
                break;
            }
            len1++; // �������ڵ�ĸ���++
        }
        len2 = tempIn.length - len1 - 1;

        int index1 = 0;
        int index2 = 0;
        int[] temp1 = new int[len1]; // ��ǰ�ڵ��������
        int[] temp2 = new int[len2]; // ��ǰ�ڵ��������
        boolean flag = false; // ��ʾ��û�ҵ�pre[index] == tempIn[i]
        for (int i = 0; i < tempIn.length; i++) {
            if (pre[index] == tempIn[i]) {
                flag = true;
            } else if (!flag) { // �����û�ҵ�pre[index] == tempIn[i]
                temp1[index1++] = tempIn[i];
            } else { // ��ʾ�Ѿ�����pre[index] == tempIn[i]���ұ�
                temp2[index2++] = tempIn[i];
            }
        }
        TreeNode node = new TreeNode(pre[index]);
        node.left = null;
        node.right = null;
        System.out.printf("%d������:", pre[index]);
        for (int i = 0; i< temp1.length; i++) {
            System.out.printf("%d", temp1[i]);
        }
        System.out.printf(", ");
        System.out.printf("%d������:", pre[index]);
        for (int i = 0; i< temp2.length; i++) {
            System.out.printf("%d", temp2[i]);
        }
        System.out.println();
        // ���εݹ�ĺ���
        if (index < pre.length && temp1.length > 0) { // �����ǰ�ڵ����������
            index++; // ����ǰ�����е��±��1
            node.left = solve(pre, temp1); // ������ǰ�ڵ��������
        }
        if (index < pre.length && temp2.length > 0) { // �����ǰ�ڵ����������
            index++; // ����ǰ�����е��±��1
            node.right = solve(pre, temp2); // ������ǰ�ڵ��������
        }
        return node;
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] mid) {
        index = 0; // ����ǰ�����е��±�
        return solve(pre, mid);
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8}; // ǰ���������
        int[] mid = {4, 7, 2, 1, 5, 3, 8, 6}; // �����������

        TreeNode root = reConstructBinaryTree(pre, mid);

        dfs1(root);
        System.out.println();
        dfs2(root);
        System.out.println();
        dfs3(root);
        System.out.println();
    }

    private static void dfs1(TreeNode node) { // �������
        System.out.printf("%d ", node.val);
        if (node.left != null) {
            dfs1(node.left);
        }
        if (node.right != null) {
            dfs1(node.right);
        }
    }
    private static void dfs3(TreeNode node) { // ��������
        if (node.left != null) {
            dfs3(node.left);
        }
        if (node.right != null) {
            dfs3(node.right);
        }
        System.out.printf("%d ", node.val);
    }
    private static void dfs2(TreeNode node) { // �������
        if (node.left != null) {
            dfs2(node.left);
        }
        System.out.printf("%d ", node.val);
        if (node.right != null) {
            dfs2(node.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}