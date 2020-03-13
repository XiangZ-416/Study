package �����㷨������03;
/**
 * תȦ��ӡ����
 * ���������㣺���Ͻ�t�����½�d
 */
class Code_19_PrintMatrixSpiralOrde {
    // ���Ͻǡ����½�ȷ��һ����������
    // �ı����Ͻǡ����½�������
    public static void printMatrix(int [][] matrix) {
        // ���Ͻ�
        int tr = 0, tc = 0;
        // ���½�
        int dr = matrix.length - 1;
        int dc = matrix[0].length - 1;

        // �����Ͻǵ������½ǵ㲻��ͻʱһֱ˳ʱ���ӡ
        while (tr <= dr && tc <= dc) {
            printMatrix(matrix, tr++, tc++, dr--, dc--);
        }
    }

    public static void printMatrix(int[][] m, int tR, int tC, int dR, int dC) {
        // �����������
        // ��tc = dcʱ,��m��������ʱ
        if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else if (tR == dR) { // ��tr = drʱ,��m��������ʱ
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        }else {
            // ˳ʱ��ֱ��ӡ�ĸ����ϵ�Ԫ��
            int curR = tR, curC = tC; // ��ǰλ��
            while (curC < dC) {
                System.out.print(m[tR][curC++] + " ");
            }
            while (curR < dR) {
                System.out.print(m[curR++][dC] + " ");
            }
            while (curC > tC) {
                System.out.print(m[dR][curC--] + " ");
            }
            while (curR > tR) {
                System.out.print(m[curR--][tC] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3, 4}, {5, 6, 7, 8},
                {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrix(matrix);
    }
}
