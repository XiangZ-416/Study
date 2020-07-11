package �����㷨���װ�;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @Description: //TODO ���ݽṹ�����
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/1 20:06
 */
public class Code_09_dataStructDesign {

    /**
     * @Description //TODO ��ƿ��Ա���Ļ���ṹ��LRU�ڴ��滻�㷨����map + ˫������
     *                              ���ʹ�ã�put��get����key���£�������ʹ�õ�key���ȥ
     *                              ɾ����ɾ���ȼ��͵�key
     * @Author ZX
     * @Date 20:10 200/7/1
     **/
    public static class LRUCache {

        Entry head, tail; // �ڱ��ڵ�
        int capacity;
        int size;
        Map<Integer, Entry> cache;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            // ��ʼ������
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
         * ����ڵ㲻���ڣ����� -1��������ڣ����ڵ��ƶ���ͷ��㣬�����ؽڵ�����ݡ�
         * @param key
         * @return
         */
        public int get(int key) {
            Entry node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // �����ƶ��ڵ�
            moveToHead(node);
            return node.value;
        }

        /**
         * ���ڵ���뵽ͷ��㣬�����������������ɾ��β���
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
            // �����ڡ��ȼӽ�ȥ�����Ƴ�β���
            // ��ʱ�������� ɾ��β���
            if (size == capacity) {
                Entry lastNode = tail.pre;
                deleteNode(lastNode);
                cache.remove(lastNode.key);
                size--;
            }
            // ����ͷ���
            Entry newNode = new Entry();
            newNode.key = key;
            newNode.value = value;
            addNode(newNode);
            cache.put(key, newNode);
            size++;

        }

        private void moveToHead(Entry node) {
            // ����ɾ��ԭ���ڵ�Ĺ�ϵ
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
     * @Description //TODO LFU�����������ʹ�ã������ݼ��뵽�����У���Ƶ������һ�����ݱ����ʹ���������Ƶ��+1��������̭��ʱ�򣬰�Ƶ�ε͵���̭����
     *                          Ҫ��put��get����O(1)
     * @Author ZX
     * @Date 20:12 2020/7/1
     **/
    public static class LFUCache {

        private int capacity; // ��������
        private int size;     // ��ǰ���ݸ���
        private int minFreq;  // ��ǰ��СƵ��

        private Map<Integer, Node> map; // key�����ݵ�ӳ��
        private Map<Integer, LinkedHashSet<Node>> freqMap; // ����Ƶ�ʺͶ�Ӧ������ɵ�����

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
            // �������ݵķ���Ƶ��
            freqPlus(node);
            return node.value;
        }

        public void put(int key, int value) {

            if (capacity <= 0) {
                return;
            }

            Node node = map.get(key);
            if (node != null) {
                // ������������Ӹ����ݵķ���Ƶ��
                node.value = value;
                freqPlus(node);
            } else {
                // ��̭����
                eliminate();
                // �������ݲ��ŵ�����Ƶ��Ϊ1������������
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

            // ������С����Ƶ��
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
