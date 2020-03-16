package Bean;

/**
 * ORM编程思想（object relational mapping对象关系映射）
 * 一个表对应一个java类
 * 表中的一条记录对应java类的一个对象
 * 表中的一个字段对应java类的一个属性
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
