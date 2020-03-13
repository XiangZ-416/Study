package 左神算法初级班02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_13_Comparator {
    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    // ID升序
    // 1、自己定义的类继承Comparator接口
    public static class IdAscendingComparator implements Comparator<Student> { // 2、接口里面放着待比较的对象类型Student

        @Override
        // 3、类里面写着重写的compare方法（自己定义的大小关系）
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }

    }

    // ID降序
    public static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }

    }

    public static class AgeAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }

    }

    public static class AgeDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }

    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);

        Student[] students = new Student[] { student3, student2, student1 };
        printStudents(students);

        // 排序的时候告诉排序的规则（new自己定义的比较器）
        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeDescendingComparator());
        printStudents(students);

        // 利用 优先级队列（堆）+比较器 实现小根堆
        PriorityQueue<Student> heap = new PriorityQueue<>(new IdAscendingComparator());
        // 利用 优先级队列+比较器实现大根堆
        //PriorityQueue<Student> heap = new PriorityQueue<>(new IdDescendingComparator());
        heap.add(student1);
        heap.add(student2);
        heap.add(student3);
        while (!heap.isEmpty()) {
            Student student = heap.poll();
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }

    }

}