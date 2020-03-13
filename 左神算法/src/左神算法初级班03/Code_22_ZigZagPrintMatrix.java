package �����㷨������03;

public class Code_22_ZigZagPrintMatrix {
    /**
     * ����ĵ����߼�
     * @param matrix
     */
    public static void printMatrixZigZag(int[][] matrix) {
        // A����кź��к�
        int aR = 0;
        int aC = 0;
        // B����кź��к�
        int bR = 0;
        int bC = 0;
        // ��ֹλ��
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        // ȡ�������ͱ�Ǵ��ϻ��Ǵ��´�ӡ
        boolean fromUp = false;
        // ���A�������һ�У���A,B�г̽���������дB�������һ�У���A,B�г̽�����
        while (aR != endR + 1) {
            printLevel(matrix, aR, aC, bR, bC, fromUp);
            aR = aC == endC ? aR + 1 : aR; // A���У����A�������������һ�У�A����+1������A���в���
            aC = aC == endC ? aC : aC + 1; // A���У����A���е������һ�У�A���в��䣬����A����+1
            bC = bR == endR ? bC + 1 : bC; // B���У����B���е������һ�У�B����+1������B���в���
            bR = bR == endR ? bR : bR + 1; // B���У����B���е������һ�У�B���в��䣬����B����+1
            fromUp = !fromUp; // ��һ�δ��ϵ��£���һ�ξ�Ҫ���µ���
        }
        System.out.println();
    }

    /**
     * ���Խ����ϵ�Ԫ�ش�ӡ
     * @param m �������
     * @param aR A������
     * @param aC A������
     * @param bR B������
     * @param bC B������
     * @param f ���ϵ��´��Ǵ��µ��ϴ�ӡ
     */
    public static void printLevel(int[][] m, int aR, int aC, int bR, int bC, boolean f) {
        if (f) {
            while (aR != bR + 1) {
                System.out.print(m[aR++][aC--] + " ");
            }
        } else {
            while (bR != aR - 1) {
                System.out.print(m[bR--][bC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);

    }
}
