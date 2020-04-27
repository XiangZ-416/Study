package Pakg_03_SpringJDBC.Num_01_SpringJDBC;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/23 20:36
 */
public class userTable {

    private String user;
    private long password;
    private long balance;

    public userTable() {
    }

    public userTable(String user, long password, long balance) {
        this.user = user;
        this.password = password;
        this.balance = balance;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "userTable{" +
                "user='" + user + '\'' +
                ", password=" + password +
                ", balance=" + balance +
                '}';
    }
}
