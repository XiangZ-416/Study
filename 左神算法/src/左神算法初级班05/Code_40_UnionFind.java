package 左神算法初级班05;
/**
 * 并查集结构
 */
import java.util.HashMap;
import java.util.List;

public class Code_40_UnionFind {
    public static class Node {
        // whatever you like
    }

    public static class UnionFindSet {
        // Key : chile , value : father,一层一层往上找
        public HashMap<Node, Node> fatherMap;
        // Node所在的集合一共有Integer个值
        public HashMap<Node, Integer> sizeMap;

        /**
         * 初始化：将用户给的样本数据
         */
        public UnionFindSet(List<Node> nodes) {
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes) {
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
            for (Node node : nodes) {
                // 将nodes中的每个节点node都单独放到一个集合中,所以每个node都是自己的父节点
                fatherMap.put(node, node);
                sizeMap.put(node, 1); // 每个集合元素总数为1
            }
        }

        /**
         * 功能2：查找节点node的代表节点
         * 优化：将node及node的父节点直接连到代表节点上，将集合优化，变扁平
         * @param node 被查节点
         * @return 被查节点集合的代表节点
         */
        private Node findHead(Node node) {
            // 找到node的父节点
            Node father = fatherMap.get(node);
            // 如果node的父节点不是自己
            if (father != node) {
                // 继续找node父节点的父节点，一直查到整个集合的代表节点
                father = findHead(father);
            }
            // 优化：将node直接连到代表节点上
            fatherMap.put(node, father);
            return father; // 返回此集合的代表节点
        }

        /**
         * 判断元素a,b是否在一个集合
         * @param a
         * @param b
         * @return
         */
        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        /**
         * 将元素a, b所在集合合并
         * @param a
         * @param b
         */
        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            // 分别找到a, b 的代表节点
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead) { // 如果a, b不在一个集合
                int aSetSize= sizeMap.get(aHead); // a所在集合的元素个数
                int bSetSize = sizeMap.get(bHead); // b所在集合的元素个数
                if (aSetSize <= bSetSize) { // 如果a所在集合元素数量小
                    fatherMap.put(aHead, bHead); // 将a集合的代表节点的父节点设为b集合的代表节点
                    sizeMap.put(bHead, aSetSize + bSetSize); // b集合的元素个数 = aSetSize + bSetSize
                } else { // 如果b所在集合元素数量小
                    fatherMap.put(bHead, aHead); // b集合连到a集合上
                    sizeMap.put(aHead, aSetSize + bSetSize); // a集合元素个数变大
                }
            }
        }

    }

    public static void main(String[] args) {

    }
}
