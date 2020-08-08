import java.util.*;

/**
 * @Description: //TODO ��ָOffer
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/2 11:21
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
     * @Description //TODO ���ض�������Ȩ���·����·�������ڵ㵽Ҷ�ڵ㣩
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
            ArrayList<Integer> list = new ArrayList<>(); // ��¼��ǰ·��
            process(root, list);
            int[] sums = new int[lists.size()];
            // ����ÿ��·���ĳ���
            for (int i = 0; i < lists.size(); i++) {
                for (int j = 0; j < lists.get(i).size(); j++) {
                    sums[i] += lists.get(i).get(j);
                }
            }
            int resIndex = 0; // �·�����±�
            int max = sums[0];
            for (int i = 1; i < sums.length; i++) {
                if (sums[i] > max) {
                    resIndex = i;
                    max = sums[i];
                }
            }
            return lists.get(resIndex);
        }

        // lists��¼����������·��
        private static void process(TreeNode node, ArrayList<Integer> list) {
            if (node == null) {
                return;
            }
            list.add(node.val);
            if (node.left == null && node.right == null) { // ��ǰ�ڵ���Ҷ�ڵ㣬����ǰ·��list�浽lists
                lists.add(new ArrayList<>(list));
            }
            process(node.left, list);
            process(node.right, list);
            list.remove(list.size() - 1); // ���ݵ�ǰҶ�ڵ�
        }
    }

    /**
     * @Description //TODO ��ظ�������
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

            for (int i = 0; i < lenA; i++) { // A������B����������
                int cur = 0;
                int k = i;
                for (int j = 0; j < lenB && k < lenA; k++, j++) {
                    if (A[k] == B[j]) {
                        cur++; // ��i��ͷ�ĵ�ǰ�ظ������鳤��
                        res = Math.max(cur, res);
                    } else {
                        cur = 0;
                    }
                }
            }

            for (int i = 0; i < lenB; i++) { // B������A����������
                int cur = 0;
                int k = i;
                for (int j = 0; j < lenA && k < lenB; k++, j++) {
                    if (B[k] == A[j]) {
                        cur++; // ��i��ͷ�ĵ�ǰ�ظ������鳤��
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
     * @Description //TODO �������������
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
     * @Description //TODO ��K��������
     * @Author ZX
     * @Date 20:26 2020/7/7
     **/
    public static class sumKSubArray {
        // ������
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

        // ����map��¼�������ۼӺͳ��ֵĴ���
        public int subarraySum2(int[] nums, int k) {
            if (nums == null) {
                return 0;
            }
            Map<Integer, Integer> map = new HashMap<>(); // key����������ۼӺ� value�����ۼӺͳ��ֵĴ���
            map.put(0, 1); // �ۼӺ�Ϊ0��������������һ������[]
            int sum = 0;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i]; // ��iλ��ʱ���ۼӺ�
                if (map.containsKey(sum - k)) {
                    res += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return res;
        }
    }

    /**
     * @Description //TODO ��ָOffer1����ά����Ĳ���
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
     * @Description //TODO ��ָOffer2���滻�ո�
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
//            int spaceNum = 0; // �ո�����
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
     * @Description //TODO ��ָOffer3����β��ͷ��ӡ����
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

        // ��ջ
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

        // ����ջ
        public static void printListFromHeadToTail2(ListNode head) {
            if (head == null) {
                return;
            }
            // ��������
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
            // ��������
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
     * @Description //TODO ��ָOffer4�����������������������ؽ�������
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
     * @Description //TODO ��ָOffer5��������ջʵ�ֶ���
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
            if (stack2.isEmpty()) { // stack2Ϊ��
                while (!stack1.isEmpty()) { // ��stack1��Ԫ��ȫ��ѹ��stack2��
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop(); // stack2��Ϊ��
        }
    }

    /**
     * @Description //TODO ��ָOffer6����ת�������С����
     * @Author ZX
     * @Date 11:09 2020/7/6
     **/
    public static class MinNumberInRotateArray {
        // ������
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

        // ������
        public int minNumberInRotateArray2(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            Arrays.sort(array);
            return array[0];
        }
    }

    /**
     * @Description //TODO ��ָOffer7��쳲����������У���̬�滮��
     * @Author ZX
     * @Date 11:46 2020/7/6
     **/
    public static class Fibonacci {
        // �ݹ�
        public int fibonacci1(int n) {
            if (n < 2) {
                return n;
            }
            return fibonacci1(n - 1) + fibonacci1(n - 2);
        }

        // ���ݵݹ�ĵĶ�̬�滮
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
     * @Description //TODO ��ָOffer8����̨�ף���̬�滮��
     * @Author ZX
     * @Date 15:26 2020/7/6
     **/
    public static class JumpFloor {
        public int JumpFloor(int target) {
            int preNum = 2;
            int prePreNum = 1; // û��0����̨��
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
     * @Description //TODO ��ָOffer9����̬��̨�ף�̰�ģ�
     * @Author ZX
     * @Date 21:54 2020/7/6
     **/
    public static class JumpFloorII {
        // ˼·1������target��ÿһ��̨�׶������벻�����ֿ���
        public int jumpFloorII1(int target) {
            return (int) Math.pow(2, target - 1);
        }

        // ˼·2���Ӻ���ǰ�ҹ��ɣ��ٴ�ǰ�������
        // ��֪ f(n)=f(n-1)+f(n-2)+����f(1)
        // f(n-1)=f(n-2)+����f(1)
        // ��ʽ�����f(n)=2f(n-1)
        public int jumpFloorII2(int target) {
            int res = 1;
            for (int i = 2; i < target + 1; i++) {
                res = 2 * res;
            }
            return res;
        }
    }

    /**
     * @Description //TODO ��ָOffer10�����θ���
     * @Author ZX
     * @Date 9:49 2020/7/7
     **/
    public static class RectCover {
        // �ݹ�
        public int rectCover1(int target) {
            if (target < 4) {
                return target;
            }
            return rectCover1(target - 1) + rectCover1(target - 2);
        }

        // ��̬�滮
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
     * @Description //TODO ��ָOffer11����������1�ĸ���
     * @Author ZX
     * @Date 9:50 2020/7/7
     **/
    public static class NumsOfOne {
        // ����1��temp��������ж�n��ÿһλ�Ƿ�λ1
        // ȱ�㣺����ÿһ��������Ҫ��temp����32��
        public int NumberOfOne1(int n) {
            int sum = 0; // ��¼1�ĸ���
            int temp = 1; // ��temp�ж�n��ÿһλ�Ƿ�Ϊ1
            while (temp != 0) { // int�ͱ���Ϊ32λ��temp����32��֮��temp�ͻ��Ϊ0����ʱ˵��n����������
                sum = (n & temp) != 0 ? sum + 1 : sum;
                temp = temp << 1;
            }
            return sum;
        }

        // ����2��n & (n -1)������n���ұߵ�1
        public int NumberOfOne2(int n) {
            int sum = 0; // ��¼1�ĸ���
            while (n != 0) { // ˵��n��������һ��1
                sum++;
                n = n & (n - 1); // ����n - 1����n���ұߵ�1
            }
            return sum;
        }

    }

    /**
     * @Description //TODO ��ָOffer12����ֵ�������η�
     * @Author ZX
     * @Date 11:11 2020/7/7
     **/
    public static class Power {
        // �ǵݹ�
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

        // �ݹ�
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
     * @Description //TODO ��ָOffer13����������˳��ʹ����λ��ż��ǰ��
     * @Author ZX
     * @Date 19:33 2020/7/7
     **/
    public static class ReOrderArray {
        // ʹ�ø������黮����ż���ٸ�ֵ��ԭ���飺O(3N)
        public void reOrderArray1(int[] array) {
            if (array == null || array.length == 0) {
                return;
            }
            int[] res = new int[array.length];
            int index = 0;
            for (int cur : array) {
                if (cur % 2 == 1) { // ����
                    res[index++] = cur;
                }
            }
            for (int cur : array) {
                if (cur % 2 == 0) { // ż��
                    res[index++] = cur;
                }
            }
            int i = 0;
            for (int cur : res) { // ���ԭ����
                array[i++] = cur;
            }
        }
    }

    /**
     * @Description //TODO ��ָOffer14�������е�����K���ڵ�
     * @Author ZX
     * @Date 19:50 2020/7/7
     **/
    public static class FindKthToTail {
        // ȫ������ջ�У��ٷ���ջ�е����ĵ�K���ڵ�
        public ListNode findKthToTail1(ListNode head, int k) {
            if (head == null || k == 0) { // base case
                return null;
            }
            Stack<ListNode> stack = new Stack<>(); // ����ڵ�ȫ������ջ��
            int num = 0; // ͳ�����������
            while (head != null) {
                stack.push(head);
                num++;
                head = head.next;
            }
            if (num < k) { // ���k��������ڵ���������ؿ�
                return null;
            }
            for (int i = 1; i < k; i++) { // ����ջ��ǰk-1���ڵ�
                stack.pop();
            }
            return stack.pop();
        }
    }

    /**
     * @Description //TODO ��ָOffer15����ת����
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
     * @Description //TODO ��ָOffer16���ϲ�������������
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
            ListNode cur1 = list1; // ָ��1
            ListNode cur2 = list2; // ָ��2
            ArrayList<ListNode> list = new ArrayList<>();
            while (cur1 != null && cur2 != null) { // ˭С˭��ָ��������
                if (cur1.val <= cur2.val) {
                    list.add(cur1);
                    cur1 = cur1.next;
                } else {
                    list.add(cur2);
                    cur2 = cur2.next;
                }
            }
            while (cur1 != null) { // list1û������
                list.add(cur1);
                cur1 = cur1.next;
            }
            while (cur2 != null) { // list2û������
                list.add(cur2);
                cur2 = cur2.next;
            }
            ListNode newHead = list.get(0);
            ListNode cur = newHead;
            for (ListNode curNode : list) { // ��list�еĽڵ���������
                cur.next = curNode;
                cur = curNode;
            }
            return newHead;
        }
    }

    /**
     * @Description //TODO ��ָOffer17�������ӽṹ
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

        // ��һ�׶Σ������������root1��root2ֵ��ȵĽڵ�
        private boolean DFS(TreeNode curNode, TreeNode root2) {
            boolean res = false;
            if (curNode.val == root2.val) {
                // ����ڶ��׶Σ�ƥ��
                res = match(curNode, root2);
            }
            if (res) { // ͨ����ǰ�ڵ��Ѿ��ҵ�ƥ��Ľṹ
                return true;
            }
            // �����һ�׶Σ�����
            boolean flag1 = false;
            boolean flag2 = false;
            if (curNode.left != null) {
                flag1 = DFS(curNode.left, root2);
            }
            if (!flag1 && curNode.right != null) {
                flag2 = DFS(curNode.right, root2);
            }
            return flag1 || flag2; // �ҵ�������������������һ������root2��ֵ��ֹͣ����
        }

        // �ڶ��׶Σ��ж���curNode1Ϊ���ڵ�����������������ṹ�Ƿ���root2�����������ṹһ��
        private boolean match(TreeNode curNode1, TreeNode root2) {
            if (root2 == null) { // root2�������ˣ�root1û�����꣬һ��ƥ��
                return true;
            }
            if (curNode1 == null) { // root1�������ˣ�root2û�����꣬һ����ƥ��
                return false;
            }
            if (curNode1.val == root2.val) {
                boolean flag1 = true; // �˴���ʼ��Ϊtrue��������Զ��false
                boolean flag2 = true; // �˴���ʼ��Ϊtrue��������Զ��false
                if (curNode1.left != null || root2.left != null) {
                    flag1 = match(curNode1.left, root2.left);
                }
                if (curNode1.right != null || root2.right != null) {
                    flag2 = match(curNode1.right, root2.right);
                }
                return flag1 && flag2; // ���ҽṹ��ƥ��Ϊ����
            } else {
                return false;
            }
        }
    }

    /**
     * @Description //TODO ��ָOffer18���������ľ���
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
     * @Description //TODO ��ָOffer19��˳ʱ���ӡ����
     * @Author ZX
     * @Date 16:52 2020/7/10
     **/
    public static class PrintMatrix {
        public static ArrayList<Integer> printMatrix(int[][] matrix) {
            if (matrix == null) {
                return null;
            }

            int Lx = 0, Ly = 0; //  ���Ͻ�x,y
            int Rx = matrix.length - 1, Ry = matrix[0].length - 1; // ���½�x,y

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
     * @Description //TODO ��ָOffer20������min��ջ
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
     * @Description //TODO ��ָOffer21��ջ��ѹ�롢��������
     * ��˼·������һ��������ջ������ѹջ˳���Ƚ���һ������ջ�У�������1��Ȼ���ж�ջ��Ԫ���ǲ��ǳ�ջ˳��ĵ�һ��Ԫ�أ�
     * ������4������Ȼ1��4���������Ǽ���ѹջ��ֱ������Ժ�ʼ��ջ����ջһ��Ԫ�أ��򽫳�ջ˳������ƶ�һλ��ֱ������ȣ�
     * ����ѭ����ѹջ˳�������ɣ��������ջ����Ϊ�գ�˵���������в��Ǹ�ջ�ĵ���˳��
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
     * @Description //TODO ��ָOffer22���������´�ӡ������
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
     * @Description //TODO ��ָOffer23�������������ĺ����������
     * ˼·��1.�����һ����end���������л���Ϊ���ڲ���maxList��С�ڲ���minList
     * 2.�ҵ�С�ڡ���������ĵ�һ��λ�÷ֱ���minIndex��maxIndex
     * 3.���maxList��minList������
     * minIndex��maxIndex����ߣ�����false��
     * maxIndex֮���б�endС����������false��
     * 4.�ݹ��ж�maxList��minList��ͬʱΪtrue�������շ���true
     * @Author ZX
     * @Date 11:05 2020/7/11
     **/
    public static class verifySquenceOfBST {
        public boolean VerifySquenceOfBST(int[] sequence) {
            if (sequence == null || sequence.length == 0) {
                return false;
            }
            ArrayList<Integer> list = new ArrayList<>(); // ����ת��list
            for (int num : sequence) {
                list.add(num);
            }
            return process(list);
        }

        private boolean process(ArrayList<Integer> list) {
            if (list.size() == 0 || list.size() == 1) { // û���������� || ��������ֻ��һ���ڵ�
                return true;
            }
            ArrayList<Integer> minList = new ArrayList<>(); // С��end������
            ArrayList<Integer> maxList = new ArrayList<>(); // ����end������
            int end = list.get(list.size() - 1);
            int minIndex = -1, maxIndex = -1; // ��һ��С��end��λ�á���һ�δ���end��λ��
            for (int i = 0; i < list.size() - 1; i++) { // ����end����listΪ���ں�С�����������Լ�minIndex��maxIndex
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
            if (minIndex != -1 && maxIndex != -1) { // ������������������
                if (maxIndex < minIndex) { // �����������ĺ������С������Ŀ϶��ڴ�����������
                    return false;
                }
                for (int i = maxIndex; i < list.size() - 1; i++) { // �������Ǵ������в�����������������С�ڸ��ڵ����
                    if (list.get(i) < end) {
                        return false;
                    }
                }
            }
            return process(minList) && process(maxList); // ����һ���������������������������
        }
    }

    /**
     * @Description //TODO ��ָOffer24���������к�Ϊĳһֵ��·��
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
            ArrayList<Integer> list = new ArrayList<>(); //��¼��ǰ·��
            int sum = 0; // ��ǰ·����
            search(root, target, list, sum); // ���Ҷ���������·��������·���͵���target��·���浽res
            Sort(res); // res�е�list�����ȴ�С��������
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
            list.remove(list.size() - 1); // ���ݵ�ǰҶ�ڵ�
        }

        // ѡ������
        private void Sort(ArrayList<ArrayList<Integer>> res) {
            if (res == null || res.size() < 2) {
                return;
            }

            for (int i = 0; i < res.size(); i++) {
                int minIndex = i;
                for (int j = i + 1; j < res.size(); j++) {
                    if (res.get(i).size() < minIndex) {
                        // ����maxIndex
                        minIndex = j;
                    }
                }
                // ����maxIndex��i��list
                ArrayList<Integer> help = res.get(i);
                res.set(i, res.get(minIndex));
                res.set(minIndex, help);
            }
        }
    }

    /**
     * @Description //TODO ��ָOffer25����������ĸ���
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
     * @Description //TODO ��ָOffer26��������������˫������
     * ע�⣺LinkedList��ѯ��������ArrayList����queue�����������������
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
            // ������������������нڵ�浽list
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
     * @Description //TODO ��ָOffer27���ַ��������� + ȥ�� + ���ֵ�������
     * @Author ZX
     * @Date 15:46 2020/7/13
     **/
    public static class permutation {
        public ArrayList<String> Permutation(String str) {
            if (str == null || str.length() == 0) {
                return new ArrayList<String>();
            }
            char[] array = str.toCharArray();
            ArrayList<String> res = new ArrayList<>(); // ���ؽ��
            solve(array, 0, res, array.length); // �õ��ַ���ȫ����
            res = new ArrayList<>(new HashSet<>(res)); // ȥ��
            Collections.sort(res); // ���ֵ�������
            return res;
        }

        // �õ��ַ�����ȫ����
        private void solve(char[] array, int index, ArrayList<String> res, int length) {
            if (index == length) { // ��ǰ���λ��Ϊ���������һλ
                String s = changeToString(array); // ���ַ�����ת���ַ���
                res.add(s); // ����ǰ�ַ������з�ʽ�浽res
            } else {
                for (int i = index; i < length; i++) {
                    swap(array, index, i); // �����õ�indexλ�ÿ��ܳ��ֵ��ַ����ܲ��������
                    solve(array, index + 1, res, length);
                    swap(array, index, i); // ����һ�λ���һ�Σ�����Ͳ���indexλ�õ�ȫ����
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
     * @Description //TODO ��ָOffer28�������г��ִ�������һ�������
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
     * @Description //TODO ��ָOffer29����С��K����
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
            // ð������O(N^2)(�ȶ�)
            for (int i = input.length; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (input[j] < input[j + 1]) {
                        int help = input[j];
                        input[j] = input[j + 1];
                        input[j + 1] = help;
                    }
                }
            }
            // ѡ������O(N^2)�����ȶ���
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
            // ��������O(N^2)���ȶ���
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
     * @Description //TODO ��ָOffer30�����������������
     * @Author ZX
     * @Date 10:04 2020/7/14
     **/
    public static class findGreatestSumOfSubArray {
        // ������O(N^3)
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
                curSum = curSum < 0 ? 0 : curSum; // curSum���С��0����ǰλ�ò�����������ۼӺ����������벿�֣��Ӹ�λ�������¼����ۼӺ�
            }
            return max;
        }
    }

    /**
     * @Description //TODO ��ָOffer31��������1���ֵĴ�������1��n������1���ֵĴ�����
     * @Author ZX
     * @Date 11:01 2020/7/14
     **/
    public static class numberOf1Between1AndN_Solution {
        // ������
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

        // �ֶΣ���λ + ����λ
        public int NumberOf1Between1AndN_Solution2(int n) {
            if (n == 0) {
                return 0;
            }

            int ans = 0;

            String str = "" + n; // ��nת��Ϊ�ַ���
            int len = str.length(); // n��λ��
            if (len == 1) {
                return 1;
            }
            int res = (int) Math.pow(10, len - 1); // ��λ���ݼ�
            int firstBit = n / res; // ��λ�ϵ���
            //int firstBit = str.charAt(0) - '0';
            int otherBit = n % res; // ������λ������λ��ɵ���
            ans = firstBit == 1 ? (otherBit + 1) : res; // ֻ����λ����1�ĸ���
            ans += firstBit * (len - 1) * Math.pow(10, len - 1 - 1); // ������λ������λ��ɵ���1���ֵĴ���(firstBit * ʣ�µ�N-1��λ�ö�������1 * ʣ�µ�N-2��λ�ø���10��ѡ��)
            return ans + NumberOf1Between1AndN_Solution2(otherBit);
        }
    }

    /**
     * @Description //TODO ��ָOffer32���������ųɳ���С����
     * @Author ZX
     * @Date 15:21 2020/7/17
     **/
    public static class printMinNum {
        // ����1���ҳ�����ƴ�ӵ���ʽ -> ��С�������� -> ���ص�һ��
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

        // �ҵ����������ʽ
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

        // ����ת�ַ���
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


        // ����2���Զ���Ƚ���
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
     * @Description //TODO ��ָOffer33:����
     * ˼·��һ������һ������һ����������2���߳���3���߳���5�õ�
     * ����ά����������
     * û�б�Ҫά���������У�ֻ��Ҫ��¼����ָ����ʾ������һ��
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
            int index1 = 0; // ��2
            int index2 = 0; // ��3
            int index3 = 0; // ��5
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
     * @Description //TODO ��ָOffer34:��һ��ֻ����һ�ε��ַ�
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
     * @Description //TODO ��ָOffer35:�����е������
     * @Author ZX
     * @Date 19:54 2020/7/17
     **/
    public static class InversePairs {
        public int InversePairs(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            return (int) (part(array, 0, array.length - 1) % 1000000007); // ��������Ϊ������
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
     * @Description //TODO ��ָOffer36:��������ĵ�һ���������
     * @Author ZX
     * @Date 21:00 2020/7/17
     **/
    public static class findFirstCommonNode {
        // �����޻�������ཻ����
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
            if (cha > 0) { // pHead1�ϳ�
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
            } else { // pHead2�ϳ�
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
     * @Description //TODO ��ָOffer37�����������������г��ֵĴ���
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
     * @Description //TODO ��ָOffer38�������������
     * @Author ZX
     * @Date 11:25 2020/7/18
     **/
    public static class treeDepth {
        // ����1������
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

        // ����2���ݹ�
        public int TreeDepth2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(TreeDepth2(root.left), TreeDepth2(root.right)) + 1;
        }
    }

    /**
     * @Description //TODO ��ָOffer39��ƽ�������
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
     * @Description //TODO ��ָOffer40��������ֻ����һ�ε�����
     * @Author ZX
     * @Date 16:10 2020/7/18
     **/
    public static class findNumsAppearOnce {
        // ����1��ʹ��mapͳ��ÿ�������ֵĴ���
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

        // ����2����HashSet
        public void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : array) {
                if (!set.add(num)) { // set.add()���������ã��������ж��Ƿ�ӹ�
                    set.remove(num);
                }
            }
            Object[] res = set.toArray();
            num1[0] = (int) res[0];
            num2[0] = (int) res[1];
        }

        // ����3�����ȥ��
        public int[] singleNumber(int[] nums) {
            int bit = 0; // 0����κ������Ǹ�������
            for (int num : nums) {
                bit ^= num; // ����bit������ֻ����һ�ε����������
            }
            // �����������ֻ��һ��1�����ﱣ��������е�һ��1��������λΪ1��һ�飬��Ϊ1��һ��ֱ����
            bit = bit & -bit;
            int[] res = {0, 0}; // ���ؽ��
            for (int num : nums) { // ����ֱ����
                if ((num & bit) != 0) { // Ϊ1��һ��
                    res[0] ^= num;
                } else { // ��Ϊ1��һ��
                    res[1] ^= num;
                }
            }
            return res;
        }
    }

    /**
     * @Description //TODO ��ָOffer41����ΪS��������������
     * @Author ZX
     * @Date 21:00 2020/7/18
     **/
    public static class findContinuousSequence {
        // ����1���������
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

        // ����2��˫ָ��
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
     * @Description //TODO ��ָOffer42����ΪS����������
     * @Author ZX
     * @Date 19:48 2020/7/18
     **/
    public static class findNumbersWithSum {
        // ����1��������
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

        // ����2��˫ָ��
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
     * @Description //TODO ��ָOffer43������ת�ַ���
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
     * @Description //TODO ��ָOffer44����ת��������
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

        // ţ��
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
     * @Description //TODO ��ָOffer45���˿���˳��
     * @Author ZX
     * @Date 15:35 2020/7/19
     **/
    public static class IsContinuous {
        public boolean isContinuous(int[] nums) {
            if (nums == null || nums.length == 0)
                return false;
            Arrays.sort(nums); // ����ͳ�ƿ�ȱλ�ó��ָ���
            // ͳ��nums��0�ĸ�����ɾ��0��nums��ֻ���·�0�����֣�ͳ�ƿ�ȱλ�ø���ʱ��0���ò��룩
            int zeroNums = 0;
            int[] noZeroNums = new int[nums.length]; // ɾ��0���nums
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
            // ͳ��nums�п�ȱλ�õĸ���
            int spaceNums = 0;
            int pre = noZeroNums[0];
            for (int i = 1; i < noZeroNums.length - zeroNums; i++) {
                if (noZeroNums[i] == pre) { // ������ͬ�ƣ��Ͳ�������˳��
                    return false;
                }
                if (noZeroNums[i] - pre > 1) {
                    spaceNums += noZeroNums[i] - pre - 1;
                }
                pre = noZeroNums[i];
            }
            return zeroNums >= spaceNums || spaceNums == 0; // ��С�������ڵ��ڿ�ȱλ���� || nums�������˳��
        }
    }

    /**
     * @Description //TODO ��ָOffer46��ԲȦ��������µ���
     * @Author ZX
     * @Date 16:43 2020/7/19
     **/
    public static class LastRemaining {
        // ����1����ArrayListģ��ɾ������
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

        // ����2�������һ�ַ���
        public int lastRemaining(int n, int m) {
            int ans = 0;
            // �����һ�֣�ʣ��������ʱ����������ʣ�µ�����
            for (int i = 2; i <= n; i++) {
                ans = (ans + m) % i; // ��һ���е�λ�� = ����ǰλ�� + m�� % ��һ��ʣ�µĸ���
            }
            return ans;
        }
    }

    /**
     * @Description //TODO ��ָOffer47����1+2+3+...+n
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
     * @Description //TODO ��ָOffer48�����üӼ��˳�����a + b
     * ˼·
     * �����ǽ�λ��num1 = a ^ b
     * ֻ���ǽ�λ�� num2 = (a & b) << 1
     * ����
     * a + b = num1 + num2��ѭ����num1��num2��ֱ��num2Ϊ0��û�н�λʱ��
     * @Author ZX
     * @Date 20:31 2020/7/19
     **/
    public static class addAandB {
        public int add(int a, int b) {
            while (b != 0) {
                int c = (a & b) << 1;
                a = a ^ b; // �����ǽ�λ
                b = c; // ֻ���ǽ�λ
            }
            return a;
        }
    }

    /**
     * @Description //TODO ��ָOffer49���ַ���ת����
     * @Author ZX
     * @Date 20:37 2020/7/20
     **/
    public static class StringToInt {
        // ţ��
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
     * @Description //TODO ��ָOffer50���������ظ�������
     * @Author ZX
     * @Date 20:45 2020/7/20
     **/
    public static class Duplicate {
        // Parameters:
        //    numbers:     an array of integers
        //    length:      the length of array numbers
        //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
        //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
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
     * @Description //TODO ��ָOffer51�������˻�����
     * @Author ZX
     * @Date 21:44 2020/7/20
     **/
    public static class Multiply {
        // ʱ�临�Ӷȹ���
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

        // ����0 ~ index-1�����˻�
        private int left(int[] A, int index) {
            int ans = 1;
            for (int i = 0; i < index; i++) {
                ans *= A[i];
            }
            return ans;
        }

        // ����index+1 ~ A.length-1�����˻�
        private int right(int[] A, int index) {
            int ans = 1;
            for (int i = index + 1; i < A.length; i++) {
                ans *= A[i];
            }
            return ans;
        }

        // leecode����ͨ��
        public int[] multiply2(int[] A) {
            // base case
            if (A == null || A.length == 0)
                return new int[]{};

            int len = A.length;
            int[] leftMultiply = new int[len]; // ��¼�����Լ���ߵ����˻�
            int[] rightMultiply = new int[len]; // ��¼�����Լ��ұߵ����˻�
            leftMultiply[0] = rightMultiply[len - 1] = 1; // ��������λ��

            // ��¼ÿһ��iλ����ߵ����˻�
            for (int i = 1; i < len; i++) {
                leftMultiply[i] = A[i - 1] * leftMultiply[i - 1];
            }
            // ��¼ÿһ��iλ���ұߵ����˻�
            for (int i = len - 2; i >= 0; i--) {
                rightMultiply[i] = A[i + 1] * rightMultiply[i + 1];
            }
            int[] B = new int[len];
            // ����B[i] = i��ߵ����˻�lefts[i] * i�ұߵ����˻�rights[i]
            for (int i = 0; i < len; i++) {
                B[i] = leftMultiply[i] * rightMultiply[i];
            }

            return B;
        }
    }

    /**
     * @Description //TODO ��ָOffer52��������ʽƥ��
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
                    //�ֳɿ�����ͷǿ���������
                    if (j == 0) {
                        f[i][j] = i == 0;
                    } else {
                        //�ǿ������Ϊ������� * �� ��*
                        if (B.charAt(j - 1) != '*') {
                            if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) ||
                                    B.charAt(j - 1) == '.')) {
                                f[i][j] = f[i - 1][j - 1];
                            }
                        } else {
                            //���� * �ˣ���Ϊ���Ͳ����������
                            //����
                            if (j >= 2) {
                                f[i][j] |= f[i][j - 2];
                            }
                            //��
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
     * @Description //TODO ��ָOffer53����ʾ��ֵ���ַ���
     * @Author ZX
     * @Date 19:05 2020/7/21
     **/
    public static class IsNumeric {
        public boolean isNumeric(char[] str) {
            // ��Ƿ��š�С���㡢e�Ƿ���ֹ�
            boolean sign = false, decimal = false, hasE = false;
            for (int i = 0; i < str.length; i++) {
                if (str[i] == 'e' || str[i] == 'E') {
                    if (i == str.length - 1) return false; // e����һ��Ҫ������
                    if (hasE) return false;  // ����ͬʱ��������e
                    hasE = true;
                } else if (str[i] == '+' || str[i] == '-') {
                    // �ڶ��γ���+-���ţ�����������e֮��
                    if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                    // ��һ�γ���+-���ţ��Ҳ������ַ�����ͷ����Ҳ���������e֮��
                    if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                    sign = true;
                } else if (str[i] == '.') {
                    // e���治�ܽ�С���㣬С���㲻�ܳ�������
                    if (hasE || decimal) return false;
                    decimal = true;
                } else if (str[i] < '0' || str[i] > '9') // ���Ϸ��ַ�
                    return false;
            }
            return true;
        }
    }

    /**
     * @Description //TODO ��ָOffer54���ַ����е�һ�����ظ����ַ�
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
     * @Description //TODO ��ָOffer55�������л�����ڽڵ�
     * @Author ZX
     * @Date 19:08 2020/7/21
     **/
    public static class entryNodeOfLoop {
        public ListNode EntryNodeOfLoop(ListNode pHead) {
            // ����ڵ���С��3�������ܳɻ�
            if (pHead == null || pHead.next == null || pHead.next.next == null)
                return null;
            ListNode slow = pHead; // ��ָ��һ����һ��
            ListNode fast = pHead; // ��ָ�뿪ʼһ��������
            while (slow.next != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow.equals(fast)) { // ����ָ������ʱ����ѭ��������һ����
                    break;
                }
            }
            if (fast == null) { // �����ָ���ߵ�ͷ��û������ָ���������������޻�
                return null;
            }
            fast = pHead; // ����ڶ��׶Σ���ָ��ص�����ͷ�ڵ㣬���Ҹ�Ϊһ����һ��
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow; // �졢��ָ���ٴ�����ʱ����Ϊ��һ���뻷�Ľڵ�
        }
    }

    /**
     * @Description //TODO ��ָOffer56��ɾ���������ظ��Ľڵ�
     * 1.ȷ��ɾ���ظ��ڵ��������ͷ�ڵ�ans
     * 2.��ans�������β�����ж�ÿһ���ڵ��Ƿ�Ϊ�ظ��ڵ㣬�ǵĻ�������
     * // ţ�ͣ�1 -> 2 -> 2 -> 3 -> 4 -> 4 -> 5 ɾ���� 1 -> 3 -> 5
     * // leecode��1 -> 2 -> 2 -> 3 -> 4 -> 4 -> 5 ɾ���� 1 -> 2 -> 3 -> 4 -> 5
     * @Author ZX
     * @Date 19:15 2020/7/21
     **/
    public static class DeleteDuplication {
        // ţ��
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null || pHead.next == null)
                return pHead;
            // �ҵ�ɾ���ظ��ڵ��������ͷ�ڵ�
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
            if (ans == null) { // pHeadΪͷ���������нڵ�ֵ�����
                return null;
            }
            // �ж�ans֮��Ľڵ��Ƿ��ظ������ظ���������
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
            // �ҵ�ɾ���ظ��ڵ�֮����������ͷ�ڵ�ans
            ListNode ans = head;
            while (ans != null) {
                if (ans.next != null && ans.val == ans.next.val) {
                    ans = ans.next;
                } else {
                    break; // ��ʱans�����µ�ͷ�ڵ�
                }
            }
            if (ans == null) {
                return null;
            }
            // �ж�ans����Ľڵ��Ƿ����ظ��ģ��ظ���ɾ����������
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
     * @Description //TODO ��ָOffer57������������һ���ڵ�
     * @Author ZX
     * @Date 21:39 2020/7/22
     **/
    public static class getNext {
        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if (pNode == null)
                return null;
            // ���1��pNode�Һ��Ӳ�Ϊ�գ�pNode����һ���ڵ�����������������Ľڵ�
            if (pNode.right != null) {
                TreeLinkNode cur = pNode.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                return cur;
            }
            if (pNode.next == null) // ���2��pNode���Һ���Ϊ�յĸ��ڵ�
                return null;
            // ���3��pNode���丸�ڵ�����ӣ�pNode����һ���ڵ����丸�ڵ�
            if (pNode.next.left == pNode) {
                return pNode.next;
            } else if (pNode.next.right == pNode) { // ���4��pNode���丸�ڵ���Һ��ӣ�pNode����һ���ڵ����丸�ڵ�ĸ��ڵ�
                if (pNode.next.next.right == pNode.next) { // ���5��pNode��������������һ���ڵ㣨�ж�pNode�ĸ��ڵ��ǲ���pNode�ĸ��ڵ�ĸ��ڵ���Һ��ӣ�
                    return null;
                }
                return pNode.next.next;
            }
            return null;
        }
    }

    /**
     * @Description //TODO ��ָOffer58���ԳƵĶ�����
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
     * @Description //TODO ��ָOffer59��֮���δ�ӡ������
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
            int sum = 1; // ��ʼ����ǰ��ڵ�ĸ���
            int flag = 1; // ż���ʹ��������ӡ
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int temp = 0; // ��һ��ڵ�ĸ���
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
                if (flag % 2 == 0) { // ż�����������棺����list
                    for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
                        int res = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, res);
                    }
                }
                flag++;
                ans.add(list);
                sum = temp; // ���µ�ǰ��Ľڵ���
            }
            return ans;
        }
    }

    /**
     * @Description //TODO ��ָOffer60���Ѷ�������ӡ�ɶ���
     * @Author ZX
     * @Date 21:30 2020/7/23
     **/
    public static class print {
        ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            if (pRoot == null) return new ArrayList<>();
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(pRoot);
            int num = 1; // ��ʼ����ǰ��Ľڵ���
            while (!queue.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                int temp = 0; // ��һ��Ľڵ���
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
                num = temp; // ���µ�ǰ��Ľڵ����
                ans.add(list);
            }
            return ans;
        }

        /**
         * @Description //TODO ��ָOffer61�������������л������л�
         * @Author ZX
         * @Date 16:03 2020/7/24
         **/
        public static class Serialization {
            // ���л�
            String Serialize(TreeNode root) {
                if (root == null)
                    return "#_";
                String res = root.val + "_";
                res += Serialize(root.left);
                res += Serialize(root.right);
                return res;
            }

            // �����л�
            TreeNode Deserialize(String str) {
                String[] strs = str.split("_");
                LinkedList<String> queue = new LinkedList<>();
                for (String s : strs) {
                    queue.add(s);
                }
                return rebuild(queue);
            }

            // �����л�����
            private TreeNode rebuild(LinkedList<String> queue) {
                String value = queue.poll();
                if (value.equals("#")) // �սڵ�
                    return null;
                TreeNode node = new TreeNode(Integer.valueOf(value));
                node.left = rebuild(queue);
                node.right = rebuild(queue);
                return node;
            }
        }

        /**
         * @Description //TODO ��ָOffer62�������������ĵ�K��ڵ�
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
         * @Description //TODO ��ָOffer63���������е���λ��
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

            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // С����
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new myComparator()); // �����

            public void Insert(Integer num) {
                if ((minHeap.size() + maxHeap.size()) % 2 == 0) { // ������������ż������num�������
                    maxHeap.add(num);
                    // ����ѶѶ�Ԫ�ش���С���ѶѶ�Ԫ�أ��Ѷ�����
                    if (!minHeap.isEmpty() && (maxHeap.peek() > minHeap.peek())) {
                        int help = maxHeap.poll();
                        maxHeap.add(minHeap.poll());
                        minHeap.add(help);
                    }
                } else { // ��������������������num��С����
                    minHeap.add(num);
                    // С���ѶѶ�Ԫ��С�ڴ���ѶѶ�Ԫ�أ��Ѷ�����
                    if (!maxHeap.isEmpty() && (minHeap.peek() < maxHeap.peek())) {
                        int help = minHeap.poll();
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(help);
                    }
                }
            }

            public Double GetMedian() {
                // ��ǰ������һ��ż����������λ���Ǵ�С���ѶѶ�Ԫ��֮�ͳ���2
                if ((minHeap.size() + maxHeap.size()) % 2 == 0) {
                    return (((double) minHeap.peek() + (double) maxHeap.peek()) / 2);
                } else { // ��ǰ������һ��������������λ���Ǵ���ѶѶ�Ԫ��
                    return (double) maxHeap.peek();
                }
            }
        }

        /**
         * @Description //TODO ��ָOffer64���������ڵ����ֵ
         * @Author ZX
         * @Date 21:15 2020/7/24
         **/
        public static class maxInWindow {
            public ArrayList<Integer> maxInWindows(int [] num, int size){
                if(num == null || size == 0) return new ArrayList<>();
                // ά��һ�������ң���ͷ��β���±��Ӧ��ֵ�����ݼ��Ķ���
                LinkedList<Integer> queue = new LinkedList<>();
                ArrayList<Integer> ans = new ArrayList<>(); // ����ÿ�����ڵ����ֵ
                for(int i = 0; i < num.length; i++) {
                    // ���ڼ�����������βԪ�ض�Ӧ��ֵ������ӵ�ֵʱ��ӣ����򵯳���βԪ�أ�ֱ�������������
                    while(!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                        queue.pollLast();
                    }
                    queue.add(i);
                    // ���ڼ������� i-����Ԫ�� == k ʱ����Ԫ�س���
                    if(i - queue.peekFirst() == size) {
                        queue.pollFirst();
                    }
                    // �����ڳ��ȵ���sizeʱ��¼����Ԫ�ض�Ӧ��ֵ������ǰ���ڵ����ֵ
                    if(i >= size - 1) {
                        ans.add(num[queue.peekFirst()]);
                    }
                }
                return ans;
            }
        }
        
        /**
         * @Description //TODO ��ָOffer65�������е�·��
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
                boolean[][] flag = new boolean[height][width]; // ����Ƿ��߹���false��û�߹���
                char[] aim = word.toCharArray();
                // ������ά���飬�ж���ÿ��λ��Ϊ����Ƿ����ƥ���·��
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        // �ж���board[i][j]Ϊ����Ƿ����ƥ���·��
                        if (judge(board, flag, i, j, 0, aim)) {
                            return true;
                        }
                    }
                }
                return false;
            }

            private boolean judge(char[][] board, boolean[][] flag,
                                  int i, int j, int k, char[] aim) { // k��aim���������
                // Խ�� || ��ǰλ�ò�ƥ�� || ��ǰλ���Ѿ��߹�
                if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                        || board[i][j] != aim[k] || flag[i][j])
                    return false;
                flag[i][j] = true; // ��ǵ�ǰλ���Ѿ��߹�
                // �ߵ��˴�˵��board[i][j]��aim[k]��ƥ���
                if (k == aim.length - 1) // ���һ���ַ�ƥ��ɹ� -> �ݹ���ֹ -> �ҵ�·��
                    return true;
                // ��ǰλ��ƥ��ɹ����жϵ�ǰλ�õ����������Ƿ������aim[k + 1]λ��ƥ�䣬����оͼ����ݹ�Ѱ����	  // һ����ǰλ�õ����������Ƿ������aim[k + 1]λ��ƥ��...
                if (judge(board, flag, i + 1, j, k + 1, aim)
                        || judge(board, flag, i - 1, j, k + 1, aim)
                        || judge(board, flag, i, j + 1, k + 1, aim)
                        || judge(board, flag, i, j - 1, k + 1, aim))
                    return true;
                flag[i][j] = false; // ����ifƥ��ʧ�ܣ����߹���λ�û���Ϊû�߹�
                return false; // �Ե�ǰi��jΪ���ƥ��ʧ�ܡ��ж�board����һ��λ��Ϊ����Ƿ����ƥ��ɹ�
            }

            // ţ��
            public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
                // һά����ת��ά����
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
                boolean[][] flag = new boolean[height][width]; // ����Ƿ��߹���false��û�߹���
                // ������ά����
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
         * @Description //TODO ��ָOffer66�������˵��˶���Χ
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
                // Խ�� || ��ǰλ���߹��� || x,y������λ֮�ʹ���threshold
                if(x < 0 || x >= rows || y < 0 || y >= cols
                        || m[x][y] || calcu(x, y) > threshold)
                    return;
                m[x][y] = true; // ��ǰλ�ÿ�����
                ans++;
                solve(threshold, rows, cols, m, x + 1, y);
                solve(threshold, rows, cols, m, x - 1, y);
                solve(threshold, rows, cols, m, x, y + 1);
                solve(threshold, rows, cols, m, x, y - 1);
            }
            // ����num1��num2����λ֮��
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
         * @Description //TODO ��ָOffer67��������
         * @Author ZX
         * @Date 21:03 2020/7/26
         **/
        public static class CutRope {
            public int cutRope(int n) {
                // n<=3�������m>1����Ҫ�ֶ�
                // ���磺3����ֳ�1��2��1��1��1 ��n=3���ֶγ˻���2,
                if(n==2)
                    return 1;
                if(n==3)
                    return 2;
                int[] dp = new int[n+1];
                /*
                ����3����n>=4���������n<=3��ͬ��4���Էֺܶ�Σ�����ֳ�1��3��
                �����3���Բ���Ҫ�ٷ��ˣ���Ϊ3�ֶ�����2�����־���3����¼���ġ�
                */
                dp[1]=1;
                dp[2]=2;
                dp[3]=3;
                int res=0;//��¼����
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
