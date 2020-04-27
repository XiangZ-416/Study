package Pakg_01_SpringIOC.Num_10_FactoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description: //TODO ͨ�� factoryBean ���� bean���Զ���� FactoryBean ��Ҫʵ�� FactoryBean �ӿ�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/21 15:32
 */
public class CarFactoryBean implements FactoryBean {

   private  String brand;

   public void setBrand(String brand) {
       this.brand = brand;
   }


    // ���� bean ����
    @Override
    public Object getObject() throws Exception {
        return new Car("BMW",500000);
    }

    // ���� bean ������
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    // bean ��ʵ���ǲ��ǵ�ʵ��
    @Override
    public boolean isSingleton() {
        return true;
    }
}
