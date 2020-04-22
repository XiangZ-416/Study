package Pakg_01_Spring.Num_07_Spel;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/20 17:37
 */
public class Person {

    private String name;
    private Car car;

    // 引用 address bean 的 city 属性
    private String city;

    // 根据 car 的 price 确定 info: car 的 price >= 300000: 金领
    // 否则为：白领
    private String info;

    public Person() {
    }

    public Person(String name, Car car, String city, String info) {
        this.name = name;
        this.car = car;
        this.city = city;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", city='" + city + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
