package Type_03_decorativeMode;

/**
 * @Description: //TODO �ȴ���һ��Teenager���󣬽�����Shirtװ�������ͱ���˴���Shirt��Teenager��
 *                      ����Casquetteװ�Σ��ͱ���˴���Casquette�Ĵ���Shirt��Teenager�����н��������ʾ��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/17 16:20
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Teenager(); // ��һ��Teenager����

        person = new Skirt(person); // ��Skirt����Teenager

        System.out.println(person.getDescription() + " �� " + person.cost());
    }
}
