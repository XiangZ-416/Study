package chapter01;

/**
 * @Description: //TODO ģ�Ⲣ��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/14 11:26
 */
public class Code_01_TryConcurrency {
    private static void println(String msg) {
        System.out.println(msg);
    }

    private static void readFromDataBse() {
        try {
            println("Begin read data from db.");
            Thread.sleep(1000 * 10L);
            println("Read data done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("read successfully.");
    }

    private static void writeDataToFile() {
        try {
            println("Begin write data from db.");
            Thread.sleep(2000 * 10L);
            println("Write data done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("Write successfully.");
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            println("Task I =>" + i);
//        }
//        for (int j = 0; j < 100; j++) {
//            println("Task J =>" + j);
//        }

//        readFromDataBse();
//        writeDataToFile();

        // ���������������ֻ��mainһ���̣߳�����Task I��Task J���ύ��ִ��
        // ���������������main�̡߳�t1�̣߳�����Task I��Task J�ύ��ִ��
//        Thread t1 = new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    println("Task I =>" + i);
//                }
//            }
//        };
//
//        t1.start();
//
//        for (int j = 0; j < 100; j++) {
//            println("Task J =>" + j);
//        }
//        try {
//            Thread.sleep(10 * 10L); // main�߳�����100ms
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
        // �����ݿ��д��Ϊ���߳�
        new Thread("READ-Thread") {
            @Override
            public void run() {
                readFromDataBse();
            }
        }.start();

        new Thread("WRITE-Thread") {
            @Override
            public void run() {
                writeDataToFile();
            }
        }.start();

    }
}
