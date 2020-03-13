package �����㷨������07;

public class Code_56_MinPath {
    public static int minPath1(int[][] matrix) {
        return process1(matrix, matrix.length - 1, matrix[0].length - 1);
    }
    /**
     * ����1�������ݹ飺�ұ߽硢�±߽硢��ͨλ��
     * ʱ�临�ӶȺܸߣ��д������ظ�����
     * @param matrix
     * @param i ��ǰ��
     * @param j ��ǰ��
     * @return ���·����
     */
    public static int process1(int[][] matrix, int i, int j) {
        // �Ѿ��������½�
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        // �������һ�У�ֻ��������
        // �ݹ�˼·�����ڵ�ǰλ�õ��ұ�λ�õ������½ǵ���̾��� + ��ǰλ�õ���ֵ
        if (i == matrix.length - 1) {
            return matrix[i][j] + process1(matrix, i , j + 1);
        }
        // �������һ��,ֻ��������
        // �ݹ�˼·�����ڵ�ǰλ�õ����·�λ�õ������½ǵ���̾��� + ��ǰλ�õ���ֵ
        if (j == matrix.length - 1) {
            return matrix[i][j] + process1(matrix, i + 1, j);
        }
        // �ձ���������������ߣ�Ҳ����������
        // �����ߣ��ݹ�˼·�����ڵ�ǰλ�õ��ұ�λ�õ������½ǵ���̾��� + ��ǰλ�õ���ֵ
        // �����ߣ��ݹ�˼·�����ڵ�ǰλ�õ����·�λ�õ������½ǵ���̾��� + ��ǰλ�õ���ֵ
        int right = process1(matrix, i, j + 1); // right���ұ�λ�õ����½ǵ����·����
        int down = process1(matrix, i + 1, j);  // down���±�λ�õ����½ǵ����·����
        // ѡ���¡��ҽ�С���ټ��ϵ�ǰλ�õ�ֵ
        return matrix[i][j] + Math.min(right, down);
    }
    /**
     * ����2����̬�滮
     * �����ݹ�Ķ�̬�滮
     * �����仯�������������ݹ��ظ���������ݻ��棬�´μ���ʱ���������Ƿ����������������map�ѽ��ȡ����
     * @param m
     * @return ���·����
     */
    public static int minPath2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }
}
