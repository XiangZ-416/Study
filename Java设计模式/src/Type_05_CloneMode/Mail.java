package Type_05_CloneMode;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/7/30 11:26
 */
public class Mail implements Cloneable {
    String name;
    String emailAddress;
    String mailContent;
    public Mail() {
        System.out.println("Mail Class Constructor");
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }
    public String getName() {
        return name;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getMailContent() {
        return mailContent;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("Clone Mail");
        return super.clone();
    }
    @Override
    public String toString() {
        return "Mail{" +
                "name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", mailContent='" + mailContent + '\'' +
                '}';
    }
}
