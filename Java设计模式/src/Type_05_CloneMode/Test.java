package Type_05_CloneMode;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/30 11:27
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setMailContent("��ʼ��mailģ��");
        for (int i = 0; i < 5; i++) {
            Mail cloneMail = (Mail) mail.clone();
            cloneMail.setName("����" + i);
            cloneMail.setEmailAddress("����" + i + "@XXX.com");
            cloneMail.setMailContent("��ϲ�����н���");
        }
    }
}
