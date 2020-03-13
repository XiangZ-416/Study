import java.util.Stack;
/**
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 */
public class main05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // ��stack1����push
    public void push(int node) {
        // ���ݴ���stack1
        stack1.push(node);
    }
    // ��stack2����pop
    public int pop() {
        // ���stack2Ϊ�գ���stack1��Ԫ��ȫ���Ƶ�stack2��
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        int num = stack2.pop();
        return num;
    }

    public static void main(String[] args) {
        main05 queue = new main05();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.pop());
        System.out.println(queue.pop());

        queue.push(8);
        System.out.println(queue.pop());
    }
}
