package ��ƪ.chapter05;

/**
 * @Description: //TODO ���ַ�ʽ����ThreadGroup
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/16 16:23
 */
public class ThreadGroupCreate {
    public static void main(String[] args) {
        ThreadGroup tg1 = new ThreadGroup("TG1"); // �����߳������ƴ����߳��飬�丸�߳���Ϊmain�߳���
        ThreadGroup tg2 = new ThreadGroup(tg1, "TG2"); // �����߳������ƴ����߳��飬�丸�߳���Ϊָ����parent�߳���

        System.out.println("tg1 name: " + tg1.getName() + "\n" + "tg1 parent: " + tg1.getParent().getName());
        System.out.println("tg2 name: " + tg2.getName() + "\n" + "tg2 parent: " + tg2.getParent().getName());
    }
}
