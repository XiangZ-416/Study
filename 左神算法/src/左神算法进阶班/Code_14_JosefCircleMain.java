package �����㷨���װ�;

/**
 * @Description: //TODO Լɪ������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/5 17:17
 */
public class Code_14_JosefCircleMain {

    public static void count(int n) {
        //����3���֣��м���������
        int k = 3;
        //ͷ��㲻�洢����
        Node head = new Node();
        Node cur = head;
        //ѭ�������������
        for (int i = 1; i <= n; i++) {
            Node node = new Node(i);
            cur.next = node;
            cur = node;
        }
        //���������ݵĲ�����β�����γ�һ������
        cur.next = head.next;
        //ͳ�ƿ�ʼ��ʱ����ȥͷ��㣬Ȼ��ӵ�һ�������ݵĽ�㿪ʼ����
        Node p = head.next;
        //ѭ���˳������������ֻʣһ����㣬Ҳ�������������һ�������������
        while (p.next != p) {
            //���������ı����߼�
            for (int i = 1; i < k - 1; i++) {
                p = p.next;
            }
            //������3��ʱ�򣬳���
            System.out.print(p.next.data + "->");
            p.next = p.next.next;
            p = p.next;
        }
        //���ʣ�µ�һ�����
        System.out.println("(left:" + p.data + ")");
    }

    static class Node {
        int data;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        //��4����Ϊ����1234 : ���ȳ��ֵ���3��Ȼ��ʣ��412,����2���֣�ʣ��41����ʱ�����4���֣����ʣ��1.
        count(4);
        //41����Ϊ��������Լɪ�򻷵ı����ˣ����ʣ�µ���31
        count(41);
    }

}

