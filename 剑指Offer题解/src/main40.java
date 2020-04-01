/**
 * @Description: //TODO ����һ�ö��������жϸö������Ƿ���ƽ���������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/26 16:05
 */
public class main40 {
    // ����ÿ���ڵ���Ҫ�õ��ýڵ����Ϣ���ýڵ��Ƿ�ƽ�⡢�ýڵ�ĸ߶�
    public static class returnData {
        boolean isAVL;
        int height;

        public returnData(boolean isAVL, int height) {
            this.isAVL = isAVL;
            this.height = height;
        }
    }

    /**
     * @Author ZX
     * @Description //TODO �ݹ��ȡ��nodeΪ���ڵ�����Ƿ�Ϊ�������������ĸ߶�(0Ϊ��׼)
     * @Date 16:10 2020/3/27
     * @Param [node]
     * @return main40.returnData
     **/
    protected static returnData Process(TreeNode node) {
        //base case
        if (node == null)
            return new returnData(true, 0); // ������������

        returnData leftData = Process(node.left); // ������ǰ�ڵ��������
        leftData.height++; // �������߶�+1
        returnData rightData = Process(node.right); // ������ǰ�ڵ��������
        rightData.height++;  // �������߶�+1

        if (leftData.isAVL && rightData.isAVL && Math.abs(leftData.height - rightData.height) < 2) // ƽ�����������
            return new returnData(true, Math.max(leftData.height, rightData.height)); // �Խڵ�nodeΪ���ڵ������ƽ����������߶�Ϊ���������������߶ȵĽϴ�ֵ�����߶ȵĶ��壩

        return new returnData(false, 0); // �Խڵ�nodeΪ���ڵ��������ƽ����������߶���Ϣû��
    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        // base case
        if (root == null)
            return true;

        returnData leftReturnData = Process(root.left); // ������ǰ�ڵ��������
        returnData rightReturnData = Process(root.right); // ������ǰ�ڵ��������

        return leftReturnData.isAVL && rightReturnData.isAVL && Math.abs(leftReturnData.height - rightReturnData.height) < 2; // ƽ�����������
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println(IsBalanced_Solution(root));
    }
}
