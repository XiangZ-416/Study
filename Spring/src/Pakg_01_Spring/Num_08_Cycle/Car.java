package Pakg_01_Spring.Num_08_Cycle;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/21 11:17
 */
public class Car {

    public Car() {
        System.out.println("Car's Constructor...");
    }

    private String brand;

    public void setBrand(String brand) {
        System.out.println("setBrand...");
        this.brand = brand;
    }

    public void init() {
        System.out.println("init...");
    }

    public void destroy() {
        System.out.println("destroy...");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
