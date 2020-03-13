/**
 * ��Ŀ����
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������
 * ע�⣺��֤�����в��ᵱջΪ�յ�ʱ�򣬶�ջ����pop()����min()����top()������
 */
import java.util.Stack;

public class main21 {
    Stack<Integer> dataStack = new Stack<>(); // ����getmin���ܵ�ջ
    Stack<Integer> helpStack = new Stack<>(); // ����ջ������ջ����Զ����dataStack�е���СԪ�أ�

    // ��
    // ����ջ����Զ����dataջ����Ԫ�ص���СԪ��
    public void push(int node) {
        dataStack.push(node); // dataջ����ѹջ

        // ��Ԫ��С�ڵ��ڵ�ǰ����ջ��Ԫ�ػ���ջΪ��ʱ����ջѹ��Ԫ��
        if (helpStack.isEmpty() || node <= helpStack.peek()){
            helpStack.push(node);
        }else { // ������ջѹ�Լ���ǰջ��Ԫ��
            helpStack.push(helpStack.peek());
        }
    }

    // ɾ��dataStackջ��Ԫ��,һ��Ҫͬʱɾ��helpDataջ��Ԫ�ز��ܱ�֤
    // helpDataջ����dataStackջɾ��ջ����ʣ��Ԫ�ص���СԪ�أ���push��else���ֶ�Ӧ
    public void pop() {
        if (!dataStack.isEmpty()){
            dataStack.pop();
        }
        if (!helpStack.isEmpty()){
            helpStack.pop();
        }
    }

    // ����dataStackջ��Ԫ��
    public int top() {
        return dataStack.peek();
    }

    // ����dataStackջ����СԪ��
    public int min() {
        return helpStack.peek();
    }
}
