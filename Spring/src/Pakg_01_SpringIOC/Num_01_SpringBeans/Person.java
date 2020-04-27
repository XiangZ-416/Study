package Pakg_01_SpringIOC.Num_01_SpringBeans;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/20 14:35
 */
public class Person {

    private String Name;
    private int age;

    private Car car; // ÄÚ²¿bean

    public Person() {

    }

    public Person(String name, int age, Car car) {
        Name = name;
        this.age = age;
        this.car = car;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
