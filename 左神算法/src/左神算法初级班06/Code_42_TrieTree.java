package 左神算法初级班06;
/**
 * 前缀树
 */
public class Code_42_TrieTree {
    /**
     * 前缀树节点结构
     */
    public static class TrieNode {
        public int path; // 有多少个字符串到达过这个路径
        public int end; // 有多少个字符串以这个节点结尾
        public TrieNode[] nexts; // 根节点路的条数
        //初始化
        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26]; // 默认26条路（26个英文字母）
        }
    }

    public static class Trie {
        private TrieNode root; // 创建根节点
        // 初始化
        public Trie() {
            root = new TrieNode();
        }

        /**
         * 插入一个字符word
         * @param word
         */
        public void insert(String word) {
            // base case
            if (word == null) {
                return;
            }

            char[] chs = word.toCharArray(); // 将此字符转成字符串类型数组
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a'; // ASCII相减，如果index是0，则chs[i]为a....
                if (node.nexts[index] == null) { // 当前node有没有走向chs[i]的路
                    node.nexts[index] = new TrieNode(); // 如果没有，建出来
                }
                // 如果有判断下一个节点
                node = node.nexts[index]; // node跳到chs[i]上
                node.path++; // 功能3
            }
            node.end++; // 功能2
        }

        /**
         * 删除一个字符word
         * 思路：怎么插入的怎么删除。
         * @param word
         */
        public void delete(String word) {
            if (search(word) != 0) { // 如果word存在，才有必要进行删除
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].path == 0) { // 节点的路径为0，则此节点后面为null
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        /**
         * 找字符word插入了几次
         * 思路：怎么插入的怎么查。找到该字符的end，返回end的数据项
         * @param word
         * @return
         */
        public int search(String word) {
            // base case
            if (word == null) {
                return 0;
            }

            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        /**
         * 查以pre为前缀的字符串数量
         * @param pre
         * @return path的数据项
         */
        public int prefixNumber(String pre) {
            // base case
            if (pre == null) {
                return 0;
            }

            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));
    }
}
