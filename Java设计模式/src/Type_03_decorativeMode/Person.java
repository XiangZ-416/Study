package Type_03_decorativeMode;

/**
 * @Description: //TODO ����Component���ࣺ��Ϊ����������ˣ��������ǿ��԰��˳���Ϊ���࣬�½�Person.java:
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/17 16:08
 */
public abstract class Person {
    String description = "Unknown"; // �˱�ʲôװ����

    public String getDescription() {
        return description;
    }

    public abstract double cost(); // ���װ�λ��˶���Ǯ
}
