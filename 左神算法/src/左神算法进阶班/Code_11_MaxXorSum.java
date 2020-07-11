package �����㷨���װ�;

/**
 * @Description: //TODO ��������������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/2 19:54
 */
public class Code_11_MaxXorSum {

    // �����⣺O(N^3)
    public static int maxXorSum1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int start = 0; start <= i; start++) {
                int res = 0;
                for (int k = start; k <= i; k++) {
                    res ^= arr[k];
                }
                max = Math.max(max, res);
            }
        }
        return max;
    }

    // �Ż���ı����⣺O(N^2)
    public static int maxXorSum2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i]; // 0 ~ i�������
            max = Math.max(max, eor);
            for (int start = 1; start <= i; start++) {
                int startToIEor = eor ^ dp[start - 1]; // startToIEOR��start ~ i�������
            }
            dp[i] = eor;
        }
        return max;
    }

    // ����ǰ׺����O(N)
    public static int maxXorSum3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int eor = 0;
        NumTrie numTrie = new NumTrie();
        numTrie.add(0);
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i]; // 0 ~ i�������
            max = Math.max(max, numTrie.maxXor(eor)); // ѡ��0 ~ i�������������
            numTrie.add(eor);
        }
        return max;
    }

    //ǰ׺���ڵ�
    public static class Node {
        public Node[] nexts = new Node[2];//ֻ������·��0/1
    }

    //ǰ׺��
    public static class NumTrie {
        public Node head = new Node();

        public void add(int num) {
            Node cur = head;
            //λ�ƣ�������31λ
            for (int move = 31; move >= 0; move--) {
                //��ȡ��ÿ���������������
                //���磺0101 >> 3 = 0
                //�ں�1����������
                //0 0 0 0
                //0 0 0 1
                //0 0 0 0 //ȡ���˵�һλΪ0
                int path = ((num >> move) & 1);
                //�鿴�Ƿ���·��û�о��½�
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
                cur = cur.nexts[path];
            }
        }

        //num��0~i���������ѡ�������ٷ���
        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                int path = (num >> move) & 1;
                //����������λϣ����path��һ���� 1^1=0 0^0=0
                //����λ�ã�ϣ�����෴�� 1^0=1 0^1=1
                int best = move == 31 ? path : (path ^ 1);//�ڴ�
                best = cur.nexts[best] != null ? best : (best ^ 1);//ʵ��
                //��ǰλ������ѡ�����Ƶ�ǰλ����ֵ�󣬼�����(��һ��)
                res |= (path ^ best) << move;//����ÿһλ�Ĵ�
                cur = cur.nexts[best];//��һ��
            }
            return res;
        }
    }

}
