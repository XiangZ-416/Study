package 左神算法进阶班;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @Description: //TODO 数据结构设计题
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/1 20:06
 */
public class Code_09_dataStructDesign {

    /**
     * @Description //TODO 设计可以变更的缓存结构（LRU内存替换算法）：map + 双向链表
     *                              最经常使用（put、get）的key留下；不经常使用的key替出去
     *                              删除先删优先级低的key
     * @Author ZX
     * @Date 20:10 200/7/1
     **/
    public static class LRUCache {

        Entry head, tail; // 哨兵节点
        int capacity;
        int size;
        Map<Integer, Entry> cache;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            // 初始化链表
            initLinkedList();
            size = 0;
            cache = new HashMap<>(capacity + 2);
        }

        public static class Entry {
            public Entry pre;
            public Entry next;
            public int key;
            public int value;

            public Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public Entry() {
            }
        }

        private void initLinkedList() {
            head = new Entry();
            tail = new Entry();

            head.next = tail;
            tail.pre = head;

        }

        /**
         * 如果节点不存在，返回 -1；如果存在，将节点移动到头结点，并返回节点的数据。
         * @param key
         * @return
         */
        public int get(int key) {
            Entry node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 存在移动节点
            moveToHead(node);
            return node.value;
        }

        /**
         * 将节点加入到头结点，如果容量已满，将会删除尾结点
         * @param key
         * @param value
         */
        public void put(int key, int value) {
            Entry node = cache.get(key);
            if (node != null) {
                node.value = value;
                moveToHead(node);
                return;
            }
            // 不存在。先加进去，再移除尾结点
            // 此时容量已满 删除尾结点
            if (size == capacity) {
                Entry lastNode = tail.pre;
                deleteNode(lastNode);
                cache.remove(lastNode.key);
                size--;
            }
            // 加入头结点
            Entry newNode = new Entry();
            newNode.key = key;
            newNode.value = value;
            addNode(newNode);
            cache.put(key, newNode);
            size++;

        }

        private void moveToHead(Entry node) {
            // 首先删除原来节点的关系
            deleteNode(node);
            addNode(node);
        }

        private void addNode(Entry node) {
            head.next.pre = node;
            node.next = head.next;

            node.pre = head;
            head.next = node;
        }

        private void deleteNode(Entry node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public static void main(String[] args) {

            LRUCache cache = new LRUCache(2);

            cache.put(1, 1);
            cache.put(2, 2);
            System.out.println(cache.get(1));
            cache.put(3, 3);
            System.out.println(cache.get(2));

        }
    }

    /**
     * @Description //TODO LFU：最近不经常使用，把数据加入到链表中，按频次排序，一个数据被访问过，把它的频次+1，发生淘汰的时候，把频次低的淘汰掉。
     *                          要求put、get都是O(1)
     * @Author ZX
     * @Date 20:12 2020/7/1
     **/
    public static class LFUCache {

        private int capacity; // 容量限制
        private int size;     // 当前数据个数
        private int minFreq;  // 当前最小频率

        private Map<Integer, Node> map; // key和数据的映射
        private Map<Integer, LinkedHashSet<Node>> freqMap; // 数据频率和对应数据组成的链表

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.minFreq = 1;
            this.map = new HashMap<>();
            this.freqMap = new HashMap<>();
        }

        public int get(int key) {

            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            // 增加数据的访问频率
            freqPlus(node);
            return node.value;
        }

        public void put(int key, int value) {

            if (capacity <= 0) {
                return;
            }

            Node node = map.get(key);
            if (node != null) {
                // 如果存在则增加该数据的访问频次
                node.value = value;
                freqPlus(node);
            } else {
                // 淘汰数据
                eliminate();
                // 新增数据并放到数据频率为1的数据链表中
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                LinkedHashSet<Node> set = freqMap.get(1);
                if (set == null) {
                    set = new LinkedHashSet<>();
                    freqMap.put(1, set);
                }

                set.add(newNode);
                minFreq = 1;
                size++;
            }

        }

        private void eliminate() {

            if (size < capacity) {
                return;
            }

            LinkedHashSet<Node> set = freqMap.get(minFreq);
            Node node = set.iterator().next();
            set.remove(node);
            map.remove(node.key);

            size--;
        }

        void freqPlus(Node node) {

            int frequency = node.frequency;
            LinkedHashSet<Node> oldSet = freqMap.get(frequency);
            oldSet.remove(node);

            // 更新最小数据频率
            if (minFreq == frequency && oldSet.isEmpty()) {
                minFreq++;
            }

            frequency++;
            node.frequency++;
            LinkedHashSet<Node> set = freqMap.get(frequency);
            if (set == null) {
                set = new LinkedHashSet<>();
                freqMap.put(frequency, set);
            }
            set.add(node);
        }
    }

    static class Node {
        int key;
        int value;
        int frequency = 1;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


}
