package Pakg_01_SpringIOC.Num_10_FactoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description: //TODO 通过 factoryBean 配置 bean：自定义的 FactoryBean 需要实现 FactoryBean 接口
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/21 15:32
 */
public class CarFactoryBean implements FactoryBean {

   private  String brand;

   public void setBrand(String brand) {
       this.brand = brand;
   }


    // 返回 bean 对象
    @Override
    public Object getObject() throws Exception {
        return new Car("BMW",500000);
    }

    // 返回 bean 的类型
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    // bean 的实例是不是单实例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
