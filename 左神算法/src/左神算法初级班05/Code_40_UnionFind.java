package �����㷨������05;
/**
 * ���鼯�ṹ
 */
import java.util.HashMap;
import java.util.List;

public class Code_40_UnionFind {
    public static class Node {
        // whatever you like
    }

    public static class UnionFindSet {
        // Key : chile , value : father,һ��һ��������
        public HashMap<Node, Node> fatherMap;
        // Node���ڵļ���һ����Integer��ֵ
        public HashMap<Node, Integer> sizeMap;

        /**
         * ��ʼ�������û�������������
         */
        public UnionFindSet(List<Node> nodes) {
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes) {
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
            for (Node node : nodes) {
                // ��nodes�е�ÿ���ڵ�node�������ŵ�һ��������,����ÿ��node�����Լ��ĸ��ڵ�
                fatherMap.put(node, node);
                sizeMap.put(node, 1); // ÿ������Ԫ������Ϊ1
            }
        }

        /**
         * ����2�����ҽڵ�node�Ĵ���ڵ�
         * �Ż�����node��node�ĸ��ڵ�ֱ����������ڵ��ϣ��������Ż������ƽ
         * @param node ����ڵ�
         * @return ����ڵ㼯�ϵĴ���ڵ�
         */
        private Node findHead(Node node) {
            // �ҵ�node�ĸ��ڵ�
            Node father = fatherMap.get(node);
            // ���node�ĸ��ڵ㲻���Լ�
            if (father != node) {
                // ������node���ڵ�ĸ��ڵ㣬һֱ�鵽�������ϵĴ���ڵ�
                father = findHead(father);
            }
            // �Ż�����nodeֱ����������ڵ���
            fatherMap.put(node, father);
            return father; // ���ش˼��ϵĴ���ڵ�
        }

        /**
         * �ж�Ԫ��a,b�Ƿ���һ������
         * @param a
         * @param b
         * @return
         */
        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        /**
         * ��Ԫ��a, b���ڼ��Ϻϲ�
         * @param a
         * @param b
         */
        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            // �ֱ��ҵ�a, b �Ĵ���ڵ�
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead) { // ���a, b����һ������
                int aSetSize= sizeMap.get(aHead); // a���ڼ��ϵ�Ԫ�ظ���
                int bSetSize = sizeMap.get(bHead); // b���ڼ��ϵ�Ԫ�ظ���
                if (aSetSize <= bSetSize) { // ���a���ڼ���Ԫ������С
                    fatherMap.put(aHead, bHead); // ��a���ϵĴ���ڵ�ĸ��ڵ���Ϊb���ϵĴ���ڵ�
                    sizeMap.put(bHead, aSetSize + bSetSize); // b���ϵ�Ԫ�ظ��� = aSetSize + bSetSize
                } else { // ���b���ڼ���Ԫ������С
                    fatherMap.put(bHead, aHead); // b��������a������
                    sizeMap.put(aHead, aSetSize + bSetSize); // a����Ԫ�ظ������
                }
            }
        }

    }

    public static void main(String[] args) {

    }
}
