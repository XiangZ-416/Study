/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
import java.util.Stack;

public class main21 {
    Stack<Integer> dataStack = new Stack<>(); // 具有getmin功能的栈
    Stack<Integer> helpStack = new Stack<>(); // 辅助栈（辅助栈顶永远存着dataStack中的最小元素）

    // 存
    // 辅助栈顶永远存着data栈已有元素的最小元素
    public void push(int node) {
        dataStack.push(node); // data栈正常压栈

        // 新元素小于等于当前辅助栈顶元素或辅助栈为空时辅助栈压新元素
        if (helpStack.isEmpty() || node <= helpStack.peek()){
            helpStack.push(node);
        }else { // 否则辅助栈压自己当前栈顶元素
            helpStack.push(helpStack.peek());
        }
    }

    // 删除dataStack栈顶元素,一定要同时删除helpData栈顶元素才能保证
    // helpData栈顶是dataStack栈删除栈顶后剩下元素的最小元素，与push的else部分对应
    public void pop() {
        if (!dataStack.isEmpty()){
            dataStack.pop();
        }
        if (!helpStack.isEmpty()){
            helpStack.pop();
        }
    }

    // 返回dataStack栈顶元素
    public int top() {
        return dataStack.peek();
    }

    // 返回dataStack栈中最小元素
    public int min() {
        return helpStack.peek();
    }
}
