import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @Description: //TODO �Ƚ�����ʹ��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/7 21:55
 */
public class Code_05_Comparator {

    static class Student {
        private String name;
        private int id;

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }

    }

    static class myComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            // ����student��id�Ӵ�С��
            return -(o1.id - o2.id);
        }

    }

    public static void main(String[] args) {
        Student stu1 = new Student("stu1", 1);
        Student stu2 = new Student("stu2", 2);
        Student stu3 = new Student("stu3", 3);

        Student[] students = {stu1, stu2, stu3};

        for (Student stu : students) {
            System.out.println(stu.toString());
        }

        System.out.println("=========================");

        Arrays.sort(students, new myComparator());

        for (Student stu : students) {
            System.out.println(stu.toString());
        }

        System.out.println("=========================");

        // ���ȼ�����(��)�е�Ӧ�ã����ȼ�����Ĭ����С���ѣ������ñȽ���ʵ�ֽ��ɴ���ѣ�
        PriorityQueue<Student> heap = new PriorityQueue<>(3, new myComparator());
        heap.add(stu1);
        heap.add(stu2);
        heap.add(stu3);
        while (!heap.isEmpty()) {
            System.out.println(heap.poll().toString());
        }

        // ������е�Ӧ��
        TreeSet<Student> treeSet = new TreeSet<>(new myComparator());

    }

}
