import java.util.*;

/**
 * @Description: //TODO 剑指Offer
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/2 11:21
 */
public class Offer {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * @Description //TODO 最长重复子数组
     * @Author ZX
     * @Date 13:29 2020/7/2
     **/
    public static class Solution {
        public static int findLength(int[] A, int[] B) {
            // base case
            if (B == null || (A == null && B != null) || (A != null && B == null)) {
                return 0;
            }

            int lenA = A.length;
            int lenB = B.length;
            int res = 0;

            for (int i = 0; i < lenA; i++) { // A不动，B依次向右推
                int cur = 0;
                int k = i;
                for (int j = 0; j < lenB && k < lenA; k++, j++) {
                    if (A[k] == B[j]) {
                        cur++; // 以i开头的当前重复子数组长度
                        res = Math.max(cur, res);
                    } else {
                        cur = 0;
                    }
                }
            }

            for (int i = 0; i < lenB; i++) { // B不动，A依次向右推
                int cur = 0;
                int k = i;
                for (int j = 0; j < lenA && k < lenB; k++, j++) {
                    if (B[k] == A[j]) {
                        cur++; // 以i开头的当前重复子数组长度
                        res = Math.max(cur, res);
                    } else {
                        cur = 0;
                    }
                }
            }

            return res;
        }
    }

    /**
     * @Description //TODO 层序遍历二叉树
     * @Author ZX
     * @Date 15:38 2020/7/2
     **/
    public static class cengXu {
        static class Node {
            int val;
            Node left;
            Node right;

            public Node(int val) {
                this.val = val;
            }
        }

        public static void process(Node head) {
            if (head == null) {
                return;
            }
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()) {
                Node curNode = queue.poll();
                System.out.print(curNode.val + " ");
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }
    }

    /**
     * @Description //TODO 和K的子数组
     * @Author ZX
     * @Date 20:26 2020/7/7
     **/
    public static class sumKSubArray {
        // 暴力法
        public int subarraySum1(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int res = 0;
            for (int start = 0; start < nums.length; start++) {
                for (int end = start; end < nums.length; end++) {
                    int sum = 0;
                    for (int i = start; i <= end; i++) {
                        sum += nums[i];
                    }
                    if (sum == k) {
                        res++;
                    }
                }
            }
            return res;
        }

        // 利用map记录子数组累加和出现的次数
        public int subarraySum2(int[] nums, int k) {
            if (nums == null) {
                return 0;
            }
            Map<Integer, Integer> map = new HashMap<>(); // key：子数组的累加和 value：该累加和出现的次数
            map.put(0, 1); // 累加和为0的子数组至少有一个，即[]
            int sum = 0;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i]; // 到i位置时的累加和
                if (map.containsKey(sum - k)) {
                    res += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return res;
        }
    }

    /**
     * @Description //TODO 剑指Offer1：二维数组的查找
     * @Author ZX
     * @Date 16:32 2020/7/2
     **/
    public static class searchTargetInMatrix {
        public static boolean process(int[][] array, int target) {
            int startX = 0;
            int startY = array[0].length - 1;
            while (startX < array.length && startY >= 0) {
                if (array[startX][startY] < target) {
                    startX++;
                } else if (array[startX][startY] > target) {
                    startY--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * @Description //TODO 剑指Offer2：替换空格
     * @Author ZX
     * @Date 16:35 2020/7/2
     **/
    public static class ReplaceSpace {
        public static String replaceSpace(StringBuffer str) {
            if (str == null || str.length() == 0) {
                return "";
            }

            String STR = str.toString();
            char[] strArray = STR.toCharArray();
//            int spaceNum = 0; // 空格总数
//            for(int i = 0; i < strArray.length; i ++) {
//                if(strArray[i] == ' ') {
//                    spaceNum++;
//                }
//            }
            //char[] newArray = new char[STR.length() + 3 * spaceNum - spaceNum];
            StringBuilder res = new StringBuilder();
            int index = 0;
            for (int i = 0; i < strArray.length; i++) {
                if (strArray[i] != ' ') {
                    //newArray[index++]= strArray[i];
                    res.append(strArray[i]);
                } else {
                    res.append("%20");
                    //newArray[index++] = '%';
                    //newArray[index++] = '2';
                    //newArray[index++] = '0';
                }
            }
            return res.toString();
        }
    }

    /**
     * @Description //TODO 剑指Offer3：从尾到头打印链表
     * @Author ZX
     * @Date 18:38 2020/7/2
     **/
    public static class PrintListFromHeadToTail {
        static class ListNode {
            int val;
            ListNode next;

            public ListNode(int val) {
                this.val = val;
            }
        }

        // 用栈
        public static void printListFromHeadToTail1(ListNode head) {
            if (head == null) {
                return;
            }
            Stack<ListNode> stack = new Stack<>();
            while (head != null) {
                stack.push(head);
                head = head.next;
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop().val + " ");
            }
        }

        // 不用栈
        public static void printListFromHeadToTail2(ListNode head) {
            if (head == null) {
                return;
            }
            // 链表逆序
            ListNode pre = null;
            ListNode next = null;
            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            ListNode cur = pre;
            while (cur != null) {
                System.out.print(cur.val + " ");
                cur = cur.next;
            }
            // 链表逆序
            ListNode PRE = null;
            ListNode NEXT = null;
            while (pre != null) {
                NEXT = pre.next;
                pre.next = PRE;
                PRE = pre;
                pre = NEXT;
            }
        }
    }

    /**
     * @Description //TODO 剑指Offer4：根据先序遍历、中序遍历重建二叉树
     * @Author ZX
     * @Date 10:27 2020/7/6
     **/
    public static class ReConstructBinaryTree {
        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            if (pre == null || in == null || pre.length == 0 || in.length == 0) {
                return null;
            }

            TreeNode root = new TreeNode(pre[0]);
            int rootIndex = 0;
            for (int i = 0; i < in.length; i++) {
                if (in[i] == root.val) {
                    rootIndex = i;
                    break;
                }
            }
            root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1),
                    Arrays.copyOfRange(in, 0, rootIndex));
            root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length),
                    Arrays.copyOfRange(in, rootIndex + 1, in.length));

            return root;
        }
    }

    /**
     * @Description //TODO 剑指Offer5：用两个栈实现队列
     * @Author ZX
     * @Date 10:46 2020/7/6
     **/
    public static class twoStackToQueue {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.isEmpty()) { // stack2为空
                while (!stack1.isEmpty()) { // 将stack1中元素全部压入stack2中
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop(); // stack2不为空
        }
    }

    /**
     * @Description //TODO 剑指Offer6：旋转数组的最小数字
     * @Author ZX
     * @Date 11:09 2020/7/6
     **/
    public static class MinNumberInRotateArray {
        // 暴力法
        public int minNumberInRotateArray1(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            int min = array[0];
            for (int i = 1; i < array.length; i++) {
                min = Math.min(min, array[i]);
            }
            return min;
        }

        // 先排序
        public int minNumberInRotateArray2(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            Arrays.sort(array);
            return array[0];
        }
    }

    /**
     * @Description //TODO 剑指Offer7：斐波那契额数列（动态规划）
     * @Author ZX
     * @Date 11:46 2020/7/6
     **/
    public static class Fibonacci {
        // 递归
        public int fibonacci1(int n) {
            if (n < 2) {
                return n;
            }
            return fibonacci1(n - 1) + fibonacci1(n - 2);
        }

        // 根据递归改的动态规划
        public int fibonacci2(int n) {
            int preNum = 1;
            int prePreNum = 0;
            if (n == 0)
                return 0;
            if (n == 1)
                return 1;
            int res = 0;
            for (int i = 2; i <= n; i++) {
                res = preNum + prePreNum;
                prePreNum = preNum;
                preNum = res;
            }
            return res;
        }
    }

    /**
     * @Description //TODO 剑指Offer8：跳台阶（动态规划）
     * @Author ZX
     * @Date 15:26 2020/7/6
     **/
    public static class JumpFloor {
        public int JumpFloor(int target) {
            int preNum = 2;
            int prePreNum = 1; // 没有0级的台阶
            if (target <= 2) {
                return target;
            }
            int res = 0;
            for (int i = 3; i <= target; i++) {
                res = preNum + prePreNum;
                prePreNum = preNum;
                preNum = res;
            }
            return res;
        }
    }

    /**
     * @Description //TODO 剑指Offer9：变态跳台阶（贪心）
     * @Author ZX
     * @Date 21:54 2020/7/6
     **/
    public static class JumpFloorII {
        // 思路1：除了target，每一个台阶都有跳与不跳两种可能
        public int jumpFloorII1(int target) {
            return (int) Math.pow(2, target - 1);
        }

        // 思路2：从后往前找规律；再从前往后递推
        // 易知 f(n)=f(n-1)+f(n-2)+……f(1)
        // f(n-1)=f(n-2)+……f(1)
        // 两式相减得f(n)=2f(n-1)
        public int jumpFloorII2(int target) {
            int res = 1;
            for (int i = 2; i < target + 1; i++) {
                res = 2 * res;
            }
            return res;
        }
    }

    /**
     * @Description //TODO 剑指Offer10：矩形覆盖
     * @Author ZX
     * @Date 9:49 2020/7/7
     **/
    public static class RectCover {
        // 递归
        public int rectCover1(int target) {
            if (target < 4) {
                return target;
            }
            return rectCover1(target - 1) + rectCover1(target - 2);
        }

        // 动态规划
        public int rectCover2(int target) {
            if (target < 2)
                return target;
            int[] dp = new int[target + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < target + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[target];
        }
    }

    /**
     * @Description //TODO 剑指Offer11：二进制中1的个数
     * @Author ZX
     * @Date 9:50 2020/7/7
     **/
    public static class NumsOfOne {
        // 方法1：temp左移逐个判断n的每一位是否位1
        // 缺点：对于每一个数都需要将temp左移32次
        public int NumberOfOne1(int n) {
            int sum = 0; // 记录1的个数
            int temp = 1; // 用temp判断n的每一位是否为1
            while (temp != 0) { // int型变量为32位。temp左移32次之后，temp就会变为0。此时说明n遍历结束了
                sum = (n & temp) != 0 ? sum + 1 : sum;
                temp = temp << 1;
            }
            return sum;
        }

        // 方法2：n & (n -1)即消除n最右边的1
        public int NumberOfOne2(int n) {
            int sum = 0; // 记录1的个数
            while (n != 0) { // 说明n中至少有一个1
                sum++;
                n = n & (n - 1); // 利用n - 1消除n最右边的1
            }
            return sum;
        }

    }

    /**
     * @Description //TODO 剑指Offer12：数值的整数次方
     * @Author ZX
     * @Date 11:11 2020/7/7
     **/
    public static class Power {
        // 非递归
        public double power1(double base, int exponent) {
            if (exponent == 0) {
                return 1;
            }
            if (base == 0) {
                return 0;
            }
            double res = 1;
            if (exponent > 0) {
                for (int i = 1; i <= exponent; i++) {
                    res *= base;
                }
                return res;
            } else {
                for (int i = 1; i <= -exponent; i++) {
                    res *= base;
                }
                return 1 / res;
            }
        }

        // 递归
        public double power2(double base, int exponent) {
            if (exponent == 0) {
                return 1;
            }
            if (base == 0) {
                return 0;
            }
            if (exponent > 0) {
                return base * power2(base, exponent - 1);
            } else {
                return 1 / (base * power2(base, Math.abs(exponent) - 1));
            }
        }
    }

    /**
     * @Description //TODO 剑指Offer13：调整数组顺序使奇数位于偶数前面
     * @Author ZX
     * @Date 19:33 2020/7/7
     **/
    public static class ReOrderArray {
        // 使用辅助数组划分奇偶，再赋值回原数组：O(3N)
        public void reOrderArray1(int[] array) {
            if (array == null || array.length == 0) {
                return;
            }
            int[] res = new int[array.length];
            int index = 0;
            for (int cur : array) {
                if (cur % 2 == 1) { // 奇数
                    res[index++] = cur;
                }
            }
            for (int cur : array) {
                if (cur % 2 == 0) { // 偶数
                    res[index++] = cur;
                }
            }
            int i = 0;
            for (int cur : res) { // 存回原数组
                array[i++] = cur;
            }
        }
    }

    /**
     * @Description //TODO 剑指Offer14：链表中倒数第K个节点
     * @Author ZX
     * @Date 19:50 2020/7/7
     **/
    public static class FindKthToTail {
        // 全部存入栈中，再返回栈中弹出的第K个节点
        public ListNode findKthToTail1(ListNode head, int k) {
            if (head == null || k == 0) { // base case
                return null;
            }
            Stack<ListNode> stack = new Stack<>(); // 链表节点全部存入栈中
            int num = 0; // 统计链表结点个数
            while (head != null) {
                stack.push(head);
                num++;
                head = head.next;
            }
            if (num < k) { // 如果k大于链表节点个数，返回空
                return null;
            }
            for (int i = 1; i < k; i++) { // 弹出栈中前k-1个节点
                stack.pop();
            }
            return stack.pop();
        }
    }

    /**
     * @Description //TODO 剑指Offer15：反转链表
     * @Author ZX
     * @Date 20:23 2020/7/7
     **/
    public static class ReverseList {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode pre = null;
            ListNode next = null;
            ListNode cur = head;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }

    /**
     * @Description //TODO 剑指Offer16：合并两个排序链表
     * @Author ZX
     * @Date 20:23 2020/7/7
     **/
    public static class Merge {
        public ListNode merge(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null)
                return null;
            if (list1 == null && list2 != null)
                return list2;
            if (list1 != null && list2 == null)
                return list1;
            ListNode cur1 = list1; // 指针1
            ListNode cur2 = list2; // 指针2
            ArrayList<ListNode> list = new ArrayList<>();
            while (cur1 != null && cur2 != null) { // 谁小谁的指针向右移
                if (cur1.val <= cur2.val) {
                    list.add(cur1);
                    cur1 = cur1.next;
                } else {
                    list.add(cur2);
                    cur2 = cur2.next;
                }
            }
            while (cur1 != null) { // list1没遍历完
                list.add(cur1);
                cur1 = cur1.next;
            }
            while (cur2 != null) { // list2没遍历完
                list.add(cur2);
                cur2 = cur2.next;
            }
            ListNode newHead = list.get(0);
            ListNode cur = newHead;
            for (ListNode curNode : list) { // 将list中的节点连成链表
                cur.next = curNode;
                cur = curNode;
            }
            return newHead;
        }
    }

    /**
     * @Description //TODO 剑指Offer17：树的子结构
     * @Author ZX
     * @Date 21:34 2020/7/7
     **/
    public static class HasSubtree {
        public boolean hasSubtree(TreeNode root1, TreeNode root2) {
            if (root2 == null || root1 == null) {
                return false;
            }
            return DFS(root1, root2);
        }

        // 第一阶段：先序遍历查找root1与root2值相等的节点
        private boolean DFS(TreeNode curNode, TreeNode root2) {
            boolean res = false;
            if (curNode.val == root2.val) {
                // 进入第二阶段：匹配
                res = match(curNode, root2);
            }
            if (res) { // 通过当前节点已经找到匹配的结构
                return true;
            }
            // 进入第一阶段：查找
            boolean flag1 = false;
            boolean flag2 = false;
            if (curNode.left != null) {
                flag1 = DFS(curNode.left, root2);
            }
            if (!flag1 && curNode.right != null) {
                flag2 = DFS(curNode.right, root2);
            }
            return flag1 || flag2; // 找到左子树、右子树其中一个等于root2的值，停止查找
        }

        // 第二阶段：判断以curNode1为根节点的子树的左右子树结构是否与root2的左右子树结构一样
        private boolean match(TreeNode curNode1, TreeNode root2) {
            if (root2 == null) { // root2遍历完了，root1没遍历完，一定匹配
                return true;
            }
            if (curNode1 == null) { // root1遍历完了，root2没遍历完，一定不匹配
                return false;
            }
            if (curNode1.val == root2.val) {
                boolean flag1 = true; // 此处初始化为true，否则永远是false
                boolean flag2 = true; // 此处初始化为true，否则永远是false
                if (curNode1.left != null || root2.left != null) {
                    flag1 = match(curNode1.left, root2.left);
                }
                if (curNode1.right != null || root2.right != null) {
                    flag2 = match(curNode1.right, root2.right);
                }
                return flag1 && flag2; // 左右结构都匹配为子树
            } else {
                return false;
            }
        }
    }

    /**
     * @Description //TODO 剑指Offer18：二叉树的镜像
     * @Author ZX
     * @Date 16:22 2020/7/10
     **/
    public static class mirror {
        public void Mirror(TreeNode root) {
            if(root == null) {
                return;
            }
            TreeNode help = root.left;
            root.left = root.right;
            root.right = help;

            Mirror(root.left);
            Mirror(root.right);
        }
    }

    /**
     * @Description //TODO 剑指Offer19：顺时针打印矩阵
     * @Author ZX
     * @Date 16:52 2020/7/10
     **/
    public static class PrintMatrix {
        public static ArrayList<Integer> printMatrix(int [][] matrix) {
            if (matrix == null) {
                return null;
            }

            int Lx = 0, Ly = 0; //  左上角x,y
            int Rx = matrix.length - 1, Ry = matrix[0].length - 1; // 右下角x,y

            return printProcess(matrix, Lx, Ly, Rx, Ry);
        }

        private static ArrayList<Integer> printProcess(int[][] matrix , int Lx, int Ly, int Rx, int Ry) {
            ArrayList<Integer> res = new ArrayList<>();
            while(Lx <= Rx && Ly <= Ry) {
                if(Lx == Rx) {
                    while(Ly <= Ry) {
                        res.add(matrix[Lx][Ly++]);
                    }
                }
                if(Ly == Ry) {
                    while(Lx <= Rx) {
                        res.add(matrix[Lx++][Ly]);
                    }
                }
                int curX = Lx, curY = Ly;
                while(curY < Ry) {
                    res.add(matrix[Lx][curY++]);
                }
                while(curX < Rx) {
                    res.add(matrix[curX++][Ry]);
                }
                while(curY > Ly) {
                    res.add(matrix[Rx][curY--]);
                }
                while(curX > Lx) {
                    res.add(matrix[curX--][Ly]);
                }
                Lx++;
                Ly++;
                Rx--;
                Ry--;
            }
            return res;
        }
    }

    /**
     * @Description //TODO 剑指Offer20：包含min的栈
     * @Author ZX
     * @Date 20:59 2020/7/10
     **/
    public static class MinStack {

        Stack<Integer> dataStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int node) {
            dataStack.push(node);
            if(minStack.isEmpty()) {
                minStack.push(dataStack.peek());
            } else {
                if(dataStack.peek() < minStack.peek()) {
                    minStack.push(dataStack.peek());
                } else {
                    minStack.push(minStack.peek());
                }
            }
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

    /**
     * @Description //TODO 剑指Offer21：栈的压入、弹出序列
     *                                       【思路】借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，
     *                                       这里是4，很显然1≠4，所以我们继续压栈，直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，
     *                                       这样循环等压栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
     * @Author ZX
     * @Date 21:38 2020/7/10
     **/
    public static class isPopOrder {
        public boolean IsPopOrder(int [] pushA,int [] popA) {
            if(pushA.length == 0 || popA.length == 0) {
                return false;
            }
            Stack<Integer> help = new Stack<>();
            int index = 0;
            for(int num : pushA) {
                help.push(num);
                while(!help.isEmpty() && help.peek() == popA[index]) {
                    help.pop();
                    index++;
                }
            }
            return help.isEmpty();
        }
    }

    /**
     * @Description //TODO 剑指Offer22：从上往下打印二叉树
     * @Author ZX
     * @Date 10:26 2020/7/11
     **/
    public static class printFromTopToBottom {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            if(root == null) {
                return new ArrayList<Integer>();
            }
            ArrayList<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                TreeNode curNode = queue.poll();
                list.add(curNode.val);
                if(curNode.left != null) {
                    queue.add(curNode.left);
                }
                if(curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            return list;
        }
    }
    
    /**
     * @Description //TODO 剑指Offer23：二叉搜索树的后序遍历序列
     * @Author ZX
     * @Date 11:05 2020/7/11
     **/
    public static class erifySquenceOfBST {
        public boolean VerifySquenceOfBST(int [] sequence) {
            return false;
        }
    }

    public static void main(String[] args) {
//        int[] A = {5,14,53,80,48};
//        int[] B = {50,47,3,80,83};
//
//        int[] C = {1,0,0,0,0};
//        int[] D = {0,0,0,0,1};
//
//        int[] E = {1,2,3,2,1};
//        int[] F = {3,2,1,4,7};
//
//        System.out.println(Solution.findLength(A, B));
//        System.out.println(Solution.findLength(C, D));
//        System.out.println(Solution.findLength(D, C));
//        System.out.println(Solution.findLength(E, F));

//        cengXu.Node head = new cengXu.Node(1);
//        head.left = new cengXu.Node(2);
//        head.right = new cengXu.Node(3);
//        cengXu.process(head);

//        int[][] matrix = {{1, 2, 3},
//                          {4, 5, 6}};
//        System.out.println(searchTargetInMatrix.process(matrix, 7));

//        StringBuffer str = new StringBuffer("We Are Happy");
//        System.out.println(ReplaceSpace.replaceSpace(str));

//        System.out.println(new Offer.JumpFloorII().jumpFloorII1(20));
//        System.out.println(new Offer.JumpFloorII().jumpFloorII2(20));

//        System.out.println(new Offer.RectCover().rectCover1(1));
//        System.out.println(new Offer.RectCover().rectCover2(1));

        int[][] matrix = {{1, 2},{4, 3}};
        ArrayList<Integer> list = new PrintMatrix().printMatrix(matrix);
        System.out.println(list);
    }
}
