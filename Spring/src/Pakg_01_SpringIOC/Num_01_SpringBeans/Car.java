package Pakg_01_SpringIOC.Num_01_SpringBeans;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/18 22:52
 */
public class Car {
    private String Brand;
    private String Origin;
    private double price;
    private int speed;

    public Car() {

    }

    public Car(String brand, String origin, double price) {
        Brand = brand;
        Origin = origin;
        this.price = price;
    }

    public Car(String brand, String origin, int speed) {
        Brand = brand;
        Origin = origin;
        this.speed = speed;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Brand='" + Brand + '\'' +
                ", Origin='" + Origin + '\'' +
                ", price=" + price +
                ", speed=" + speed +
                '}';
    }
}
