package �����㷨������03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Code_17_StackAndQueueConvert {
    public static class TwoStacksQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(int pushInt) {
            stackPush.push(pushInt);
            dao();
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            dao();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            dao();
            return stackPop.peek();
        }

        public void dao() {
            // ����1�����popջ��Ϊ��
            if (!stackPop.isEmpty()) {
                // ���ܵ�
                return;
            }
            // ����2�����popջΪ��,һ�ε���
            while (!stackPop.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }


    public static class TwoQueuesStack {
        private Queue<Integer> Data;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            Data = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int pushInt) {
            Data.add(pushInt);
        }

        public int peek() {
            if (Data.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (Data.size() != 1) {
                help.add(Data.poll());
            }
            int res = Data.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop() {
            if (Data.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            // ֻҪData�����в�ֹһ������Data���н����һ������������Ÿ��û����أ���������浽help����
            while (Data.size() > 1) {
                help.add(Data.poll());
            }
            // ��Data����ʣ�µ������������û�
            int res = Data.poll();
            // �ٽ�helpջԪ�ظ�Dataջ��
            // �������ã�helpջ��Dataջ��Dataջ��helpջ
            swap();

            return res;
        }

        private void swap() {
            Queue<Integer> tmp = help;
            help = Data;
            Data = tmp;
        }

    }
}