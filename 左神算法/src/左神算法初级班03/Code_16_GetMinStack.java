package �����㷨������03;

import java.util.Stack;

public class Code_16_GetMinStack {
    public static class MyStack {
        private Stack<Integer> stackData; // Dataջ����ѹջ
        // ���minջΪ����ֱ�ӽ�Dataջ��������ѹջ�������Ϊ�գ�minջ����Dataջÿ�ν����������Ƚϡ�
        // ��minջ������С��Dataջ�ս���������minջ���Լ�ջ������ѹ��minջ������minջ��Dataջ�ս�������ѹ���Լ�ջ��
        // Ŀ�ģ�minջ����Զ�������Dataջ����С��Ԫ��
        private Stack<Integer> stackMin;

        // ��ʼ������ջ
        public MyStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }
        // ��
        public void push(int newNum) {
            // minջѹջ˼·
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getmin()) {
                this.stackMin.push(newNum);
            }
            // Dataջ����ѹջ
            this.stackData.push(newNum);
        }
        // ȡ��ȡ��Dataջ����С��
        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }
        // �õ�minջ������
        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack stack1 = new MyStack();
        stack1.push(3);
        System.out.println(stack1.getmin());
        stack1.push(4);
        System.out.println(stack1.getmin());
        stack1.push(1);
        System.out.println(stack1.getmin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getmin());
    }
}
