package �����㷨������06;

import java.util.PriorityQueue;

public class Code_47_Less_Money {
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(); // ���ȶ��У�ϵͳʵ�ֵ�С���ѣ�
        for (int i = 0; i < arr.length; i++) { // ���е����ӵ�����
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll(); // �����ó�������
            sum += cur; // ��Ϊ�����ۼ�����
            pQ.add(cur); // �����·Żض���
        }
        return sum;
    }

    public static void main(String[] args) {
        // solution
        int[] arr = { 6, 7, 8, 9 };
        System.out.println(lessMoney(arr));
    }
}
