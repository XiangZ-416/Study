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
     * @Description //TODO 返回二叉树带权最大路径（路径：根节点到叶节点）
     * @Author ZX
     * @Date 16:28 2020/7/12
     **/
    public static class FindLongestPath {
        public static ArrayList<ArrayList<Integer>> lists = null;

        public static List<Integer> findLongestPath(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>(); // 记录当前路径
            process(root, list);
            int[] sums = new int[lists.size()];
            // 计算每个路径的长度
            for (int i = 0; i < lists.size(); i++) {
                for (int j = 0; j < lists.get(i).size(); j++) {
                    sums[i] += lists.get(i).get(j);
                }
            }
            int resIndex = 0; // 最长路径的下标
            int max = sums[0];
            for (int i = 1; i < sums.length; i++) {
                if (sums[i] > max) {
                    resIndex = i;
                    max = sums[i];
                }
            }
            return lists.get(resIndex);
        }

        // lists记录二叉树所有路径
        private static void process(TreeNode node, ArrayList<Integer> list) {
            if (node == null) {
                return;
            }
            list.add(node.val);
            if (node.left == null && node.right == null) { // 当前节点是叶节点，将当前路径list存到lists
                lists.add(new ArrayList<>(list));
            }
            process(node.left, list);
            process(node.right, list);
            list.remove(list.size() - 1); // 回溯当前叶节点
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

        public TreeNode recoverTree(int[] pre, int[] in) {
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
            root.left = recoverTree(Arrays.copyOfRange(pre, 1, rootIndex + 1),
                    Arrays.copyOfRange(in, 0, rootIndex));
            root.right = recoverTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length),
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
            if (root == null) {
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
        public static ArrayList<Integer> printMatrix(int[][] matrix) {
            if (matrix == null) {
                return null;
            }

            int Lx = 0, Ly = 0; //  左上角x,y
            int Rx = matrix.length - 1, Ry = matrix[0].length - 1; // 右下角x,y

            return printProcess(matrix, Lx, Ly, Rx, Ry);
        }

        private static ArrayList<Integer> printProcess(int[][] matrix, int Lx, int Ly, int Rx, int Ry) {
            ArrayList<Integer> res = new ArrayList<>();
            while (Lx <= Rx && Ly <= Ry) {
                if (Lx == Rx) {
                    while (Ly <= Ry) {
                        res.add(matrix[Lx][Ly++]);
                    }
                }
                if (Ly == Ry) {
                    while (Lx <= Rx) {
                        res.add(matrix[Lx++][Ly]);
                    }
                }
                int curX = Lx, curY = Ly;
                while (curY < Ry) {
                    res.add(matrix[Lx][curY++]);
                }
                while (curX < Rx) {
                    res.add(matrix[curX++][Ry]);
                }
                while (curY > Ly) {
                    res.add(matrix[Rx][curY--]);
                }
                while (curX > Lx) {
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
            if (minStack.isEmpty()) {
                minStack.push(dataStack.peek());
            } else {
                if (dataStack.peek() < minStack.peek()) {
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
     * 【思路】借用一个辅助的栈，遍历压栈顺序，先将第一个放入栈中，这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，
     * 这里是4，很显然1≠4，所以我们继续压栈，直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，
     * 这样循环等压栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
     * @Author ZX
     * @Date 21:38 2020/7/10
     **/
    public static class isPopOrder {
        public boolean IsPopOrder(int[] pushA, int[] popA) {
            if (pushA.length == 0 || popA.length == 0) {
                return false;
            }
            Stack<Integer> help = new Stack<>();
            int index = 0;
            for (int num : pushA) {
                help.push(num);
                while (!help.isEmpty() && help.peek() == popA[index]) {
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
            if (root == null) {
                return new ArrayList<Integer>();
            }
            ArrayList<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode curNode = queue.poll();
                list.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            return list;
        }
    }

    /**
     * @Description //TODO 剑指Offer23：二叉搜索树的后序遍历序列
     * 思路：1.按最后一个数end将所给序列划分为大于部分maxList、小于部分minList
     * 2.找到小于、大于区域的第一个位置分别是minIndex、maxIndex
     * 3.如果maxList和minList都存在
     * minIndex在maxIndex的左边，返回false；
     * maxIndex之后还有比end小的数，返回false；
     * 4.递归判断maxList、minList，同时为true，则最终返回true
     * @Author ZX
     * @Date 11:05 2020/7/11
     **/
    public static class verifySquenceOfBST {
        public boolean VerifySquenceOfBST(int[] sequence) {
            if (sequence == null || sequence.length == 0) {
                return false;
            }
            ArrayList<Integer> list = new ArrayList<>(); // 数组转成list
            for (int num : sequence) {
                list.add(num);
            }
            return process(list);
        }

        private boolean process(ArrayList<Integer> list) {
            if (list.size() == 0 || list.size() == 1) { // 没有左右子树 || 左右子树只有一个节点
                return true;
            }
            ArrayList<Integer> minList = new ArrayList<>(); // 小于end的序列
            ArrayList<Integer> maxList = new ArrayList<>(); // 大于end的序列
            int end = list.get(list.size() - 1);
            int minIndex = -1, maxIndex = -1; // 第一次小于end的位置、第一次大于end的位置
            for (int i = 0; i < list.size() - 1; i++) { // 根据end划分list为大于和小于两个序列以及minIndex、maxIndex
                if (list.get(i) < end) {
                    if (minIndex == -1) {
                        minIndex = i;
                    }
                    minList.add(list.get(i));
                }
                if (list.get(i) > end) {
                    if (maxIndex == -1) {
                        maxIndex = i;
                    }
                    maxList.add(list.get(i));
                }
            }
            if (minIndex != -1 && maxIndex != -1) { // 左右两个子树都存在
                if (maxIndex < minIndex) { // 搜索二叉树的后序遍历小于区域的肯定在大于区域的左边
                    return false;
                }
                for (int i = maxIndex; i < list.size() - 1; i++) { // 本质上是大于序列不连续，即右子树有小于根节点的数
                    if (list.get(i) < end) {
                        return false;
                    }
                }
            }
            return process(minList) && process(maxList); // 任意一颗子树都是搜索二叉树整体才是
        }
    }

    /**
     * @Description //TODO 剑指Offer24：二叉树中和为某一值的路径
     * @Author ZX
     * @Date 9:49 2020/7/12
     **/
    public static class findPath {
        ArrayList<ArrayList<Integer>> res = null;

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            if (root == null) {
                return new ArrayList<>();
            }
            res = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>(); //记录当前路径
            int sum = 0; // 当前路径和
            search(root, target, list, sum); // 查找二叉树所有路径，并将路径和等于target的路径存到res
            Sort(res); // res中的list按长度从小到大排序
            return res;
        }

        private void search(TreeNode node, int target, ArrayList<Integer> list, int sum) {
            if (node == null) {
                return;
            }
            sum += node.val;
            list.add(node.val);
            if (node.left == null && node.right == null && sum == target) {
                ArrayList<Integer> List = new ArrayList<>(list);
                res.add(List);
            }
            search(node.left, target, list, sum);
            search(node.right, target, list, sum);
            list.remove(list.size() - 1); // 回溯当前叶节点
        }

        // 选择排序
        private void Sort(ArrayList<ArrayList<Integer>> res) {
            if (res == null || res.size() < 2) {
                return;
            }

            for (int i = 0; i < res.size(); i++) {
                int minIndex = i;
                for (int j = i + 1; j < res.size(); j++) {
                    if (res.get(i).size() < minIndex) {
                        // 更新maxIndex
                        minIndex = j;
                    }
                }
                // 交换maxIndex与i的list
                ArrayList<Integer> help = res.get(i);
                res.set(i, res.get(minIndex));
                res.set(minIndex, help);
            }
        }
    }

    /**
     * @Description //TODO 剑指Offer25：复杂链表的复制
     * @Author ZX
     * @Date 9:38 2020/7/13
     **/
    public static class clone {
        public class RandomListNode {
            int label;
            RandomListNode next = null;
            RandomListNode random = null;

            RandomListNode(int label) {
                this.label = label;
            }
        }

        public RandomListNode Clone(RandomListNode pHead) {
            if (pHead == null) {
                return null;
            }
            Map<RandomListNode, RandomListNode> map = new HashMap<>();
            RandomListNode cur = pHead;
            while (cur != null) {
                map.put(cur, new RandomListNode(cur.label));
                cur = cur.next;
            }
            RandomListNode CUR = pHead;
            while (CUR != null) {
                map.get(CUR).next = map.get(CUR.next);
                map.get(CUR).random = map.get(CUR.random);
                CUR = CUR.next;
            }
            return map.get(pHead);
        }
    }

    /**
     * @Description //TODO 剑指Offer26：二叉搜索树与双向链表
     * 注意：LinkedList查询很慢，用ArrayList或者queue来存中序遍历的序列
     * @Author ZX
     * @Date 10:40 2020/7/13
     **/
    public static class Convert {
        static class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        public static TreeNode treeToDoublyList(TreeNode root) {
            if (root == null) {
                return null;
            }
            // 中序遍历，将树的所有节点存到list
            ArrayList<TreeNode> nodes = new ArrayList<>();
            inOrder(root, nodes);
            TreeNode head = nodes.get(0);
            TreeNode pre = head;
            for (int i = 1; i < nodes.size(); i++) {
                TreeNode curNode = nodes.get(i);
                pre.right = curNode;
                curNode.left = pre;
                pre = curNode;
            }
            pre.right = head;
            head.left = pre;
            return head;
        }

        private static void inOrder(TreeNode node, ArrayList<TreeNode> list) {
            if (node == null) {
                return;
            }
            inOrder(node.left, list);
            list.add(node);
            inOrder(node.right, list);
        }
    }

    /**
     * @Description //TODO 剑指Offer27：字符串的排列 + 去重 + 按字典序排序
     * @Author ZX
     * @Date 15:46 2020/7/13
     **/
    public static class permutation {
        public ArrayList<String> Permutation(String str) {
            if (str == null || str.length() == 0) {
                return new ArrayList<String>();
            }
            char[] array = str.toCharArray();
            ArrayList<String> res = new ArrayList<>(); // 返回结果
            solve(array, 0, res, array.length); // 得到字符串全排列
            res = new ArrayList<>(new HashSet<>(res)); // 去重
            Collections.sort(res); // 按字典序排序
            return res;
        }

        // 得到字符串的全排列
        private void solve(char[] array, int index, ArrayList<String> res, int length) {
            if (index == length) { // 当前填充位置为数组中最后一位
                String s = changeToString(array); // 将字符数组转成字符串
                res.add(s); // 将当前字符串排列方式存到res
            } else {
                for (int i = index; i < length; i++) {
                    swap(array, index, i); // 交换得到index位置可能出现的字符所能产生的组合
                    solve(array, index + 1, res, length);
                    swap(array, index, i); // 交换一次回溯一次，否则就不是index位置的全排列
                }
            }
        }

        private void swap(char[] array, int index, int i) {
            char help = array[index];
            array[index] = array[i];
            array[i] = help;
        }

        private String changeToString(char[] array) {
            StringBuilder sb = new StringBuilder();
            for (char str : array) {
                sb.append(str);
            }
            return sb.toString();
        }
    }

    /**
     * @Description //TODO 剑指Offer28：数组中出现次数超过一半的数字
     * @Author ZX
     * @Date 16:14 2020/7/13
     **/
    public static class moreThanHalfNum_Solution {
        public int MoreThanHalfNum_Solution(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            if (array.length == 1) {
                return array[0];
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                if (map.containsKey(array[i])) {
                    map.put(array[i], map.get(array[i]) + 1);
                    if (map.get(array[i]) > array.length / 2) {
                        return array[i];
                    }
                } else {
                    map.put(array[i], 1);
                }
            }
            return 0;
        }
    }

    /**
     * @Description //TODO 剑指Offer29：最小的K个数
     * @Author ZX
     * @Date 9:20 2020/7/14
     **/
    public static class getLeastNumbers_Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
            if (input == null || input.length == 0 || k == 0 || k > input.length) {
                return new ArrayList<Integer>();
            }
            ArrayList<Integer> res = new ArrayList<>();
            // Arrays.sort(input);
            // 冒泡排序O(N^2)(稳定)
            for (int i = input.length; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (input[j] < input[j + 1]) {
                        int help = input[j];
                        input[j] = input[j + 1];
                        input[j + 1] = help;
                    }
                }
            }
            // 选择排序O(N^2)（不稳定）
//            for (int i = 0; i < input.length; i++) {
//                int minIndex = i;
//                for (int j = i + 1; j < input.length; j++) {
//                    if (input[j] < input[minIndex]) {
//                        minIndex = j;
//                    }
//                }
//                int help = input[minIndex];
//                input[minIndex] = input[i];
//                input[i] = help;
//            }
            // 插入排序O(N^2)（稳定）
//            for(int i = 1; i < input.length; i++) {
//                for(int j = i - 1; j >= 0 && input[j] > input[j + 1]; j--) {
//                    int help = input[j];
//                    input[j] = input[j + 1];
//                    input[j + 1] = help;
//                }
//            }
            for (int i = 0; i < k; i++) {
                res.add(input[i]);
            }
            return res;
        }
    }

    /**
     * @Description //TODO 剑指Offer30：连续子数组的最大和
     * @Author ZX
     * @Date 10:04 2020/7/14
     **/
    public static class findGreatestSumOfSubArray {
        // 暴力法O(N^3)
        public int FindGreatestSumOfSubArray1(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            int max = Integer.MIN_VALUE;
            for (int start = 0; start < array.length; start++) {
                for (int end = start; end < array.length; end++) {
                    int sum = 0;
                    for (int i = start; i <= end; i++) {
                        sum += array[i];
                    }
                    max = Math.max(max, sum);
                }
            }
            return max;
        }

        // O(N)
        public int FindGreatestSumOfSubArray2(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            int max = Integer.MIN_VALUE;
            int curSum = 0;
            for (int i = 0; i < array.length; i++) {
                curSum += array[i];
                max = Math.max(max, curSum);
                curSum = curSum < 0 ? 0 : curSum; // curSum如果小于0，则当前位置不可能是最大累加和子数组的左半部分，从该位置起重新计算累加和
            }
            return max;
        }
    }

    /**
     * @Description //TODO 剑指Offer31：整数中1出现的次数（从1到n整数中1出现的次数）
     * @Author ZX
     * @Date 11:01 2020/7/14
     **/
    public static class numberOf1Between1AndN_Solution {
        // 暴力法
        public int NumberOf1Between1AndN_Solution1(int n) {
            if (n == 0) {
                return 0;
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                int curNum = i;
                while (curNum != 0) {
                    if (curNum % 10 == 1) {
                        ans++;
                    }
                    curNum = curNum / 10;
                }
            }
            return ans;
        }

        // 分段：首位 + 其他位
        public int NumberOf1Between1AndN_Solution2(int n) {
            if (n == 0) {
                return 0;
            }

            int ans = 0;

            String str = "" + n; // 将n转换为字符串
            int len = str.length(); // n的位数
            if (len == 1) {
                return 1;
            }
            int res = (int) Math.pow(10, len - 1); // 首位的幂级
            int firstBit = n / res; // 首位上的数
            //int firstBit = str.charAt(0) - '0';
            int otherBit = n % res; // 除了首位，其他位组成的数
            ans = firstBit == 1 ? (otherBit + 1) : res; // 只看首位出现1的个数
            ans += firstBit * (len - 1) * Math.pow(10, len - 1 - 1); // 除了首位，其他位组成的数1出现的次数(firstBit * 剩下的N-1个位置都可能是1 * 剩下的N-2个位置各有10种选择)
            return ans + NumberOf1Between1AndN_Solution2(otherBit);
        }
    }

    /**
     * @Description //TODO 剑指Offer32：把数组排成长最小的数
     * @Author ZX
     * @Date 15:21 2020/7/17
     **/
    public static class printMinNum {
        // 方法1：找出所有拼接的形式 -> 从小到大排序 -> 返回第一个
        public String PrintMinNumber1(int[] numbers) {
            if (numbers == null || numbers.length == 0) {
                return "";
            }
            if (numbers.length == 1) {
                return changeToString(numbers);
            }
            ArrayList<String> list = new ArrayList<>();
            int len = numbers.length;
            solve(numbers, 0, list, len);
            list = new ArrayList<String>(new HashSet<String>(list));
            Collections.sort(list);
            return list.get(0);
        }

        // 找到所有组合形式
        private void solve(int[] nums, int index, ArrayList<String> list, int len) {
            if (index == len) {
                String s = changeToString(nums);
                list.add(s);
            } else {
                for (int i = index; i < len; i++) {
                    swap(nums, index, i);
                    solve(nums, index + 1, list, len);
                    swap(nums, index, i);
                }
            }
        }

        // 数组转字符串
        private String changeToString(int[] nums) {
            StringBuilder sb = new StringBuilder();
            for (int num : nums) {
                sb.append(num);
            }
            return sb.toString();
        }

        private void swap(int[] nums, int index, int i) {
            int help = nums[index];
            nums[index] = nums[i];
            nums[i] = help;
        }


        // 方法2：自定义比较器
        public String PrintMinNumber2(int[] nums) {
            if (nums == null || nums.length == 0) {
                return "";
            }
            ArrayList<String> list = new ArrayList<>();
            for (int num : nums) {
                list.add("" + num);
            }
            Collections.sort(list, new myComparator());
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                res.append(list.get(i));
            }
            return res.toString();
        }

        public class myComparator implements Comparator<String> {
            @Override
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        }
    }

    /**
     * @Description //TODO 剑指Offer33:丑数
     * 思路：一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到
     * 可以维护三个队列
     * 没有必要维护三个队列，只需要记录三个指针显示到达哪一步
     * @Author ZX
     * @Date 16:45 2020/7/17
     **/
    public static class getUglyNumber_Solution {
        public int GetUglyNumber_Solution(int index) {
            if (index == 0) {
                return 0;
            }
            int[] uglyNums = new int[index];
            uglyNums[0] = 1;
            int index1 = 0; // 乘2
            int index2 = 0; // 乘3
            int index3 = 0; // 乘5
            for (int i = 1; i < index; i++) {
                uglyNums[i] = Math.min(Math.min(uglyNums[index1] * 2, uglyNums[index2] * 3), uglyNums[index3] * 5);
                if (uglyNums[i] == uglyNums[index1] * 2) {
                    index1++;
                }
                if (uglyNums[i] == uglyNums[index2] * 3) {
                    index2++;
                }
                if (uglyNums[i] == uglyNums[index3] * 5) {
                    index3++;
                }
            }
            return uglyNums[index - 1];
        }
    }

    /**
     * @Description //TODO 剑指Offer34:第一个只出现一次的字符
     * @Author ZX
     * @Date 19:46 2020/7/17
     **/
    public static class firstNotRepeatingChar {
        public int FirstNotRepeatingChar(String str) {
            if (str == null || str.length() == 0) {
                return -1;
            }
            char[] arr = str.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) + 1);
                } else {
                    map.put(arr[i], 1);
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (map.get(arr[i]) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * @Description //TODO 剑指Offer35:数组中的逆序对
     * @Author ZX
     * @Date 19:54 2020/7/17
     **/
    public static class InversePairs {
        public int InversePairs(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            return (int) (part(array, 0, array.length - 1) % 1000000007); // 划分数组为两部分
        }

        private long part(int[] array, int L, int R) {
            if (L == R) {
                return 0;
            }
            int mid = L + (R - L) / 2;
            return part(array, L, mid) + part(array, mid + 1, R) + merge(array, L, mid, R);
        }

        private long merge(int[] array, int L, int mid, int R) {
            int p1 = L;
            int p2 = mid + 1;
            int[] help = new int[R - L + 1];
            int index = 0;
            long ans = 0;
            while (p1 <= mid && p2 <= R) {
                ans += array[p1] > array[p2] ? (mid - p1 + 1) : 0;
                help[index++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
            }
            while (p1 <= mid) {
                help[index++] = array[p1++];
            }
            while (p2 <= R) {
                help[index++] = array[p2++];
            }
            index = 0;
            for (int i = 0; i < help.length; i++) {
                array[L + i] = help[i];
            }
            return ans;
        }
    }

    /**
     * @Description //TODO 剑指Offer36:两个链表的第一个公共结点
     * @Author ZX
     * @Date 21:00 2020/7/17
     **/
    public static class findFirstCommonNode {
        // 两个无环链表的相交问题
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            if (pHead1 == null || pHead2 == null) {
                return null;
            }
            int p1 = 0;
            ListNode curNode1 = pHead1;
            while (curNode1 != null) {
                p1++;
                curNode1 = curNode1.next;
            }
            int p2 = 0;
            ListNode curNode2 = pHead2;
            while (curNode2 != null) {
                p2++;
                curNode2 = curNode2.next;
            }
            int cha = p1 - p2;
            if (cha > 0) { // pHead1较长
                while (cha > 0) {
                    pHead1 = pHead1.next;
                    cha--;
                }
                while (pHead1 != null && pHead2 != null) {
                    if (pHead1 == pHead2) {
                        return pHead1;
                    }
                    pHead1 = pHead1.next;
                    pHead2 = pHead2.next;
                }
            } else { // pHead2较长
                while (cha > 0) {
                    pHead2 = pHead2.next;
                    cha--;
                }
                while (pHead1 != null && pHead2 != null) {
                    if (pHead1 == pHead2) {
                        return pHead1;
                    }
                    pHead1 = pHead1.next;
                    pHead2 = pHead2.next;
                }
            }
            return null;
        }
    }

    /**
     * @Description //TODO 剑指Offer37：数字在排序数组中出现的次数
     * @Author ZX
     * @Date 21:35 2020/7/17
     **/
    public static class getNumberOfK {
        public int GetNumberOfK(int[] array, int k) {
            if (array == null || array.length == 0) {
                return 0;
            }
            int ans = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == k) {
                    ans++;
                }
            }
            return ans;
        }
    }

    /**
     * @Description //TODO 剑指Offer38：二叉树的深度
     * @Author ZX
     * @Date 11:25 2020/7/18
     **/
    public static class treeDepth {
        // 方法1：宽搜
        public int TreeDepth1(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int ans = 0;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                while (count > 0) {
                    TreeNode curNode = queue.poll();
                    if (curNode.left != null) {
                        queue.add(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.add(curNode.right);
                    }
                    count--;
                }
                ans++;
            }
            return ans;
        }

        // 方法2：递归
        public int TreeDepth2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(TreeDepth2(root.left), TreeDepth2(root.right)) + 1;
        }
    }

    /**
     * @Description //TODO 剑指Offer39：平衡二叉树
     * @Author ZX
     * @Date 11:26 2020/7/18
     **/
    public static class isBalancedTree {
        static class returnData {
            boolean isB;
            int h;

            public returnData(boolean isB, int h) {
                this.isB = isB;
                this.h = h;
            }
        }

        public boolean isBalanced(TreeNode root) {
            if (root == null)
                return true;
            return process(root).isB;
        }

        private returnData process(TreeNode root) {
            if (root == null)
                return new returnData(true, 0);
            returnData leftData = process(root.left);
            if (!leftData.isB) {
                return new returnData(false, 0);
            }
            returnData rightData = process(root.right);
            if (!rightData.isB)
                return new returnData(false, 0);
            if (Math.abs(leftData.h - rightData.h) > 1)
                return new returnData(false, 0);
            return new returnData(true, Math.max(leftData.h, rightData.h) + 1);
        }
    }

    /**
     * @Description //TODO 剑指Offer40：数组中只出现一次的数字
     * @Author ZX
     * @Date 16:10 2020/7/18
     **/
    public static class findNumsAppearOnce {
        // 方法1：使用map统计每个数出现的次数
        public void FindNumsAppearOnce1(int[] array, int num1[], int num2[]) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                if (map.containsKey(array[i])) {
                    map.put(array[i], map.get(array[i]) + 1);
                } else {
                    map.put(array[i], 1);
                }
            }
            int index1 = 0, index2 = 0;
            for (int i = 0; i < array.length; i++) {
                if (map.get(array[i]) == 1) {
                    if (index1 == 0) {
                        index1 = i;
                    } else {
                        index2 = i;
                    }
                }
            }
            num1[0] = array[index1];
            num2[0] = array[index2];
        }

        // 方法2：用HashSet
        public void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : array) {
                if (!set.add(num)) { // set.add()：两个作用：加数、判断是否加过
                    set.remove(num);
                }
            }
            Object[] res = set.toArray();
            num1[0] = (int) res[0];
            num2[0] = (int) res[1];
        }

        // 方法3：异或去重
        public int[] singleNumber(int[] nums) {
            int bit = 0; // 0异或任何数都是该数本身
            for (int num : nums) {
                bit ^= num; // 最终bit是两个只出现一次的数的异或结果
            }
            // 保留异或结果中只有一个1（这里保留异或结果中第一个1）。按该位为1是一组，不为1是一组分别异或
            bit = bit & -bit;
            int[] res = {0, 0}; // 返回结果
            for (int num : nums) { // 两组分别异或
                if ((num & bit) != 0) { // 为1是一组
                    res[0] ^= num;
                } else { // 不为1是一组
                    res[1] ^= num;
                }
            }
            return res;
        }
    }

    /**
     * @Description //TODO 剑指Offer41：和为S的连续正数序列
     * @Author ZX
     * @Date 21:00 2020/7/18
     **/
    public static class findContinuousSequence {
        // 方法1：暴力穷举
        public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
            if (sum == 0)
                return new ArrayList<>();
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            for (int start = 1; start <= sum / 2 + 1; start++) {
                for (int end = start + 1; end <= sum / 2 + 1; end++) {
                    int curSum = 0;
                    for (int i = start; i <= end; i++) {
                        curSum += i;
                    }
                    if (curSum == sum) {
                        ArrayList<Integer> list = new ArrayList<>();
                        for (int i = start; i <= end; i++) {
                            list.add(i);
                        }
                        res.add(list);
                    }
                }
            }
            return res;
        }

        // 方法2：双指针
        public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int target) {
            if (target < 2)
                return new ArrayList<>();
            int p1 = 1, p2 = 2;
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            while (p1 < p2) {
                if (sumP1ToP2(p1, p2) == target) {
                    ArrayList<Integer> res = new ArrayList<>();
                    int start = p1;
                    while (start <= p2) {
                        res.add(start);
                        start++;
                    }
                    ans.add(res);
                    p1++;
                } else if (sumP1ToP2(p1, p2) < target) {
                    p2++;
                } else {
                    p1++;
                }
            }
            return ans;
        }

        private int sumP1ToP2(int p1, int p2) {
            return (p1 + p2) * (p2 - p1 + 1) / 2;
        }
    }

    /**
     * @Description //TODO 剑指Offer42：和为S的两个数字
     * @Author ZX
     * @Date 19:48 2020/7/18
     **/
    public static class findNumbersWithSum {
        // 方法1：暴力法
        public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
            if (array == null || array.length == 0)
                return new ArrayList<Integer>();
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = i; j < array.length; j++) {
                    if (array[i] + array[j] == sum) {
                        list.add(array[i]);
                        list.add(array[j]);
                        res.add(list);
                    }
                }
            }

            if (res.size() == 0) {
                return new ArrayList<>();
            }

            int min = res.get(0).get(0) * res.get(0).get(1);
            int minIndex = 0;
            for (int i = 1; i < res.size(); i++) {
                if (res.get(i).get(0) * res.get(i).get(1) < min) {
                    minIndex = i;
                }
            }
            return res.get(minIndex);
        }

        // 方法2：双指针
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return new int[]{};
            int len = nums.length;
            int p1 = 0, p2 = len - 1;
            int[] res = new int[2];
            while (p1 < p2) {
                if (nums[p1] + nums[p2] == target) {
                    res[0] = nums[p1];
                    res[1] = nums[p2];
                    return res;
                } else if (nums[p1] + nums[p2] < target) {
                    p1++;
                } else if (nums[p1] + nums[p2] > target) {
                    p2--;
                }
            }
            return new int[]{};
        }
    }

    /**
     * @Description //TODO 剑指Offer43：左旋转字符串
     * @Author ZX
     * @Date 10:54 2020/7/19
     **/
    public static class leftRotateString {
        public String LeftRotateString(String str, int n) {
            if (str == null || str.length() == 0)
                return "";
            char[] arr = str.toCharArray();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (i < n) {
                    sb1.append(arr[i]);
                } else {
                    sb2.append(arr[i]);
                }
            }
            sb2.append(sb1);
            return sb2.toString();
        }
    }

    /**
     * @Description //TODO 剑指Offer44：翻转单词序列
     * @Author ZX
     * @Date 11:02 2020/7/19
     * @Param [args]
     * @return void
     **/
    public static class reverseSentence {
        // leetcode
        public String reverseWords(String s) {
            String trimS = s.trim();
            String[] strings = trimS.split(" ");
            StringBuilder res = new StringBuilder();
            for (int i = strings.length - 1; i >= 0; i--) {
                res.append(strings[i]);
                if (i > 0) {
                    res.append(" ");
                }
            }
            return res.toString();
        }

        // 牛客
        public String ReverseSentence(String s) {
            if (s == null || s.length() == 0 || s.trim().length() == 0)
                return s;
            String[] strings = s.split("\\s+");
            StringBuilder res = new StringBuilder();
            for (int i = strings.length - 1; i >= 0; i--) {
                res.append(strings[i]);
                if (i > 0) {
                    res.append(" ");
                }
            }
            return res.toString().trim();
        }
    }

    /**
     * @Description //TODO 剑指Offer45：扑克牌顺子
     * @Author ZX
     * @Date 15:35 2020/7/19
     **/
    public static class IsContinuous {
        public boolean isContinuous(int[] nums) {
            if (nums == null || nums.length == 0)
                return false;
            Arrays.sort(nums); // 避免统计空缺位置出现负数
            // 统计nums中0的个数并删除0，nums中只留下非0的数字（统计空缺位置个数时，0不用参与）
            int zeroNums = 0;
            int[] noZeroNums = new int[nums.length]; // 删除0后的nums
            int index = 0;
            for (int num : nums) {
                if (num == 0) {
                    zeroNums++;
                } else {
                    if (index < nums.length) {
                        noZeroNums[index++] = num;
                    }
                }
            }
            // 统计nums中空缺位置的个数
            int spaceNums = 0;
            int pre = noZeroNums[0];
            for (int i = 1; i < noZeroNums.length - zeroNums; i++) {
                if (noZeroNums[i] == pre) { // 出现相同牌，就不可能是顺子
                    return false;
                }
                if (noZeroNums[i] - pre > 1) {
                    spaceNums += noZeroNums[i] - pre - 1;
                }
                pre = noZeroNums[i];
            }
            return zeroNums >= spaceNums || spaceNums == 0; // 大小王数大于等于空缺位置数 || nums本身就是顺子
        }
    }

    /**
     * @Description //TODO 剑指Offer46：圆圈中最后留下的数
     * @Author ZX
     * @Date 16:43 2020/7/19
     **/
    public static class LastRemaining {
        // 方法1：用ArrayList模拟删除过程
        public int LastRemaining_Solution(int n, int m) {
            if (m == 0) {
                return -1;
            }
            ArrayList<Integer> list = new ArrayList<>(n);
            int num = 0;
            while (num < n) {
                list.add(num++);
            }
            int start = 0;
            while (n > 1) {
                start = (start + m - 1) % n;
                list.remove(start);
                n--;
            }
            return list.get(0);
        }

        // 方法2：从最后一轮反推
        public int lastRemaining(int n, int m) {
            int ans = 0;
            // 从最后一轮（剩下两个数时）反推最终剩下的数字
            for (int i = 2; i <= n; i++) {
                ans = (ans + m) % i; // 上一轮中的位置 = （当前位置 + m） % 上一轮剩下的个数
            }
            return ans;
        }
    }

    /**
     * @Description //TODO 剑指Offer47：求1+2+3+...+n
     * @Author ZX
     * @Date 17:06 2020/7/19
     **/
    public static class sum {
        int ans = 0;

        public int Sum_Solution(int n) {
            boolean flag = n > 1 && Sum_Solution(n - 1) > 0;
            ans += n;
            return ans;
        }
    }

    /**
     * @Description //TODO 剑指Offer48：不用加减乘除计算a + b
     * 思路
     * 不考虑进位：num1 = a ^ b
     * 只考虑进位： num2 = (a & b) << 1
     * 程序
     * a + b = num1 + num2，循环求num1、num2，直达num2为0（没有进位时）
     * @Author ZX
     * @Date 20:31 2020/7/19
     **/
    public static class addAandB {
        public int add(int a, int b) {
            while (b != 0) {
                int c = (a & b) << 1;
                a = a ^ b; // 不考虑进位
                b = c; // 只考虑进位
            }
            return a;
        }
    }

    /**
     * @Description //TODO 剑指Offer49：字符串转数字
     * @Author ZX
     * @Date 20:37 2020/7/20
     **/
    public static class StringToInt {
        // 牛客
        public int StrToInt1(String str) {
            if (str == null || str.length() == 0)
                return 0;
            char[] array = str.toCharArray();
            int len = array.length;
            int ans = 0;
            if (array[0] == '+') {
                for (int i = 1; i < array.length; i++) {
                    if ((array[i] >= 'a' && array[i] <= 'z') ||
                            (array[i] >= 'A' && array[i] <= 'Z')) {
                        return 0;
                    }
                    ans += Math.pow(10, len - i - 1) *
                            Integer.parseInt(String.valueOf(array[i]));
                }
            } else if (array[0] == '-') {
                for (int i = 1; i < array.length; i++) {
                    if ((array[i] >= 'a' && array[i] <= 'z') ||
                            (array[i] >= 'A' && array[i] <= 'Z')) {
                        return 0;
                    }
                    ans += Math.pow(10, len - i - 1) *
                            Integer.parseInt(String.valueOf(array[i]));
                }
                ans = -ans;
            } else {
                for (int i = 0; i < array.length; i++) {
                    if ((array[i] >= 'a' && array[i] <= 'z') ||
                            (array[i] >= 'A' && array[i] <= 'Z')) {
                        return 0;
                    }
                    ans += Math.pow(10, len - i - 1) *
                            Integer.parseInt(String.valueOf(array[i]));
                }
            }
            return ans;
        }

        // leecode
        public static int StrToInt2(String str) {
            char[] c = str.trim().toCharArray();
            if (c.length == 0) return 0;
            int res = 0, bndry = Integer.MAX_VALUE / 10;
            int i = 1, sign = 1;
            if (c[0] == '-') sign = -1;
            else if (c[0] != '+') i = 0;
            for (int j = i; j < c.length; j++) {
                if (c[j] < '0' || c[j] > '9') break;
                if (res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                res = res * 10 + (c[j] - '0');
            }
            return sign * res;
        }
    }

    /**
     * @Description //TODO 剑指Offer50：数组中重复的数字
     * @Author ZX
     * @Date 20:45 2020/7/20
     **/
    public static class Duplicate {
        // Parameters:
        //    numbers:     an array of integers
        //    length:      the length of array numbers
        //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
        //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
        // Return value:       true if the input is valid, and there are some duplications in the array number
        //                     otherwise false
        public boolean duplicate(int numbers[], int length, int[] duplication) {
            if (numbers == null || length == 0)
                return false;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : numbers) {
                if (map.containsKey(num)) {
                    duplication[0] = num;
                    return true;
                } else {
                    map.put(num, 1);
                }
            }
            return false;
        }
    }

    /**
     * @Description //TODO 剑指Offer51：构建乘积数组
     * @Author ZX
     * @Date 21:44 2020/7/20
     **/
    public static class Multiply {
        // 时间复杂度过大
        public int[] multiply1(int[] A) {
            if (A == null || A.length == 0) {
                return new int[]{};
            }
            int[] B = new int[A.length];
            B[0] = 1; // B[0]
            for (int i = 1; i < A.length; i++) {
                B[0] *= A[i];
            }
            B[B.length - 1] = 1; // B[N - 1]
            for (int i = 0; i < A.length - 1; i++) {
                B[B.length - 1] *= A[i];
            }
            for (int i = 1; i < B.length - 1; i++) {
                B[i] = left(A, i) * right(A, i);
            }
            return B;
        }

        // 计算0 ~ index-1的连乘积
        private int left(int[] A, int index) {
            int ans = 1;
            for (int i = 0; i < index; i++) {
                ans *= A[i];
            }
            return ans;
        }

        // 计算index+1 ~ A.length-1的连乘积
        private int right(int[] A, int index) {
            int ans = 1;
            for (int i = index + 1; i < A.length; i++) {
                ans *= A[i];
            }
            return ans;
        }

        // leecode可以通过
        public int[] multiply2(int[] A) {
            // base case
            if (A == null || A.length == 0)
                return new int[]{};

            int len = A.length;
            int[] leftMultiply = new int[len]; // 记录除了自己左边的连乘积
            int[] rightMultiply = new int[len]; // 记录除了自己右边的连乘积
            leftMultiply[0] = rightMultiply[len - 1] = 1; // 两个特殊位置

            // 记录每一个i位置左边的连乘积
            for (int i = 1; i < len; i++) {
                leftMultiply[i] = A[i - 1] * leftMultiply[i - 1];
            }
            // 记录每一个i位置右边的连乘积
            for (int i = len - 2; i >= 0; i--) {
                rightMultiply[i] = A[i + 1] * rightMultiply[i + 1];
            }
            int[] B = new int[len];
            // 数组B[i] = i左边的连乘积lefts[i] * i右边的连乘积rights[i]
            for (int i = 0; i < len; i++) {
                B[i] = leftMultiply[i] * rightMultiply[i];
            }

            return B;
        }
    }

    /**
     * @Description //TODO 剑指Offer52：正则表达式匹配
     * @Author ZX
     * @Date 19:03 2020/7/21
     **/
    public static class Match {
        public boolean isMatch(String A, String B) {
            int n = A.length();
            int m = B.length();
            boolean[][] f = new boolean[n + 1][m + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    //分成空正则和非空正则两种
                    if (j == 0) {
                        f[i][j] = i == 0;
                    } else {
                        //非空正则分为两种情况 * 和 非*
                        if (B.charAt(j - 1) != '*') {
                            if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) ||
                                    B.charAt(j - 1) == '.')) {
                                f[i][j] = f[i - 1][j - 1];
                            }
                        } else {
                            //碰到 * 了，分为看和不看两种情况
                            //不看
                            if (j >= 2) {
                                f[i][j] |= f[i][j - 2];
                            }
                            //看
                            if (i >= 1 && j >= 2 &&
                                    (A.charAt(i - 1) == B.charAt(j - 2) ||
                                            B.charAt(j - 2) == '.')) {
                                f[i][j] |= f[i - 1][j];
                            }
                        }
                    }
                }
            }
            return f[n][m];
        }
    }

    /**
     * @Description //TODO 剑指Offer53：表示数值的字符串
     * @Author ZX
     * @Date 19:05 2020/7/21
     **/
    public static class IsNumeric {
        public boolean isNumeric(char[] str) {
            // 标记符号、小数点、e是否出现过
            boolean sign = false, decimal = false, hasE = false;
            for (int i = 0; i < str.length; i++) {
                if (str[i] == 'e' || str[i] == 'E') {
                    if (i == str.length - 1) return false; // e后面一定要接数字
                    if (hasE) return false;  // 不能同时存在两个e
                    hasE = true;
                } else if (str[i] == '+' || str[i] == '-') {
                    // 第二次出现+-符号，则必须紧接在e之后
                    if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                    // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                    if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                    sign = true;
                } else if (str[i] == '.') {
                    // e后面不能接小数点，小数点不能出现两次
                    if (hasE || decimal) return false;
                    decimal = true;
                } else if (str[i] < '0' || str[i] > '9') // 不合法字符
                    return false;
            }
            return true;
        }
    }

    /**
     * @Description //TODO 剑指Offer54：字符流中第一个不重复的字符
     * @Author ZX
     * @Date 19:06 2020/7/21
     **/
    public static class solution {
        ArrayList<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        //Insert one char from stringstream
        public void Insert(char ch) {
            list.add(ch);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        //return the first appearence once char in current stringstream
        public char FirstAppearingOnce() {
            for (Character s : list) {
                if (map.get(s) == 1) {
                    return s;
                }
            }
            return '#';
        }
    }

    /**
     * @Description //TODO 剑指Offer55：链表中环的入口节点
     * @Author ZX
     * @Date 19:08 2020/7/21
     **/
    public static class entryNodeOfLoop {
        public ListNode EntryNodeOfLoop(ListNode pHead) {
            // 链表节点数小于3，不可能成环
            if (pHead == null || pHead.next == null || pHead.next.next == null)
                return null;
            ListNode slow = pHead; // 慢指针一次走一步
            ListNode fast = pHead; // 快指针开始一次走两步
            while (slow.next != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow.equals(fast)) { // 快慢指针相遇时跳出循环进入下一环节
                    break;
                }
            }
            if (fast == null) { // 如果快指针走到头都没有与慢指针相遇，则链表无环
                return null;
            }
            fast = pHead; // 进入第二阶段：快指针回到链表头节点，并且改为一次走一步
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow; // 快、慢指针再次相遇时，即为第一个入环的节点
        }
    }

    /**
     * @Description //TODO 剑指Offer56：删除链表中重复的节点
     * 1.确定删除重复节点后的链表的头节点ans
     * 2.从ans到链表的尾部，判断每一个节点是否为重复节点，是的话就跳过
     * // 牛客：1 -> 2 -> 2 -> 3 -> 4 -> 4 -> 5 删除后 1 -> 3 -> 5
     * // leecode：1 -> 2 -> 2 -> 3 -> 4 -> 4 -> 5 删除后 1 -> 2 -> 3 -> 4 -> 5
     * @Author ZX
     * @Date 19:15 2020/7/21
     **/
    public static class DeleteDuplication {
        // 牛客
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null || pHead.next == null)
                return pHead;
            // 找到删除重复节点后的链表的头节点
            ListNode ans = pHead;
            while (ans != null) {
                if (ans.next != null && ans.val == ans.next.val) {
                    int val = ans.val;
                    while (ans != null && ans.val == val) {
                        ans = ans.next;
                    }
                } else {
                    break;
                }
            }
            if (ans == null) { // pHead为头的链表所有节点值都相等
                return null;
            }
            // 判断ans之后的节点是否重复，若重复，则跳过
            ListNode lastNode = ans;
            ListNode curNode = ans.next;
            while (curNode != null) {
                if (curNode.next != null && curNode.val == curNode.next.val) {
                    int val = curNode.val;
                    while (curNode != null && curNode.val == val) {
                        curNode = curNode.next;
                    }
                } else {
                    lastNode.next = curNode;
                    lastNode = curNode;
                    curNode = curNode.next;
                }
            }
            lastNode.next = null;
            return ans;
        }

        // leecode
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null)
                return head;
            // 找到删除重复节点之后的新链表的头节点ans
            ListNode ans = head;
            while (ans != null) {
                if (ans.next != null && ans.val == ans.next.val) {
                    ans = ans.next;
                } else {
                    break; // 此时ans就是新的头节点
                }
            }
            if (ans == null) {
                return null;
            }
            // 判断ans后面的节点是否有重复的，重复就删除（跳过）
            ListNode lastNode = ans;
            ListNode curNode = ans.next;
            while (curNode != null) {
                if (curNode.next != null && curNode.val == curNode.next.val) {
                    curNode = curNode.next;
                } else {
                    lastNode.next = curNode;
                    lastNode = curNode;
                    curNode = curNode.next;
                }
            }
            lastNode.next = null;
            return ans;
        }
    }


    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * @Description //TODO 剑指Offer57：二叉树的下一个节点
     * @Author ZX
     * @Date 21:39 2020/7/22
     **/
    public static class getNext {
        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if (pNode == null)
                return null;
            // 情况1：pNode右孩子不为空：pNode的下一个节点是其右子树中最左的节点
            if (pNode.right != null) {
                TreeLinkNode cur = pNode.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                return cur;
            }
            if (pNode.next == null) // 情况2：pNode是右孩子为空的根节点
                return null;
            // 情况3：pNode是其父节点的左孩子：pNode的下一个节点是其父节点
            if (pNode.next.left == pNode) {
                return pNode.next;
            } else if (pNode.next.right == pNode) { // 情况4：pNode是其父节点的右孩子，pNode的下一个节点是其父节点的父节点
                if (pNode.next.next.right == pNode.next) { // 情况5：pNode是中序遍历的最后一个节点（判断pNode的父节点是不是pNode的父节点的父节点的右孩子）
                    return null;
                }
                return pNode.next.next;
            }
            return null;
        }
    }

    /**
     * @Description //TODO 剑指Offer58：对称的二叉树
     * @Author ZX
     * @Date 21:13 2020/7/23
     **/
    public static class IsSymmetrical {
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            return judge(root, root);
        }

        private boolean judge(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null)
                return true;
            if ((root1 == null && root2 != null)
                    || (root1 != null && root2 == null)
                    || (root1.val != root2.val))
                return false;
            return judge(root1.left, root2.right) && judge(root1.right, root2.left);
        }
    }

    /*
     * @Description //TODO 剑指Offer59：之字形打印二叉树
     * @Author ZX
     * @Date 21:14 2020/7/23
     **/
    public static class LevelOrder {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null)
                return new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int sum = 1; // 初始化当前层节点的个数
            int flag = 1; // 偶数就从右往左打印
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int temp = 0; // 下一层节点的个数
                while (sum > 0) {
                    TreeNode curNode = queue.poll();
                    list.add(curNode.val);
                    if (curNode.left != null) {
                        queue.add(curNode.left);
                        temp++;
                    }
                    if (curNode.right != null) {
                        queue.add(curNode.right);
                        temp++;
                    }
                    sum--;
                }
                if (flag % 2 == 0) { // 偶数层从右往左存：反置list
                    for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
                        int res = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, res);
                    }
                }
                flag++;
                ans.add(list);
                sum = temp; // 更新当前层的节点数
            }
            return ans;
        }
    }

    /**
     * @Description //TODO 剑指Offer60：把二叉树打印成多行
     * @Author ZX
     * @Date 21:30 2020/7/23
     **/
    public static class print {
        ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            if (pRoot == null) return new ArrayList<>();
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(pRoot);
            int num = 1; // 初始化当前层的节点数
            while (!queue.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                int temp = 0; // 下一层的节点数
                while (num > 0) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                        temp++;
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        temp++;
                    }
                    num--;
                }
                num = temp; // 更新当前层的节点个数
                ans.add(list);
            }
            return ans;
        }

        /**
         * @Description //TODO 剑指Offer61：二叉树的序列化反序列化
         * @Author ZX
         * @Date 16:03 2020/7/24
         **/
        public static class Serialization {
            // 序列化
            String Serialize(TreeNode root) {
                if (root == null)
                    return "#_";
                String res = root.val + "_";
                res += Serialize(root.left);
                res += Serialize(root.right);
                return res;
            }

            // 反序列化
            TreeNode Deserialize(String str) {
                String[] strs = str.split("_");
                LinkedList<String> queue = new LinkedList<>();
                for (String s : strs) {
                    queue.add(s);
                }
                return rebuild(queue);
            }

            // 反序列化建树
            private TreeNode rebuild(LinkedList<String> queue) {
                String value = queue.poll();
                if (value.equals("#")) // 空节点
                    return null;
                TreeNode node = new TreeNode(Integer.valueOf(value));
                node.left = rebuild(queue);
                node.right = rebuild(queue);
                return node;
            }
        }

        /**
         * @Description //TODO 剑指Offer62：搜索二叉树的第K大节点
         * @Author ZX
         * @Date 17:17 2020/7/24
         **/
        public static class KthNode {
            public int kthLargest(TreeNode root, int k) {
                if (root == null) return 0;
                ArrayList<Integer> list = new ArrayList<>();
                getInOrderList(root, list);
                return list.get(list.size() - k);
            }

            private void getInOrderList(TreeNode node, ArrayList<Integer> list) {
                if (node == null) return;
                getInOrderList(node.left, list);
                list.add(node.val);
                getInOrderList(node.right, list);
            }
        }

        /**
         * @Description //TODO 剑指Offer63：数据流中的中位数
         * @Author ZX
         * @Date 17:18 2020/7/24
         **/
        public static class MedianFinder {
            class myComparator implements Comparator<Integer> {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            }

            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 小根堆
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new myComparator()); // 大根堆

            public void Insert(Integer num) {
                if ((minHeap.size() + maxHeap.size()) % 2 == 0) { // 数据流个数是偶数个，num进大根堆
                    maxHeap.add(num);
                    // 大根堆堆顶元素大于小根堆堆顶元素，堆顶交换
                    if (!minHeap.isEmpty() && (maxHeap.peek() > minHeap.peek())) {
                        int help = maxHeap.poll();
                        maxHeap.add(minHeap.poll());
                        minHeap.add(help);
                    }
                } else { // 数据流个数是奇数个，num进小根堆
                    minHeap.add(num);
                    // 小根堆堆顶元素小于大根堆堆顶元素，堆顶交换
                    if (!maxHeap.isEmpty() && (minHeap.peek() < maxHeap.peek())) {
                        int help = minHeap.poll();
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(help);
                    }
                }
            }

            public Double GetMedian() {
                // 当前数据流一共偶数个数，中位数是大小根堆堆顶元素之和除以2
                if ((minHeap.size() + maxHeap.size()) % 2 == 0) {
                    return (((double) minHeap.peek() + (double) maxHeap.peek()) / 2);
                } else { // 当前数据流一共奇数个数，中位数是大根堆堆顶元素
                    return (double) maxHeap.peek();
                }
            }
        }

        /**
         * @Description //TODO 剑指Offer64：滑动窗口的最大值
         * @Author ZX
         * @Date 21:15 2020/7/24
         **/
        public static class maxInWindow {
            public ArrayList<Integer> maxInWindows(int [] num, int size){
                if(num == null || size == 0) return new ArrayList<>();
                // 维护一个从左到右（从头到尾）下标对应的值单调递减的队列
                LinkedList<Integer> queue = new LinkedList<>();
                ArrayList<Integer> ans = new ArrayList<>(); // 保存每个窗口的最大值
                for(int i = 0; i < num.length; i++) {
                    // 窗口加数：仅当队尾元素对应的值大于入队的值时入队；否则弹出队尾元素，直到满足入队条件
                    while(!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                        queue.pollLast();
                    }
                    queue.add(i);
                    // 窗口减数：当 i-队首元素 == k 时队首元素出队
                    if(i - queue.peekFirst() == size) {
                        queue.pollFirst();
                    }
                    // 当窗口长度等于size时记录队首元素对应的值，即当前窗口的最大值
                    if(i >= size - 1) {
                        ans.add(num[queue.peekFirst()]);
                    }
                }
                return ans;
            }
        }
        
        /**
         * @Description //TODO 剑指Offer65：矩阵中的路径
         * @Author ZX
         * @Date 21:16 2020/7/24
         **/
        public static class MatrixPath {
            // leetcode
            public boolean exist(char[][] board, String word) {
                if (board == null || word == null)
                    return false;
                int height = board.length;
                int width = board[0].length;
                boolean[][] flag = new boolean[height][width]; // 标记是否走过（false：没走过）
                char[] aim = word.toCharArray();
                // 遍历二维数组，判断以每个位置为起点是否存在匹配的路径
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        // 判断以board[i][j]为起点是否存在匹配的路径
                        if (judge(board, flag, i, j, 0, aim)) {
                            return true;
                        }
                    }
                }
                return false;
            }

            private boolean judge(char[][] board, boolean[][] flag,
                                  int i, int j, int k, char[] aim) { // k是aim数组的索引
                // 越界 || 当前位置不匹配 || 当前位置已经走过
                if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                        || board[i][j] != aim[k] || flag[i][j])
                    return false;
                flag[i][j] = true; // 标记当前位置已经走过
                // 走到此处说明board[i][j]与aim[k]是匹配的
                if (k == aim.length - 1) // 最后一个字符匹配成功 -> 递归终止 -> 找到路径
                    return true;
                // 当前位置匹配成功后判断当前位置的上下左右是否存在与aim[k + 1]位置匹配，如果有就继续递归寻找下	  // 一个当前位置的上下左右是否存在与aim[k + 1]位置匹配...
                if (judge(board, flag, i + 1, j, k + 1, aim)
                        || judge(board, flag, i - 1, j, k + 1, aim)
                        || judge(board, flag, i, j + 1, k + 1, aim)
                        || judge(board, flag, i, j - 1, k + 1, aim))
                    return true;
                flag[i][j] = false; // 上面if匹配失败，将走过的位置回溯为没走过
                return false; // 以当前i，j为起点匹配失败。判断board的下一个位置为起点是否可以匹配成功
            }

            // 牛客
            public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
                // 一维数组转二维数组
                char[][] board = new char[rows][cols];
                int x = 0;
                int y = 0;
                for (char c : matrix) {
                    if (y >= cols) {
                        y = 0;
                        x++;
                    }
                    board[x][y] = c;
                    y++;
                }

                if (board == null || str == null)
                    return false;
                int height = board.length;
                int width = board[0].length;
                boolean[][] flag = new boolean[height][width]; // 标记是否走过（false：没走过）
                // 遍历二维数组
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (judge(board, flag, i, j, 0, str)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        
        /**
         * @Description //TODO 剑指Offer66：机器人的运动范围
         * @Author ZX
         * @Date 20:59 2020/7/26
         **/
        public static class MovingCount {
            int ans = 0;
            public int movingCount(int threshold, int rows, int cols){
                boolean[][] m = new boolean[rows][cols];
                solve(threshold, rows, cols, m, 0, 0);
                return ans;
            }
            private void solve(int threshold, int rows, int cols, boolean[][] m, int x, int y) {
                // 越界 || 当前位置走过了 || x,y坐标数位之和大于threshold
                if(x < 0 || x >= rows || y < 0 || y >= cols
                        || m[x][y] || calcu(x, y) > threshold)
                    return;
                m[x][y] = true; // 当前位置可以走
                ans++;
                solve(threshold, rows, cols, m, x + 1, y);
                solve(threshold, rows, cols, m, x - 1, y);
                solve(threshold, rows, cols, m, x, y + 1);
                solve(threshold, rows, cols, m, x, y - 1);
            }
            // 计算num1、num2的数位之和
            private int calcu(int num1, int num2) {
                int res = 0;
                while(num1 != 0) {
                    res += num1 % 10;
                    num1 /= 10;
                }
                while(num2 != 0) {
                    res += num2 % 10;
                    num2 /= 10;
                }
                return res;
            }
        }

        /**
         * @Description //TODO 剑指Offer67：剪绳子
         * @Author ZX
         * @Date 21:03 2020/7/26
         **/
        public static class CutRope {
            public int cutRope(int n) {
                // n<=3的情况，m>1必须要分段
                // 例如：3必须分成1、2；1、1、1 ，n=3最大分段乘积是2,
                if(n==2)
                    return 1;
                if(n==3)
                    return 2;
                int[] dp = new int[n+1];
                /*
                下面3行是n>=4的情况，跟n<=3不同，4可以分很多段，比如分成1、3，
                这里的3可以不需要再分了，因为3分段最大才2，不分就是3。记录最大的。
                */
                dp[1]=1;
                dp[2]=2;
                dp[3]=3;
                int res=0;//记录最大的
                for (int i = 4; i <= n; i++) {
                    for (int j = 1; j <=i/2 ; j++) {
                        res=Math.max(res,dp[j]*dp[i-j]);
                    }
                    dp[i]=res;
                }
                return dp[n];
            }
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

//        int[][] matrix = {{1, 2},{4, 3}};
//        ArrayList<Integer> list = new PrintMatrix().printMatrix(matrix);
//        System.out.println(list);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//        System.out.println(Offer.FindLongestPath.findLongestPath(root));
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.remove(1);
    }
}
