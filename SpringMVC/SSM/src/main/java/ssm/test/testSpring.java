package ssm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.service.AccountService;

/**
 * @Description: //TODO ����Spring���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/5/15 18:08
 */
public class testSpring {

    @Test
    public void run1() {
        // ����spring�����ļ�
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // ��ȡservice����
        AccountService as = (AccountService) ac.getBean("accountService");
        // ���÷���
        as.findAll();
    }

}
