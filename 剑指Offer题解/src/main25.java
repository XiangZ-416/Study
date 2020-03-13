import java.util.ArrayList;
/**
 * ��Ŀ����
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * (ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
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
     * ˼·��������ȱ���+Ȩֵ�ۼ�+����+����
     * @param root
     * @param target
     * @return
     */
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // ��Ÿ���Ȩֵ�͵���target��·��
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> list = new ArrayList<>(); // ��ž����Ľڵ�
        // 1.�ҵ����е���target��·����������ȱ���+Ȩֵ�ۼ�+����
        sovle(root, target, 0, list);

        // 2.��ans�д�ŵĸ���·�������ȴӴ�С����
        Sort(ans);

        return ans;
    }
    /**
     * ѡ������
     * @param ans
     */
    private void Sort(ArrayList<ArrayList<Integer>> ans) {
        for (int i = 0; i < ans.size(); i++) {
            int maxIndex = i; // ����i��Ϊ���Ԫ��
            for (int j = maxIndex + 1; j < ans.size(); j++) {
                if (ans.get(j).size() > ans.get(maxIndex).size()) {
                    // ����maxIndex
                    maxIndex = j;
                    // ����maxIndex��Ԫ�غ�i��Ԫ��

                }
            }
            if (i != maxIndex) { // ���ֵλ�ò���iλ�ã�����i��maxIndex
                ArrayList<Integer> help = ans.get(i);
                ans.set(i, ans.get(maxIndex));
                ans.set(maxIndex, help);
            }
        }
    }
    /**
     * ������ȱ���+Ȩֵ�ۼ�+����
     * Ѱ��Ȩֵ����target��·��
     * @param node ��ǰ�ڵ�
     * @param target Ŀ��Ȩֵ
     * @param pathSum ��ǰ·����
     * @param list ��ǰ·��
     */
    private void sovle(TreeNode node, int target, int pathSum, ArrayList<Integer> list) {
        // base case
        if (node == null)
            return;

        pathSum += node.val;
        list.add(node.val);

        if (node.left == null && node.right == null && pathSum == target) { // ���node��Ҷ�ӽڵ��ҵ�ǰ·���͵���target
            // ����ǰ·���б��Ƶ�res�У���Ϊjava������ͼ������������������������list�����ƻ���ǰ��ŵ�·��
            ArrayList<Integer> res = new ArrayList<>(list);
            ans.add(res); // ����ǰ����target��·���浽ans��
        }else { // node����Ҷ�ӽڵ�
            sovle(node.left, target, pathSum, list);
            sovle(node.right, target, pathSum, list);
        }
        list.remove(list.size() - 1); // ����ɾ����ǰ�ڵ�
    }
}