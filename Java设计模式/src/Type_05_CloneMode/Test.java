package Type_05_CloneMode;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/30 11:27
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setMailContent("初始化mail模板");
        for (int i = 0; i < 5; i++) {
            Mail cloneMail = (Mail) mail.clone();
            cloneMail.setName("姓名" + i);
            cloneMail.setEmailAddress("姓名" + i + "@XXX.com");
            cloneMail.setMailContent("恭喜您，中奖了");
        }
    }
}
