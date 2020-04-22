package Pakg_01_Spring.Num_08_Cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/21 11:37
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("postProcessBeforeInitialization:" + bean + "," + beanName);

            // ���Թ���
            if ("car".equals(beanName)) {
                // ...
            }

            return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization:" + bean + "," + beanName);

//        // ͵������
//        Car car = new Car();
//        car.setBrand("����");
//
//        return car;

        return bean;
    }
}
