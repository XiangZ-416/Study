package 左神算法初级班03;

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
            // 限制1：如果pop栈不为空
            if (!stackPop.isEmpty()) {
                // 不能倒
                return;
            }
            // 限制2：如果pop栈为空,一次倒完
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
            // 只要Data队列中不止一个数，Data队列将最后一个进入的数留着给用户返回，其余的数存到help队列
            while (Data.size() > 1) {
                help.add(Data.poll());
            }
            // 将Data队列剩下的数弹出来给用户
            int res = Data.poll();
            // 再将help栈元素给Data栈，
            // 即改引用：help栈变Data栈，Data栈变help栈
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