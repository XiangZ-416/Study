package 左神算法初级班06;

import java.util.Arrays;
import java.util.Comparator;

public class Code_50_BestArrange {
    /**
     * 项目类型
     */
    public static class Program {
        public int start; // 开始时间
        public int end; // 结束时间

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 比较器：按照结束时间从小到达排序
     */
    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    /**
     * 最多的安排
     * @param programs
     * @param cur 当前时刻
     * @return 一共要安排项目的个数
     */
    public static int bestArrange(Program[] programs, int cur) {
        Arrays.sort(programs, new ProgramComparator()); // 按照比较器排好序
        int result = 0; // 一共要安排项目的个数
        for (int i = 0; i < programs.length; i++) { // 遍历所有项目
            if (cur <= programs[i].start) { // 如果当前时刻 <= 最早结束哪个项目的开始时间(淘汰)
                result++;
                cur = programs[i].end; // 当前时刻来到此项目结束的时候
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
