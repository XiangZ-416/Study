import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: //TODO 1.ջʵ�ֶ���
 * 2.����ʵ��ջ
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/10 20:13
 */
public class Code_07_stackQueue {

    /**
     * @Description //TODO ����ʵ��ջ
     * @Author ZX
     * @Date 20:37 2020/6/10
     **/
    public static class queueToStack {

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> help = new LinkedList<>();

        private void push(int num) {
            queue.add(num);
        }

        private int pop() {
            while (queue.size() != 1) {
                help.add(queue.poll());
            }

            int popResult = queue.poll();
            // ����queue��helpջ������
            swap();
            return popResult;
        }

        private int peek() {
            while (queue.size() != 1) {
                help.add(queue.poll());
            }

            int peekResult = queue.poll(); // ע��˴���poll���ٽ�poll��ȥ��������help���С�ֱ��ʹ��queue.peek()���������õ�help�ᶪ��Ԫ��
            help.add(peekResult);
            swap();
            return peekResult;
        }

        private boolean isEmpty() {
            if (queue.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

        // ����stack��help������
        private void swap() {
            Queue<Integer> exchange = help;
            help = queue;
            queue = exchange;
        }

    }

    /**
     * @Description //TODO ջʵ�ֶ���
     * @Author ZX
     * @Date 21:16 2020/6/10
     **/
    public static class stackToQueue {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();

        private void add(int num) {
            stack.push(num);
        }

        private int poll() {
            while (!stack.isEmpty()) {
                help.push(stack.pop());
            }

            int pollResult = help.pop();

            while (!help.isEmpty()) {
                stack.push(help.pop());
            }
            return pollResult;
        }

        private int peek() {
            while (!stack.isEmpty()) {
                help.push(stack.pop());
            }

            int peekResult = help.peek();

            while (!help.isEmpty()) {
                stack.push(help.pop());
            }
            return peekResult;
        }

        private boolean isEmpty() {
            if (stack.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

    }

    public static void main(String[] args) {

        System.out.println("����ʵ��ջ");

        queueToStack stack = new queueToStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("pop():" + stack.pop());
        System.out.println("peek():" + stack.peek());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println();
        System.out.println("================");
        System.out.println("ջʵ�ֶ���");

        stackToQueue queue = new stackToQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("poll():" + queue.poll());
        System.out.println("peek():" + queue.peek());
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }

    }

}
