/**
 * ��Ŀ����
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
 * �����������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 */
public class main08 {
    /**
     * ����1������
     * @param target
     * @return
     */
    public static int JumpFloor1(int target) {
        if (target  == 1) {
            return 1;
        }
        int[] arr = new int[target];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < target; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr[target - 1];
    }

    /**
     * ����2��β�ݹ�
     * @param target
     * @return
     */
    public static int JumpFloor2(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor2(target - 2) + JumpFloor2(target - 1);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor1(3));
        System.out.println("--");
        System.out.println(JumpFloor2(3));
    }
}
