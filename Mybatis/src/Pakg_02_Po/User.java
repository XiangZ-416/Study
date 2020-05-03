package Pakg_02_Po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/26 16:39
 */
// Userʵ�����л��ͷ����л���Ϊ���ڶ����������ܹ��ϵ�洢
public class User implements Serializable {

    //�����������ݿ���е��ֶζ�Ӧ
    private int id;
    private String username;
    private Date birthday;
    private int sex;
    private String address;

    // �����б�����
    private List<Orders> ordersList;

    public User() {
    }

    public User(int id, String username, Date birthday, int sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", ordersList=" + ordersList +
                '}';
    }
}
