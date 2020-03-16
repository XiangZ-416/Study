package Bean;

/**
 * ORM���˼�루object relational mapping�����ϵӳ�䣩
 * һ�����Ӧһ��java��
 * ���е�һ����¼��Ӧjava���һ������
 * ���е�һ���ֶζ�Ӧjava���һ������
 * @author ZX
 * @date 2020/3/16 - 20:48
 */
public class Customer {
    private  int id;
    private  String name;

    public Customer() {
        super();
    }

    public Customer(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
