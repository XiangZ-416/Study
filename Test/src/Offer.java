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
            for (int i= 1; i < sums.length; i++) {
                if(sums[i] > max) {
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
     * @Description //TODO ��ָOffer19��˳ʱ���ӡ����
     * @Author ZX
     * @Date 16:52 2020/7/10
     **/
    public static class PrintMatrix {
        public static ArrayList<Integer> printMatrix(int [][] matrix) {
            if (matrix == null) {
                return null;
            }

            int Lx = 0, Ly = 0; //  ���Ͻ�x,y
            int Rx = matrix.length - 1, Ry = matrix[0].length - 1; // ���½�x,y

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
     * @Description //TODO ��ָOffer20������min��ջ
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
     * @Description //TODO ��ָOffer21��ջ��ѹ�롢��������
     *                                       ��˼·������һ��������ջ������ѹջ˳���Ƚ���һ������ջ�У�������1��Ȼ���ж�ջ��Ԫ���ǲ��ǳ�ջ˳��ĵ�һ��Ԫ�أ�
     *                                       ������4������Ȼ1��4���������Ǽ���ѹջ��ֱ������Ժ�ʼ��ջ����ջһ��Ԫ�أ��򽫳�ջ˳������ƶ�һλ��ֱ������ȣ�
     *                                       ����ѭ����ѹջ˳�������ɣ��������ջ����Ϊ�գ�˵���������в��Ǹ�ջ�ĵ���˳��
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
     * @Description //TODO ��ָOffer22���������´�ӡ������
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
     * @Description //TODO ��ָOffer23�������������ĺ����������
     *                                         ˼·��1.�����һ����end���������л���Ϊ���ڲ���maxList��С�ڲ���minList
     *                                               2.�ҵ�С�ڡ���������ĵ�һ��λ�÷ֱ���minIndex��maxIndex
     *                                               3.���maxList��minList������
     *                                                      minIndex��maxIndex����ߣ�����false��
     *                                                      maxIndex֮���б�endС����������false��
     *                                               4.�ݹ��ж�maxList��minList��ͬʱΪtrue�������շ���true
     * @Author ZX
     * @Date 11:05 2020/7/11
     **/
    public static class verifySquenceOfBST {
        public boolean VerifySquenceOfBST(int [] sequence) {
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
            if(root == null) {
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
            if(node == null) {
                return;
            }
            sum += node.val;
            list.add(node.val);
            if(node.left == null && node.right == null && sum == target) {
                ArrayList<Integer> List = new ArrayList<>(list);
                res.add(List);
            }
            search(node.left, target, list, sum);
            search(node.right, target, list, sum);
            list.remove(list.size() - 1); // ���ݵ�ǰҶ�ڵ�
        }

        // ѡ������
        private void Sort(ArrayList<ArrayList<Integer>> res) {
            if (res == null ||res.size() < 2) {
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
            if(pHead == null) {
                return null;
            }
            Map<RandomListNode, RandomListNode> map = new HashMap<>();
            RandomListNode cur = pHead;
            while(cur != null) {
                map.put(cur, new RandomListNode(cur.label));
                cur = cur.next;
            }
            RandomListNode CUR = pHead;
            while(CUR != null) {
                map.get(CUR).next = map.get(CUR.next);
                map.get(CUR).random = map.get(CUR.random);
                CUR = CUR.next;
            }
            return map.get(pHead);
        }
    }

    /**
     * @Description //TODO ��ָOffer26��������������˫������
     *                                          ע�⣺LinkedList��ѯ��������ArrayList����queue�����������������
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
            if(root == null) {
                return null;
            }
            // ������������������нڵ�浽list
            ArrayList<TreeNode> nodes = new ArrayList<>();
            inOrder(root, nodes);
            TreeNode head = nodes.get(0);
            TreeNode pre = head;
            for(int i = 1; i < nodes.size(); i++) {
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
            if(node == null) {
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
        public int MoreThanHalfNum_Solution(int [] array) {
            if(array == null || array.length == 0) {
                return 0;
            }
            if (array.length == 1) {
                return array[0];
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < array.length; i++) {
                if(map.containsKey(array[i])) {
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
        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            if(input == null || input.length == 0 || k == 0 || k > input.length) {
                return new ArrayList<Integer>();
            }
            ArrayList<Integer> res = new ArrayList<>();
            // Arrays.sort(input);
            // ð������O(N^2)(�ȶ�)
            for(int i = input.length; i >= 0; i--) {
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
            for(int i = 0; i < k; i++) {
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
            if(array == null || array.length == 0) {
                return 0;
            }
            int max = Integer.MIN_VALUE;
            for(int start = 0; start < array.length; start++) {
                for(int end = start; end < array.length; end++) {
                    int sum = 0;
                    for(int i = start; i <= end; i++) {
                        sum += array[i];
                    }
                    max = Math.max(max, sum);
                }
            }
            return max;
        }

        // O(N)
        public int FindGreatestSumOfSubArray2(int[] array) {
            if(array == null || array.length == 0) {
                return 0;
            }
            int max = Integer.MIN_VALUE;
            int curSum = 0;
            for(int i = 0; i < array.length; i++) {
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
        public int NumberOf1Between1AndN_Solution(int n) {
            return  0;
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

    }
}
