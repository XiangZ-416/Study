import java.util.Stack;
/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class main05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // 往stack1里面push
    public void push(int node) {
        // 数据存入stack1
        stack1.push(node);
    }
    // 往stack2里面pop
    public int pop() {
        // 如果stack2为空，将stack1的元素全部移到stack2中
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
