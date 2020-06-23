import java.util.Stack;

/**
 * @Description: //TODO �̶�����ʵ��ջ������
 *                           ʵ��һ������getMin��ջ
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/10 11:26
 */
public class Code_06_ArrayToStackQueue {

    /**
     * @Description //TODO ����ʵ��ջ
     * @Author ZX
     * @Date 11:31 2020/6/10
     **/
    public static class arrayToStack {

        private int index; // ��ǰλ��
        private int[] arr;

        // ��ʼ��ջ
        public arrayToStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("stack init is empty!");
            }

            arr = new int[initSize];
            index = 0;
        }

        // ȡ��ջ��Ԫ��
        private int peek() {
            if (index == 0) {
                throw new IllegalArgumentException("stack is empty!");
            }
            return arr[index - 1];
        }

        // ����ջ��Ԫ��
        private int pop() {
            if (index == 0) {
                throw new IllegalArgumentException("stack is empty!");
            }
            return arr[--index];
        }

        // ���Ԫ��
        private void push(int num) {
            if (index == arr.length) {
                throw new IllegalArgumentException("stack is full!");
            }
            arr[index++] = num;
        }

        private boolean isEmpty() {
            return index == 0;
        }

    }

    /**
     * @Description //TODO ����ʵ�ֶ���
     * @Author ZX
     * @Date 15:18 2020/6/10
     **/
    public static class arrayToQueue {

        private int size; // �����е�ǰԪ�صĸ���
        private int end; // �ս�����Ԫ�طŵ�λ��
        private int start; // ȡ��Ԫ�ص�λ��
        int[] arr;

        public arrayToQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("queue init is empty!");
            }
            arr = new int[initSize];
            size = 0;
            end = 0;
            start = 0;
        }

        // ���Ԫ��
        private void push(int num) {
            if (size == arr.length) {
                throw new IllegalArgumentException("queue is full!");
            }
            arr[end] = num;
            size++;
            end = end == arr.length - 1 ? 0 : end;
        }

        // ����Ԫ��
        private int poll() {
            if (size == 0) {
                throw new IllegalArgumentException("queue is empty!");
            }

            int result = arr[start];
            size--;
            start = start == arr.length - 1 ? 0 : start + 1;

            return result;
        }

    }
    
    /**
     * @Description //TODO ��һ�������ջ����ʵ��ջ�Ļ������ܵĻ����ϣ���ʵ�ַ���ջ����СԪ�صĲ���
     * @Author ZX
     * @Date 17:27 2020/6/10
     * @Param 
     * @return 
     **/
    public static class getMinStack {
        private Stack<Integer> stack1 = new Stack(); // ����ѹջ
        private Stack<Integer> stack2 = new Stack(); // ջ�����Ǵ��stack����Сֵ

        private void push(int num) {
            stack1.push(num);

            if (stack2.isEmpty()) {
                stack2.push(num);
            } else if (stack2.peek() > num) {
                stack2.push(num);
            } else {
                stack2.push(stack2.peek());
            }
        }

        private int pop() {
            if (stack1.isEmpty()) {
                throw new IllegalArgumentException("stack is empty!");
            }

            int popResult = stack1.pop();
            if (popResult == stack2.peek()) {
                stack2.pop();
            }
            return popResult;
        }

        private int peek() {
            if (stack1.isEmpty()) {
                throw new IllegalArgumentException("stack is empty!");
            }

            return stack1.peek();
        }

        private int getMin() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else {
                throw new IllegalArgumentException("stack is empty!");
            }
        }

        private boolean isEmpty() {
            if (stack1.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

    }

    public static void main(String[] args) {

        arrayToStack arrayToStack = new arrayToStack(4);

        arrayToStack.push(1);
        arrayToStack.push(2);
        arrayToStack.push(3);

        while (!arrayToStack.isEmpty()) {
            System.out.print(arrayToStack.pop() + " ");
        }

        System.out.println();
        System.out.println("===================================");

        getMinStack getMinStack = new getMinStack();
        getMinStack.push(1);
        getMinStack.push(2);
        getMinStack.push(3);
        getMinStack.push(4);
        System.out.println("min = " + getMinStack.getMin());
        while (!getMinStack.isEmpty()) {
            System.out.print(getMinStack.pop() + " ");
        }


    }
}
