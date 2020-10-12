import java.util.HashMap;

/**
 * @Description: //TODO 哈希问题
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/20 14:57
 */
public class Code_11_HashingProblem {

    /**
     * @Description //TODO 设计RandomPool结构
     * @Author ZX
     * @Date 15:27 2020/6/20
     **/
    public static class randomPoll {
        public HashMap<String, Integer> map1;
        public HashMap<Integer, String> map2;
        public int size;

        public randomPoll() {
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            size = 0;
        }

        public void add(String str) {
            if (!map1.containsKey(str)) {
                map1.put(str, size);
                map2.put(size, str);
                size++;
            }
        }

        public String getRandom() {
            if (size == 0) {
                return null;
            }
            int index = (int) (Math.random() * size);
            return map2.get(index);
        }

        public void remove(String str) {
            if (map1.containsKey(str)) {
                Integer deleteIndex = map1.get(str);
                int lastIndex = size - 1;
                String lastStr = map2.get(lastIndex);
                map1.put(lastStr, deleteIndex);
                map2.put(deleteIndex, lastStr);
                map1.remove(str);
                map2.remove(lastIndex);
            }
        }

    }

}
