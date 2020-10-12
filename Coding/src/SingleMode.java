/**
 * @Description: //TODO ����ģʽ������ʵ��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/17 9:32
 */
public class SingleMode {

    // ����
    public static class Hungry {
        private static Hungry instance = new Hungry();

        private Hungry() {

        }

        public static Hungry getInstance() {
            return instance;
        }
    }

    // ����
    public static class Lazy {
        private static Lazy instance = null;

        private Lazy() {

        }

        public synchronized static Lazy getInstance() { // һ����ͬ������/ͬ������飬������̵߳��ÿ��ܻᴴ�����instance
            if (instance == null) {
                instance = new Lazy();
            }
            return instance;
        }
    }

}
