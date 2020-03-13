import java.util.ArrayList;
/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某【二叉搜索树】的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 思路：递归
 * 1.划分
 *  按根分出大于根的部分large和小于根的部分small，
 * 2.判断
 *  如果是搜索二叉树的后序遍历，每一个序列都要满足
 * （1）large在small的右边
 * （2）large、small都连续
 */
public class main24 {
    public static boolean solve(ArrayList<Integer> list) {
        if (list.size() == 0 || list.size() == 1) // 遍历完序列中所有元素 || 遍历到叶子节点
            return true;

        ArrayList<Integer> small = new ArrayList<>(); // 存放小于根节点部分
        ArrayList<Integer> large = new ArrayList<>(); // 存放大于根节点部分
        int root = list.get(list.size() - 1); // 根节点
        int firstSmallIndex = -1;
        int firstLargeIndex = -1;

        // 1.划分
        // 将list的元素分为两部分：小于根节点、大于根节点
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < root) {
                if (firstSmallIndex == -1) { // 确定第一个小于根节点值的元素
                    firstSmallIndex = i;
                }
                small.add(list.get(i));
            }else if (list.get(i) > root){
                if (firstLargeIndex == -1) { // 确定第一个大于根节点的元素
                    firstLargeIndex = i;
                }
                large.add(list.get(i));
            }
        }

        // 2.判断
        // 大于和小于部分都不为空
        if (firstSmallIndex != -1 && firstLargeIndex != -1) {
            // 判断小于部分是否在大于部分的左边
            if (firstSmallIndex > firstLargeIndex) {
                return false;
            }
            // 判断大于部分是否连续
            for (int i = firstLargeIndex; i < list.size(); i++) {
                if (list.get(i) < root) {
                    return false;
                }
            }
        }

        return solve(small) && solve(large); // 每一个子序列都需要满足
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        // base case
        if (sequence.length == 0)
            return false;

        // 放到ArrayList中好操作
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < sequence.length; i++) {
            arrayList.add(sequence[i]);
        }

        return solve(arrayList);
    }

    public static void main(String[] args) {
        int[] sequence = {4, 6, 7, 5};
        System.out.println(VerifySquenceOfBST(sequence));
    }
}