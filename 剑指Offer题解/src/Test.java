import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ZX
 * @Description //TODO ²âÊÔComparator½Ó¿Ú
 * @Date 21:44 2020/4/2
 * @Param
 * @return
 **/
class test {
    public static class Person implements Comparable<Person>{
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person person) {
            if (this.age > person.age) {
                return 1;
            } else if (this.age < person.age) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "people{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static class myComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if (p1.age == p2.age) {
                return p1.name.compareTo(p2.name);
            } else {
                return p1.age - p2.age;
            }
        }
    }

    private static void printPerson(Person[] people) {
        for (Person p : people) {
            System.out.println(p.name + " " + p.age);
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person(23, "d");
        Person p2 = new Person(3, "a");
        Person p3 = new Person(41, "b");
        Person p4 = new Person(23, "c");
        Person[] people = new Person[] {p1, p2, p3, p4};
        Arrays.sort(people, new myComparator());
        printPerson(people);
        System.out.println("*****************");
        Arrays.sort(people);
        printPerson(people);
        String property = System.getProperty("java.version");
        System.out.println("java°æ±¾£º" + property);
    }
}
