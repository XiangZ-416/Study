import java.util.Scanner;

/**
 * @Description: //TODO ����˳ʱ���ӡ���顣
 *                           ��M��N�У����Ͻ�Ϊ[0,0],���½�Ϊ[M-1,N-1]�������Ͻǿ�ʼ��������һ����Ϊ1��˳ʱ������Ȧ��ʼ��
 *                           ��Ȧ���������Ȧ���ż���������������λ��7��ʮλΪ����ʱ����ӡ����λ�����꣬����[1,2],[3,4]��
 *                           ���������еĽ������ʽΪ��[[1,2],[3,4],[5,6]]��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/20 10:14
 */
public class main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        int startX = 0; // ���x
        int startY = 0; // ���y
        int endX = matrix.length - 1; // �յ�x
        int endY = matrix[0].length - 1; // �յ�y
        int count = 0;
        System.out.print("[");
        while (startX <= endX && startY <= endY) {
            if (startX == endX) { // matrix����Ϊ���о���
                for (int i = startY; i <= endY; i++) {
                    count++;
                    if (count % 10 == 7 && (count / 10) % 2 == 1) {
                        if (count == 17) {
                            System.out.print("[" +  startX + "," + i + "]");
                        } else  {
                            System.out.print(",[" +  startX + "," + i + "]");
                        }
                    }
                }
            } else if (startY == endY) { // // matrix����Ϊ���о���
                for (int i = startX; i <= endX; i++) {
                    count++;
                    if (count % 10 == 7 && (count / 10) % 2 == 1) {
                        if (count == 17) {
                            System.out.print("[" +  i + "," + startY + "]");
                        } else  {
                            System.out.print(",[" +  i + "," + startY + "]");
                        }
                    }
                }
            } else {
                for (int i = startY; i < endY; i++) { // ���Ͻ� -> ���Ͻ�
                    count++;
                    if (count % 10 == 7 && (count / 10) % 2 == 1) {
                        if (count == 17) {
                            System.out.print("[" +  startX + "," + i + "]");
                        } else  {
                            System.out.print(",[" +  startX + "," + i + "]");
                        }
                    }
                }
                for (int i = startX; i < endX; i++) { // ���Ͻ� -> ���½�
                    count++;
                    if (count % 10 == 7 && (count / 10) % 2 == 1) {
                        if (count == 17) {
                            System.out.print("[" +  i + "," + endY + "]");
                        } else  {
                            System.out.print(",[" +  i + "," + endY + "]");
                        }
                    }
                }
                for (int i = endY; i > startY; i--) { // ���½� -> ���½�
                    count++;
                    if (count % 10 == 7 && (count / 10) % 2 == 1) {
                        if (count == 17) {
                            System.out.print("[" +  endX + "," + i + "]");
                        } else  {
                            System.out.print(",[" +  endX + "," + i + "]");
                        }
                    }
                }
                for (int i = endX; i > startX; i--) { // ���½� -> ���Ͻ�
                    count++;
                    if (count % 10 == 7 && (count / 10) % 2 == 1) {
                        if (count == 17) {
                            System.out.print("[" +  i + "," + startY + "]");
                        } else  {
                            System.out.print(",[" +  i + "," + startY + "]");
                        }
                    }
                }
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
        System.out.print("]");
    }
}
