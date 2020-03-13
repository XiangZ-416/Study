package �����㷨������05;

public class Code_41_Islands {
    /**
     * ������
     * @param m ����m
     * @return ����m�е��ĸ���
     */
    public static int countIslands(int[][] m) {
        // base case
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length; // ��
        int M = m[0].length; // ��
        int res = 0; // ���ĸ���
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) { // ����1
                    res++; // ���ĸ�����1
                    infect(m, i, j, N, M); // �����Ⱦ����
                }
            }
        }
        return res;
    }

    /**
     * ��Ⱦ����
     * @param m ����m
     * @param i ��ǰ��
     * @param j ��ǰ��
     * @param N ������
     * @param M ������
     */
    public static void infect(int[][] m, int i, int j, int N, int M) {
        // �ݹ���ֹ������Խ�� �� ��ǰԪ�ز�Ϊ1��ֹͣ��Ⱦ
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2; // ��ǰλ�ñ���Ⱦ��2
        infect(m, i + 1, j, N, M); // ��Ⱦm[i][j]����
        infect(m, i - 1, j, N, M); // ��Ⱦm[i][j]����
        infect(m, i, j + 1, N, M); // ��Ⱦm[i][j]����
        infect(m, i, j - 1, N, M); // ��Ⱦm[i][j]����
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                          { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                          { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                          { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
                       };
        System.out.println(countIslands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                          { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                          { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                          { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                          { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
                       };
        System.out.println(countIslands(m2));
    }
}
