package �����㷨������05;

import java.util.HashMap;

public class Code_39_RandomPool {
    public static class Pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool() {
            this.keyIndexMap = new HashMap<K, Integer>();
            this.indexKeyMap = new HashMap<Integer, K>();
            this.size = 0;
        }

        public void insert(K key) {
            if (!this.keyIndexMap.containsKey(key)) {
                this.keyIndexMap.put(key, this.size);
                this.indexKeyMap.put(this.size++, key);
            }
        }

        public K getRandom() {
            if (this.size == 0) {
                return null;
            }
            int randomIndex = (int) (Math.random() * this.size); // 0 ~ size -1
            return this.indexKeyMap.get(randomIndex);// �����������
        }

        public void delete(K key) {
            if (this.keyIndexMap.containsKey(key)) {
                int deleteIndex = this.keyIndexMap.get(key);// ���ر�ɾ������index
                // ����indexKeyMap����index
                int lastIndex = --this.size;
                // ��������index��Ӧ��Key
                K lastKey = this.indexKeyMap.get(lastIndex);
                // ��ɾ����λ�õ�ֵ������ˣ�ԭ������key ��value
                this.keyIndexMap.put(lastKey, deleteIndex);
                this.indexKeyMap.put(deleteIndex, lastKey);
                // �Ƴ�����map����λ��
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
            }
        }
    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("datiangou");
        pool.insert("cimu");
        pool.insert("quanyecha");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
    }
}
