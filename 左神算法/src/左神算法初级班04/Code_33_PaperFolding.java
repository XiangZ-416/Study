package 左神算法初级班04;

public class Code_33_PaperFolding {
    /**
     * 主函数
     * @param N 折纸次数（二叉树的总层数）
     */
    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    /**
     * 打印折痕方向
     * @param i 递归到第i层
     * @param N 折纸次数（二叉树的总层数）
     * @param down 根节点
     * 递归方式遍历树：每个节点都遍历3次，第二次遇到时打印即中序遍历
     */
    public static void printProcess(int i, int N, boolean down) {
        if (i > N) { // 递归到最后一层之后停止
            return;
        }
        printProcess(i + 1, N, true); // 左节点
        System.out.println(down ? "down " : "up ");
        printProcess(i + 1, N, false); // 右节点
    }

    public static void main(String[] args) {
        int N = 2;
        printAllFolds(N);
    }
}
