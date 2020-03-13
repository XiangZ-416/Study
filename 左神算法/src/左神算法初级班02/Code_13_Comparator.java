package �����㷨������02;

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

    // ID����
    // 1���Լ��������̳�Comparator�ӿ�
    public static class IdAscendingComparator implements Comparator<Student> { // 2���ӿ�������Ŵ��ȽϵĶ�������Student

        @Override
        // 3��������д����д��compare�������Լ�����Ĵ�С��ϵ��
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }

    }

    // ID����
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

        // �����ʱ���������Ĺ���new�Լ�����ıȽ�����
        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeDescendingComparator());
        printStudents(students);

        // ���� ���ȼ����У��ѣ�+�Ƚ��� ʵ��С����
        PriorityQueue<Student> heap = new PriorityQueue<>(new IdAscendingComparator());
        // ���� ���ȼ�����+�Ƚ���ʵ�ִ����
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