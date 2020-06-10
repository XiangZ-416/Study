import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: //TODO 1.栈实现队列
 *                           2.队列实现栈
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/10 20:13
 */
public class Code_07_stackQueue {

    /**
     * @Description //TODO 队列实现栈
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
            if (queue.size() != 0) {
                while (queue.size() != 1) {
                    help.add(queue.poll());
                }
            }

            Integer popResult = queue.poll();

            while (help.size() != 0) {
                queue.add(help.poll());
            }

            return popResult;
        }

        private boolean isEmpty() {
            if (queue.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

    }

    /**
     * @Description //TODO 栈实现队列
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

            }

            return 1;
        }

    }
    public static void main(String[] args) {

        queueToStack stack = new queueToStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println();
        System.out.println("================");

    }

}
