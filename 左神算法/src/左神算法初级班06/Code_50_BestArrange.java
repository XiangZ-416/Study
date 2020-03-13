package �����㷨������06;

import java.util.Arrays;
import java.util.Comparator;

public class Code_50_BestArrange {
    /**
     * ��Ŀ����
     */
    public static class Program {
        public int start; // ��ʼʱ��
        public int end; // ����ʱ��

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * �Ƚ��������ս���ʱ���С��������
     */
    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    /**
     * ���İ���
     * @param programs
     * @param cur ��ǰʱ��
     * @return һ��Ҫ������Ŀ�ĸ���
     */
    public static int bestArrange(Program[] programs, int cur) {
        Arrays.sort(programs, new ProgramComparator()); // ���ձȽ����ź���
        int result = 0; // һ��Ҫ������Ŀ�ĸ���
        for (int i = 0; i < programs.length; i++) { // ����������Ŀ
            if (cur <= programs[i].start) { // �����ǰʱ�� <= ��������ĸ���Ŀ�Ŀ�ʼʱ��(��̭)
                result++;
                cur = programs[i].end; // ��ǰʱ����������Ŀ������ʱ��
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
