package 左神算法初级班03;

import java.util.Stack;

public class Code_16_GetMinStack {
    public static class MyStack {
        private Stack<Integer> stackData; // Data栈正常压栈
        // 如果min栈为空则直接将Data栈进来的数压栈，如果不为空，min栈顶与Data栈每次进来的数作比较。
        // 若min栈顶的数小与Data栈刚进来的数，min栈将自己栈顶的数压到min栈，否则min栈将Data栈刚进来的数压至自己栈。
        // 目的：min栈顶永远保存的是Data栈中最小的元素
        private Stack<Integer> stackMin;

        // 初始化两个栈
        public MyStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }
        // 存
        public void push(int newNum) {
            // min栈压栈思路
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getmin()) {
                this.stackMin.push(newNum);
            }
            // Data栈正常压栈
            this.stackData.push(newNum);
        }
        // 取及取出Data栈中最小数
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
        // 得到min栈顶数据
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
