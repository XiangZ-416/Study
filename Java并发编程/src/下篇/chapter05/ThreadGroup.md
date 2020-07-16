# ThreadGroup����

## һ��ThreadGroup�ṹ
![ThreadGroup](../../imgs/03.png)

## ����ThreadGroup�ٷ�API˵��
1.����
    
    һ��ThreadGroup����һ���̣߳�����һ��ThreadGroupҲ���԰���������ThreadGroup��ThreadGroup��һ����״�ṹ��ÿ��
    �����µ�ThreadGroup�ͻ�ӵ�����״�ṹ�С��¼����ThreadGroup������������ڵ�ThreadGroup�����ǲ��ܷ���....����Ϣ��
2.����
    
    Ϊ�̷߳����û�ͨ��ʹ���߳���ĸ������������̣߳�������ֹͣ�����ȡ�
       
## ������δ���ThreadGroup
1.���ִ�����ʽ

    ThreadGroup(String name)�������߳������ƴ����߳��飬�丸�߳���Ϊmain�߳���
    ThreadGroup(ThreadGroup parent, String name)�������߳������ƴ����߳��飬�丸�߳���Ϊָ����parent�߳���
2.����    
~~~ java
public class ThreadGroupCreate {
    public static void main(String[] args) {
        ThreadGroup tg1 = new ThreadGroup("TG1"); // �����߳������ƴ����߳��飬�丸�߳���Ϊmain�߳���
        ThreadGroup tg2 = new ThreadGroup(tg1, "TG2"); // �����߳������ƴ����߳��飬�丸�߳���Ϊָ����parent�߳���

        System.out.println("tg1 name: " + tg1.getName() + "\n" + "tg1 parent: " + tg1.getParent().getName());
        System.out.println("tg2 name: " + tg2.getName() + "\n" + "tg2 parent: " + tg2.getParent().getName());
    }
}
~~~
3.Console���
~~~ java
tg1 name: TG1
tg1 parent: main
tg2 name: TG2
tg2 parent: TG1
~~~

## ����ThreadGroup���÷�
�鿴�߳�����Ϣ����ֹ�߳����е������߳�