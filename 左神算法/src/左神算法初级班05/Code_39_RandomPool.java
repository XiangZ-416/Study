package 左神算法初级班05;

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
            return this.indexKeyMap.get(randomIndex);// 真正的随机了
        }

        public void delete(K key) {
            if (this.keyIndexMap.containsKey(key)) {
                int deleteIndex = this.keyIndexMap.get(key);// 返回被删除处的index
                // 返回indexKeyMap最后的index
                int lastIndex = --this.size;
                // 返回最后的index对应的Key
                K lastKey = this.indexKeyMap.get(lastIndex);
                // 被删除的位置的值，变成了，原本最后的key 的value
                this.keyIndexMap.put(lastKey, deleteIndex);
                this.indexKeyMap.put(deleteIndex, lastKey);
                // 移除两个map最后的位置
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
