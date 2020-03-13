package �����㷨������04;

public class Code_33_PaperFolding {
    /**
     * ������
     * @param N ��ֽ���������������ܲ�����
     */
    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    /**
     * ��ӡ�ۺ۷���
     * @param i �ݹ鵽��i��
     * @param N ��ֽ���������������ܲ�����
     * @param down ���ڵ�
     * �ݹ鷽ʽ��������ÿ���ڵ㶼����3�Σ��ڶ�������ʱ��ӡ���������
     */
    public static void printProcess(int i, int N, boolean down) {
        if (i > N) { // �ݹ鵽���һ��֮��ֹͣ
            return;
        }
        printProcess(i + 1, N, true); // ��ڵ�
        System.out.println(down ? "down " : "up ");
        printProcess(i + 1, N, false); // �ҽڵ�
    }

    public static void main(String[] args) {
        int N = 2;
        printAllFolds(N);
    }
}
