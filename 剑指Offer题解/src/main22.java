import java.util.Stack;
/**
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *（注意：这两个序列的长度是相等的）
 */
public class main22 {
    /**
     * 思路：纸上写出能通过的序列，找出操作规律。再用代码实现操作。
     *      双指针：1、栈中有数据 && 栈顶元素与popA元素相等
     *                      取出栈顶元素；（栈中少一个栈顶数据，push指针不用动，相当于右移）
     *                      pop指针同时右移；
     *                栈中没有数据
     *                      给栈加数据；
     *                      push指针右移；
     *             2、pushA中元素已经全部存入栈中。
     *                      栈不为空 && 栈顶与当前popA位置元素是相等
     *                          取出栈顶元素；
     *                          pop指针右移；
     *                      否则
     *                          false；
     *                true；
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        // 定义站存放pushA数组元素
        Stack<Integer> stack = new Stack<>();

        int pushIndex = 0; // pushA数组的指针
        int popIndex = 0; // popA数组的指针

        // 先判断栈中有没有数据，再判断栈顶元素与popA元素是否相等；栈中没有数据需要先给栈加数据
        while (pushIndex < pushA.length) {
            if (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }else {
                stack.push(pushA[pushIndex]);
                pushIndex++;
            }
        }
        // 这是错的
        // pushA中元素没有全部存入栈中
//        while (pushIndex < pushA.length) {
//            if (pushA[pushIndex] != popA[popIndex]) {
//                stack.push(pushA[pushIndex]);
//                pushIndex++;
//            }else if (pushA[pushIndex] == popA[popIndex]) {
//                stack.push(pushA[pushIndex]);
//                stack.pop();
//                pushIndex++;
//                popIndex++;
//            }
//        }

        // pushA中元素已经全部存入栈中
        // 判断栈顶与当前popA位置元素是相等
        while ((pushIndex == pushA.length) && (popIndex < popA.length)) {
            if (!stack.isEmpty() && (stack.peek() == popA[popIndex])) {
                stack.pop();
                popIndex++;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {2, 1, 0};
        int[] popA1 = {1, 2, 0};
        int[] popA2 = {4,3,5,1,2};

        System.out.println(IsPopOrder(pushA, popA1));
        System.out.println(IsPopOrder(pushA, popA2));
    }
}
