package 左神算法进阶班;

import java.util.LinkedList;

/**
 * @Description: //TODO 计算字符串表示的公式的值
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/2 14:53
 */
public class Code_10_getValue {

    public static int getValue(String str) {
        return value(str.toCharArray(), 0)[0];
    }

    // 递归函数
    // 返回值为数组，长度一定为2
    // bra[0]代表计算结果
    // bra[1]代表计算到的位置
    private static int[] value(char[] str, int i) {
        LinkedList<String> que = new LinkedList<>(); // 收集遇到的字符串
        int pre = 0;
        int[] bra = null; // bra[0]：括号中的计算结果；bra[1]代表计算到的位置
        while (i < str.length && str[i] != ')') {
            if (str[i] >= '0' && str[i] < '9') { // 如果一直遇到的数字，收集数字
                pre = pre * 10 + str[i++] - '0';
            } else if (str[i] != '(') { // 遇到了 + - * /
                addNum(que, pre);
                que.addLast(String.valueOf(str[i++]));
                pre = 0;
            } else { // i位置是 ‘（’，从i + 1位置递归
                bra = value(str, i + 1);
                pre = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(que, pre);
        return new int[] { getNum(que), i};
    }

    private static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("+") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    private static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }

}
