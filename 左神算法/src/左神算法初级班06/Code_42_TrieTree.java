package �����㷨������06;
/**
 * ǰ׺��
 */
public class Code_42_TrieTree {
    /**
     * ǰ׺���ڵ�ṹ
     */
    public static class TrieNode {
        public int path; // �ж��ٸ��ַ�����������·��
        public int end; // �ж��ٸ��ַ���������ڵ��β
        public TrieNode[] nexts; // ���ڵ�·������
        //��ʼ��
        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26]; // Ĭ��26��·��26��Ӣ����ĸ��
        }
    }

    public static class Trie {
        private TrieNode root; // �������ڵ�
        // ��ʼ��
        public Trie() {
            root = new TrieNode();
        }

        /**
         * ����һ���ַ�word
         * @param word
         */
        public void insert(String word) {
            // base case
            if (word == null) {
                return;
            }

            char[] chs = word.toCharArray(); // �����ַ�ת���ַ�����������
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a'; // ASCII��������index��0����chs[i]Ϊa....
                if (node.nexts[index] == null) { // ��ǰnode��û������chs[i]��·
                    node.nexts[index] = new TrieNode(); // ���û�У�������
                }
                // ������ж���һ���ڵ�
                node = node.nexts[index]; // node����chs[i]��
                node.path++; // ����3
            }
            node.end++; // ����2
        }

        /**
         * ɾ��һ���ַ�word
         * ˼·����ô�������ôɾ����
         * @param word
         */
        public void delete(String word) {
            if (search(word) != 0) { // ���word���ڣ����б�Ҫ����ɾ��
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].path == 0) { // �ڵ��·��Ϊ0����˽ڵ����Ϊnull
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        /**
         * ���ַ�word�����˼���
         * ˼·����ô�������ô�顣�ҵ����ַ���end������end��������
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
         * ����preΪǰ׺���ַ�������
         * @param pre
         * @return path��������
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
