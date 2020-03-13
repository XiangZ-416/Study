import java.util.Stack;
/**
 * ��Ŀ����
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 *��ע�⣺���������еĳ�������ȵģ�
 */
public class main22 {
    /**
     * ˼·��ֽ��д����ͨ�������У��ҳ��������ɡ����ô���ʵ�ֲ�����
     *      ˫ָ�룺1��ջ�������� && ջ��Ԫ����popAԪ�����
     *                      ȡ��ջ��Ԫ�أ���ջ����һ��ջ�����ݣ�pushָ�벻�ö����൱�����ƣ�
     *                      popָ��ͬʱ���ƣ�
     *                ջ��û������
     *                      ��ջ�����ݣ�
     *                      pushָ�����ƣ�
     *             2��pushA��Ԫ���Ѿ�ȫ������ջ�С�
     *                      ջ��Ϊ�� && ջ���뵱ǰpopAλ��Ԫ�������
     *                          ȡ��ջ��Ԫ�أ�
     *                          popָ�����ƣ�
     *                      ����
     *                          false��
     *                true��
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        // ����վ���pushA����Ԫ��
        Stack<Integer> stack = new Stack<>();

        int pushIndex = 0; // pushA�����ָ��
        int popIndex = 0; // popA�����ָ��

        // ���ж�ջ����û�����ݣ����ж�ջ��Ԫ����popAԪ���Ƿ���ȣ�ջ��û��������Ҫ�ȸ�ջ������
        while (pushIndex < pushA.length) {
            if (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }else {
                stack.push(pushA[pushIndex]);
                pushIndex++;
            }
        }
        // ���Ǵ��
        // pushA��Ԫ��û��ȫ������ջ��
//        while (pushIndex < pushA.length) {
//            if (pushA[pushIndex] != popA[popIndex]) {
//                stack.push(pushA[pushIndex]);
//                pushIndex++;
//            }else if (pushA[pushIndex] == popA[popIndex]) {
//                stack.push(pushA[pushIndex]);
//                stack.pop();
//                pushIndex++;
//                popIndex++;
//            }
//        }

        // pushA��Ԫ���Ѿ�ȫ������ջ��
        // �ж�ջ���뵱ǰpopAλ��Ԫ�������
        while ((pushIndex == pushA.length) && (popIndex < popA.length)) {
            if (!stack.isEmpty() && (stack.peek() == popA[popIndex])) {
                stack.pop();
                popIndex++;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {2, 1, 0};
        int[] popA1 = {1, 2, 0};
        int[] popA2 = {4,3,5,1,2};

        System.out.println(IsPopOrder(pushA, popA1));
        System.out.println(IsPopOrder(pushA, popA2));
    }
}
