package Pakg_01_SpringIOC.Num_02_BeansCollection;

import Pakg_01_SpringIOC.Num_01_SpringBeans.Car;

import java.util.List;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/20 14:35
 */
public class Person {

    private String Name;
    private int age;

    private List<Car> cars; // ÄÚ²¿bean

    public Person() {
    }

    public Person(String name, int age, List<Car> cars) {
        Name = name;
        this.age = age;
        this.cars = cars;
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
