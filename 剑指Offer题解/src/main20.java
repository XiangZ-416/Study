import java.util.ArrayList;

/**
 * ��Ŀ����
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ������
 * ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 *      �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class main20 {
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    /**
     * ����1�����Ͻǡ����½�ȷ��һ���������򣻸ı����Ͻǡ����½�������
     *         ��ӡʱ�������������������������������һ�����
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix1(int [][] matrix) {
        // base case
        if (matrix == null)
            return null;

        // ���Ͻ�
        int tr = 0, tc = 0;
        // ���½�
        int dr = matrix.length - 1;
        int dc = matrix[0].length - 1;

        // ��arrayList�е�Ԫ�ظ���С�ھ����е�Ԫ�ظ���ʱѭ����ӡ
        while (arrayList.size() < (matrix.length * matrix[0].length)) {
            printMatrix(matrix, tr++, tc++, dr--, dc--);
        }

        return arrayList;
    }

    public static void printMatrix(int[][] m, int tR, int tC, int dR, int dC) {
        // base case
        // m��������
        if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                arrayList.add(m[i][tC]);
            }
        } else if (tR == dR) { // m��������
            for (int i = tC; i <= dC; i++) {
                arrayList.add(m[tR][i]);
            }
        }else { // m��һ�����
            int curR = tR, curC = tC; // ��ǰλ��
            // ˳ʱ��ֱ��ӡ�ĸ����ϵ�Ԫ��
            while (curC < dC) {
                arrayList.add(m[tR][curC++]);
            }
            while (curR < dR) {
                arrayList.add(m[curR++][dC]);
            }
            while (curC > tC) {
                arrayList.add(m[dR][curC--]);
            }
            while (curR > tR) {
                arrayList.add(m[curR--][tC]);
            }
        }
    }

    /**
     * ����2�������ж�ÿһ��Ԫ�ء����ж��Ƿ�Խ�硢�Ƿ��Ѿ�����������Ӧ��flag�Ƕ���
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix2(int [][] matrix) {
        // base case
        if (matrix == null)
            return null;

        ArrayList<Integer> arrayList = new ArrayList<>();
        int flag = 1; // 1 -> right, 2 -> down, 3 -> left, 4 -> up

        int x = 0, y = 0; // ��ʼλ�õ��С���
        boolean[][] m = new boolean[matrix.length][matrix[0].length]; // ������Ԫ�ر���Ƿ��Ѿ���ǹ�

        // arrayList��Ԫ�صĸ���С��ԭ������Ԫ�صĸ���ʱһֱѭ�����������е�ÿһ��Ԫ��
        while (arrayList.size() < (matrix.length * matrix[0].length)) {
            // Խ���Ĵ���
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || m[x][y]) {
                // �����ĸ����㴦Խ��Ĵ���
                if (flag == 1) {
                    x++;
                    y--;
                    flag = 2;
                }else if (flag == 2) {
                    x--;
                    y--;
                    flag = 3;
                }else if (flag == 3) {
                    x--;
                    y++;
                    flag = 4;
                }else if (flag == 4) {
                    x++;
                    y++;
                    flag = 1;
                }
            }else { // ûԽ��ʹ浽arrayList��
                arrayList.add(matrix[x][y]);
                m[x][y] = true; // ��Ǹ�Ԫ���Ѿ�������

                // ˳ʱ�����
                if (flag == 1) {
                    y++;
                }else if (flag == 2) {
                    x++;
                }else if (flag == 3) {
                    y--;
                }else if (flag == 4) {
                    x--;
                }
            }
        }

        return arrayList;
    }

    public static void main(String[] args) {
        int[][] matrix = { {1, 2}, {3, 4}};
        System.out.println("����1��" + printMatrix1(matrix));

        System.out.println("����2��" + printMatrix2(matrix));
    }
}