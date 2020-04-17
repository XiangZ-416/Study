package Type_03_decorativeMode;

/**
 * @Description: //TODO ����ConcreteDecorator�������װ����
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/17 16:17
 */
public class Skirt extends Cloth {
    // ��ʵ����������Person������
    Person person;

    public Skirt(Person person) {
        this.person = person;
    }

    @Override
    public String getDescription() {
        return person.getDescription() + "a shirt  ";
    }

    @Override
    public double cost() {
        return 100 + person.cost(); //ʵ����cost()��������������person��cost()������Ŀ���ǻ�������ۼ�ֵ
    }
}
