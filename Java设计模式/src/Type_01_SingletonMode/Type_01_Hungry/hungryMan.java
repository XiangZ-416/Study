package Type_01_SingletonMode.Type_01_Hungry;

/**
 * @Description: //TODO ����ģʽ������ʵ�֣���̬���� �� ��̬�����ʵ�֣�
 * �ŵ㣺д���򵥡�������ص�ʱ������ʵ�������������߳�ͬ��������
 * ȱ�㣺�����ʼ����û���ù������ʱ������ʵ������������ڴ���˷�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/15 18:02
 */
public class hungryMan {
    public static void main(String[] args) {
        Hungry instance1 = Hungry.getInstance();
        Hungry instance2 = Hungry.getInstance();

        System.out.println(instance1 == instance2);
    }
}
// ��̬����ʵ��
class Hungry {
    // 1.˽�пղι���������ֹnew
    private Hungry() {

    }
    // 2.ʵ���������һ��˽�о�̬ʵ������ļ��ع��̾�ʵ����������󣬹ʳƶ���ģʽ��
    private static Hungry instance = new Hungry();
    // 3.�ṩ���з���getInstance
    public static Hungry getInstance() {
        return instance;
    }
}

// ��̬�����ʵ��
/*
class Hungry {
    // 1.˽�пղι���������ֹnew
    private Hungry() {

    }
    // 2.�������˽�о�̬ʵ��
    private static Hungry instance;
    // 3.�ھ�̬������д������ʵ������ļ��ع��̾�ʵ����������󣬹ʳƶ���ģʽ��
    static {
        instance = new Hungry();
    }
    // 4.�ṩ���еľ�̬getInstance����������һ�������ʵ��
    public static Hungry getInstance() {
        return instance;
    }
}
 */
