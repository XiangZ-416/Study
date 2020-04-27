package Pakg_01_SpringIOC.Num_02_BeansCollection;

import Pakg_01_SpringIOC.Num_01_SpringBeans.Car;

import java.util.Map;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/20 16:51
 */
public class NewPerson {
    private String name;
    private int age;

    private Map<String, Car> Cars;

    public NewPerson() {
    }

    public NewPerson(String name, int age, Map<String, Car> cars) {
        this.name = name;
        this.age = age;
        Cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Car> getCars() {
        return Cars;
    }

    public void setCars(Map<String, Car> cars) {
        Cars = cars;
    }

    @Override
    public String toString() {
        return "NewPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Cars=" + Cars +
                '}';
    }
}
