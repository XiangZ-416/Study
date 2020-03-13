package �����㷨������07;

public class Code_52_Hanoi {
    /**
     * �ƶ�����
     * @param N N��Բ��
     * @param Start ����
     * @param End �յ��
     * @param Help ������
     */
    public static void Move(int N, String Start, String End, String Help) {
        if (N == 1) {
            System.out.println(" Move 1 From " + Start + " to " + End  );
        }else {
            Move( N - 1, Start, Help, End); // ��ʣ�µ�N - 1��Բ�̽����յ�˴������Ƶ���������
            System.out.println(" Move " +  N + " From " + Start + " to " + End);
            Move(N - 1, Help, End, Start); // �ٽ�ʣ�µ�N - 1��Բ�̽������˴Ӹ������Ƶ��յ��
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Move(n, "��", "��", "��" );
    }
}